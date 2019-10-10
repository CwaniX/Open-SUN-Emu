package pl.cwanix.opensun.agentserver.packets.c2s.connection;

import io.netty.channel.ChannelHandlerContext;
import pl.cwanix.opensun.agentserver.packets.s2c.connection.S2CAnsWorldConnectPacket;
import pl.cwanix.opensun.agentserver.server.context.AgentServerContext;
import pl.cwanix.opensun.commonserver.packets.annotations.IncomingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;

@IncomingPacket(category = PacketCategory.CONNECTION, type = (byte) 0xDF)
public class C2SAskWordConnectPacket implements Packet<AgentServerContext>  {

	public C2SAskWordConnectPacket(byte[] value) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void process(ChannelHandlerContext ctx, AgentServerContext srv) {
		ctx.writeAndFlush(new S2CAnsWorldConnectPacket());
	}
}
