package tdu_market.entity_bean;

import java.io.Serializable;
import java.util.Date;

public final class MessageInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private long messageID;
	private long roomID;
	private String postStudentNumber;
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

	public String getPostStudentNumber() {
		return postStudentNumber;
	}

	public void setPostStudentNumber(String postStudentNumber) {
		this.postStudentNumber = postStudentNumber;
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
}
