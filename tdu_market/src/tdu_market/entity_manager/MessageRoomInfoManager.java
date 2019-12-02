package tdu_market.entity_manager;

import java.util.ArrayList;

import tdu_market.dao.MessageRoomInfoDAO;
import tdu_market.dto.ItemBuyInfo;
import tdu_market.dto.ItemGetInfo;
import tdu_market.dto.MessageGetInfo;
import tdu_market.dto.MessageRoomGetInfo;
import tdu_market.dto.RoomMemberCreateInfo;
import tdu_market.dto.RoomMemberGetInfo;
import tdu_market.dto.StudentGetInfo;
import tdu_market.entity_bean.MessageRoomInfo;

public final class MessageRoomInfoManager {

	/** メッセールルームを取得する。 */
	public ArrayList<MessageRoomGetInfo> getMessageRoomInfo(String mailAddress) {

		MessageRoomInfoDAO messageRoomInfoDAO = new MessageRoomInfoDAO();
		ArrayList<MessageRoomInfo> list = messageRoomInfoDAO.getMessageRoomInfo(mailAddress);

		if (list == null || list.size() < 1) {
			return null;
		}

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

				opponentStudentGetIfo = studentInfoManager.getStudentInfo(addresses[j], false);
				break;
			}

			MessageGetInfo latestMessageGetInfo = messageInfoManager.getLatestMessageInfo(i.getRoomID());

			result.add(MessageRoomGetInfo.create(i, opponentStudentGetIfo, latestMessageGetInfo));
		}

		return result;
	}

	/** メッセールルームを作成する。 */
	public void createMessageRoomInfo(ItemBuyInfo itemBuyInfo) {

		MessageRoomInfoDAO messageRoomInfoDAO = new MessageRoomInfoDAO();
		long roomID = messageRoomInfoDAO.createMessageRoomInfo();

		if (roomID < 1) {
			System.err.println("createMessageRoomInfo : roomID is invalid");
			return;
		}

		String beginTraderMailAddress = itemBuyInfo.getBeginTraderMailAddress();

		ItemInfoManager itemInfoManager = new ItemInfoManager();
		ItemGetInfo itemGetInfo = itemInfoManager.getItemInfo(itemBuyInfo.getTradedItemID());

		String exhibitorMailAddress = itemGetInfo.getExhibitorMailAddress();
		String[] members = new String[] {beginTraderMailAddress, exhibitorMailAddress};

		// ルームを作成する
		RoomMemberInfoManager roomMemberInfoManager = new RoomMemberInfoManager();
		RoomMemberCreateInfo roomMemberCreateInfo = new RoomMemberCreateInfo(roomID, members);
		roomMemberInfoManager.createRoomMemberInfo(roomMemberCreateInfo);
	}

	/** メッセールルームを削除する */
	public void deleteMessageRoomInfo(long roomID) {

		// 先にメッセージを削除する
		MessageInfoManager messageInfoManager = new MessageInfoManager();
		messageInfoManager.deleteMessageInfoWithMessageRoom(roomID);

		// 先にルームを削除する
		RoomMemberInfoManager roomMemberInfoManager = new RoomMemberInfoManager();
		roomMemberInfoManager.deleteRoomMemberInfoWithMessageRoom(roomID);

		MessageRoomInfoDAO messageRoomInfoDAO = new MessageRoomInfoDAO();
		messageRoomInfoDAO.deleteMessageRoomInfo(roomID);
	}
}
