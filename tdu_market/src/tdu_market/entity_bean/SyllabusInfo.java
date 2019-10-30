package tdu_market.entity_bean;

import java.io.Serializable;

public final class SyllabusInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String classCode;
	private String className;
	private long departmentID;
	private long teacherID;
	private String dates;
	private int unitNum;
	private String classRoom;
	private String overview;
	private String target;
	private String requirments;
	private String evaluationMethod;

	public SyllabusInfo() {
		super();
	}

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public long getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(long departmentID) {
		this.departmentID = departmentID;
	}

	public long getTeacherID() {
		return teacherID;
	}

	public void setTeacherID(long teacherID) {
		this.teacherID = teacherID;
	}

	public String getDates() {
		return dates;
	}

	public void setDates(String dates) {
		this.dates = dates;
	}

	public int getUnitNum() {
		return unitNum;
	}

	public void setUnitNum(int unitNum) {
		this.unitNum = unitNum;
	}

	public String getClassRoom() {
		return classRoom;
	}

	public void setClassRoom(String classRoom) {
		this.classRoom = classRoom;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getRequirments() {
		return requirments;
	}

	public void setRequirments(String requirments) {
		this.requirments = requirments;
	}

	public String getEvaluationMethod() {
		return evaluationMethod;
	}

	public void setEvaluationMethod(String evaluationMethod) {
		this.evaluationMethod = evaluationMethod;
	}
}
