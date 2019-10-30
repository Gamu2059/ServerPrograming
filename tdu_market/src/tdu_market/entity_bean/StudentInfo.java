package tdu_market.entity_bean;

import java.io.Serializable;

public final class StudentInfo extends UseBase implements Serializable {

	private static final long serialVersionUID = 1L;

	private String studentNumber;
	private String selfIntroduction;
	private long departmentID;

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

	public long getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(long departmentID) {
		this.departmentID = departmentID;
	}
}
