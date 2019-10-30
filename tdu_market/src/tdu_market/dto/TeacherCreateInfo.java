package tdu_market.dto;

public class TeacherCreateInfo {

	private final long teacherID;
	private final String teacherName;
	private final long departmentID;

	public TeacherCreateInfo(long teacherID, String teacherName, long departmentID) {
		super();
		this.teacherID = teacherID;
		this.teacherName = teacherName;
		this.departmentID = departmentID;
	}

	public long getTeacherID() {
		return teacherID;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public long getDepartmentID() {
		return departmentID;
	}
}
