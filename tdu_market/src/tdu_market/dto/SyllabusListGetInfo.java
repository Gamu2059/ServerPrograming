package tdu_market.dto;

public class SyllabusListGetInfo {

	private final String classCode;
	private final String className;
	private final String facultyName;
	private final String subjectName;
	private final String dates;
	private final String teacherName;
	private final String openingSemester;

	public SyllabusListGetInfo(String classCode, String className, String facultyName, String subjectName, String dates,
			String teacherName, String openingSemester) {
		super();
		this.classCode = classCode;
		this.className = className;
		this.facultyName = facultyName;
		this.subjectName = subjectName;
		this.dates = dates;
		this.teacherName = teacherName;
		this.openingSemester = openingSemester;
	}

	public String getClassCode() {
		return classCode;
	}

	public String getClassName() {
		return className;
	}

	public String getFacultyName() {
		return facultyName;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public String getDates() {
		return dates;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public String getOpeningSemester() {
		return openingSemester;
	}
}
