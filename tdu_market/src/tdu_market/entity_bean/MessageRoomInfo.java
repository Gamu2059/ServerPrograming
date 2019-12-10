package tdu_market.entity_bean;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public final class MessageRoomInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String ROOM_ID = "roomID";
	public static final String CREATED_DATE = "createdDate";

	private long roomID;
	private Date createdDate;

	public MessageRoomInfo() {
		super();
	}

	public long getRoomID() {
		return roomID;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setRoomID(long roomID) {
		this.roomID = roomID;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "MessageRoomInfo [roomID=" + roomID + ", createdDate=" + createdDate + "]";
	}

	public static MessageRoomInfo create(ResultSet resultSet) throws SQLException {

		if (resultSet == null) {
			return null;
		}

		MessageRoomInfo messageRoomInfo = new MessageRoomInfo();

		messageRoomInfo.setRoomID(resultSet.getLong(ROOM_ID));
		messageRoomInfo.setCreatedDate(resultSet.getDate(CREATED_DATE));

		return messageRoomInfo;
	}
}
