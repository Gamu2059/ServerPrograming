package tdu_market.dto;

import tdu_market.entity_bean.DepartmentInfo;

public class DepartmentGetInfo {

	private final long departmentID;
	private final String facultyName;
	private final String subjectName;

	public DepartmentGetInfo(long departmentID, String facultyName, String subjectName) {
		super();
		this.departmentID = departmentID;
		this.facultyName = facultyName;
		this.subjectName = subjectName;
	}

	public long getDepartmentID() {
		return departmentID;
	}

	public String getFacultyName() {
		return facultyName;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public static DepartmentGetInfo create(DepartmentInfo departmentInfo) {

		if (departmentInfo == null) {
			return null;
		}

		long depID = departmentInfo.getDepartmentID();
		String faculty = departmentInfo.getFacultyName();
		String subject = departmentInfo.getSubjectName();

		return new DepartmentGetInfo(depID, faculty, subject);
	}
}
