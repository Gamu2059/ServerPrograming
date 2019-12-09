package tdu_market.entity_bean;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public final class MessageInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String MESSAGE_ID = "messageID";
	public static final String ROOM_ID = "roomID";
	public static final String POST_MAIL_ADDRESS = "postMailAddress";
	public static final String POST_CONTENT = "postContent";
	public static final String POST_DATE = "postDate";

	private long messageID;
	private long roomID;
	private String postMailAddress;
	private String postContent;
	private Date postDate;

	public MessageInfo() {
		super();
	}

	public long getMessageID() {
		return messageID;
	}

	public void setMessageID(long messageID) {
		this.messageID = messageID;
	}

	public long getRoomID() {
		return roomID;
	}

	public void setRoomID(long roomID) {
		this.roomID = roomID;
	}

	public String getPostMailAddress() {
		return postMailAddress;
	}

	public void setPostMailAddress(String postMailAddress) {
		this.postMailAddress = postMailAddress;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	@Override
	public String toString() {
		return "MessageInfo [messageID=" + messageID + ", roomID=" + roomID + ", postMailAddress=" + postMailAddress
				+ ", postContent=" + postContent + ", postDate=" + postDate + "]";
	}

	public static MessageInfo create(ResultSet resultSet) throws SQLException {

		if (resultSet == null) {
			return null;
		}

		MessageInfo messageInfo = new MessageInfo();

		messageInfo.setMessageID(resultSet.getLong(MESSAGE_ID));
		messageInfo.setRoomID(resultSet.getLong(ROOM_ID));
		messageInfo.setPostMailAddress(resultSet.getString(POST_MAIL_ADDRESS));
		messageInfo.setPostContent(resultSet.getString(POST_CONTENT));
		messageInfo.setPostDate(resultSet.getDate(POST_DATE));

		return messageInfo;
	}
}
