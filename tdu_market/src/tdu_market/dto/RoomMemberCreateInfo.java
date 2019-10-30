package tdu_market.dto;

public class RoomMemberCreateInfo {

	private final long roomID;
	private final String[] studentNumbers;

	public RoomMemberCreateInfo(long roomID, String[] studentNumbers) {
		super();
		this.roomID = roomID;
		this.studentNumbers = studentNumbers;
	}

	public long getRoomID() {
		return roomID;
	}

	public String[] getStudentNumbers() {
		return studentNumbers;
	}
}
