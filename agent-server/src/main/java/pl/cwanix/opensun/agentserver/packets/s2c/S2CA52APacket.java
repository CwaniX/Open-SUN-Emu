package pl.cwanix.opensun.agentserver.packets.s2c;

import io.netty.channel.ChannelHandlerContext;
import pl.cwanix.opensun.commonserver.packets.ServerPacket;
import pl.cwanix.opensun.utils.bytes.BytesUtils;
import pl.cwanix.opensun.utils.packets.PacketHeader;

public class S2CA52APacket extends ServerPacket {
	
	public static final PacketHeader PACKET_ID = new PacketHeader((byte) 0xA5, (byte) 0x2A);
	
	private byte[] value = { 0x00, 0x00, 0x0f, 0x00, 0x0a, 0x00,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x01, 0x00, 0x00, 0x00, 0x40, 0x42, 0x0f, 0x00, 0x00, 0x00,
			0x00, 0x00, (byte) 0xf0, (byte) 0xeb, (byte) 0x9e, 0x08, 0x3b, 0x01, (byte) 0xc4, 0x03, (byte) 0xda, 0x00, 0x65, 0x00, (byte) 0x98, 0x00,
			0x01, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x01, 0x01, 0x00, 0x00, 0x00, 0x00, 0x00,
			0x00, 0x00, 0x00, 0x00, 0x14, 0x00, 0x12, 0x00, 0x0f, 0x00, 0x0e, 0x00, 0x0d, 0x00, 0x00, 0x00,
			0x00, 0x00, 0x00, 0x00, 0x0b, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x02, 0x00, (byte) 0xff,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x53, 0x00, 0x35, 0x00, 0x00, 0x00, 0x00, 0x06, 0x00, (byte) 0xa5, (byte) 0x9f,
			0x01, 0x00, (byte) 0xe1, 0x2e, 0x03, 0x00, (byte) 0xa5, (byte) 0xbe, 0x00, 0x00
	};

	@Override
	public byte[] toByteArray() {
		// TODO Auto-generated method stub
		return BytesUtils.mergeArrays(PACKET_ID.getValue(), value);
	}

	@Override
	public void process(ChannelHandlerContext ctx) {
		// TODO Auto-generated method stub
		
	}

}