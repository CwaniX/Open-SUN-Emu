package pl.cwanix.opensun.agentserver.packets.processors.sync;

import io.netty.channel.ChannelHandlerContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import pl.cwanix.opensun.agentserver.packets.c2s.sync.C2SAskKeyboardMovePacket;
import pl.cwanix.opensun.agentserver.server.AgentServerChannelHandler;
import pl.cwanix.opensun.agentserver.server.session.AgentServerSession;
import pl.cwanix.opensun.commonserver.packets.SUNPacketProcessor;
import pl.cwanix.opensun.commonserver.packets.annotations.PacketProcessor;
import pl.cwanix.opensun.model.character.CharacterDataSource;

@Slf4j
@RequiredArgsConstructor
@PacketProcessor(packetClass = C2SAskKeyboardMovePacket.class)
public class C2SAskKeyboardMoveProcessor implements SUNPacketProcessor<C2SAskKeyboardMovePacket> {

    private static final Marker MARKER = MarkerFactory.getMarker("C2S -> KEYBOARD MOVE");

    private final CharacterDataSource characterDataSource;

    @Override
    public void process(final ChannelHandlerContext ctx, final C2SAskKeyboardMovePacket packet) {
        AgentServerSession session = ctx.channel().attr(AgentServerChannelHandler.SESSION_ATTRIBUTE).get();

        log.trace(MARKER, "Updating character position: {} {} {} {}",
                packet.getCurrentPosition().getX(),
                packet.getCurrentPosition().getY(),
                packet.getCurrentPosition().getZ(),
                packet.getAngle());

        characterDataSource.updateCharacterPosition(
                session.getCharacter().getId(),
                packet.getCurrentPosition().getX(),
                packet.getCurrentPosition().getY(),
                packet.getCurrentPosition().getZ(),
                packet.getAngle().toShort());
    }
}
