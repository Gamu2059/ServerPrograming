package tdu_market.dto;

public final class StudentCreateInfo {

	private final String mailAddress;
	private final String hashedPassword;
	private final String studentNumber;

	public StudentCreateInfo(String mailAddress, String hashedPassword, String studentNumber) {
		super();
		this.mailAddress = mailAddress;
		this.hashedPassword = hashedPassword;
		this.studentNumber = studentNumber;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public String getHashedPassword() {
		return hashedPassword;
	}

	public String getStudentNumber() {
		return studentNumber;
	}
}
