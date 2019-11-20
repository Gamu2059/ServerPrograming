package tdu_market.entity_manager;

import java.util.ArrayList;

import tdu_market.dao.MessageInfoDAO;
import tdu_market.dto.MessageCreateInfo;
import tdu_market.dto.MessageGetInfo;
import tdu_market.entity_bean.MessageInfo;

/** 原則として、StudentInfoManagerやMessageRoomInfoManagerから呼び出される前提になっています。 */
public final class MessageInfoManager {

	/** あらゆる場所からアクセスしても大丈夫です。 */
	public MessageGetInfo getMessageInfo(long messageID) {

		MessageInfoDAO messageInfoDAO = new MessageInfoDAO();
		MessageInfo messageInfo = messageInfoDAO.getMessageInfo(messageID);
		return MessageGetInfo.create(messageInfo);
	}

	/** あらゆる場所からアクセスしても大丈夫です。 */
	public ArrayList<MessageGetInfo> getMessageInfoWithRoomInfo(long roomID) {

		MessageInfoDAO messageInfoDAO = new MessageInfoDAO();
		ArrayList<MessageInfo> list = messageInfoDAO.getMessageInfoWithRoomInfo(roomID);

		ArrayList<MessageGetInfo> result = new ArrayList<MessageGetInfo>();
		for (MessageInfo i : list) {
			result.add(MessageGetInfo.create(i));
		}

		return result;
	}

	/** あらゆる場所からアクセスしても大丈夫です。 */
	public MessageGetInfo getLatestMessageInfo(long roomID) {

		MessageInfoDAO messageInfoDAO = new MessageInfoDAO();
		MessageInfo messageInfo = messageInfoDAO.getLatestMessageInfo(roomID);

		return MessageGetInfo.create(messageInfo);
	}

	/** 処理的に、サーブレットのみで使用してほしいです。 */
	public void createMessageInfo(MessageCreateInfo messageCreateInfo) {

		MessageInfoDAO messageInfoDAO = new MessageInfoDAO();
		messageInfoDAO.createMessageInfo(messageCreateInfo);
	}

	/** 処理的に、MessageRoomInfoManagerのみで使用してほしいです。 */
	public void deleteMessageInfoWithMessageRoom(long roomID) {

		MessageInfoDAO messageInfoDAO = new MessageInfoDAO();
		messageInfoDAO.deleteMessageInfoWithMessageRoom(roomID);
	}

	/** 処理的に、StudentInfoManagerのみで使用してほしいです。 */
	public void deleteMessageInfoWithMailAddress(String mailAddress) {

		MessageInfoDAO messageInfoDAO = new MessageInfoDAO();
		messageInfoDAO.deleteMessageInfoWithMailAddress(mailAddress);
	}
}
