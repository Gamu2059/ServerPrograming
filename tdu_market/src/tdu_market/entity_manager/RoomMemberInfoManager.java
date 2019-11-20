package tdu_market.entity_manager;

import java.util.ArrayList;

import tdu_market.dao.RoomMemberInfoDAO;
import tdu_market.dto.RoomMemberCreateInfo;
import tdu_market.dto.RoomMemberGetInfo;
import tdu_market.entity_bean.RoomMemberInfo;

/** 原則として、StudentInfoManagerやMessageRoomInfoManagerから呼び出される前提になっています。 */
public final class RoomMemberInfoManager {

	/** あらゆる場所からアクセスしても大丈夫です。 */
	public RoomMemberGetInfo getRoomMemberInfoWithMailAddress(String studentMailAddress) {

		RoomMemberInfoDAO roomMemberInfoDAO = new RoomMemberInfoDAO();
		ArrayList<RoomMemberInfo> list = roomMemberInfoDAO.getRoomMemberInfoWithMailAddress(studentMailAddress);

		long[] roomIDs = new long[list.size()];
		for (int i = 0; i < list.size(); i++) {
			roomIDs[i] = list.get(i).getRoomID();
		}

		return new RoomMemberGetInfo(new String[] { studentMailAddress }, roomIDs);
	}

	/** あらゆる場所からアクセスしても大丈夫です。 */
	public RoomMemberGetInfo getRoomMemberInfoWithRoomInfo(long roomID) {

		RoomMemberInfoDAO roomMemberInfoDAO = new RoomMemberInfoDAO();
		ArrayList<RoomMemberInfo> list = roomMemberInfoDAO.getRoomMemberInfoWithRoomInfo(roomID);

		String[] addresses = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			addresses[i] = list.get(i).getMemberMailAddress();
		}

		return new RoomMemberGetInfo(addresses, new long[] { roomID });
	}

	/** 処理的に、MessageRoomInfoManagerのみで使用してほしいです。 */
	public void createRoomMemberInfo(RoomMemberCreateInfo roomMemberCreateInfo) {

		RoomMemberInfoDAO roomMemberInfoDAO = new RoomMemberInfoDAO();
		roomMemberInfoDAO.createRoomMemberInfo(roomMemberCreateInfo);
	}

	/** 処理的に、MessageRoomInfoManagerのみで使用してほしいです。 */
	public void deleteRoomMemberInfoWithMessageRoom(long roomID) {

		RoomMemberInfoDAO roomMemberInfoDAO = new RoomMemberInfoDAO();
		roomMemberInfoDAO.deleteRoomMemberInfoWithMessageRoom(roomID);
	}

	/** 処理的に、StudentInfoInfoManagerのみで使用してほしいです。 */
	public void deleteRoomMemberInfoWithStudentMailAddress(String studentMailAddress) {

		RoomMemberInfoDAO roomMemberInfoDAO = new RoomMemberInfoDAO();
		roomMemberInfoDAO.deleteRoomMemberInfoWithMemberMailAddress(studentMailAddress);
	}
}
