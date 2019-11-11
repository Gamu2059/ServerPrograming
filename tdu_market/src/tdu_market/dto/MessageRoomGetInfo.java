package tdu_market.dto;

import tdu_market.entity_bean.MessageRoomInfo;

public class MessageRoomGetInfo {

	private final long roomID;
	private final StudentGetInfo opponentStudentGetInfo;
	private final MessageGetInfo latestPostMessageGetInfo;

	public MessageRoomGetInfo(long roomID, StudentGetInfo opponentStudentGetInfo,
			MessageGetInfo latestPostMessageGetInfo) {
		super();
		this.roomID = roomID;
		this.opponentStudentGetInfo = opponentStudentGetInfo;
		this.latestPostMessageGetInfo = latestPostMessageGetInfo;
	}

	public long getRoomID() {
		return roomID;
	}

	public StudentGetInfo getOpponentStudentGetInfo() {
		return opponentStudentGetInfo;
	}

	public MessageGetInfo getLatestPostMessageGetInfo() {
		return latestPostMessageGetInfo;
	}

	public static MessageRoomGetInfo create(MessageRoomInfo messageRoomInfo, StudentGetInfo opponentStudentGetInfo, MessageGetInfo latestPostMessageGetInfo) {

		if (messageRoomInfo == null || opponentStudentGetInfo == null || latestPostMessageGetInfo == null) {
			return null;
		}

		long roomID = messageRoomInfo.getRoomID();

		return new MessageRoomGetInfo(roomID, opponentStudentGetInfo, latestPostMessageGetInfo);
	}
}
