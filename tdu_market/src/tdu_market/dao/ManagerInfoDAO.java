package tdu_market.dao;

import tdu_market.dto.ManagerCreateInfo;
import tdu_market.dto.ManagerUpdateInfo;
import tdu_market.entity_bean.ManagerInfo;

public final class ManagerInfoDAO {

	public ManagerInfo createManagerInfo(ManagerCreateInfo managerCreateInfo) {
		System.err.println("createManagerInfo is non implementation!");
		return null;
	}

	public ManagerInfo getManagerInfo(String mailAddress) {
		System.err.println("getManagerInfo is non implementation!");
		return null;
	}

	public void updateManagerInfo(ManagerUpdateInfo managerUpdateInfo) {
		System.err.println("updateManagerInfo is non implementation!");
	}

	public void deleteManagerInfo(String mailAddress) {
		System.err.println("deleteManagerInfo is non implementation!");
	}

	public void updateLastLogin(String mailAddress) {
		System.err.println("updateLastLogin is non implementation!");
	}
}
