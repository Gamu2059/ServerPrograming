package tdu_market.entity_manager;

import java.util.ArrayList;

import tdu_market.dto.MessageRoomChangeInfo;
import tdu_market.dto.MessageRoomCreateInfo;
import tdu_market.dto.MessageRoomGetInfo;

public final class MessageRoomInfoManager {

	public ArrayList<MessageRoomGetInfo> getMessageRoomInfo(long roomID) {
		System.err.println("getMessageRoomInfo is non implementation!");
		return null;
	}

	public void createMessageRoomInfo(MessageRoomCreateInfo messageRoomCreateInfo) {
		System.err.println("createMessageRoomInfo is non implementation!");
	}

	public void changeStateMessageRoomInfo(MessageRoomChangeInfo messageRoomChangeInfo) {
		System.err.println("changeStateMessageRoomInfo is non implementation!");
	}

	public void deleteMessageRoomInfo(long roomID) {
		System.err.println("deleteMessageRoomInfo is non implementation!");
	}
}
