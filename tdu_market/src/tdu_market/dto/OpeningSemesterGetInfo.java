package tdu_market.dto;

public class OpeningSemesterGetInfo {

	// 設計上、循環参照になってしまうため、SyllabusGetInfoは参照しない
	private final String classCode;
	private final SemesterGetInfo[] openingSemesters;



	public OpeningSemesterGetInfo(String classCode, SemesterGetInfo[] openingSemesters) {
		super();
		this.classCode = classCode;
		this.openingSemesters = openingSemesters;
	}

	public String getClassCode() {
		return classCode;
	}

	public SemesterGetInfo[] getOpeningSemesters() {
		return openingSemesters;
	}
}
