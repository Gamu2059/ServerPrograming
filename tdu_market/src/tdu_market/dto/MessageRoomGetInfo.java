package tdu_market.dto;

public class MessageRoomGetInfo {

	private final long roomID;
	private final StudentGetInfo opponentStudentGetInfo;
	private final MessageGetInfo latestPostMessageGetInfo;

	public MessageRoomGetInfo(long roomID, StudentGetInfo opponentStudentGetInfo,
			MessageGetInfo latestPostMessageGetInfo) {
		super();
		this.roomID = roomID;
		this.opponentStudentGetInfo = opponentStudentGetInfo;
		this.latestPostMessageGetInfo = latestPostMessageGetInfo;
	}

	public long getRoomID() {
		return roomID;
	}

	public StudentGetInfo getOpponentStudentGetInfo() {
		return opponentStudentGetInfo;
	}

	public MessageGetInfo getLatestPostMessageGetInfo() {
		return latestPostMessageGetInfo;
	}
}
