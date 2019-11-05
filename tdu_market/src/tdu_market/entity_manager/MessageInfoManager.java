package tdu_market.entity_manager;

import java.util.ArrayList;

import tdu_market.dto.MessageCreateInfo;
import tdu_market.dto.MessageGetInfo;

public final class MessageInfoManager {

	public ArrayList<MessageGetInfo> getMessageInfo(long roomID) {
		System.err.println("getMessageInfo is non implementation!");
		return null;
	}

	public void createMessageInfo(MessageCreateInfo messageCreateInfo) {
		System.err.println("createMessageInfo is non implementation!");
		return;
	}

	public void deleteMessageInfoWithMessageRoom(long roomID) {
		System.err.println("deleteMessageInfoWithMessageRoom is non implementation!");
	}

	public void deleteMessageInfoWithStudentNumber(String studentNumber) {
		System.err.println("deleteMessageInfoWithStudentNumber is non implementation!");
	}
}
