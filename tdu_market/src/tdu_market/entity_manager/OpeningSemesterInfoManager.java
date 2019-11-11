package tdu_market.entity_manager;

import java.util.ArrayList;

import tdu_market.dao.OpeningSemesterInfoDAO;
import tdu_market.dto.OpeningSemesterCreateInfo;
import tdu_market.dto.OpeningSemesterGetInfo;
import tdu_market.dto.SemesterGetInfo;
import tdu_market.entity_bean.OpeningSemesterInfo;

public final class OpeningSemesterInfoManager {

	public OpeningSemesterGetInfo getOpeningSemesterInfo(String classCode) {

		OpeningSemesterInfoDAO openingSemesterInfoDAO = new OpeningSemesterInfoDAO();
		ArrayList<OpeningSemesterInfo> list = openingSemesterInfoDAO.getOpeningSemesterInfo(classCode);

		SemesterInfoManager semesterInfoManager = new SemesterInfoManager();
		SemesterGetInfo[] semesterGetInfos = new SemesterGetInfo[list.size()];
		for(int i=0;i<list.size();i++) {

			semesterGetInfos[i] = semesterInfoManager.getSemesterInfo(list.get(i).getSemesterID());
		}

		return new OpeningSemesterGetInfo(classCode, semesterGetInfos);
	}

	public void createOpeningSemesterInfo(OpeningSemesterCreateInfo openingSemesterCreateInfo) {

		OpeningSemesterInfoDAO openingSemesterInfoDAO = new OpeningSemesterInfoDAO();
		openingSemesterInfoDAO.createOpeningSemesterInfo(openingSemesterCreateInfo);
	}

	public void deleteOpeningSemesterInfo(String classCode) {

		OpeningSemesterInfoDAO openingSemesterInfoDAO = new OpeningSemesterInfoDAO();
		openingSemesterInfoDAO.deleteOpeningSemesterInfo(classCode);
	}
}
