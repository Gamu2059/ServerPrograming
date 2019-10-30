package tdu_market.entity_bean;

import java.io.Serializable;

public final class CampusInfo implements Serializable {

	private static final long serialVersionUID = 1L;

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
}
