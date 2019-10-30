package tdu_market.dto;

public class SyllabusUpdateInfo {

	private final String previousClassCode;
	private final String classCode;
	private final String className;
	private final long semesterID;
	private final String dates;
	private final int unitNum;
	private final String classRoom;
	private final long teacherID;
	private final String overview;
	private final String target;
	private final String requirements;
	private final String evaluationMethod;

	public SyllabusUpdateInfo(String previousClassCode, String classCode, String className, long semesterID,
			String dates, int unitNum, String classRoom, long teacherID, String overview, String target,
			String requirements, String evaluationMethod) {
		super();
		this.previousClassCode = previousClassCode;
		this.classCode = classCode;
		this.className = className;
		this.semesterID = semesterID;
		this.dates = dates;
		this.unitNum = unitNum;
		this.classRoom = classRoom;
		this.teacherID = teacherID;
		this.overview = overview;
		this.target = target;
		this.requirements = requirements;
		this.evaluationMethod = evaluationMethod;
	}

	public String getPreviousClassCode() {
		return previousClassCode;
	}

	public String getClassCode() {
		return classCode;
	}

	public String getClassName() {
		return className;
	}

	public long getSemesterID() {
		return semesterID;
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

	public long getTeacherID() {
		return teacherID;
	}

	public String getOverview() {
		return overview;
	}

	public String getTarget() {
		return target;
	}

	public String getRequirements() {
		return requirements;
	}

	public String getEvaluationMethod() {
		return evaluationMethod;
	}
}
