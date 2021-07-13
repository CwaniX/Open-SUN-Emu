package pl.cwanix.opensun.commonserver.server.messages;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.c2s.C2SAskUnknownPacket;
import pl.cwanix.opensun.utils.bytes.BytesUtils;
import pl.cwanix.opensun.utils.datatypes.PacketHeader;
import pl.cwanix.opensun.utils.functions.ThrowingFunction;

@Slf4j
@ChannelHandler.Sharable
@RequiredArgsConstructor
public class PacketDecoder extends MessageToMessageDecoder<byte[]> {

    private static final Marker MARKER = MarkerFactory.getMarker("PACKET DECODER");

    private final Map<PacketHeader, ThrowingFunction<byte[], Packet, Exception>> clientPacketDefinitions;

    @Override
    protected void decode(final ChannelHandlerContext ctx, final byte[] msg, final List<Object> out) throws Exception {
        log.debug(MARKER, "Incoming data: {}", BytesUtils.byteArrayToHexString(msg));

        PacketHeader id = new PacketHeader(msg[0], msg[1]);
        byte[] value = Arrays.copyOfRange(msg, 2, msg.length);

        ThrowingFunction<byte[], Packet, Exception> packetCreationFunction = clientPacketDefinitions.get(id);

        if (packetCreationFunction == null) {
            out.add(new C2SAskUnknownPacket(id, value));
        } else {
            out.add(packetCreationFunction.apply(value));
        }
    }
}
