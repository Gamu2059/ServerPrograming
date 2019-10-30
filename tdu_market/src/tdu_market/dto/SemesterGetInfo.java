package tdu_market.dto;

public class SemesterGetInfo {

	private final long semesterID;
	private final String year;
	private final String semester;

	public SemesterGetInfo(long semesterID, String year, String semester) {
		super();
		this.semesterID = semesterID;
		this.year = year;
		this.semester = semester;
	}

	public long getSemesterID() {
		return semesterID;
	}

	public String getYear() {
		return year;
	}

	public String getSemester() {
		return semester;
	}
}
