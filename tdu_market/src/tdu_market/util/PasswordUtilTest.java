package tdu_market.util;

class PasswordUtilTest {

	public PasswordUtilTest() {
		testGetHashedPassword();
		testCreateNonHashedPassword();
	}

	void testGetHashedPassword() {
	}

	void testCreateNonHashedPassword() {
		for(int i=0;i<10;i++) {
			String p = PasswordUtil.createNonHashedPassword();
			System.out.println("Password: " + p);
		}
	}

	public static void main(String[] args) {
		new PasswordUtilTest();
	}
}
