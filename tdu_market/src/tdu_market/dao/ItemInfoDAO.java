package tdu_market.dao;

import java.util.ArrayList;

import tdu_market.dto.ItemCreateInfo;
import tdu_market.dto.ItemSearchInfo;
import tdu_market.dto.ItemUpdateInfo;
import tdu_market.entity_bean.ItemInfo;

public final class ItemInfoDAO {

	public ItemInfo getItemInfo(long itemID) {
		System.err.println("getItemInfo is non implementation!");
		return null;
	}

	public void createItemInfo(ItemCreateInfo itemCreateInfo) {
		System.err.println("createItemInfo is non implementation!");
	}

	public void updateItemInfo(ItemUpdateInfo itemUpdateInfo) {
		System.err.println("updateItemInfo is non implementation!");
	}

	public void deleteItemInfo(long itemID) {
		System.err.println("deleteItemInfo is non implementation!");
	}

	public ArrayList<ItemInfo> getExhibitItem(String studentNumber) {
		System.err.println("getExhibitItem is non implementation!");
		return null;
	}

	public ArrayList<ItemInfo> searchItemInfo(ItemSearchInfo itemSearchInfo) {
		System.err.println("searchItemInfo is non implementation!");
		return null;
	}
}
