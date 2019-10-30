package tdu_market.entity_bean;

import java.io.Serializable;
import java.util.Date;

public final class MessageRoomInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private long roomID;
	private Date generatedDate;
	private Date lastPostedDate;
	private int roomState;

	public MessageRoomInfo() {
		super();
	}

	public long getRoomID() {
		return roomID;
	}

	public void setRoomID(long roomID) {
		this.roomID = roomID;
	}

	public Date getGeneratedDate() {
		return generatedDate;
	}

	public void setGeneratedDate(Date generatedDate) {
		this.generatedDate = generatedDate;
	}

	public Date getLastPostedDate() {
		return lastPostedDate;
	}

	public void setLastPostedDate(Date lastPostedDate) {
		this.lastPostedDate = lastPostedDate;
	}

	public int getRoomState() {
		return roomState;
	}

	public void setRoomState(int roomState) {
		this.roomState = roomState;
	}
}
