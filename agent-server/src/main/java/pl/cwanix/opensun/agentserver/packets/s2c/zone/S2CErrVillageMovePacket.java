package pl.cwanix.opensun.agentserver.packets.s2c.zone;

import pl.cwanix.opensun.agentserver.packets.AgentServerPacketOPCode;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.annotations.OutgoingPacket;

@SuppressWarnings("checkstyle:MagicNumber")
@OutgoingPacket(category = AgentServerPacketOPCode.Zone.CATEGORY, operation = AgentServerPacketOPCode.Zone.Err.VILLAGE_MOVE) //TODO: ?
public class S2CErrVillageMovePacket implements Packet {

    public S2CErrVillageMovePacket() {
    }

    @Override
    public Object[] getOrderedFields() {
        return null;
    }
}
