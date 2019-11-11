package tdu_market.entity_bean;

import java.io.Serializable;

public final class RoomMemberInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private long roomID;
	private String studentMailAddress;

	public RoomMemberInfo() {
		super();
	}

	public long getRoomID() {
		return roomID;
	}

	public void setRoomID(long roomID) {
		this.roomID = roomID;
	}

	public String getStudentMailAddress() {
		return studentMailAddress;
	}

	public void setStudentMailAddress(String studentMailAddress) {
		this.studentMailAddress = studentMailAddress;
	}
}
