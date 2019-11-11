package tdu_market.dto;

public final class ManagerCreateInfo {

	private final String mailAddress;
	private final String nonHashedPassword;

	public ManagerCreateInfo(String mailAddress, String nonHashedPassword) {
		super();
		this.mailAddress = mailAddress;
		this.nonHashedPassword = nonHashedPassword;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public String getNonHashedPassword() {
		return nonHashedPassword;
	}
}
