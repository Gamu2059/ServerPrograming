package tdu_market.entity_bean;

import java.io.Serializable;

import tdu_market.dao.ManagerInfoDAO;
import tdu_market.util.AccountUtil;

public final class ManagerInfo extends UseBase implements Serializable {

	private static final long serialVersionUID = 1L;

	public ManagerInfo() {
		super();
	}

	@Override
	public boolean canLogin(String nonHashedPassword) {
		String hashedPassword = AccountUtil.getHashedPassword(getMailAddress(), nonHashedPassword);
		return hashedPassword.equals(getHashedPassword());
	}

	@Override
	public void login() {
		ManagerInfoDAO dao = new ManagerInfoDAO();
		dao.updateLastLogin(getMailAddress());
	}

	@Override
	public void logout() {
		// ログアウトの記録をDBに保存するなら処理を何か記述する
	}
}
