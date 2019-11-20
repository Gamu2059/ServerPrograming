package tdu_market.entity_manager;

import java.util.ArrayList;

import tdu_market.dao.ItemImageInfoDAO;
import tdu_market.dto.ItemImageCreateInfo;
import tdu_market.dto.ItemImageGetInfo;
import tdu_market.entity_bean.ItemImageInfo;

/** 原則として、ItemInfoManagerから呼び出される前提になっています。 */
public final class ItemImageInfoManager {

	/** あらゆる場所からアクセスしても大丈夫です。 */
	public ItemImageGetInfo getItemImageInfo(long itemID) {

		ItemImageInfoDAO itemImageInfoDAO = new ItemImageInfoDAO();
		ArrayList<ItemImageInfo> getResult = itemImageInfoDAO.getItemImageInfo(itemID);
		if (getResult == null) {
			return null;
		}

		String[] binaries = new String[getResult.size()];
		for (int i = 0; i < getResult.size(); i++) {
			binaries[i] = getResult.get(i).getImageBinary();
		}

		return new ItemImageGetInfo(itemID, binaries);
	}

	/** 処理的に、ItemInfoManagerのみで使用してほしいです。 */
	public void createItemImageInfo(ItemImageCreateInfo itemImageCreateInfo) {

		ItemImageInfoDAO itemImageInfoDAO = new ItemImageInfoDAO();
		itemImageInfoDAO.createItemImageInfo(itemImageCreateInfo);
	}

	/** 処理的に、ItemInfoManagerのみで使用してほしいです。 */
	public void deleteItemImageInfo(long itemID) {

		ItemImageInfoDAO itemImageInfoDAO = new ItemImageInfoDAO();
		itemImageInfoDAO.deleteItemImageInfo(itemID);
	}
}
