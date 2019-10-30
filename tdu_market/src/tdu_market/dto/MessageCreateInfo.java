package tdu_market.dto;

public class MessageCreateInfo {

	private final long roomID;
	private final String postStudentNumber;
	private final String postContent;

	public MessageCreateInfo(long roomID, String postStudentNumber, String postContent) {
		super();
		this.roomID = roomID;
		this.postStudentNumber = postStudentNumber;
		this.postContent = postContent;
	}

	public long getRoomID() {
		return roomID;
	}

	public String getPostStudentNumber() {
		return postStudentNumber;
	}

	public String getPostContent() {
		return postContent;
	}
}
