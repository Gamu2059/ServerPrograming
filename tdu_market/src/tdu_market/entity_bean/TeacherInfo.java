package tdu_market.entity_bean;

import java.io.Serializable;

public final class TeacherInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private long teacherID;
	private String teacherName;
	private long departmentID;

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

	public long getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(long departmentID) {
		this.departmentID = departmentID;
	}
}
