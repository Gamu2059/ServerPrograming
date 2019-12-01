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

	/** アカウントを更新する。 更新に成功した場合、trueの情報を返す。*/
	public ReturnInfo updateManagerInfo( ManagerUpdateInfo managerUpdateInfo ) {

		String mailAddress = managerUpdateInfo.getMailAddress();
		String nonHashedPassword = managerUpdateInfo.getNonHashedPassword();

		// メールアドレスがメールアドレスの体を成しているか確認
		if (!AccountUtil.isMeetRequirementMailAddress(mailAddress)) {
			return new ReturnInfo("これはメールアドレスではありません。");
		}

		// メールアドレスが運営メールアドレスであるか確認
		if (!AccountUtil.isManagerMailAddress(mailAddress)) {
			return new ReturnInfo("このメールアドレスは運営アカウントとして使用できません。");
		}

		// パスワードが条件を満たしているか確認
		if (!AccountUtil.isMeetRequirementPassword(nonHashedPassword)) {
			return new ReturnInfo("パスワードは、8～16文字の英数字で設定して下さい。");
		}

		ManagerInfoDAO managerInfoDAO = new ManagerInfoDAO();
		managerInfoDAO.updateManagerInfo(managerUpdateInfo);
		return new ReturnInfo("", true);
	}

	/** アカウントを削除する。 */
	public void deleteManagerInfo( String mailAddress ) {

		ManagerInfoDAO managerInfoDAO = new ManagerInfoDAO();
		managerInfoDAO.deleteManagerInfo(mailAddress);
	}
}
