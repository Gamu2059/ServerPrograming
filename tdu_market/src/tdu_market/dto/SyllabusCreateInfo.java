package tdu_market.dto;

public class SyllabusCreateInfo {

	private final String classCode;
	private final String className;
	private final long subjectID;
	private final long teacherID;
	private final String dates;
	private final int unitNum;
	private final String classRoom;
	private final String overview;
	private final String target;
	private final String requirements;
	private final String evaluationMethod;

	public SyllabusCreateInfo(String classCode, String className, long subjectID, long teacherID, String dates,
			int unitNum, String classRoom, String overview, String target, String requirements,
			String evaluationMethod) {
		super();
		this.classCode = classCode;
		this.className = className;
		this.subjectID = subjectID;
		this.teacherID = teacherID;
		this.dates = dates;
		this.unitNum = unitNum;
		this.classRoom = classRoom;
		this.overview = overview;
		this.target = target;
		this.requirements = requirements;
		this.evaluationMethod = evaluationMethod;
	}

	public String getClassCode() {
		return classCode;
	}

	public String getClassName() {
		return className;
	}

	public long getSubjectID() {
		return subjectID;
	}

	public long getTeacherID() {
		return teacherID;
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
