package pl.cwanix.opensun.authserver.packet.s2c;

import io.netty.channel.ChannelHandlerContext;
import pl.cwanix.opensun.commonserver.packets.ServerPacket;
import pl.cwanix.opensun.utils.bytes.BytesUtils;
import pl.cwanix.opensun.utils.packets.FixedLengthField;
import pl.cwanix.opensun.utils.packets.PacketHeader;

public class S2CAnsSrvListPacket extends ServerPacket {

	public static final PacketHeader PACKET_ID = new PacketHeader((byte) 0x33, (byte) 0x11);
	
	private FixedLengthField serversCount;
	private FixedLengthField serverName;
	private byte[] value;
	
	public S2CAnsSrvListPacket() {
		this.serversCount = new FixedLengthField(FixedLengthField.BYTE, (byte) 0x01);
		this.serverName = new FixedLengthField(32, new byte[] { (byte) 0xc2, (byte) 0xd2, (byte) 0xca, (byte) 0xc0, (byte) 0xd5, (byte) 0xbd, (byte) 0xbb, (byte) 0xea });
		this.value = new byte[] { 0x00, 0x01 };
	}

	@Override
	public void process(ChannelHandlerContext ctx) {

	}

	@Override
	public byte[] toByteArray() {
		return BytesUtils.mergeArrays(PACKET_ID.getValue(), serversCount.getValue(), serverName.getValue(), value);
	}
}
