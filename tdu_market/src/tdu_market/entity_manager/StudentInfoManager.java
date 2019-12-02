package tdu_market.entity_manager;

import java.util.ArrayList;

import tdu_market.dao.StudentInfoDAO;
import tdu_market.dto.DepartmentGetInfo;
import tdu_market.dto.ItemGetInfo;
import tdu_market.dto.LoginInfo;
import tdu_market.dto.ReturnInfo;
import tdu_market.dto.RoomMemberGetInfo;
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
	private StudentInfo getRawStudentInfo(String mailAddress, boolean isIncludeNonRegistered) {
		StudentInfoDAO studentInfoDAO = new StudentInfoDAO();
		return studentInfoDAO.getStudentInfo(mailAddress, isIncludeNonRegistered);
	}

	/** 指定したメールアドレスが存在するか判定する。存在する場合は、trueの情報を返す。 */
	public ReturnInfo existMailAddress(String mailAddress) {

		StudentInfo studentInfo = getRawStudentInfo(mailAddress, true);
		boolean isExist = studentInfo != null;

		return new ReturnInfo(isExist ? "" : "アカウントが存在しません。", isExist);
	}

	/** ログインする。ログインに成功した場合は、trueの情報を返す。 */
	public ReturnInfo login(LoginInfo loginInfo) {

		try {
			String mailAddress = loginInfo.getMailAddress();
			String password = loginInfo.getNonHashedPassword();
			StudentInfo studentInfo = getRawStudentInfo(mailAddress, true);

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
			StudentInfo studentInfo = getRawStudentInfo(mailAddress, true);

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
			StudentInfo studentInfo = getRawStudentInfo(mailAddress, true);

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
				return new ReturnInfo("これはメールアドレスではありません。");
			}

			// メールアドレスが学生メールアドレスであるか確認
			if (!AccountUtil.isStudentMailAddress(mailAddress)) {
				return new ReturnInfo("このメールアドレスは学生アカウントとして登録できません。");
			}

			String studentNumber = AccountUtil.getStudentNumber(mailAddress);
			String password = PasswordUtil.createNonHashedPassword();

			String subjectSymbol = AccountUtil.getSubjectSymbolFromStudentNumber(studentNumber);
			DepartmentInfoManager departmentInfoManager = new DepartmentInfoManager();
			ArrayList<DepartmentGetInfo> depList = departmentInfoManager.getAllDepartmentInfoList(false);
			long subjectID = -1;
			for (DepartmentGetInfo dep : depList) {
				if (subjectSymbol.equals(dep.getSubjectSymbol().toLowerCase())) {
					subjectID = dep.getSubjectID();
					break;
				}
			}

			if (subjectID < 1) {
				return new ReturnInfo("このメールアドレスから所属学科を推定できません。");
			}

			StudentInfoDAO studentInfoDAO = new StudentInfoDAO();
			studentInfoDAO.createStudentInfo(new StudentCreateInfo(mailAddress, password, studentNumber, subjectID));

			return new ReturnInfo(password, true);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/** アカウントを取得する。 */
	public StudentGetInfo getStudentInfo(String mailAddress, boolean isIncludeNonRegistered) {

		StudentInfo studentInfo = getRawStudentInfo(mailAddress, isIncludeNonRegistered);
		return StudentGetInfo.create(studentInfo);
	}

	/** 学生としてアカウントを更新する。 更新に成功した場合は、trueの情報を返す。*/
	public ReturnInfo updateStudentInfo(StudentUpdateInfo studentUpdateInfo) {

		String mailAddress = studentUpdateInfo.getMailAddress();
		String nonHashedPassword = studentUpdateInfo.getNonHashedPassword();

		// メールアドレスがメールアドレスの体を成しているか確認
		if (!AccountUtil.isMeetRequirementMailAddress(mailAddress)) {
			return new ReturnInfo("これはメールアドレスではありません。");
		}

		// メールアドレスが学生メールアドレスであるか確認
		if (!AccountUtil.isStudentMailAddress(mailAddress)) {
			return new ReturnInfo("このメールアドレスは学生アカウントとして使用できません。");
		}

		// パスワードが条件を満たしているか確認
		if (!AccountUtil.isMeetRequirementPassword(nonHashedPassword)) {
			return new ReturnInfo("パスワードは、8～16文字の英数字で設定して下さい。");
		}

		StudentInfoDAO studentInfoDAO = new StudentInfoDAO();
		studentInfoDAO.updateStudentInfo(studentUpdateInfo);

		return new ReturnInfo("", true);
	}

	/** 運営としてアカウントを更新する。 更新に成功した場合は、trueの情報を返す。*/
	public ReturnInfo updateStudentInfoByAdmin(StudentUpdateInfo studentUpdateInfo) {

		String mailAddress = studentUpdateInfo.getMailAddress();

		// メールアドレスがメールアドレスの体を成しているか確認
		if (!AccountUtil.isMeetRequirementMailAddress(mailAddress)) {
			return new ReturnInfo("これはメールアドレスではありません。");
		}

		// メールアドレスが学生メールアドレスであるか確認
		if (!AccountUtil.isStudentMailAddress(mailAddress)) {
			return new ReturnInfo("このメールアドレスは学生アカウントとして使用できません。");
		}

		StudentInfoDAO studentInfoDAO = new StudentInfoDAO();
		studentInfoDAO.updateStudentInfo(studentUpdateInfo);

		return new ReturnInfo("", true);
	}

	/** アカウントを削除する。 */
	public void deleteStudentInfo(String mailAddress) {

		RoomMemberInfoManager roomMemberInfoManager = new RoomMemberInfoManager();
		RoomMemberGetInfo roomMemberGetInfo = roomMemberInfoManager.getRoomMemberInfoWithMailAddress(mailAddress);

		if (roomMemberGetInfo != null) {
			// ルーム情報を削除する
			MessageRoomInfoManager messageRoomInfoManager = new MessageRoomInfoManager();
			for (long roomID : roomMemberGetInfo.getRoomIDs()) {
				messageRoomInfoManager.deleteMessageRoomInfo(roomID);
			}
		}

		// 出品物を削除する
		ItemInfoManager itemInfoManager = new ItemInfoManager();
		ArrayList<ItemGetInfo> itemGetInfos = itemInfoManager.getExhibitItem(mailAddress);
		if (itemGetInfos != null) {
			for (ItemGetInfo itemGetInfo : itemGetInfos) {
				itemInfoManager.deleteItemInfo(itemGetInfo.getItemID());
			}
		}

		// 学生情報を削除する
		StudentInfoDAO studentInfoDAO = new StudentInfoDAO();
		studentInfoDAO.deleteStudentInfo(mailAddress);
	}

	/** アカウントを検索する。 */
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
