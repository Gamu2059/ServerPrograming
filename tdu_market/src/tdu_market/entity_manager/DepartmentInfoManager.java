package tdu_market.entity_manager;

import java.util.ArrayList;

import tdu_market.dao.DepartmentInfoDAO;
import tdu_market.dto.DepartmentGetInfo;
import tdu_market.entity_bean.DepartmentInfo;

public final class DepartmentInfoManager {

	public ArrayList<DepartmentGetInfo> getDepartmentInfoListWithDegree(long degreeID, boolean isIncludeNormalSubject) {

		DepartmentInfoDAO departmentInfoDAO = new DepartmentInfoDAO();
		ArrayList<DepartmentInfo> list = departmentInfoDAO.getDepartmentInfoWithDegree(degreeID,
				isIncludeNormalSubject);
		if (list == null) {
			return null;
		}

		ArrayList<DepartmentGetInfo> result = new ArrayList<DepartmentGetInfo>();
		for (DepartmentInfo i : list) {
			result.add(DepartmentGetInfo.create(i));
		}

		return result;
	}

	public ArrayList<DepartmentGetInfo> getDepartmentInfoListWithFaculty(long facultyID, boolean isIncludeNormalSubject) {

		DepartmentInfoDAO departmentInfoDAO = new DepartmentInfoDAO();
		ArrayList<DepartmentInfo> list = departmentInfoDAO.getDepartmentInfoWithFaculty(facultyID, isIncludeNormalSubject);
		if (list == null) {
			return null;
		}

		ArrayList<DepartmentGetInfo> result = new ArrayList<DepartmentGetInfo>();
		for (DepartmentInfo i : list) {
			result.add(DepartmentGetInfo.create(i));
		}

		return result;
	}

	public ArrayList<DepartmentGetInfo> getDepartmentInfoWithSubject(long subjectID, boolean isIncludeNormalSubject) {

		DepartmentInfoDAO departmentInfoDAO = new DepartmentInfoDAO();
		ArrayList<DepartmentInfo> list = departmentInfoDAO.getDepartmentInfoWithSubject(subjectID, isIncludeNormalSubject);
		if (list == null) {
			return null;
		}

		ArrayList<DepartmentGetInfo> result = new ArrayList<DepartmentGetInfo>();
		for (DepartmentInfo i : list) {
			result.add(DepartmentGetInfo.create(i));
		}

		return result;
	}

	public ArrayList<DepartmentGetInfo> getAllDepartmentInfoList(boolean isIncludeNormalSubject) {

		DepartmentInfoDAO departmentInfoDAO = new DepartmentInfoDAO();
		ArrayList<DepartmentInfo> list = departmentInfoDAO.getAllDepartmentInfo(isIncludeNormalSubject);
		if (list == null) {
			return null;
		}

		ArrayList<DepartmentGetInfo> result = new ArrayList<DepartmentGetInfo>();
		for (DepartmentInfo i : list) {
			result.add(DepartmentGetInfo.create(i));
		}

		return result;
	}
}
