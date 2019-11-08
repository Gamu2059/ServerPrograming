package tdu_market.entity_manager;

import java.util.ArrayList;

import tdu_market.dao.DepartmentInfoDAO;
import tdu_market.dto.DepartmentGetInfo;
import tdu_market.entity_bean.DepartmentInfo;

public final class DepartmentInfoManager {

	public DepartmentGetInfo getDepartmentInfo(long departmentID) {

		DepartmentInfoDAO departmentInfoDAO = new DepartmentInfoDAO();
		DepartmentInfo departmentInfo = departmentInfoDAO.getDepartmentInfo(departmentID);
		return DepartmentGetInfo.create(departmentInfo);
	}

	public ArrayList<DepartmentGetInfo> getDepartmentInfoList() {

		DepartmentInfoDAO departmentInfoDAO = new DepartmentInfoDAO();
		ArrayList<DepartmentInfo> list = departmentInfoDAO.getAllDepartmentInfo();

		ArrayList<DepartmentGetInfo> result = new ArrayList<DepartmentGetInfo>();
		for (DepartmentInfo i : list) {
			result.add(DepartmentGetInfo.create(i));
		}

		return result;
	}
}
