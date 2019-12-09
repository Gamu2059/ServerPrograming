package tdu_market.entity_bean;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class SyllabusInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String CLASS_CODE = "classCode";
	public static final String CLASS_NAME = "className";
	public static final String SUBJECT_ID = "classSubjectID";
	public static final String TEACHER_ID = "classTeacherID";
	public static final String DATES = "dates";
	public static final String UNIT_NUM = "unitNum";
	public static final String CLASS_ROOM = "classRoom";
	public static final String OVERVIEW = "overview";
	public static final String TARGET = "target";
	public static final String REQUIREMENTS = "requirements";
	public static final String EVALUATIONMETHOD = "evaluationMethod";

	private String classCode;
	private String className;
	private long subjectID;
	private long teacherID;
	private String dates;
	private int unitNum;
	private String classRoom;
	private String overview;
	private String target;
	private String requirements;
	private String evaluationMethod;

	public SyllabusInfo() {
		super();
	}

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public long getSubjectID() {
		return subjectID;
	}

	public void setSubjectID(long subjectID) {
		this.subjectID = subjectID;
	}

	public long getTeacherID() {
		return teacherID;
	}

	public void setTeacherID(long teacherID) {
		this.teacherID = teacherID;
	}

	public String getDates() {
		return dates;
	}

	public void setDates(String dates) {
		this.dates = dates;
	}

	public int getUnitNum() {
		return unitNum;
	}

	public void setUnitNum(int unitNum) {
		this.unitNum = unitNum;
	}

	public String getClassRoom() {
		return classRoom;
	}

	public void setClassRoom(String classRoom) {
		this.classRoom = classRoom;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getRequirements() {
		return requirements;
	}

	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}

	public String getEvaluationMethod() {
		return evaluationMethod;
	}

	public void setEvaluationMethod(String evaluationMethod) {
		this.evaluationMethod = evaluationMethod;
	}

	@Override
	public String toString() {
		return "SyllabusInfo [classCode=" + classCode + ", className=" + className + ", subjectID=" + subjectID
				+ ", teacherID=" + teacherID + ", dates=" + dates + ", unitNum=" + unitNum + ", classRoom=" + classRoom
				+ ", overview=" + overview + ", target=" + target + ", requirements=" + requirements
				+ ", evaluationMethod=" + evaluationMethod + "]";
	}

	public static SyllabusInfo create(ResultSet resultSet) throws SQLException {

		if (resultSet == null) {
			return null;
		}

		SyllabusInfo syllabusInfo = new SyllabusInfo();

		syllabusInfo.setClassCode(resultSet.getString(CLASS_CODE));
		syllabusInfo.setClassName(resultSet.getString(CLASS_NAME));
		syllabusInfo.setTeacherID(resultSet.getLong(TEACHER_ID));
		syllabusInfo.setSubjectID(resultSet.getLong(SUBJECT_ID));
		syllabusInfo.setDates(resultSet.getString(DATES));
		syllabusInfo.setUnitNum(resultSet.getInt(UNIT_NUM));
		syllabusInfo.setClassRoom(resultSet.getString(CLASS_ROOM));
		syllabusInfo.setOverview(resultSet.getString(OVERVIEW));
		syllabusInfo.setTarget(resultSet.getString(TARGET));
		syllabusInfo.setRequirements(resultSet.getString(REQUIREMENTS));
		syllabusInfo.setEvaluationMethod(resultSet.getString(EVALUATIONMETHOD));

		return syllabusInfo;
	}
}
