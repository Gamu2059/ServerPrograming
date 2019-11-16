package tdu_market.entity_bean;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class TeacherInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final String TEACHER_ID = "teacherID";
	private static final String TEACHER_NAME = "teacherName";
	private static final String SUBJECT_ID = "subjectID";

	private long teacherID;
	private String teacherName;
	private long subjectID;

	public TeacherInfo() {
		super();
	}

	public long getTeacherID() {
		return teacherID;
	}

	public void setTeacherID(long teacherID) {
		this.teacherID = teacherID;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public long getSubjectID() {
		return subjectID;
	}

	public void setSubjectID(long subjectID) {
		this.subjectID = subjectID;
	}

	@Override
	public String toString() {
		return "TeacherInfo [teacherID=" + teacherID + ", teacherName=" + teacherName + ", subjectID=" + subjectID
				+ "]";
	}

	public static TeacherInfo create(ResultSet resultSet) throws SQLException {

		if (resultSet == null) {
			return null;
		}

		TeacherInfo teacherInfo = new TeacherInfo();
		teacherInfo.setTeacherID(resultSet.getLong(TEACHER_ID));
		teacherInfo.setTeacherName(resultSet.getString(TEACHER_NAME));
		teacherInfo.setSubjectID(resultSet.getLong(SUBJECT_ID));

		return teacherInfo;
	}
}
