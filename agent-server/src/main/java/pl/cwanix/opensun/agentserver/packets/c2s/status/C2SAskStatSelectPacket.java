package pl.cwanix.opensun.agentserver.packets.c2s.status;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import pl.cwanix.opensun.agentserver.packets.AgentServerPacketOPCode;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.annotations.IncomingPacket;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@SuppressWarnings("checkstyle:MagicNumber")
@Slf4j
@Getter
@IncomingPacket(category = AgentServerPacketOPCode.Status.CATEGORY, operation = AgentServerPacketOPCode.Status.Ask.STAT_SELECT)
public class C2SAskStatSelectPacket implements Packet {

    private final FixedLengthField attributeCode;

    public C2SAskStatSelectPacket(final byte[] value) {
        this.attributeCode = new FixedLengthField(1, value);
    }
}
