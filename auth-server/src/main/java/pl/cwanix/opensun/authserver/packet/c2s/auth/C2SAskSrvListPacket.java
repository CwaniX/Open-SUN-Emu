package pl.cwanix.opensun.authserver.packet.c2s.auth;

import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.commonserver.packets.annotations.IncomingPacket;

@IncomingPacket(category = PacketCategory.AUTH, type = 0x0F)
public class C2SAskSrvListPacket implements Packet {
	
	public C2SAskSrvListPacket(byte[] value) {

	}
}
