package tdu_market.dto;

import tdu_market.entity_bean.SyllabusInfo;

public class SyllabusGetInfo {

	private final String classCode;
	private final String className;
	private final String openingSemester;
	private final String dates;
	private final int unitNum;
	private final String classRoom;
	private final String teacherName;
	private final String overview;
	private final String target;
	private final String requirments;
	private final String evaluationMethod;

	public SyllabusGetInfo(String classCode, String className, String openingSemester, String dates, int unitNum,
			String classRoom, String teacherName, String overview, String target, String requirments,
			String evaluationMethod) {
		super();
		this.classCode = classCode;
		this.className = className;
		this.openingSemester = openingSemester;
		this.dates = dates;
		this.unitNum = unitNum;
		this.classRoom = classRoom;
		this.teacherName = teacherName;
		this.overview = overview;
		this.target = target;
		this.requirments = requirments;
		this.evaluationMethod = evaluationMethod;
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

	public static SyllabusGetInfo create(SyllabusInfo syllabusInfo, OpeningSemesterGetInfo openingSemesterGetInfo, TeacherGetInfo teacherGetInfo) {

		if (syllabusInfo == null) {
			return null;
		}

		String classCode = syllabusInfo.getClassCode();
		String className = syllabusInfo.getClassName();
		String openingSemester = null;
		String dates = syllabusInfo.getDates();
		int unitNum = syllabusInfo.getUnitNum();
		String classRoom = syllabusInfo.getClassRoom();
		String teacherName = null;
		String overview = syllabusInfo.getOverview();
		String target = syllabusInfo.getTarget();
		String requirments = syllabusInfo.getRequirments();
		String evaluationMethod = syllabusInfo.getEvaluationMethod();

		if (openingSemesterGetInfo != null) {

			SemesterGetInfo[] semesterGetInfos = openingSemesterGetInfo.getOpeningSemesters();
			if (semesterGetInfos != null) {
				for(SemesterGetInfo i : semesterGetInfos) {
					String s = i.getSemester();
					if (s == null || s.trim().isEmpty()) {
						continue;
					}

					openingSemester = s.trim();
					break;
				}
			}
		}

		if (teacherGetInfo != null) {
			teacherName = teacherGetInfo.getTeacherName();
		}

		return new SyllabusGetInfo(classCode, className, openingSemester, dates, unitNum, classRoom, teacherName, overview, target, requirments, evaluationMethod);
	}
}
