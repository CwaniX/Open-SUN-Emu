package pl.cwanix.opensun.agentserver.packets.c2s.sync;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import pl.cwanix.opensun.agentserver.packets.AgentServerPacketOPCode;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.annotations.IncomingPacket;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;
import pl.cwanix.opensun.utils.datatypes.Vector;

@SuppressWarnings("checkstyle:MagicNumber")
@Slf4j
@Getter
@IncomingPacket(category = AgentServerPacketOPCode.Sync.CATEGORY, operation = AgentServerPacketOPCode.Sync.Ask.KEYBOARD_MOVE)
public class C2SAskKeyboardMovePacket implements Packet {

    private final Vector currentPosition;
    private final FixedLengthField angle;
    private final FixedLengthField tileIndex;
    private final FixedLengthField moveState;

    public C2SAskKeyboardMovePacket(final byte[] value) {
        currentPosition = new Vector(value);
        angle = new FixedLengthField(2, value[12], value[13]);
        tileIndex = new FixedLengthField(2, value[14], value[15]);
        moveState = new FixedLengthField(1, value[16]);
    }
}
