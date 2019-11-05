package tdu_market.entity_manager;

import java.util.ArrayList;

import tdu_market.dto.LoginInfo;
import tdu_market.dto.StudentGetInfo;
import tdu_market.dto.StudentSearchInfo;
import tdu_market.dto.StudentUpdateInfo;

public final class StudentInfoManager {

	public boolean existMailAddress(String mailAddress) {
		System.err.println("existMailAddress is non implementation!");
		return false;
	}

	public boolean canLogin(LoginInfo loginInfo) {
		System.err.println("canLogin non implementation!");
		return false;
	}

	public void login(LoginInfo loginInfo) {
		System.err.println("login is non implementation!");
	}

	public void logout(String mailAddress) {
		System.err.println("logout is non implementation!");
	}

	public boolean isRegisteredState(String mailAddress) {
		System.err.println("isRegisteredState is non implementation!");
		return false;
	}

	public String createTemporaryAccount(String mailAddress) {
		System.err.println("createTemporaryAccount is non implementation!");
		return null;
	}

	public StudentGetInfo getStudentInfo(String mailAddress) {
		System.err.println("getStudentInfo is non implementation!");
		return null;
	}

	public void makeStudentInfoRegistered(StudentUpdateInfo studentUpdateInfo) {
		System.err.println("makeStudentInfoRegistered is non implementation!");
	}

	public void updateStudentInfo(StudentUpdateInfo studentUpdateInfo) {
		System.err.println("updateStudentInfo is non implementation!");
	}

	public void deleteStudentInfo(String mailAddress) {
		System.err.println("deleteStudentInfo is non implementation!");
	}

	public ArrayList<StudentGetInfo> searchStudentInfo(StudentSearchInfo studentSearchInfo) {
		System.err.println("searchStudentInfo is non implementation!");
		return null;
	}
}
