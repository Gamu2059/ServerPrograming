package tdu_market.entity_manager;

import java.util.ArrayList;

import tdu_market.dao.SemesterInfoDAO;
import tdu_market.dto.SemesterGetInfo;
import tdu_market.entity_bean.SemesterInfo;

/** 原則として、データが増えも減りもしない前提です。 */
public final class SemesterInfoManager {

	public boolean isExistSemester(long semesterID) {

		SemesterInfoDAO semesterInfoDAO = new SemesterInfoDAO();
		return semesterInfoDAO.getSemesterInfo(semesterID) != null;
	}

	public SemesterGetInfo getSemesterInfo(long semesterID) {

		SemesterInfoDAO semesterInfoDAO = new SemesterInfoDAO();
		SemesterInfo semesterInfo = semesterInfoDAO.getSemesterInfo(semesterID);
		return SemesterGetInfo.create(semesterInfo);
	}

	public ArrayList<SemesterGetInfo> getSemesterInfoList() {

		SemesterInfoDAO semesterInfoDAO = new SemesterInfoDAO();
		ArrayList<SemesterInfo> list = semesterInfoDAO.getAllSemesterInfo();

		ArrayList<SemesterGetInfo> result = new ArrayList<SemesterGetInfo>();
		for(SemesterInfo i : list) {
			result.add(SemesterGetInfo.create(i));
		}

		return result;
	}
}
