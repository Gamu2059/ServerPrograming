package tdu_market.dto;

import java.io.InputStream;

public class ManagerUpdateInfo {

	private final String mailAddress;
	private final String nonHashedPassword;
	private final String displayName;
	private final InputStream iconImageBinary;

	public ManagerUpdateInfo(String mailAddress, String nonHashedPassword, String displayName, InputStream iconImageBinary) {
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

	public InputStream getIconImageBinary() {
		return iconImageBinary;
	}
}
