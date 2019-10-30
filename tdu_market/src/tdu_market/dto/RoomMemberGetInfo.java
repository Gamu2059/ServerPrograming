package tdu_market.dto;

public class RoomMemberGetInfo {

	private final StudentGetInfo studentGetInfo;
	private final MessageRoomGetInfo[] rooms;

	public RoomMemberGetInfo(StudentGetInfo studentGetInfo, MessageRoomGetInfo[] rooms) {
		super();
		this.studentGetInfo = studentGetInfo;
		this.rooms = rooms;
	}

	public StudentGetInfo getStudentGetInfo() {
		return studentGetInfo;
	}

	public MessageRoomGetInfo[] getRooms() {
		return rooms;
	}
}
