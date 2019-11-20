package tdu_market.dto;

public class ManagerUpdateInfo {

	private final String mailAddress;
	private final String nonHashedPassword;
	private final String displayName;
	private final String iconImageBinary;

	public ManagerUpdateInfo(String mailAddress, String nonHashedPassword, String displayName, String iconImageBinary) {
		super();
		this.mailAddress = mailAddress;
		this.nonHashedPassword = nonHashedPassword;
		this.displayName = displayName;
		this.iconImageBinary = iconImageBinary;
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

	public String getIconImageBinary() {
		return iconImageBinary;
	}
}
