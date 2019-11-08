package tdu_market.dto;

import tdu_market.entity_bean.SemesterInfo;

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

	public static SemesterGetInfo create(SemesterInfo semesterInfo) {

		if (semesterInfo == null) {
			return null;
		}

		long semesterID = semesterInfo.getSemesterID();
		String year = semesterInfo.getYear();
		String semester = semesterInfo.getSemester();

		return new SemesterGetInfo(semesterID, year, semester);
	}
}
