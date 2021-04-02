package pl.cwanix.opensun.agentserver.packets.s2c.status;

import org.apache.commons.lang3.ArrayUtils;
import pl.cwanix.opensun.agentserver.packets.AgentServerPacketOPCode;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.annotations.OutgoingPacket;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@SuppressWarnings("checkstyle:MagicNumber")
@OutgoingPacket(category = AgentServerPacketOPCode.Status.CATEGORY, operation = AgentServerPacketOPCode.Status.Ans.RECOVER_ATTR_MP)
public class S2CAnsRecoverAttrMpPacket implements Packet {

    private final FixedLengthField value;

    public S2CAnsRecoverAttrMpPacket() {
        value = new FixedLengthField(12,
                new byte[] {0x21, 0x00, 0x00, 0x00, (byte) 0x4e, 0x08, 0x00, 0x00,
                        (byte) 0xc4, 0x03, 0x00, 0x00});
    }

    @Override
    public Object[] getOrderedFields() {
        return ArrayUtils.toArray(value);
    }
}
