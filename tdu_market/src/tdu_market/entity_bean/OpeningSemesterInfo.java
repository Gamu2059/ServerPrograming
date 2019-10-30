package tdu_market.entity_bean;

import java.io.Serializable;

public final class OpeningSemesterInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String classCode;
	private long semesterID;

	public OpeningSemesterInfo() {
		super();
	}

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public long getSemesterID() {
		return semesterID;
	}

	public void setSemesterID(long semesterID) {
		this.semesterID = semesterID;
	}
}
