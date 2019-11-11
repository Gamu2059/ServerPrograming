package tdu_market.entity_manager;

import tdu_market.dao.ManagerInfoDAO;
import tdu_market.dto.LoginInfo;
import tdu_market.dto.ManagerCreateInfo;
import tdu_market.dto.ManagerGetInfo;
import tdu_market.dto.ManagerUpdateInfo;
import tdu_market.dto.ReturnInfo;
import tdu_market.entity_bean.ManagerInfo;
import tdu_market.util.Def;
import tdu_market.util.PasswordUtil;

public final class ManagerInfoManager {

	private ManagerInfo getRawManagerInfo(String mailAddress) {
		ManagerInfoDAO managerInfoDAO = new ManagerInfoDAO();
		return managerInfoDAO.getManagerInfo(mailAddress);
	}

	public ReturnInfo existMailAddress( String mailAddress ) {

		ManagerInfo managerInfo = getRawManagerInfo(mailAddress);
		boolean isExist = managerInfo != null;

		return new ReturnInfo(isExist ? "" : "アカウントが存在しません。", isExist);
	}

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

	public ReturnInfo isRegisteredState( String mailAddress ) {

		try {
			ManagerInfo managerInfo = getRawManagerInfo(mailAddress);

			if (managerInfo == null) {
				return new ReturnInfo("アカウントが存在しません。");
			}

			boolean isRegistered = managerInfo.getRegisterationState() == Def.REGISTERED;

			return new ReturnInfo(isRegistered ? "" : "アカウントが本登録されていません。", isRegistered);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public ReturnInfo createTemporaryAccount( String mailAddress ) {

		try {
			ReturnInfo existMailAddress = existMailAddress(mailAddress);
			if (existMailAddress.isSuccess()) {
				return new ReturnInfo("既にアカウントが存在しています。");
			}

			String password = PasswordUtil.createNonHashedPassword();

			ManagerInfoDAO managerInfoDAO = new ManagerInfoDAO();
			managerInfoDAO.createManagerInfo(new ManagerCreateInfo(mailAddress, password));

			return new ReturnInfo(password, true);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public ManagerGetInfo getManagerInfo( String mailAddress ) {

		ManagerInfo managerInfo = getRawManagerInfo(mailAddress);
		return ManagerGetInfo.create(managerInfo);
	}

	public void makeManagerInfoRegistered( ManagerUpdateInfo managerUpdateInfo ) {

		ManagerInfoDAO managerInfoDAO = new ManagerInfoDAO();
		managerInfoDAO.updateManagerInfo(managerUpdateInfo);
	}

	public void updateManagerInfo( ManagerUpdateInfo managerUpdateInfo ) {

		ManagerInfoDAO managerInfoDAO = new ManagerInfoDAO();
		managerInfoDAO.updateManagerInfo(managerUpdateInfo);
	}

	public void deleteManagerInfo( String mailAddress ) {

		ManagerInfoDAO managerInfoDAO = new ManagerInfoDAO();
		managerInfoDAO.deleteManagerInfo(mailAddress);
	}
}
