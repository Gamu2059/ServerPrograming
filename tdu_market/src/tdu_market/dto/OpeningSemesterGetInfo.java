package tdu_market.dto;

public class OpeningSemesterGetInfo {

	private final SyllabusGetInfo syllabusGetInfo;
	private final SemesterGetInfo[] openingSemesters;

	public OpeningSemesterGetInfo(SyllabusGetInfo syllabusGetInfo, SemesterGetInfo[] openingSemesters) {
		super();
		this.syllabusGetInfo = syllabusGetInfo;
		this.openingSemesters = openingSemesters;
	}

	public SyllabusGetInfo getSyllabusGetInfo() {
		return syllabusGetInfo;
	}

	public SemesterGetInfo[] getOpeningSemesters() {
		return openingSemesters;
	}
}
