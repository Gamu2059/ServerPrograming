package tdu_market.dto;

public class TeacherGetInfo {

	private final long teacherID;
	private final String teacherName;

	public TeacherGetInfo(long teacherID, String teacherName) {
		super();
		this.teacherID = teacherID;
		this.teacherName = teacherName;
	}

	public long getTeacherID() {
		return teacherID;
	}

	public String getTeacherName() {
		return teacherName;
	}
}
