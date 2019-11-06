package tdu_market.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class AccountUtil {

	private static final String ADDRESS_MATCH = "^[0-9a-zA-Z._]*@[0-9a-zA-Z._]*$";
	private static final String PASSWORD_MATCH = "[0-9a-zA-Z]{8,16}";
	private static final String STUDENT_NUMBER_MATCH = "[0-9]{2}[a-z]{2,3}[0-9]{3}";
	private static final String STUDENT_DOMAIN = "ms\\.dendai\\.ac\\.jp";
	private static final String STUDENT_ADDRESS_MATCH = "^" + STUDENT_NUMBER_MATCH + "@" + STUDENT_DOMAIN + "$";
	private static final String MANAGER_ADDRESS_MATCH = "^[0-9a-zA-Z._]*@[a-z]*\\.dendai\\.ac\\.jp(?<!" + STUDENT_DOMAIN + ")$";

	public static boolean isMeetRequirementMailAddress( String mailAddress) {

		if (mailAddress == null) {
			System.err.println("isMeetRequirementPassword() : mailAddress is null");
			return false;
		}

		return mailAddress.matches(ADDRESS_MATCH);
	}

	public static boolean isMeetRequirementPassword( String nonHashedPassword ) {

		if (nonHashedPassword == null) {
			System.err.println("isMeetRequirementPassword() : nonHashedPassword is null");
			return false;
		}

		return nonHashedPassword.matches(PASSWORD_MATCH);
	}

	public static String getHashedPassword(String mailAddress, String nonHashedPassword) {

		if (mailAddress == null) {
			System.err.println("getHashedPassword() : mailAddress is null");
			return null;
		}

		if (nonHashedPassword == null) {
			System.err.println("getHashedPassword() : nonHashedPassword is null");
			return null;
		}

		return PasswordUtil.getHashedPassword(nonHashedPassword, mailAddress);
	}

	public static boolean isStudentMailAddress( String mailAddress) {

		if (mailAddress == null) {
			System.err.println("isStudentMailAddress() : mailAddress is null");
			return false;
		}

		return mailAddress.toLowerCase().matches(STUDENT_ADDRESS_MATCH);
	}

	public static boolean isManagerMailAddress( String mailAddress ) {

		if (mailAddress == null) {
			System.err.println("isManagerMailAddress() : mailAddress is null");
			return false;
		}

		// 学生ならば運営として認めない
		if (isStudentMailAddress(mailAddress)) {
			return false;
		}

		return mailAddress.toLowerCase().matches(MANAGER_ADDRESS_MATCH);
	}

	public static String getStudentNumber( String mailAddress ) {

		if (mailAddress == null) {
			System.err.println("getStudentNumber() : mailAddress is null");
			return null;
		}

		Pattern p = Pattern.compile("(^" + STUDENT_NUMBER_MATCH + ")");
		Matcher m = p.matcher(mailAddress);


		if (!m.find()) {
			System.err.println("getStudentNumber() : student number is not found");
			return null;
		}

		return m.group();
	}
}
