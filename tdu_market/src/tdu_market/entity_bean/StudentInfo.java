package tdu_market.entity_bean;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import tdu_market.dao.StudentInfoDAO;
import tdu_market.util.AccountUtil;

public final class StudentInfo extends UseBase implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final String STUDENT_NUMBER = "studentNumber";
	private static final String SELF_INTRODUCTION = "selfIntroduction";
	private static final String SUBJECT_ID = "subjectID";

	private String studentNumber;
	private String selfIntroduction;
	private long subjectID;

	public StudentInfo() {
		super();
	}

	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getSelfIntroduction() {
		return selfIntroduction;
	}

	public void setSelfIntroduction(String selfIntroduction) {
		this.selfIntroduction = selfIntroduction;
	}

	public long getSubjectID() {
		return subjectID;
	}

	public void setSubjectID(long subjectID) {
		this.subjectID = subjectID;
	}

	@Override
	public String toString() {
		return "StudentInfo [studentNumber=" + studentNumber + ", selfIntroduction=" + selfIntroduction + ", subjectID="
				+ subjectID + ", mailAddress=" + mailAddress + ", hashedPassword=" + hashedPassword + ", displayName="
				+ displayName + ", iconImageBinary=" + iconImageBinary + ", registerState=" + registerState
				+ ", createdDate=" + createdDate + ", lastLoginDate=" + lastLoginDate + "]";
	}

	@Override
	public boolean canLogin(String nonHashedPassword) {
		String hashedPassword = AccountUtil.getHashedPassword(getMailAddress(), nonHashedPassword);
		return hashedPassword.equals(getHashedPassword());
	}

	@Override
	public void login() {
		StudentInfoDAO dao = new StudentInfoDAO();
		dao.updateLastLogin(getMailAddress());
	}

	@Override
	public void logout() {
		// ログアウトの記録をDBに保存するなら処理を何か記述する
	}

	public static StudentInfo create(ResultSet resultSet) throws SQLException {

		if (resultSet == null) {
			return null;
		}

		StudentInfo studentInfo = new StudentInfo();

		studentInfo.setMailAddress(resultSet.getString(MAIL_ADDRESS));
		studentInfo.setHashedPassword(resultSet.getString(HASHED_PASSWORD));
		studentInfo.setDisplayName(resultSet.getString(DISPLAY_NAME));
		studentInfo.setIconImageBinary(resultSet.getBinaryStream(ICON_IMAGE_BINARY));
		studentInfo.setRegisterState(resultSet.getInt(REGISTER_STATE));
		studentInfo.setCreatedDate(resultSet.getDate(CREATED_DATE));
		studentInfo.setLastLoginDate(resultSet.getDate(LAST_LOGIN_DATE));

		studentInfo.setStudentNumber(resultSet.getString(STUDENT_NUMBER));
		studentInfo.setSelfIntroduction(resultSet.getString(SELF_INTRODUCTION));
		studentInfo.setSubjectID(resultSet.getLong(SUBJECT_ID));

		return studentInfo;
	}
}
