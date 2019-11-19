package tdu_market.dto;

import tdu_market.entity_bean.DepartmentInfo;

public class DepartmentGetInfo {

	private final long degreeID;
	private final long facultyID;
	private final long subjectID;
	private final long campusID;

	private final String degree;
	private final String facultyName;
	private final String facultySymbol;
	private final String subjectName;
	private final String subjectSymbol;
	private final boolean isFullTime;

	public DepartmentGetInfo(long degreeID, long facultyID, long subjectID, long campusID, String degree,
			String facultyName, String facultySymbol, String subjectName, String subjectSymbol, boolean isFullTime) {
		super();
		this.degreeID = degreeID;
		this.facultyID = facultyID;
		this.subjectID = subjectID;
		this.campusID = campusID;
		this.degree = degree;
		this.facultyName = facultyName;
		this.facultySymbol = facultySymbol;
		this.subjectName = subjectName;
		this.subjectSymbol = subjectSymbol;
		this.isFullTime = isFullTime;
	}

	public long getDegreeID() {
		return degreeID;
	}

	public long getFacultyID() {
		return facultyID;
	}

	public long getSubjectID() {
		return subjectID;
	}

	public long getCampusID() {
		return campusID;
	}

	public String getDegree() {
		return degree;
	}

	public String getFacultyName() {
		return facultyName;
	}

	public String getFacultySymbol() {
		return facultySymbol;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public String getSubjectSymbol() {
		return subjectSymbol;
	}

	public boolean isFullTime() {
		return isFullTime;
	}


	@Override
	public String toString() {
		return "DepartmentGetInfo [degreeID=" + degreeID + ", facultyID=" + facultyID + ", subjectID=" + subjectID
				+ ", campusID=" + campusID + ", degree=" + degree + ", facultyName=" + facultyName + ", facultySymbol="
				+ facultySymbol + ", subjectName=" + subjectName + ", subjectSymbol=" + subjectSymbol + ", isFullTime="
				+ isFullTime + "]";
	}

	public static DepartmentGetInfo create(DepartmentInfo departmentInfo) {

		if (departmentInfo == null) {
			return null;
		}

		long degreeID = departmentInfo.getDegreeID();
		long facultyID = departmentInfo.getFacultyID();
		long subjectID = departmentInfo.getSubjectID();
		long campusID = departmentInfo.getCampusID();
		String degree = departmentInfo.getDegree();
		String facultyName = departmentInfo.getFacultyName();
		String facultySymbol = departmentInfo.getFacultySymbol();
		String subjectName = departmentInfo.getSubjectName();
		String subjectSymbol = departmentInfo.getSubjectSymbol();
		boolean isFullTime = departmentInfo.isFullTime();

		return new DepartmentGetInfo(degreeID, facultyID, subjectID, campusID, degree, facultyName, facultySymbol,
				subjectName, subjectSymbol, isFullTime);
	}
}
