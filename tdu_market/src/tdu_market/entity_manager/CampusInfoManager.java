package tdu_market.entity_manager;

import java.util.ArrayList;

import tdu_market.dao.CampusInfoDAO;
import tdu_market.dto.CampusGetInfo;
import tdu_market.entity_bean.CampusInfo;

public final class CampusInfoManager {

	public CampusGetInfo getCampusInfo(long campusID) {

		CampusInfoDAO campusInfoDAO = new CampusInfoDAO();
		CampusInfo campusInfo = campusInfoDAO.getCampusInfo(campusID);
		return CampusGetInfo.create(campusInfo);
	}

	public ArrayList<CampusGetInfo> getCampusInfoList() {

		CampusInfoDAO campusInfoDAO = new CampusInfoDAO();
		ArrayList<CampusInfo> list = campusInfoDAO.getAllCampusInfo();

		ArrayList<CampusGetInfo> result = new ArrayList<CampusGetInfo>();
		for (CampusInfo i : list) {
			result.add(CampusGetInfo.create(i));
		}

		return result;
	}
}
