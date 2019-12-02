package tdu_market.dto;

public class StudentSearchInfo {

	private final String studentNumberKeyword;
	private final long subjectID;
	private final String displayNameKeyword;
	private final boolean isIncludeNonRegistered;

	public StudentSearchInfo(String studentNumberKeyword, long subjectID, String displayNameKeyword, boolean isIncludeNonRegistered) {
		super();
		this.studentNumberKeyword = studentNumberKeyword;
		this.subjectID = subjectID;
		this.displayNameKeyword = displayNameKeyword;
		this.isIncludeNonRegistered = isIncludeNonRegistered;
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

	public boolean isIncludeNonRegistered() {
		return isIncludeNonRegistered;
	}
}
