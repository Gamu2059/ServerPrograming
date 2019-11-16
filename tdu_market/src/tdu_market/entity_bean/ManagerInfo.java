package tdu_market.entity_bean;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import tdu_market.dao.ManagerInfoDAO;
import tdu_market.util.AccountUtil;

public final class ManagerInfo extends UseBase implements Serializable {

	private static final long serialVersionUID = 1L;

	public ManagerInfo() {
		super();
	}

	@Override
	public String toString() {
		return "ManagerInfo [mailAddress=" + mailAddress + ", hashedPassword=" + hashedPassword + ", displayName="
				+ displayName + ", iconImageBinary=" + iconImageBinary + ", registerState=" + registerState
				+ ", createdDate=" + createdDate + ", lastLoginDate=" + lastLoginDate + "]";
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

	public static ManagerInfo create(ResultSet resultSet) throws SQLException {

		if (resultSet == null) {
			return null;
		}

		ManagerInfo managerInfo = new ManagerInfo();

		managerInfo.setMailAddress(resultSet.getString(MAIL_ADDRESS));
		managerInfo.setHashedPassword(resultSet.getString(HASHED_PASSWORD));
		managerInfo.setDisplayName(resultSet.getString(DISPLAY_NAME));
		managerInfo.setIconImageBinary(resultSet.getString(ICON_IMAGE_BINARY));
		managerInfo.setRegisterState(resultSet.getInt(REGISTER_STATE));
		managerInfo.setCreatedDate(resultSet.getDate(CREATED_DATE));
		managerInfo.setLastLoginDate(resultSet.getDate(LAST_LOGIN_DATE));

		return managerInfo;
	}
}
