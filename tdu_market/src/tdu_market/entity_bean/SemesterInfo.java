package tdu_market.entity_bean;

import java.io.Serializable;

public final class SemesterInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private long semesterID;
	private String year;
	private String semester;

	public SemesterInfo() {
		super();
	}

	public long getSemesterID() {
		return semesterID;
	}

	public void setSemesterID(long semesterID) {
		this.semesterID = semesterID;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}
}
