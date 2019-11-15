package tdu_market.dto;

import tdu_market.entity_bean.DepartmentInfo;

public class DepartmentGetInfo {

	private final String facultyName;
	private final String subjectName;

	public DepartmentGetInfo(String facultyName, String subjectName) {
		super();
		this.facultyName = facultyName;
		this.subjectName = subjectName;
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

//		long depID = departmentInfo.getDepartmentID();
		String faculty = departmentInfo.getFacultyName();
		String subject = departmentInfo.getSubjectName();

		return new DepartmentGetInfo(faculty, subject);
	}
}
