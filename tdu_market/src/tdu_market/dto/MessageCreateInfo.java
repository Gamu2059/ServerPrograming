package tdu_market.dto;

public class MessageCreateInfo {

	private final long roomID;
	private final String postMailAddress;
	private final String postContent;

	public MessageCreateInfo(long roomID, String postMailAddress, String postContent) {
		super();
		this.roomID = roomID;
		this.postMailAddress = postMailAddress;
		this.postContent = postContent;
	}

	public long getRoomID() {
		return roomID;
	}

	public String getPostMailAddress() {
		return postMailAddress;
	}

	public String getPostContent() {
		return postContent;
	}
}
