package tdu_market.dto;

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
	private final String evaliationMethod;

	public SyllabusGetInfo(String classCode, String className, String openingSemester, String dates, int unitNum,
			String classRoom, String teacherName, String overview, String target, String requirments,
			String evaliationMethod) {
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
		this.evaliationMethod = evaliationMethod;
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

	public String getEvaliationMethod() {
		return evaliationMethod;
	}
}
