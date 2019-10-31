package tdu_market.entity_manager;

import tdu_market.dto.LoginInfo;
import tdu_market.dto.ManagerGetInfo;
import tdu_market.dto.ManagerUpdateInfo;

public final class ManagerInfoManager {

	public boolean existMailAddress( String mailAddress ) {
		System.err.println("non implementation!");
		return false;
	}

	public boolean canLogin( LoginInfo loginInfo ) {
		System.err.println("non implementation!");
		return false;
	}

	public void login( LoginInfo loginInfo) {
		System.err.println("non implementation!");
	}

	public void logout( String mailAddress ) {
		System.err.println("non implementation!");
	}

	public boolean isRegisteredState( String mailAddress ) {
		System.err.println("non implementation!");
		return false;
	}

	public String createTemporaryAccount( String mailAddress ) {
		System.err.println("non implementation!");
		return "password";
	}

	public ManagerGetInfo getManagerInfo( String mailAddress ) {
		System.err.println("non implementation!");
		return null;
	}

	public void makeManagerInfoRegistered( ManagerUpdateInfo managerUpdateInfo ) {
		System.err.println("non implementation!");
	}

	public void updateManagerInfo( ManagerUpdateInfo managerUpdateInfo ) {
		System.err.println("non implementation!");
	}

	public void deleteManagerInfo( String mailAddress ) {
		System.err.println("non implementation!");
	}
}
