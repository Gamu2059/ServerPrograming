package tdu_market.entity_manager;

import java.util.ArrayList;

import tdu_market.dao.SyllabusInfoDAO;
import tdu_market.dto.OpeningSemesterGetInfo;
import tdu_market.dto.ReturnInfo;
import tdu_market.dto.SyllabusCreateInfo;
import tdu_market.dto.SyllabusGetInfo;
import tdu_market.dto.SyllabusSearchInfo;
import tdu_market.dto.SyllabusUpdateInfo;
import tdu_market.dto.TeacherGetInfo;
import tdu_market.entity_bean.SyllabusInfo;

public final class SyllabusInfoManager {

	public ReturnInfo existSyllabus(String classCode) {

		SyllabusInfoDAO syllabusInfoDAO = new SyllabusInfoDAO();
		SyllabusInfo syllabusInfo = syllabusInfoDAO.getSyllabusInfo(classCode);
		boolean isExist = syllabusInfo != null;

		return new ReturnInfo(isExist ? "" : "講義が存在しません。", isExist);
	}

	public ReturnInfo validateRegisterSyllabus(SyllabusCreateInfo syllabusCreateInfo) {

		try {

			String classCode = syllabusCreateInfo.getClassCode();
			String className = syllabusCreateInfo.getClassName();
			long semesterID = syllabusCreateInfo.getSemesterID();
			String dates = syllabusCreateInfo.getDates();
			int unitNum = syllabusCreateInfo.getUnitNum();
			String classRoom = syllabusCreateInfo.getClassRoom();
			long teacherID = syllabusCreateInfo.getTeacherID();

			ReturnInfo isExist = existSyllabus(classCode);
			if (isExist.isSuccess()) {
				return new ReturnInfo("同一のクラスコードを持つ講義が既に存在しています。");
			}


			return new ReturnInfo("", true);
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}

	public SyllabusGetInfo getSyllabusInfo(String classCode) {

		SyllabusInfoDAO syllabusInfoDAO = new SyllabusInfoDAO();
		SyllabusInfo syllabusInfo = syllabusInfoDAO.getSyllabusInfo(classCode);

		OpeningSemesterInfoManager openingSemesterInfoManager = new OpeningSemesterInfoManager();
		OpeningSemesterGetInfo openingSemesterGetInfo = openingSemesterInfoManager.getOpeningSemesterInfo(classCode);

		TeacherInfoManager teacherInfoManager = new TeacherInfoManager();
		TeacherGetInfo teacherGetInfo = teacherInfoManager.getTeacherInfo(syllabusInfo.getTeacherID());

		return SyllabusGetInfo.create(syllabusInfo, openingSemesterGetInfo, teacherGetInfo);
	}

	public void createSyllabusInfo(SyllabusCreateInfo syllabusCreateInfo) {

		SyllabusInfoDAO syllabusInfoDAO = new SyllabusInfoDAO();
		syllabusInfoDAO.createSyllabusInfo(syllabusCreateInfo);
	}

	public void updateSyllabusInfo(SyllabusUpdateInfo syllabusUpdateInfo) {

		SyllabusInfoDAO syllabusInfoDAO = new SyllabusInfoDAO();
		syllabusInfoDAO.updateSyllabusInfo(syllabusUpdateInfo);
	}

	public void deleteSyllabusInfo(String classCode) {

		SyllabusInfoDAO syllabusInfoDAO = new SyllabusInfoDAO();
		syllabusInfoDAO.deleteSyllabusInfo(classCode);
	}

	public ArrayList<SyllabusGetInfo> searchSyllabus(SyllabusSearchInfo syllabusSearchInfo) {

		SyllabusInfoDAO syllabusInfoDAO = new SyllabusInfoDAO();
		ArrayList<SyllabusInfo> searchResult = syllabusInfoDAO.searchSyllabusInfo(syllabusSearchInfo);

		ArrayList<SyllabusGetInfo> result = new ArrayList<SyllabusGetInfo>();
		OpeningSemesterInfoManager openingSemesterInfoManager = new OpeningSemesterInfoManager();
		TeacherInfoManager teacherInfoManager = new TeacherInfoManager();
		for(SyllabusInfo i : searchResult) {
			OpeningSemesterGetInfo openingSemesterGetInfo = openingSemesterInfoManager.getOpeningSemesterInfo(i.getClassCode());
			TeacherGetInfo teacherGetInfo = teacherInfoManager.getTeacherInfo(i.getTeacherID());
			result.add(SyllabusGetInfo.create(i, openingSemesterGetInfo, teacherGetInfo));
		}

		return result;
	}
}
