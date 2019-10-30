package tdu_market.dto;

public class ManagerGetInfo {

	private final String mailAddress;
	private final String displayName;
	private final long departmentID;
	private final String iconImageURL;

	public ManagerGetInfo(String mailAddress, String displayName, long departmentID, String iconImageURL) {
		super();
		this.mailAddress = mailAddress;
		this.displayName = displayName;
		this.departmentID = departmentID;
		this.iconImageURL = iconImageURL;
	}

	public String getMailAddress() {
		return mailAddress;
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
