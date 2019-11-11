package tdu_market.dto;

public class RoomMemberGetInfo {

	private final String[] memberMailAddresses;
	private final long[] roomIDs;

	public RoomMemberGetInfo(String[] memberMailAddresses, long[] roomIDs) {
		super();
		this.memberMailAddresses = memberMailAddresses;
		this.roomIDs = roomIDs;
	}

	public String[] getMemberMailAddresses() {
		return memberMailAddresses;
	}

	public long[] getRoomIDs() {
		return roomIDs;
	}
}
