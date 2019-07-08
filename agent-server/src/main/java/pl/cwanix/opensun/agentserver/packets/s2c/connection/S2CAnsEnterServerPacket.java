package pl.cwanix.opensun.agentserver.packets.s2c.connection;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import io.netty.channel.ChannelHandlerContext;
import pl.cwanix.opensun.agentserver.entities.CharacterEntity;
import pl.cwanix.opensun.agentserver.packets.structures.ClientCharacterPartPacketStructure;
import pl.cwanix.opensun.agentserver.properties.AgentServerProperties;
import pl.cwanix.opensun.agentserver.server.AgentServerChannelHandler;
import pl.cwanix.opensun.agentserver.server.session.AgentServerSession;
import pl.cwanix.opensun.commonserver.packets.OutgoingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@OutgoingPacket(category = PacketCategory.CONNECTION, type = (byte) 0x98)
public class S2CAnsEnterServerPacket implements Packet {

	private FixedLengthField userId;
	private FixedLengthField charCount;
	private FixedLengthField unknown;
	private List<ClientCharacterPartPacketStructure> charactersList;

	public S2CAnsEnterServerPacket() {
		userId = new FixedLengthField(4);
		charCount = new FixedLengthField(1);
		unknown = new FixedLengthField(1);
		charactersList = new ArrayList<>();
	}
	
	@Override
	public void process(ChannelHandlerContext ctx) {
		AgentServerSession session = ctx.channel().attr(AgentServerChannelHandler.SESSION_ATTRIBUTE).get();
		RestTemplate restTemplate = ctx.channel().attr(AgentServerChannelHandler.REST_TEMPLATE_ATTRIBUTE).get();
		AgentServerProperties properties = ctx.channel().attr(AgentServerChannelHandler.PROPERIES_ATTRIBUTE).get();
		
		List<CharacterEntity> characters = restTemplate.exchange(properties.getDb().getServerUrl() + "/character/findByAccountId?accountId=" + session.getUser().getAccount().getId(), HttpMethod.GET, null, new ParameterizedTypeReference<List<CharacterEntity>>(){}).getBody();
		userId.setValue(session.getUser().getId());
		charCount.setValue((byte) characters.size());
		unknown.setValue((byte) characters.size()); //??
		characters.stream().forEach(character -> charactersList.add(new ClientCharacterPartPacketStructure(character)));
	}
	
	@Override
	public Object[] getOrderedFields() {
		return ArrayUtils.toArray(userId, charCount, unknown, charactersList);
	}
}
