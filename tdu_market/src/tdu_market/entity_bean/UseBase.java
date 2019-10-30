package tdu_market.entity_bean;

import java.util.Date;

public abstract class UseBase {

	private String mailAddress;
	private String hashedPassword;
	private String displayName;
	private String iconImageURL;
	private int registerationState;
	private Date createDate;
	private Date lastLoginDate;

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

	public String getIconImageURL() {
		return iconImageURL;
	}

	public void setIconImageURL(String iconImageURL) {
		this.iconImageURL = iconImageURL;
	}

	public int getRegisterationState() {
		return registerationState;
	}

	public void setRegisterationState(int registerationState) {
		this.registerationState = registerationState;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
}
