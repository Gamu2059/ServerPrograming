package tdu_market.dto;

import java.util.Date;

import tdu_market.entity_bean.MessageInfo;

public class MessageGetInfo {

	private final long messageID;
	private final String postStudentNumber;
	private final String postContent;
	private final Date postDate;

	public MessageGetInfo(long messageID, String postStudentNumber, String postContent, Date postDate) {
		super();
		this.messageID = messageID;
		this.postStudentNumber = postStudentNumber;
		this.postContent = postContent;
		this.postDate = postDate;
	}

	public long getMessageID() {
		return messageID;
	}

	public String getPostStudentNumber() {
		return postStudentNumber;
	}

	public String getPostContent() {
		return postContent;
	}

	public Date getPostDate() {
		return postDate;
	}

	public static MessageGetInfo create(MessageInfo messageInfo) {

		if (messageInfo == null) {
			return null;
		}

		long msgID = messageInfo.getMessageID();
		String studentNumber = messageInfo.getPostMailAddress();
		String content = messageInfo.getPostContent();
		Date date = messageInfo.getPostDate();

		return new MessageGetInfo(msgID, studentNumber, content, date);
	}
}
