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
import tdu_market.util.AccountUtil;
import tdu_market.util.Def;
import tdu_market.util.PasswordUtil;

public final class StudentInfoManager {

	/** DBの生のStudentInfoを取得する */
	private StudentInfo getRawStudentInfo(String mailAddress) {
		StudentInfoDAO studentInfoDAO = new StudentInfoDAO();
		return studentInfoDAO.getStudentInfo(mailAddress);
	}

	/** 指定したメールアドレスが存在するか判定する。存在する場合は、trueの情報を返す。 */
	public ReturnInfo existMailAddress(String mailAddress) {

		StudentInfo studentInfo = getRawStudentInfo(mailAddress);
		boolean isExist = studentInfo != null;

		return new ReturnInfo(isExist ? "" : "アカウントが存在しません。", isExist);
	}

	/** ログインする。ログインに成功した場合は、trueの情報を返す。 */
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

	/** ログアウトする。 */
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

	/** 本登録済みのアカウントかどうかを判定する。本登録済みの場合は、trueの情報を返す。 */
	public ReturnInfo isRegisteredState(String mailAddress) {

		try {
			StudentInfo studentInfo = getRawStudentInfo(mailAddress);

			if (studentInfo == null) {
				return new ReturnInfo("アカウントが存在しません。");
			}

			boolean isRegistered = studentInfo.getRegisterState() == Def.REGISTERED;

			return new ReturnInfo(isRegistered ? "" : "アカウントが本登録されていません。", isRegistered);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/** アカウントを仮登録状態で作成する。作成に成功した場合は、trueの情報と仮パスワードの情報を返す。 */
	public ReturnInfo createTemporaryAccount(String mailAddress) {

		try {
			ReturnInfo existMailAddress = existMailAddress(mailAddress);
			if (existMailAddress.isSuccess()) {
				return new ReturnInfo("既にアカウントが存在しています。");
			}

			// メールアドレスがメールアドレスの体を成しているか確認
			if (!AccountUtil.isMeetRequirementMailAddress(mailAddress)) {
				return new ReturnInfo("メールアドレスを入力してください。");
			}

			// メールアドレスが学生メールアドレスであるか確認
			if (!AccountUtil.isStudentMailAddress(mailAddress)) {
				return new ReturnInfo("学籍番号メールアドレスを入力してください。");
			}

			String studnetNumber = AccountUtil.getStudentNumber(mailAddress);
			String password = PasswordUtil.createNonHashedPassword();

			StudentInfoDAO studentInfoDAO = new StudentInfoDAO();
			studentInfoDAO.createStudentInfo(new StudentCreateInfo(mailAddress, password, studnetNumber));

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
