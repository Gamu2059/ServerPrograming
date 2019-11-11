package tdu_market.dao;

import java.util.ArrayList;

import tdu_market.dto.MessageCreateInfo;
import tdu_market.entity_bean.MessageInfo;

public final class MessageInfoDAO {

	public MessageInfo getMessageInfo(long messageID) {
		System.err.println("getMessageInfo is non implementation!");
		return null;
	}

	public ArrayList<MessageInfo> getMessageInfoWithRoomInfo(long roomID){
		System.err.println("getMessageInfoWithRoomInfo is non implementation!");
		return null;
	}

	public MessageInfo getLatestMessageInfo(long roomID) {
		System.err.println("getLatestMessageInfo is non implementation!");
		return null;
	}

	public void createMessageInfo(MessageCreateInfo messageCreateInfo) {
		System.err.println("createMessageInfo is non implementation!");
	}

	public void deleteMessageInfoWithMessageRoom(long roomID) {
		System.err.println("deleteMessageInfoWithMessageRoom is non implementation!");
	}

	public void deleteMessageInfoWithStudentNumber(String studentNumber) {
		System.err.println("deleteMessageInfoWithStudentNumber is non implementation!");
	}
}
