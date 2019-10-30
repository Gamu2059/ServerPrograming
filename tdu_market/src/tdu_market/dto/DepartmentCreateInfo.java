package tdu_market.dto;

public class DepartmentCreateInfo {

	private final long departmentID;
	private final  String facultyName;
	private final String subjectName;
	private final long campusID;

	public DepartmentCreateInfo(long departmentID, String facultyName, String subjectName, long campusID) {
		super();
		this.departmentID = departmentID;
		this.facultyName = facultyName;
		this.subjectName = subjectName;
		this.campusID = campusID;
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

	public long getCampusID() {
		return campusID;
	}
}
