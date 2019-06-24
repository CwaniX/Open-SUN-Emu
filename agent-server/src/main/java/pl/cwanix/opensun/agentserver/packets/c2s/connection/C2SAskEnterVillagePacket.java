package pl.cwanix.opensun.agentserver.packets.c2s.connection;

import io.netty.channel.ChannelHandlerContext;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import pl.cwanix.opensun.agentserver.packets.s2c.characters.S2CAnsCharItemsPacket;
import pl.cwanix.opensun.agentserver.packets.s2c.characters.S2CAnsCharStylePacket;
import pl.cwanix.opensun.commonserver.packets.IncomingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.utils.packets.PacketHeader;

@Slf4j
@Getter
@IncomingPacket
public class C2SAskEnterVillagePacket extends Packet {
	
	public static final PacketHeader PACKET_ID = new PacketHeader((byte) 0x48, (byte) 0x1F);
	
	public C2SAskEnterVillagePacket(byte[] value) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void process(ChannelHandlerContext ctx) {
		ctx.writeAndFlush(new S2CAnsCharItemsPacket());
		ctx.writeAndFlush(new S2CAnsCharStylePacket());
	}
}