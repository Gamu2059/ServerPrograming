package tdu_market.entity_manager;

public final class AccountUtil {

	public static boolean isMeetRequirementMailAddress( String mailAddress) {
		System.err.println("isMeetRequirementMailAddress is non implementation!");
		return false;
	}

	public static boolean isMeetRequirementPassword( String nonHashedPassword ) {
		System.err.println("isMeetRequirementPassword is non implementation!");
		return false;
	}

	public static String getHashedPassword( String nonHashedPassword) {
		System.err.println("getHashedPassword is non implementation!");
		return nonHashedPassword;
	}

	public static boolean isStudentMailAddress( String mailAddress) {
		System.err.println("isStudentMailAddress is non implementation!");
		return false;
	}

	public static boolean isManagerMailAddress( String mailAddress ) {
		System.err.println("isManagerMailAddress is non implementation!");
		return false;
	}

	public static String getStudentNumber( String mailAddress ) {
		System.err.println("getStudentNumber is non implementation!");
		return mailAddress;
	}
}
