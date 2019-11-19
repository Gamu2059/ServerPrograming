package tdu_market.entity_manager;

import java.util.ArrayList;

import tdu_market.dao.ItemImageInfoDAO;
import tdu_market.dto.ItemImageCreateInfo;
import tdu_market.dto.ItemImageGetInfo;
import tdu_market.entity_bean.ItemImageInfo;

public final class ItemImageInfoManager {

	public ItemImageGetInfo getItemImageInfo(long itemID) {

		ItemImageInfoDAO itemImageInfoDAO = new ItemImageInfoDAO();
		ArrayList<ItemImageInfo> getResult = itemImageInfoDAO.getItemImageInfo(itemID);
		if (getResult == null) {
			return null;
		}

		String[] urls = new String[getResult.size()];
		for (int i = 0; i < getResult.size(); i++) {
			urls[i] = getResult.get(i).getImageBinary();
		}

		return new ItemImageGetInfo(itemID, urls);
	}

	public void createItemImageInfo(ItemImageCreateInfo itemImageCreateInfo) {

		ItemImageInfoDAO itemImageInfoDAO = new ItemImageInfoDAO();
		itemImageInfoDAO.createItemImageInfo(itemImageCreateInfo);
	}

	public void deleteItemImageInfo(long itemID) {

		ItemImageInfoDAO itemImageInfoDAO = new ItemImageInfoDAO();
		itemImageInfoDAO.deleteItemImageInfo(itemID);
	}
}
