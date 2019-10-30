package tdu_market.dto;

public class OpeningSemesterCreateInfo {

	private final String classCode;
	private final long[] semesterIDs;

	public OpeningSemesterCreateInfo(String classCode, long[] semesterIDs) {
		super();
		this.classCode = classCode;
		this.semesterIDs = semesterIDs;
	}

	public String getClassCode() {
		return classCode;
	}

	public long[] getSemesterIDs() {
		return semesterIDs;
	}
}
