package tdu_market.entity_manager;

import java.util.ArrayList;

import tdu_market.dao.MessageInfoDAO;
import tdu_market.dto.MessageCreateInfo;
import tdu_market.dto.MessageGetInfo;
import tdu_market.entity_bean.MessageInfo;

public final class MessageInfoManager {

	public MessageGetInfo getMessageInfo(long messageID) {

		MessageInfoDAO messageInfoDAO = new MessageInfoDAO();
		MessageInfo messageInfo = messageInfoDAO.getMessageInfo(messageID);
		return MessageGetInfo.create(messageInfo);
	}

	public ArrayList<MessageGetInfo> getMessageInfoWithRoomInfo(long roomID) {

		MessageInfoDAO messageInfoDAO = new MessageInfoDAO();
		ArrayList<MessageInfo> list = messageInfoDAO.getMessageInfoWithRoomInfo(roomID);

		ArrayList<MessageGetInfo> result = new ArrayList<MessageGetInfo>();
		for (MessageInfo i : list) {
			result.add(MessageGetInfo.create(i));
		}

		return result;
	}

	public MessageGetInfo getLatestMessageInfo(long roomID) {

		MessageInfoDAO messageInfoDAO = new MessageInfoDAO();
		MessageInfo messageInfo = messageInfoDAO.getLatestMessageInfo(roomID);

		return MessageGetInfo.create(messageInfo);
	}

	public void createMessageInfo(MessageCreateInfo messageCreateInfo) {

		MessageInfoDAO messageInfoDAO = new MessageInfoDAO();
		messageInfoDAO.createMessageInfo(messageCreateInfo);
	}

	public void deleteMessageInfoWithMessageRoom(long roomID) {

		MessageInfoDAO messageInfoDAO = new MessageInfoDAO();
		messageInfoDAO.deleteMessageInfoWithMessageRoom(roomID);
	}

	public void deleteMessageInfoWithStudentNumber(String studentNumber) {

		MessageInfoDAO messageInfoDAO = new MessageInfoDAO();
		messageInfoDAO.deleteMessageInfoWithStudentNumber(studentNumber);
	}
}
