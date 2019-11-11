package tdu_market.dto;

import tdu_market.entity_bean.TeacherInfo;

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

	public static TeacherGetInfo create(TeacherInfo teacherInfo) {

		if (teacherInfo == null) {
			return null;
		}

		long teacherID = teacherInfo.getTeacherID();
		String name = teacherInfo.getTeacherName();

		return new TeacherGetInfo(teacherID, name);
	}
}
