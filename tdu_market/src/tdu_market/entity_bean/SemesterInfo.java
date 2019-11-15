package tdu_market.entity_bean;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class SemesterInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final String SEMESTER_ID = "semesterID";
	private static final String YEAR = "year";
	private static final String SEMESTER = "semester";

	private long semesterID;
	private String year;
	private String semester;

	public SemesterInfo() {
		super();
	}

	public long getSemesterID() {
		return semesterID;
	}

	public void setSemesterID(long semesterID) {
		this.semesterID = semesterID;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	@Override
	public String toString() {
		return "SemesterInfo [semesterID=" + semesterID + ", year=" + year + ", semester=" + semester + "]";
	}

	public static SemesterInfo create(ResultSet resultSet) throws SQLException {

		if (resultSet == null) {
			return null;
		}

		SemesterInfo semesterInfo = new SemesterInfo();
		semesterInfo.setSemesterID(resultSet.getLong(SEMESTER_ID));
		semesterInfo.setYear(resultSet.getString(YEAR));
		semesterInfo.setSemester(resultSet.getString(SEMESTER));

		return semesterInfo;
	}
}
