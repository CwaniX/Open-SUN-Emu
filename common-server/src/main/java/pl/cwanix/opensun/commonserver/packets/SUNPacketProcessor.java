package pl.cwanix.opensun.commonserver.packets;

import io.netty.channel.ChannelHandlerContext;

public interface SUNPacketProcessor<T> {

	public void process(ChannelHandlerContext ctx, T packet);
}
