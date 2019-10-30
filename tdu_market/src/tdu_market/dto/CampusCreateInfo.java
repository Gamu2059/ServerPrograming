package tdu_market.dto;

public class CampusCreateInfo {

	private final long campusID;
	private final String campusName;

	public CampusCreateInfo(long campusID, String campusName) {
		super();
		this.campusID = campusID;
		this.campusName = campusName;
	}

	public long getCampusID() {
		return campusID;
	}

	public String getCampusName() {
		return campusName;
	}
}
