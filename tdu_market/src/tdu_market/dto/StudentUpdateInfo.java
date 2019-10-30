package tdu_market.dto;

public class StudentUpdateInfo {

	private final String nonHashedPassword;
	private final String displayName;
	private final int departmentID;
	private final String selfIntroduction;
	private final String iconImageURL;

	public StudentUpdateInfo(String nonHashedPassword, String displayName, int departmentID, String selfIntroduction, String iconImageURL) {
		super();
		this.nonHashedPassword = nonHashedPassword;
		this.displayName = displayName;
		this.departmentID = departmentID;
		this.selfIntroduction = selfIntroduction;
		this.iconImageURL = iconImageURL;
	}

	public String getNonHashedPassword() {
		return nonHashedPassword;
	}

	public String getDisplayName() {
		return displayName;
	}

	public int getDepartmentID() {
		return departmentID;
	}

	public String getSelfIntroduction() {
		return selfIntroduction;
	}

	public String getIconImageURL() {
		return iconImageURL;
	}
}
