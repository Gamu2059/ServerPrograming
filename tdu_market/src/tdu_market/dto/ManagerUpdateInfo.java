package tdu_market.dto;

public class ManagerUpdateInfo {

	private final String nonHashedPassword;
	private final String displayName;
	private final long departmentID;
	private final String iconImageURL;

	public ManagerUpdateInfo(String nonHashedPassword, String displayName, long departmentID, String iconImageURL) {
		super();
		this.nonHashedPassword = nonHashedPassword;
		this.displayName = displayName;
		this.departmentID = departmentID;
		this.iconImageURL = iconImageURL;
	}

	public String getNonHashedPassword() {
		return nonHashedPassword;
	}

	public String getDisplayName() {
		return displayName;
	}

	public long getDepartmentID() {
		return departmentID;
	}

	public String getIconImageURL() {
		return iconImageURL;
	}
}
