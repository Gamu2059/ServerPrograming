package tdu_market.dto;

import tdu_market.entity_bean.ManagerInfo;
import tdu_market.util.ImageUtil;

public class ManagerGetInfo {

	private final String mailAddress;
	private final String displayName;
	private final String iconImageBinary;

	public ManagerGetInfo(String mailAddress, String displayName, String iconImageBinary) {
		super();
		this.mailAddress = mailAddress;
		this.displayName = displayName;
		this.iconImageBinary = iconImageBinary;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public String getDisplayName() {
		return displayName;
	}

	public String getIconImageBinary() {
		return iconImageBinary;
	}


	@Override
	public String toString() {
		return "ManagerGetInfo [mailAddress=" + mailAddress + ", displayName=" + displayName + ", iconImageBinary="
				+ iconImageBinary + "]";
	}

	public static ManagerGetInfo create(ManagerInfo managerInfo) {

		if (managerInfo == null) {
			return null;
		}

		String addr = managerInfo.getMailAddress();
		String disp = managerInfo.getDisplayName();
		String icon = ImageUtil.getImage(managerInfo.getIconImageBinary());
		return new ManagerGetInfo(addr, disp, icon);
	}
}
