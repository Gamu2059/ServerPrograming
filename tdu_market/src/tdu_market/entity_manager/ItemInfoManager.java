package tdu_market.entity_manager;

import java.util.ArrayList;

import tdu_market.dto.ItemCreateInfo;
import tdu_market.dto.ItemGetInfo;
import tdu_market.dto.ItemSearchInfo;
import tdu_market.dto.ItemUpdateInfo;

public final class ItemInfoManager {

	public ArrayList<ItemGetInfo> getNewItemList() {
		System.err.println("getNewItemList is non implementation!");
		return null;
	}

	public boolean validateRegisterExhibitItem(ItemCreateInfo itemCreateInfo) {
		System.err.println("validateRegisterExhibitItem is non implementation!");
		return false;
	}

	public ItemGetInfo getItemInfo(long itemID) {
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

	public ArrayList<ItemGetInfo> getExhibitItem(String studentNumber) {
		System.err.println("getExhibitItem is non implementation!");
		return null;
	}

	public ArrayList<ItemGetInfo> searchItem(ItemSearchInfo itemSearchInfo) {
		System.err.println("searchItem is non implementation!");
		return null;
	}
}
