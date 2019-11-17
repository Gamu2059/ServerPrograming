package tdu_market.dto;

public class SyllabusSearchInfo {

	private final String classCodeKeyword;
	private final long subjectID;
	private final String classNameKeyword;
	private final String teacherNameKeyword;
	private final long semesterID;

	public SyllabusSearchInfo(String classCodeKeyword, long subjectID, String classNameKeyword, String teacherNameKeyword,
			long semesterID) {
		super();
		this.classCodeKeyword = classCodeKeyword;
		this.subjectID = subjectID;
		this.classNameKeyword = classNameKeyword;
		this.teacherNameKeyword = teacherNameKeyword;
		this.semesterID = semesterID;
	}

	public String getClassCodeKeyword() {
		return classCodeKeyword;
	}

	public long getSubjectID() {
		return subjectID;
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
