package pl.cwanix.opensun.agentserver.packets.s2c.characters;

import org.apache.commons.lang3.ArrayUtils;

import pl.cwanix.opensun.commonserver.packets.OutgoingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@OutgoingPacket(category = PacketCategory.CHAR_INFO, type = (byte) 0xDB)
public class S2CAnsStatePacket implements Packet {

	private FixedLengthField value;
	
	public S2CAnsStatePacket() {
		value = new FixedLengthField(13, new byte[] { (byte) 0xa5, (byte) 0xdb, 0x02, 0x01, 0x00, (byte) 0xe8, 0x03, 0x00, 0x00, 0x02, 0x00, (byte) 0xe8, 0x03, 0x00, 0x00 });
	}
	
	@Override
	public Object[] getOrderedFields() {
		return ArrayUtils.toArray(value);
	}
}
