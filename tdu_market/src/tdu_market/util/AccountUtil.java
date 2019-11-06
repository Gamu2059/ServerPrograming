package tdu_market.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class AccountUtil {

	public static boolean isMeetRequirementMailAddress( String mailAddress) {

		if (mailAddress == null) {
			System.err.println("isMeetRequirementPassword() : mailAddress is null");
			return false;
		}

		return mailAddress.matches("[0-9a-zA-Z._]*@[0-9a-zA-Z._]*");

//		System.err.println("isMeetRequirementMailAddress is non implementation!");
//		return false;
	}

	public static boolean isMeetRequirementPassword( String nonHashedPassword ) {

		if (nonHashedPassword == null) {
			System.err.println("isMeetRequirementPassword() : nonHashedPassword is null");
			return false;
		}

		int length = nonHashedPassword.length();
		if (8 <= length && length <= 16) {
			System.err.println("isMeetRequirementPassword() : nonHashedPassword length is not between 8 and 16");
			return false;
		}

		return nonHashedPassword.matches("[0-9a-zA-Z]*");
//		System.err.println("isMeetRequirementPassword is non implementation!");
//		return false;
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
//		System.err.println("getHashedPassword is non implementation!");
//		return nonHashedPassword;
	}

	public static boolean isStudentMailAddress( String mailAddress) {

		if (mailAddress == null) {
			System.err.println("isStudentMailAddress() : mailAddress is null");
			return false;
		}

		return mailAddress.toLowerCase().matches("[0-9]{2}[a-z]{2}[0-9]{3}@ms\\.dendai\\.ac\\.jp");

		//		System.err.println("isStudentMailAddress is non implementation!");
//		return false;
	}

	public static boolean isManagerMailAddress( String mailAddress ) {

		if (mailAddress == null) {
			System.err.println("isManagerMailAddress() : mailAddress is null");
			return false;
		}

		return mailAddress.toLowerCase().matches("[0-9a-zA-Z._]*@[a-z]*\\.dendai\\.ac\\.jp");

//		System.err.println("isManagerMailAddress is non implementation!");
//		return false;
	}

	public static String getStudentNumber( String mailAddress ) {

		if (mailAddress == null) {
			System.err.println("getStudentNumber() : mailAddress is null");
			return null;
		}

		Pattern p = Pattern.compile("([0-9]{2}[a-z]{2}[0-9]{3})");
		Matcher m = p.matcher(mailAddress);


		if (!m.find()) {
			System.err.println("getStudentNumber() : student number is not found");
			return null;
		}

		System.out.println("getStudentNumber() : student number :" + m.group());
		return m.group();
//		System.err.println("getStudentNumber is non implementation!");
//		return mailAddress;
	}
}
