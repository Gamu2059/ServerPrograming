package tdu_market.dto;

import tdu_market.entity_bean.ManagerInfo;

public class ManagerGetInfo {

	private final String mailAddress;
	private final String displayName;
	private final String iconImageURL;

	public ManagerGetInfo(String mailAddress, String displayName, String iconImageURL) {
		super();
		this.mailAddress = mailAddress;
		this.displayName = displayName;
		this.iconImageURL = iconImageURL;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public String getDisplayName() {
		return displayName;
	}

	public String getIconImageURL() {
		return iconImageURL;
	}

	public static ManagerGetInfo create(ManagerInfo managerInfo) {

		if (managerInfo == null) {
			return null;
		}

		String addr = managerInfo.getMailAddress();
		String disp = managerInfo.getDisplayName();
		String icon = managerInfo.getIconImageURL();
		return new ManagerGetInfo(addr, disp, icon);
	}
}
