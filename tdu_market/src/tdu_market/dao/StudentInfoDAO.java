package tdu_market.dao;

import java.util.ArrayList;

import tdu_market.dto.StudentCreateInfo;
import tdu_market.dto.StudentSearchInfo;
import tdu_market.dto.StudentUpdateInfo;
import tdu_market.entity_bean.StudentInfo;

public final class StudentInfoDAO {

	public StudentInfo createStudentInfo(StudentCreateInfo studentCreateInfo) {
		System.err.println("createStudentInfo is non implementation!");
		return null;
	}

	public StudentInfo getStudentInfo(String mailAddress) {
		System.err.println("getStudentInfo is non implementation!");
		return null;
	}

	public void updateStudentInfo(StudentUpdateInfo studentUpdateInfo) {
		System.err.println("updateStudentInfo is non implementation!");
	}

	public void deleteStudentInfo(String mailAddress) {
		System.err.println("deleteStudentInfo is non implementation!");
	}

	public void updateLastLogin(String mailAddress) {
		System.err.println("updateLastLogin is non implementation!");
	}

	public ArrayList<StudentInfo> searchStudentInfo(StudentSearchInfo studentSearchInfo) {
		System.err.println("searchStudentInfo is non implementation!");
		return null;
	}
}
