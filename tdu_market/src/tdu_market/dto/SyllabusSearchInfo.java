package tdu_market.dto;

public class SyllabusSearchInfo {

	private final String classCode;
	private final long departmentID;
	private final String classNameKeyword;
	private final String teacherNameKeyword;
	private final long semesterID;

	public SyllabusSearchInfo(String classCode, long departmentID, String classNameKeyword, String teacherNameKeyword,
			long semesterID) {
		super();
		this.classCode = classCode;
		this.departmentID = departmentID;
		this.classNameKeyword = classNameKeyword;
		this.teacherNameKeyword = teacherNameKeyword;
		this.semesterID = semesterID;
	}

	public String getClassCode() {
		return classCode;
	}

	public long getDepartmentID() {
		return departmentID;
	}

	public String getClassNameKeyword() {
		return classNameKeyword;
	}

	public String getTeacherNameKeyword() {
		return teacherNameKeyword;
	}

	public long getSemesterID() {
		return semesterID;
	}
}
