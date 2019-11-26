package tdu_market.dto;

import java.io.InputStream;

public class StudentUpdateInfo {

	private final String mailAddress;
	private final String nonHashedPassword;
	private final String displayName;
	private final long subjectID;
	private final String selfIntroduction;
	private final InputStream iconImageBinary;

	public StudentUpdateInfo(String mailAddress, String nonHashedPassword, String displayName, long subjectID, String selfIntroduction, InputStream iconImageBinary) {
		super();
		this.mailAddress = mailAddress;
		this.nonHashedPassword = nonHashedPassword;
		this.displayName = displayName;
		this.subjectID = subjectID;
		this.selfIntroduction = selfIntroduction;
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

	public long getSubjectID() {
		return subjectID;
	}

	public String getSelfIntroduction() {
		return selfIntroduction;
	}

	public InputStream getIconImageBinary() {
		return iconImageBinary;
	}
}
