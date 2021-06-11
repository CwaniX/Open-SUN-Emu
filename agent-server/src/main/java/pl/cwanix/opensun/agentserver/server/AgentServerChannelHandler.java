package pl.cwanix.opensun.agentserver.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.util.AttributeKey;
import lombok.RequiredArgsConstructor;
import pl.cwanix.opensun.agentserver.server.session.AgentServerSession;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.SUNPacketProcessorExecutor;
import pl.cwanix.opensun.commonserver.server.SUNServerChannelHandler;

@RequiredArgsConstructor
public class AgentServerChannelHandler extends SUNServerChannelHandler {

    public static final AttributeKey<AgentServerSession> SESSION_ATTRIBUTE = AttributeKey.valueOf("session");

    private final SUNPacketProcessorExecutor processorExecutor;

    @Override
    public void channelRead(final ChannelHandlerContext ctx, final Object msg) {
        Packet packet = (Packet) msg;
        processorExecutor.process(ctx, packet);
    }
}
