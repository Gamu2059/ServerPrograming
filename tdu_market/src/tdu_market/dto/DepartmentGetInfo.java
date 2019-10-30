package tdu_market.dto;

public class DepartmentGetInfo {

	private final long departmentID;
	private final String facultyName;
	private final String subjectName;

	public DepartmentGetInfo(long departmentID, String facultyName, String subjectName) {
		super();
		this.departmentID = departmentID;
		this.facultyName = facultyName;
		this.subjectName = subjectName;
	}

	public long getDepartmentID() {
		return departmentID;
	}

	public String getFacultyName() {
		return facultyName;
	}

	public String getSubjectName() {
		return subjectName;
	}
}
