package tdu_market.util;

class AccountUtilTest {

	private String[] addrs = new String[] {
			"17fi103@ms.dendai.ac.jp",
			"yamagami0711syo@gmail.com",
			"19fmi003@ms.dendai.ac.jp",
			"hogwehgpwqog@jim.dendai.ac.jp",
			"gqe4rb9hn49dendai.ac.jp",
	};

	private String[] pass = new String[] {
			"sb5mA71tz45",
			"0v4y93b(TBG)",
			"3094tvny3pivn4oetnb3qo",
			"34b",
	};

	AccountUtilTest() {
		testIsMeetRequirementMailAddress();
		testIsMeetRequirementPassword();
		testGetHashedPassword();
		testIsStudentMailAddress();
		testIsManagerMailAddress();
		testGetStudentNumber();
	}

	void testIsMeetRequirementMailAddress() {
		for(String a : addrs) {
			checkAddress(a);
		}
	}

	void checkAddress(String addr) {
		System.out.println(addr + " is mailAddress? : " + AccountUtil.isMeetRequirementMailAddress(addr));
	}

	void testIsMeetRequirementPassword() {
		for(String a : pass) {
			checkPassword(a);
		}
	}

	void checkPassword(String pass) {
		System.out.println(pass + " is password? : " + AccountUtil.isMeetRequirementPassword(pass));
	}

	void testGetHashedPassword() {
		getPass("17fi103@ms.dendai.ac.jp", "sb5mA71tz45");
		getPass("17fi003@ms.dendai.ac.jp", "sb5mA71tz45");
		getPass("yamagam0711syo@mail.com", "sb5mA71tz45");
		getPass("17fi103@ms.dendai.ac.jp", "sb5mA71tz45");
	}

	void getPass(String addr, String pass) {
		System.out.println("addr : " + addr + ", pass : " + pass);
		System.out.println("=> hashed pass : " + AccountUtil.getHashedPassword(addr, pass));
	}

	void testIsStudentMailAddress() {
		for(String a : addrs) {
			checkIsStudent(a);
		}
	}

	void checkIsStudent(String addr) {
		System.out.println(addr + " is student? : " + AccountUtil.isStudentMailAddress(addr));
	}

	void testIsManagerMailAddress() {
		for(String a : addrs) {
			checkIsManager(a);
		}
	}

	void checkIsManager(String addr) {
		System.out.println(addr + " is manager? : " + AccountUtil.isManagerMailAddress(addr));
	}

	void testGetStudentNumber() {
		for(String a : addrs) {
			getStudentNumber(a);
		}
	}

	void getStudentNumber(String addr) {
		System.out.println(addr + "'s number : " + AccountUtil.getStudentNumber(addr));
	}

	public static void main(String[] args) {
		new AccountUtilTest();
	}
}
