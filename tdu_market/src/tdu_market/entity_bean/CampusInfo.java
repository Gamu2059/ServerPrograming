package tdu_market.entity_bean;

import java.io.Serializable;
import java.sql.ResultSet;

public final class CampusInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final String CAMPUS_ID = "campusID";
	private static final String CAMPUS_NAME = "campusName";

	private long campusID;
	private String campusName;

	public CampusInfo() {
		super();
	}

	public long getCampusID() {
		return campusID;
	}

	public void setCampusID(long campusID) {
		this.campusID = campusID;
	}

	public String getCampusName() {
		return campusName;
	}

	public void setCampusName(String campusName) {
		this.campusName = campusName;
	}

	@Override
	public String toString() {
		return "CampusInfo [campusID=" + campusID + ", campusName=" + campusName + "]";
	}

	public static CampusInfo create(ResultSet resultSet) {

		try {

			if (resultSet == null) {
				return null;
			}

			CampusInfo campusInfo = new CampusInfo();
			campusInfo.setCampusID(resultSet.getLong(CAMPUS_ID));
			campusInfo.setCampusName(resultSet.getString(CAMPUS_NAME));

			return campusInfo;
		} catch(Exception e) {

			throw new RuntimeException(e);
		}
	}
}
