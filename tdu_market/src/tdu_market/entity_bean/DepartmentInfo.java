package tdu_market.entity_bean;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class DepartmentInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final String DEGREE_ID = "degreeID";
	private static final String FACULTY_ID = "facultyID";
	private static final String SUBJECT_ID = "subjectID";
	private static final String CAMPUS_ID = "campusID";

	private static final String DEGREE = "degree";
	private static final String FACULTY_NAME = "facultyName";
	private static final String FACULTY_SYMBOL = "facultySymbol";
	private static final String SUBJECT_NAME = "subjectName";
	private static final String SUBJECT_SYMBOL = "subjectSymbol";
	private static final String IS_FULL_TIME = "isFullTime";

	private long degreeID;
	private long facultyID;
	private long subjectID;
	private long campusID;

	private String degree;
	private String facultyName;
	private String facultySymbol;
	private String subjectName;
	private String subjectSymbol;
	private boolean isFullTime;

	public DepartmentInfo() {
		super();
	}

	public long getDegreeID() {
		return degreeID;
	}

	public long getFacultyID() {
		return facultyID;
	}

	public long getSubjectID() {
		return subjectID;
	}

	public long getCampusID() {
		return campusID;
	}

	public String getDegree() {
		return degree;
	}

	public String getFacultyName() {
		return facultyName;
	}

	public String getFacultySymbol() {
		return facultySymbol;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public String getSubjectSymbol() {
		return subjectSymbol;
	}

	public boolean isFullTime() {
		return isFullTime;
	}

	public void setDegreeID(long degreeID) {
		this.degreeID = degreeID;
	}

	public void setFacultyID(long facultyID) {
		this.facultyID = facultyID;
	}

	public void setSubjectID(long subjectID) {
		this.subjectID = subjectID;
	}

	public void setCampusID(long campusID) {
		this.campusID = campusID;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}

	public void setFacultySymbol(String facultySymbol) {
		this.facultySymbol = facultySymbol;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public void setSubjectSymbol(String subjectSymbol) {
		this.subjectSymbol = subjectSymbol;
	}

	public void setFullTime(boolean isFullTime) {
		this.isFullTime = isFullTime;
	}



	@Override
	public String toString() {
		return "DepartmentInfo [degreeID=" + degreeID + ", facultyID=" + facultyID + ", subjectID=" + subjectID
				+ ", campusID=" + campusID + ", degree=" + degree + ", facultyName=" + facultyName + ", facultySymbol="
				+ facultySymbol + ", subjectName=" + subjectName + ", subjectSymbol=" + subjectSymbol + ", isFullTime="
				+ isFullTime + "]";
	}

	public static DepartmentInfo create(ResultSet resultSet) throws SQLException {

		if (resultSet == null) {
			return null;
		}

		DepartmentInfo departmentInfo = new DepartmentInfo();

		departmentInfo.setDegreeID(resultSet.getLong(DEGREE_ID));
		departmentInfo.setFacultyID(resultSet.getLong(FACULTY_ID));
		departmentInfo.setSubjectID(resultSet.getLong(SUBJECT_ID));
		departmentInfo.setCampusID(resultSet.getLong(CAMPUS_ID));

		departmentInfo.setDegree(resultSet.getString(DEGREE));
		departmentInfo.setFacultyName(resultSet.getString(FACULTY_NAME));
		departmentInfo.setFacultySymbol(resultSet.getString(FACULTY_SYMBOL));
		departmentInfo.setSubjectName(resultSet.getString(SUBJECT_NAME));
		departmentInfo.setSubjectSymbol(resultSet.getString(SUBJECT_SYMBOL));
		departmentInfo.setFullTime(resultSet.getBoolean(IS_FULL_TIME));

		return departmentInfo;
	}
}
