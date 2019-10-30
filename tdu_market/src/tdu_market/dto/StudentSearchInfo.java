package tdu_market.dto;

public class StudentSearchInfo {

	private final String studentNumberKeyword;
	private final long departmentID;
	private final String displayNameKeyword;

	public StudentSearchInfo(String studentNumberKeyword, long departmentID, String displayNameKeyword) {
		super();
		this.studentNumberKeyword = studentNumberKeyword;
		this.departmentID = departmentID;
		this.displayNameKeyword = displayNameKeyword;
	}

	public String getStudentNumberKeyword() {
		return studentNumberKeyword;
	}

	public long getDepartmentID() {
		return departmentID;
	}

	public String getDisplayNameKeyword() {
		return displayNameKeyword;
	}
}
