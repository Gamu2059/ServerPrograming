package tdu_market.entity_manager;

import tdu_market.dao.ManagerInfoDAO;
import tdu_market.dto.LoginInfo;
import tdu_market.dto.ManagerCreateInfo;
import tdu_market.dto.ManagerGetInfo;
import tdu_market.dto.ManagerUpdateInfo;
import tdu_market.dto.ReturnInfo;
import tdu_market.entity_bean.ManagerInfo;
import tdu_market.util.AccountUtil;
import tdu_market.util.Def;
import tdu_market.util.PasswordUtil;

public final class ManagerInfoManager {

	/** DBの生のManagerInfoを取得する */
	private ManagerInfo getRawManagerInfo(String mailAddress) {
		ManagerInfoDAO managerInfoDAO = new ManagerInfoDAO();
		return managerInfoDAO.getManagerInfo(mailAddress);
	}

	/** 指定したメールアドレスが存在するか判定する。存在する場合は、trueの情報を返す。 */
	public ReturnInfo existMailAddress( String mailAddress ) {

		ManagerInfo managerInfo = getRawManagerInfo(mailAddress);
		boolean isExist = managerInfo != null;

		return new ReturnInfo(isExist ? "" : "アカウントが存在しません。", isExist);
	}

	/** ログインする。ログインに成功した場合は、trueの情報を返す。 */
	public ReturnInfo login( LoginInfo loginInfo ) {

		try {
			String mailAddress = loginInfo.getMailAddress();
			String password = loginInfo.getNonHashedPassword();
			ManagerInfo managerInfo = getRawManagerInfo(mailAddress);

			if (managerInfo == null) {
				return new ReturnInfo("メールアドレスまたはパスワードが正しくありません。");
			}

			if (!managerInfo.canLogin(password)) {
				return new ReturnInfo("メールアドレスまたはパスワードが正しくありません。");
			}

			managerInfo.login();

			return new ReturnInfo("", true);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/** ログアウトする。 */
	public void logout( String mailAddress ) {

		try {
			ManagerInfo managerInfo = getRawManagerInfo(mailAddress);

			if (managerInfo == null) {
				System.err.println("logout() : account is not found");
				return;
			}

			managerInfo.logout();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/** 本登録済みのアカウントかどうかを判定する。本登録済みの場合は、trueの情報を返す。 */
	public ReturnInfo isRegisteredState( String mailAddress ) {

		try {
			ManagerInfo managerInfo = getRawManagerInfo(mailAddress);

			if (managerInfo == null) {
				return new ReturnInfo("アカウントが存在しません。");
			}

			boolean isRegistered = managerInfo.getRegisterState() == Def.REGISTERED;

			return new ReturnInfo(isRegistered ? "" : "アカウントが本登録されていません。", isRegistered);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/** アカウントを仮登録状態で作成する。作成に成功した場合は、trueの情報と仮パスワードの情報を返す。 */
	public ReturnInfo createTemporaryAccount( String mailAddress ) {

		try {
			ReturnInfo existMailAddress = existMailAddress(mailAddress);
			if (existMailAddress.isSuccess()) {
				return new ReturnInfo("既にアカウントが存在しています。");
			}

			if (!AccountUtil.isMeetRequirementMailAddress(mailAddress)) {
				return new ReturnInfo("これはメールアドレスではありません。");
			}

			if (!AccountUtil.isManagerMailAddress(mailAddress)) {
				return new ReturnInfo("このメールアドレスは運営アカウントとして登録できません。");
			}

			String password = PasswordUtil.createNonHashedPassword();

			ManagerInfoDAO managerInfoDAO = new ManagerInfoDAO();
			managerInfoDAO.createManagerInfo(new ManagerCreateInfo(mailAddress, password));

			return new ReturnInfo(password, true);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/** アカウントを取得する。 */
	public ManagerGetInfo getManagerInfo( String mailAddress ) {

		ManagerInfo managerInfo = getRawManagerInfo(mailAddress);
		return ManagerGetInfo.create(managerInfo);
	}

	/** アカウントを更新する。 */
	public void updateManagerInfo( ManagerUpdateInfo managerUpdateInfo ) {

		ManagerInfoDAO managerInfoDAO = new ManagerInfoDAO();
		managerInfoDAO.updateManagerInfo(managerUpdateInfo);
	}

	/** アカウントを削除する。 */
	public void deleteManagerInfo( String mailAddress ) {

		ManagerInfoDAO managerInfoDAO = new ManagerInfoDAO();
		managerInfoDAO.deleteManagerInfo(mailAddress);
	}

	public static void main(String[] args) {

		ManagerInfoManager manager = new ManagerInfoManager();

		final String mail = "kawasumi@mail.dendai.ac.jp";
		final String pass = "HSsm49Y55XmfFk";
		final String name = "川澄 正史";

		ReturnInfo existResult = manager.existMailAddress(mail);
		if (existResult != null && existResult.isSuccess()) {
			manager.deleteManagerInfo(mail);
		}

		ReturnInfo createResult = manager.createTemporaryAccount(mail);
		System.out.println(createResult);

		if (createResult.isSuccess()) {
			System.out.println("初回パスワード : " + createResult.getMsg());
			System.out.println("初回ログイン");
			ReturnInfo loginResult = manager.login(new LoginInfo(mail, createResult.getMsg()));
			System.out.println(loginResult);

			System.out.println("初回アカウント設定");
			manager.updateManagerInfo(new ManagerUpdateInfo(mail, pass, name, ""));
		}

		System.out.println(manager.getManagerInfo(mail));

		System.out.println("アカウント更新");
		manager.updateManagerInfo(new ManagerUpdateInfo(mail, pass, "かわすーみ", ""));
		System.out.println(manager.getManagerInfo(mail));

		System.out.println("ログアウト");
		manager.logout(mail);

		System.out.println("ログイン(初回パスワードで)");
		System.out.println(manager.login(new LoginInfo(mail, createResult.getMsg())));

		System.out.println("ログイン(普通に)");
		System.out.println(manager.login(new LoginInfo(mail, pass)));
		System.out.println(manager.getManagerInfo(mail));
	}
}
