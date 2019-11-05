package tdu_market.entity_manager;

import tdu_market.dto.LoginInfo;
import tdu_market.dto.ManagerGetInfo;
import tdu_market.dto.ManagerUpdateInfo;

public final class ManagerInfoManager {

	public boolean existMailAddress( String mailAddress ) {
		System.err.println("existMailAddress is non implementation!");
		return false;
	}

	public boolean canLogin( LoginInfo loginInfo ) {
		System.err.println("canLogin is non implementation!");
		return false;
	}

	public void login( LoginInfo loginInfo) {
		System.err.println("login is non implementation!");
	}

	public void logout( String mailAddress ) {
		System.err.println("logout is non implementation!");
	}

	public boolean isRegisteredState( String mailAddress ) {
		System.err.println("isRegisteredState is non implementation!");
		return false;
	}

	public String createTemporaryAccount( String mailAddress ) {
		System.err.println("createTemporaryAccount is non implementation!");
		return "password";
	}

	public ManagerGetInfo getManagerInfo( String mailAddress ) {
		System.err.println("getManagerInfo is non implementation!");
		return null;
	}

	public void makeManagerInfoRegistered( ManagerUpdateInfo managerUpdateInfo ) {
		System.err.println("makeManagerInfoRegistered is non implementation!");
	}

	public void updateManagerInfo( ManagerUpdateInfo managerUpdateInfo ) {
		System.err.println("updateManagerInfo is non implementation!");
	}

	public void deleteManagerInfo( String mailAddress ) {
		System.err.println("deleteManagerInfo is non implementation!");
	}
}
