package tdu_market.entity_manager;

import java.util.ArrayList;

import tdu_market.dao.StudentInfoDAO;
import tdu_market.dto.LoginInfo;
import tdu_market.dto.ReturnInfo;
import tdu_market.dto.StudentCreateInfo;
import tdu_market.dto.StudentGetInfo;
import tdu_market.dto.StudentSearchInfo;
import tdu_market.dto.StudentUpdateInfo;
import tdu_market.entity_bean.StudentInfo;
import tdu_market.util.Def;
import tdu_market.util.PasswordUtil;

public final class StudentInfoManager {

	private StudentInfo getRawStudentInfo(String mailAddress) {
		StudentInfoDAO studentInfoDAO = new StudentInfoDAO();
		return studentInfoDAO.getStudentInfo(mailAddress);
	}

	public ReturnInfo existMailAddress(String mailAddress) {

		StudentInfo studentInfo = getRawStudentInfo(mailAddress);
		boolean isExist = studentInfo != null;

		return new ReturnInfo(isExist ? "" : "アカウントが存在しません。", isExist);
	}

	public ReturnInfo login(LoginInfo loginInfo) {

		try {
			String mailAddress = loginInfo.getMailAddress();
			String password = loginInfo.getNonHashedPassword();
			StudentInfo studentInfo = getRawStudentInfo(mailAddress);

			if (studentInfo == null) {
				return new ReturnInfo("メールアドレスまたはパスワードが正しくありません。", false);
			}

			if (!studentInfo.canLogin(password)) {
				return new ReturnInfo("メールアドレスまたはパスワードが正しくありません。", false);
			}

			studentInfo.login();

			return new ReturnInfo("", true);
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void logout(String mailAddress) {

		try {
			StudentInfo studentInfo = getRawStudentInfo(mailAddress);

			if (studentInfo == null) {
				System.err.println("logout() : account is not found");
				return;
			}

			studentInfo.logout();
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}

	public ReturnInfo isRegisteredState(String mailAddress) {

		try {
			StudentInfo studentInfo = getRawStudentInfo(mailAddress);

			if (studentInfo == null) {
				return new ReturnInfo("アカウントが存在しません。", false);
			}

			boolean isRegistered = studentInfo.getRegisterationState() == Def.REGISTERED;

			return new ReturnInfo(isRegistered ? "" : "アカウントが本登録されていません。", isRegistered);
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}

	public ReturnInfo createTemporaryAccount(String mailAddress) {

		try {
			ReturnInfo existMailAddress = existMailAddress(mailAddress);
			if (existMailAddress.isSuccess()) {
				return new ReturnInfo("既にアカウントが存在しています。", false);
			}

			String password = PasswordUtil.createNonHashedPassword();

			StudentInfoDAO studentInfoDAO = new StudentInfoDAO();
			studentInfoDAO.createStudentInfo(new StudentCreateInfo(mailAddress, password));

			return new ReturnInfo(password, true);
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
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
