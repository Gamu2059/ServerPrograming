package tdu_market.dto;

public class SyllabusCreateInfo {

	private final String classCode;
	private final String className;
	private final long semesterID;
	private final String dates;
	private final int unitNum;
	private final String classRoom;
	private final long teacherID;
	private final String overview;
	private final String target;
	private final String requierments;
	private final String evaluationMethod;

	public SyllabusCreateInfo(String classCode, String className, long semesterID, String dates, int unitNum,
			String classRoom, long teacherID, String overview, String target, String requierments,
			String evaluationMethod) {
		super();
		this.classCode = classCode;
		this.className = className;
		this.semesterID = semesterID;
		this.dates = dates;
		this.unitNum = unitNum;
		this.classRoom = classRoom;
		this.teacherID = teacherID;
		this.overview = overview;
		this.target = target;
		this.requierments = requierments;
		this.evaluationMethod = evaluationMethod;
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

	public String getRequierments() {
		return requierments;
	}

	public String getEvaluationMethod() {
		return evaluationMethod;
	}
}
