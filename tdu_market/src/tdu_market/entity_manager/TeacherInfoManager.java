package tdu_market.entity_manager;

import java.util.ArrayList;

import tdu_market.dao.TeacherInfoDAO;
import tdu_market.dto.TeacherGetInfo;
import tdu_market.entity_bean.TeacherInfo;

public final class TeacherInfoManager {

	public TeacherGetInfo getTeacherInfo(long teacherID) {

		TeacherInfoDAO teacherInfoDAO = new TeacherInfoDAO();
		TeacherInfo teacherInfo = teacherInfoDAO.getTeacherInfo(teacherID);
		return TeacherGetInfo.create(teacherInfo);
	}

	public ArrayList<TeacherGetInfo> getTeacherInfoList() {

		TeacherInfoDAO teacherInfoDAO = new TeacherInfoDAO();
		ArrayList<TeacherInfo> list = teacherInfoDAO.getAllTeacherInfo();

		ArrayList<TeacherGetInfo> result = new ArrayList<TeacherGetInfo>();
		for(TeacherInfo i : list) {
			result.add(TeacherGetInfo.create(i));
		}

		return result;
	}
}
