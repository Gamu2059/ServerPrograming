package tdu_market.dto;

public class StudentUpdateInfo {

	private final String mailAddress;
	private final String nonHashedPassword;
	private final String displayName;
	private final long departmentID;
	private final String selfIntroduction;
	private final String iconImageURL;

	public StudentUpdateInfo(String mailAddress, String nonHashedPassword, String displayName, long departmentID, String selfIntroduction, String iconImageURL) {
		super();
		this.mailAddress = mailAddress;
		this.nonHashedPassword = nonHashedPassword;
		this.displayName = displayName;
		this.departmentID = departmentID;
		this.selfIntroduction = selfIntroduction;
		this.iconImageURL = iconImageURL;
	}

	public String getMailAddress() {
		return mailAddress;
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

	public String getSelfIntroduction() {
		return selfIntroduction;
	}

	public String getIconImageURL() {
		return iconImageURL;
	}
}
