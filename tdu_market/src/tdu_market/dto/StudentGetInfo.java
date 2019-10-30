package tdu_market.dto;

public class StudentGetInfo {

	private final String mailAddress;
	private final String displayName;
	private final int departmentID;
	private final String selfIntroduction;
	private final String iconImageURL;

	public StudentGetInfo(String mailAddress, String displayName, int departmentID, String selfIntroduction, String iconImageURL) {
		super();
		this.mailAddress = mailAddress;
		this.displayName = displayName;
		this.departmentID = departmentID;
		this.selfIntroduction = selfIntroduction;
		this.iconImageURL = iconImageURL;
	}

	public String getMailAddress() {
		return mailAddress;
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
