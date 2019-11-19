package tdu_market.entity_manager;

import java.util.ArrayList;

import tdu_market.dao.MessageRoomInfoDAO;
import tdu_market.dto.MessageGetInfo;
import tdu_market.dto.MessageRoomCreateInfo;
import tdu_market.dto.MessageRoomGetInfo;
import tdu_market.dto.RoomMemberGetInfo;
import tdu_market.dto.StudentGetInfo;
import tdu_market.entity_bean.MessageRoomInfo;

public final class MessageRoomInfoManager {

	public ArrayList<MessageRoomGetInfo> getMessageRoomInfo(String mailAddress) {

		MessageRoomInfoDAO messageRoomInfoDAO = new MessageRoomInfoDAO();
		ArrayList<MessageRoomInfo> list = messageRoomInfoDAO.getMessageRoomInfo(mailAddress);

		ArrayList<MessageRoomGetInfo> result = new ArrayList<MessageRoomGetInfo>();
		RoomMemberInfoManager roomMemberInfoManager = new RoomMemberInfoManager();
		StudentInfoManager studentInfoManager = new StudentInfoManager();
		MessageInfoManager messageInfoManager = new MessageInfoManager();
		for (MessageRoomInfo i : list) {

			StudentGetInfo opponentStudentGetIfo = null;
			RoomMemberGetInfo roomMemberGetInfo = roomMemberInfoManager.getRoomMemberInfoWithRoomInfo(i.getRoomID());
			String[] addresses = roomMemberGetInfo.getMemberMailAddresses();
			for (int j = 0; j < addresses.length; j++) {

				if (addresses[j].equals(mailAddress)) {
					continue;
				}

				opponentStudentGetIfo = studentInfoManager.getStudentInfo(addresses[j]);
				break;
			}

			MessageGetInfo latestMessageGetInfo = messageInfoManager.getLatestMessageInfo(i.getRoomID());

			result.add(MessageRoomGetInfo.create(i, opponentStudentGetIfo, latestMessageGetInfo));
		}

		return result;
	}

	public void createMessageRoomInfo(MessageRoomCreateInfo messageRoomCreateInfo) {

		MessageRoomInfoDAO messageRoomInfoDAO = new MessageRoomInfoDAO();
		long roomID = messageRoomInfoDAO.createMessageRoomInfo();
	}

	public void deleteMessageRoomInfo(long roomID) {

		MessageRoomInfoDAO messageRoomInfoDAO = new MessageRoomInfoDAO();
		messageRoomInfoDAO.deleteMessageRoomInfo(roomID);
	}
}
