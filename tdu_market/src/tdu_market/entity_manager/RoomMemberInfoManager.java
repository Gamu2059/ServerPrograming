package tdu_market.entity_manager;

import java.util.ArrayList;

import tdu_market.dao.RoomMemberInfoDAO;
import tdu_market.dto.RoomMemberCreateInfo;
import tdu_market.dto.RoomMemberGetInfo;
import tdu_market.entity_bean.RoomMemberInfo;

public final class RoomMemberInfoManager {

	public RoomMemberGetInfo getRoomMemberInfoWithMailAddress(String studentMailAddress) {

		RoomMemberInfoDAO roomMemberInfoDAO = new RoomMemberInfoDAO();
		ArrayList<RoomMemberInfo> list = roomMemberInfoDAO.getRoomMemberInfoWithMailAddress(studentMailAddress);

		long[] roomIDs = new long[list.size()];
		for (int i = 0; i < list.size(); i++) {
			roomIDs[i] = list.get(i).getRoomID();
		}

		return new RoomMemberGetInfo(new String[] { studentMailAddress }, roomIDs);
	}

	public RoomMemberGetInfo getRoomMemberInfoWithRoomInfo(long roomID) {

		RoomMemberInfoDAO roomMemberInfoDAO = new RoomMemberInfoDAO();
		ArrayList<RoomMemberInfo> list = roomMemberInfoDAO.getRoomMemberInfoWithRoomInfo(roomID);

		String[] addresses = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			addresses[i] = list.get(i).getMemberMailAddress();
		}

		return new RoomMemberGetInfo(addresses, new long[] { roomID });
	}

	public void createRoomMemberInfo(RoomMemberCreateInfo roomMemberCreateInfo) {

		RoomMemberInfoDAO roomMemberInfoDAO = new RoomMemberInfoDAO();
		roomMemberInfoDAO.createRoomMemberInfo(roomMemberCreateInfo);
	}

	public void deleteRoomMemberInfoWithMessageRoom(long roomID) {

		RoomMemberInfoDAO roomMemberInfoDAO = new RoomMemberInfoDAO();
		roomMemberInfoDAO.deleteRoomMemberInfoWithMessageRoom(roomID);
	}

	public void deleteRoomMemberInfoWithStudentMailAddress(String studentMailAddress) {

		RoomMemberInfoDAO roomMemberInfoDAO = new RoomMemberInfoDAO();
		roomMemberInfoDAO.deleteRoomMemberInfoWithMemberMailAddress(studentMailAddress);
	}
}
