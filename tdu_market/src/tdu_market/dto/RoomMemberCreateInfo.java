package tdu_market.dto;

public class RoomMemberCreateInfo {

	private final long roomID;
	private final String[] memberMailAddresses;

	public RoomMemberCreateInfo(long roomID, String[] memberMailAddresses) {
		super();
		this.roomID = roomID;
		this.memberMailAddresses = memberMailAddresses;
	}

	public long getRoomID() {
		return roomID;
	}

	public String[] getMemberMailAddresses() {
		return memberMailAddresses;
	}
}
