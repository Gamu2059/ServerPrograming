package tdu_market.dto;

public class MessageRoomChangeInfo {

	private final long roomID;
	private final int roomState;

	public MessageRoomChangeInfo(long roomID, int roomState) {
		super();
		this.roomID = roomID;
		this.roomState = roomState;
	}

	public long getRoomID() {
		return roomID;
	}

	public int getRoomState() {
		return roomState;
	}
}
