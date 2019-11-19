package tdu_market.dto;

public final class StudentCreateInfo {

	private final String mailAddress;
	private final String nonHashedPassword;
	private final String studentNumber;

	public StudentCreateInfo(String mailAddress, String nonHashedPassword, String studentNumber) {
		super();
		this.mailAddress = mailAddress;
		this.nonHashedPassword = nonHashedPassword;
		this.studentNumber = studentNumber;
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
}
