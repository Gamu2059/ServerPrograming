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
				return new ReturnInfo("メールアドレスまたはパスワードが正しくありません。");
			}

			if (!studentInfo.canLogin(password)) {
				return new ReturnInfo("メールアドレスまたはパスワードが正しくありません。");
			}

			studentInfo.login();

			return new ReturnInfo("", true);
		} catch (Exception e) {
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
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public ReturnInfo isRegisteredState(String mailAddress) {

		try {
			StudentInfo studentInfo = getRawStudentInfo(mailAddress);

			if (studentInfo == null) {
				return new ReturnInfo("アカウントが存在しません。");
			}

			boolean isRegistered = studentInfo.getRegisterationState() == Def.REGISTERED;

			return new ReturnInfo(isRegistered ? "" : "アカウントが本登録されていません。", isRegistered);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public ReturnInfo createTemporaryAccount(String mailAddress) {

		try {
			ReturnInfo existMailAddress = existMailAddress(mailAddress);
			if (existMailAddress.isSuccess()) {
				return new ReturnInfo("既にアカウントが存在しています。");
			}

			String password = PasswordUtil.createNonHashedPassword();

			StudentInfoDAO studentInfoDAO = new StudentInfoDAO();
			studentInfoDAO.createStudentInfo(new StudentCreateInfo(mailAddress, password));

			return new ReturnInfo(password, true);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public StudentGetInfo getStudentInfo(String mailAddress) {

		StudentInfo studentInfo = getRawStudentInfo(mailAddress);
		return StudentGetInfo.create(studentInfo);
	}

	public void makeStudentInfoRegistered(StudentUpdateInfo studentUpdateInfo) {

		StudentInfoDAO studentInfoDAO = new StudentInfoDAO();
		studentInfoDAO.updateStudentInfo(studentUpdateInfo);
	}

	public void updateStudentInfo(StudentUpdateInfo studentUpdateInfo) {

		StudentInfoDAO studentInfoDAO = new StudentInfoDAO();
		studentInfoDAO.updateStudentInfo(studentUpdateInfo);
	}

	public void deleteStudentInfo(String mailAddress) {

		StudentInfoDAO studentInfoDAO = new StudentInfoDAO();
		studentInfoDAO.deleteStudentInfo(mailAddress);
	}

	public ArrayList<StudentGetInfo> searchStudentInfo(StudentSearchInfo studentSearchInfo) {

		StudentInfoDAO studentInfoDAO = new StudentInfoDAO();
		ArrayList<StudentInfo> searchResult = studentInfoDAO.searchStudentInfo(studentSearchInfo);
		if (searchResult == null) {
			return null;
		}

		ArrayList<StudentGetInfo> result = new ArrayList<StudentGetInfo>();
		for (StudentInfo i : searchResult) {
			result.add(StudentGetInfo.create(i));
		}

		return result;
	}
}
