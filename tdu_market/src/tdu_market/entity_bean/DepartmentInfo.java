package tdu_market.entity_bean;

import java.io.Serializable;

public final class DepartmentInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private long departmentID;
	private String facultyName;
	private String subjectName;
	private long campusID;

	public DepartmentInfo() {
		super();
	}

	public long getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(long departmentID) {
		this.departmentID = departmentID;
	}

	public String getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public long getCampusID() {
		return campusID;
	}

	public void setCampusID(long campusID) {
		this.campusID = campusID;
	}
}
