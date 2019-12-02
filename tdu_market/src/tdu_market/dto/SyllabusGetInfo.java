package tdu_market.dto;

import tdu_market.entity_bean.DepartmentInfo;
import tdu_market.entity_bean.SemesterInfo;
import tdu_market.entity_bean.SyllabusInfo;
import tdu_market.entity_bean.TeacherInfo;

public class SyllabusGetInfo {

	private final String classCode;
	private final String className;
	private final String openingSemester;
	private final String dates;
	private final int unitNum;
	private final String classRoom;
	private final long subjectID;
	private final String teacherName;
	private final String overview;
	private final String target;
	private final String requirments;
	private final String evaluationMethod;
	private final String facultyName;
	private final String subjectName;

	public SyllabusGetInfo(String classCode, String className, String openingSemester, String dates, int unitNum,
			String classRoom, long subjectID, String teacherName, String overview, String target, String requirments,
			String evaluationMethod, String facultyName, String subjectName) {
		super();
		this.classCode = classCode;
		this.className = className;
		this.openingSemester = openingSemester;
		this.dates = dates;
		this.unitNum = unitNum;
		this.classRoom = classRoom;
		this.subjectID = subjectID;
		this.teacherName = teacherName;
		this.overview = overview;
		this.target = target;
		this.requirments = requirments;
		this.evaluationMethod = evaluationMethod;
		this.facultyName = facultyName;
		this.subjectName = subjectName;
	}

	public String getClassCode() {
		return classCode;
	}

	public String getClassName() {
		return className;
	}

	public String getOpeningSemester() {
		return openingSemester;
	}

	public String getDates() {
		return dates;
	}

	public int getUnitNum() {
		return unitNum;
	}

	public String getClassRoom() {
		return classRoom;
	}

	public long getSubjectID() {
		return subjectID;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public String getOverview() {
		return overview;
	}

	public String getTarget() {
		return target;
	}

	public String getRequirments() {
		return requirments;
	}

	public String getEvaluationMethod() {
		return evaluationMethod;
	}

	public String getFacultyName() {
		return facultyName;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public static SyllabusGetInfo create(SyllabusInfo syllabusInfo, SemesterInfo semesterInfo, TeacherInfo teacherInfo, DepartmentInfo departmentInfo) {

		if (syllabusInfo == null || semesterInfo == null || teacherInfo == null || departmentInfo == null) {
			return null;
		}

		String classCode = syllabusInfo.getClassCode();
		String className = syllabusInfo.getClassName();
		String openingSemester = String.format("%s年度%s", semesterInfo.getYear(), semesterInfo.getSemester());
		String dates = syllabusInfo.getDates();
		int unitNum = syllabusInfo.getUnitNum();
		String classRoom = syllabusInfo.getClassRoom();
		long subjectID = syllabusInfo.getSubjectID();
		String teacherName = teacherInfo.getTeacherName();
		String overview = syllabusInfo.getOverview();
		String target = syllabusInfo.getTarget();
		String requirments = syllabusInfo.getRequirements();
		String evaluationMethod = syllabusInfo.getEvaluationMethod();
		String facultyName = departmentInfo.getFacultyName();
		String subjectName = departmentInfo.getSubjectName();

		return new SyllabusGetInfo(classCode, className, openingSemester, dates, unitNum, classRoom, subjectID, teacherName, overview, target, requirments, evaluationMethod, facultyName, subjectName);
	}
}
