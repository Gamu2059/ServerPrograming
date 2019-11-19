package tdu_market.dto;

public class StudentSearchInfo {

	private final String studentNumberKeyword;
	private final long subjectID;
	private final String displayNameKeyword;

	public StudentSearchInfo(String studentNumberKeyword, long subjectID, String displayNameKeyword) {
		super();
		this.studentNumberKeyword = studentNumberKeyword;
		this.subjectID = subjectID;
		this.displayNameKeyword = displayNameKeyword;
	}

	public String getStudentNumberKeyword() {
		return studentNumberKeyword;
	}

	public long getSubjectID() {
		return subjectID;
	}

	public String getDisplayNameKeyword() {
		return displayNameKeyword;
	}
}
