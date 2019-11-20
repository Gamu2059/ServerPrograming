package tdu_market.entity_bean;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class OpeningSemesterInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final String CLASS_CODE = "classCode";
	private static final String SEMESTER_ID = "semesterID";

	private String classCode;
	private long semesterID;

	public OpeningSemesterInfo() {
		super();
	}

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public long getSemesterID() {
		return semesterID;
	}

	public void setSemesterID(long semesterID) {
		this.semesterID = semesterID;
	}

	@Override
	public String toString() {
		return "OpeningSemesterInfo [classCode=" + classCode + ", semesterID=" + semesterID + "]";
	}

	public static OpeningSemesterInfo create(ResultSet resultSet) throws SQLException {

		if (resultSet == null) {
			return null;
		}

		OpeningSemesterInfo openingSemesterInfo = new OpeningSemesterInfo();

		openingSemesterInfo.setClassCode(resultSet.getString(CLASS_CODE));
		openingSemesterInfo.setSemesterID(resultSet.getLong(SEMESTER_ID));

		return openingSemesterInfo;
	}
}
