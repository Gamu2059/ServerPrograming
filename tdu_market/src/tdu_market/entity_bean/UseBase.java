package tdu_market.entity_bean;

import java.util.Date;

public abstract class UseBase {

	protected static final String MAIL_ADDRESS = "mailAddress";
	protected static final String HASHED_PASSWORD = "hashedPassword";
	protected static final String DISPLAY_NAME = "displayName";
	protected static final String ICON_IMAGE_BINARY = "iconImageBinary";
	protected static final String REGISTER_STATE = "registerState";
	protected static final String CREATED_DATE = "createdDate";
	protected static final String LAST_LOGIN_DATE = "lastLoginDate";

	protected String mailAddress;
	protected String hashedPassword;
	protected String displayName;
	protected String iconImageBinary;
	protected int registerState;
	protected Date createdDate;
	protected Date lastLoginDate;

	public UseBase() {
		super();
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public String getHashedPassword() {
		return hashedPassword;
	}

	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getIconImageBinary() {
		return iconImageBinary;
	}

	public void setIconImageBinary(String iconImageBinary) {
		this.iconImageBinary = iconImageBinary;
	}

	public int getRegisterState() {
		return registerState;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setRegisterState(int registerState) {
		this.registerState = registerState;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public abstract boolean canLogin(String nonHashedPassword);

	public abstract void login();

	public abstract void logout();
}
