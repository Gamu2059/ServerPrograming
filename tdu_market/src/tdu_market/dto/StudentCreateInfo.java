package tdu_market.dto;

public final class StudentCreateInfo {

	private final String mailAddress;
	private final String nonHashedPassword;
	private final String studentNumber;
	private final long subjectID;

	public StudentCreateInfo(String mailAddress, String nonHashedPassword, String studentNumber, long subjectID) {
		super();
		this.mailAddress = mailAddress;
		this.nonHashedPassword = nonHashedPassword;
		this.studentNumber = studentNumber;
		this.subjectID = subjectID;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public String getNonHashedPassword() {
		return nonHashedPassword;
	}

	public String getStudentNumber() {
		return studentNumber;
	}

	public long getSubjectID() {
		return subjectID;
	}
}
