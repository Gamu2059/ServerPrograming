package tdu_market.dto;

import tdu_market.entity_bean.CampusInfo;

public class CampusGetInfo {

	private final long campusID;
	private final String campusName;

	public CampusGetInfo(long campusID, String campusName) {
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

	public static CampusGetInfo create(CampusInfo campusInfo) {

		if (campusInfo == null) {
			return null;
		}

		long camID = campusInfo.getCampusID();
		String name = campusInfo.getCampusName();

		return new CampusGetInfo(camID, name);
	}
}
