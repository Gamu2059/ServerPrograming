package tdu_market.dto;

import tdu_market.entity_bean.StudentInfo;

public class StudentGetInfo {

	private final String mailAddress;
	private final String displayName;
	private final long departmentID;
	private final String selfIntroduction;
	private final String iconImageURL;

	public StudentGetInfo(String mailAddress, String displayName, long departmentID, String selfIntroduction,
			String iconImageURL) {
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

	public long getDepartmentID() {
		return departmentID;
	}

	public String getSelfIntroduction() {
		return selfIntroduction;
	}

	public String getIconImageURL() {
		return iconImageURL;
	}

	public static StudentGetInfo create(StudentInfo studentInfo) {

		if (studentInfo == null) {
			return null;
		}

		String addr = studentInfo.getMailAddress();
		String disp = studentInfo.getDisplayName();
		long depID = studentInfo.getDepartmentID();
		String intro = studentInfo.getSelfIntroduction();
		String icon = studentInfo.getIconImageURL();
		return new StudentGetInfo(addr, disp, depID, intro, icon);
	}
}
