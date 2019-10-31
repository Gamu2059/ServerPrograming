package tdu_market.entity_manager;

import java.util.ArrayList;

import tdu_market.dto.LoginInfo;
import tdu_market.dto.StudentGetInfo;
import tdu_market.dto.StudentSearchInfo;
import tdu_market.dto.StudentUpdateInfo;

public final class StudentInfoManager {

	public boolean existMailAddress(String mailAddress) {
		System.err.println("non implementation!");
		return false;
	}

	public boolean canLogin(LoginInfo loginInfo) {
		System.err.println("non implementation!");
		return false;
	}

	public void login(LoginInfo loginInfo) {
		System.err.println("non implementation!");
	}

	public void logout(String mailAddress) {
		System.err.println("non implementation!");
	}

	public boolean isRegisteredState(String mailAddress) {
		System.err.println("non implementation!");
		return false;
	}

	public String createTemporaryAccount(String mailAddress) {
		System.err.println("non implementation!");
		return null;
	}

	public StudentGetInfo getStudentInfo(String mailAddress) {
		System.err.println("non implementation!");
		return null;
	}

	public void makeStudentInfoRegistered(StudentUpdateInfo studentUpdateInfo) {
		System.err.println("non implementation!");
	}

	public void updateStudentInfo(StudentUpdateInfo studentUpdateInfo) {
		System.err.println("non implementation!");
	}

	public void deleteStudentInfo(String mailAddress) {
		System.err.println("non implementation!");
	}

	public ArrayList<StudentGetInfo> searchStudentInfo(StudentSearchInfo studentSearchInfo) {
		System.err.println("non implementation!");
		return null;
	}
}
