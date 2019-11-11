package tdu_market.dao;

import java.util.ArrayList;

import tdu_market.dto.RoomMemberCreateInfo;
import tdu_market.entity_bean.RoomMemberInfo;

public final class RoomMemberInfoDAO {

	public ArrayList<RoomMemberInfo> getRoomMemberInfoWithMailAddress(String studentMailAddress) {
		System.err.println("getRoomMemberInfoWithMailAddress is non implementation!");
		return null;
	}

	public ArrayList<RoomMemberInfo> getRoomMemberInfoWithRoomInfo(long roomID){
		System.err.println("getRoomMemberInfoWithRoomInfo is non implementation!");
		return null;
	}

	public void createRoomMemberInfo(RoomMemberCreateInfo roomMemberCreateInfo) {
		System.err.println("createRoomMemberInfo is non implementation!");
	}

	public void deleteRoomMemberInfoWithMessageRoom(long roomID) {
		System.err.println("deleteRoomMemberInfoWithMessageRoom is non implementation!");
	}

	public void deleteRoomMemberInfoWithStudentMailAddress(String studentMailAddress) {
		System.err.println("deleteRoomMemberInfoWithStudentNumber is non implementation!");
	}
}
