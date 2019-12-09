package tdu_market.entity_bean;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class RoomMemberInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String ROOM_ID = "roomID";
	public static final String MEMBER_MAIL_ADDRESS = "memberMailAddress";

	private long roomID;
	private String memberMailAddress;

	public RoomMemberInfo() {
		super();
	}

	public long getRoomID() {
		return roomID;
	}

	public void setRoomID(long roomID) {
		this.roomID = roomID;
	}

	public String getMemberMailAddress() {
		return memberMailAddress;
	}

	public void setMemberMailAddress(String memberMailAddress) {
		this.memberMailAddress = memberMailAddress;
	}

	@Override
	public String toString() {
		return "RoomMemberInfo [roomID=" + roomID + ", memberMailAddress=" + memberMailAddress + "]";
	}

	public static RoomMemberInfo create(ResultSet resultSet) throws SQLException {

		if (resultSet == null) {
			return null;
		}

		RoomMemberInfo roomMemberInfo = new RoomMemberInfo();

		roomMemberInfo.setRoomID(resultSet.getLong(ROOM_ID));
		roomMemberInfo.setMemberMailAddress(resultSet.getString(MEMBER_MAIL_ADDRESS));

		return roomMemberInfo;
	}
}
