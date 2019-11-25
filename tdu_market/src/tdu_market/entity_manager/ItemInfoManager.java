package tdu_market.entity_manager;

import java.util.ArrayList;

import tdu_market.dao.ItemInfoDAO;
import tdu_market.dto.ItemBuyInfo;
import tdu_market.dto.ItemCreateInfo;
import tdu_market.dto.ItemGetInfo;
import tdu_market.dto.ItemImageCreateInfo;
import tdu_market.dto.ItemImageGetInfo;
import tdu_market.dto.ItemSearchInfo;
import tdu_market.dto.ItemUpdateInfo;
import tdu_market.dto.RelatedClassCreateInfo;
import tdu_market.dto.ReturnInfo;
import tdu_market.entity_bean.ItemInfo;
import tdu_market.util.Def;

public final class ItemInfoManager {

	/** 商品の作成情報を検証する。作成可能である場合は、trueの情報を返す。 */
	public ReturnInfo validateRegisterExhibitItem(ItemCreateInfo itemCreateInfo) {

		try {

			String address = itemCreateInfo.getExhibitorMailAddress();
			String classCode = itemCreateInfo.getRelatedClassCode();
			String name = itemCreateInfo.getItemName();
			int condition = itemCreateInfo.getCondition();
			int price = itemCreateInfo.getPrice();

			StudentInfoManager studentInfoManager = new StudentInfoManager();
			ReturnInfo existStudent = studentInfoManager.existMailAddress(address);
			if (!existStudent.isSuccess()) {
				return new ReturnInfo("出品者アカウントが存在しません。");
			}

			SyllabusInfoManager syllabusInfoManager = new SyllabusInfoManager();
			ReturnInfo existSyllabus = syllabusInfoManager.existSyllabus(classCode);
			if (!existSyllabus.isSuccess()) {
				return new ReturnInfo("関連講義が設定されていません。");
			}

			if (name == null || name.trim().isEmpty()) {
				return new ReturnInfo("名前が指定されていません。");
			}

			if (condition < 0 || condition > 999) {
				return new ReturnInfo("保存状態の選択値が不正です。");
			}

			if (price < 0 || price > 999999) {
				return new ReturnInfo("価格が不正です。");
			}

			return new ReturnInfo("", true);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/** 商品を取得する。 */
	public ItemGetInfo getItemInfo(long itemID) {

		ItemInfoDAO itemInfoDAO = new ItemInfoDAO();
		ItemInfo itemInfo = itemInfoDAO.getItemInfo(itemID);

		ItemImageInfoManager itemImageInfoManager = new ItemImageInfoManager();
		ItemImageGetInfo itemImageGetInfo = itemImageInfoManager.getItemImageInfo(itemID);

		return ItemGetInfo.create(itemInfo, itemImageGetInfo);
	}

	/** 商品を生成する。 */
	public void createItemInfo(ItemCreateInfo itemCreateInfo) {

		ItemInfoDAO itemInfoDAO = new ItemInfoDAO();
		long itemID = itemInfoDAO.createItemInfo(itemCreateInfo);

		// 作成失敗
		if (itemID < 1) {
			System.err.println("createItemInfo : itemID is invalid");
		}

		// 関連する画像データも自動的に作成する
		ItemImageInfoManager itemImageInfoManager = new ItemImageInfoManager();
		ItemImageCreateInfo itemImageCreateInfo = new ItemImageCreateInfo(itemID,
				itemCreateInfo.getItemImageBinaries());
		itemImageInfoManager.createItemImageInfo(itemImageCreateInfo);

		// 関連講義のデータも自動的に作成する
		RelatedClassInfoManager relatedClassInfoManager = new RelatedClassInfoManager();
		RelatedClassCreateInfo relatedClassCreateInfo = new RelatedClassCreateInfo(itemID,
				itemCreateInfo.getRelatedClassCode());
		relatedClassInfoManager.createRelatedClassInfo(relatedClassCreateInfo);
	}

	/** 商品を更新する。 */
	public void updateItemInfo(ItemUpdateInfo itemUpdateInfo) {

		ItemInfoDAO itemInfoDAO = new ItemInfoDAO();
		itemInfoDAO.updateItemInfo(itemUpdateInfo);

		ItemImageInfoManager itemImageInfoManager = new ItemImageInfoManager();

		// 関連する画像データを削除する
		long itemID = itemUpdateInfo.getItemID();
		itemImageInfoManager.deleteItemImageInfo(itemID);

		// 削除してきてから作成する
		ItemImageCreateInfo imageCreateInfo = new ItemImageCreateInfo(itemID, itemUpdateInfo.getItemImageBinaries());
		itemImageInfoManager.createItemImageInfo(imageCreateInfo);
	}

	/** 商品を削除する。 */
	public void deleteItemInfo(long itemID) {

		// 先に関連講義データを削除する
		RelatedClassInfoManager relatedClassInfoManager = new RelatedClassInfoManager();
		relatedClassInfoManager.deleteRelatedClassInfoWithItem(itemID);

		// 先に画像データを削除する
		ItemImageInfoManager itemImageInfoManager = new ItemImageInfoManager();
		itemImageInfoManager.deleteItemImageInfo(itemID);

		ItemInfoDAO itemInfoDAO = new ItemInfoDAO();
		itemInfoDAO.deleteItemInfo(itemID);
	}

	/** 過去1日までに出品された商品を取得する。 */
	public ArrayList<ItemGetInfo> getNewItemList() {

		ItemSearchInfo itemSearchInfo = new ItemSearchInfo(null, -1, -1, 1);
		return searchItem(itemSearchInfo);
	}

	/** 出品者が出品した商品を取得する。 */
	public ArrayList<ItemGetInfo> getExhibitItem(String exhibitorMailAddress) {

		ItemInfoDAO dao = new ItemInfoDAO();
		ArrayList<ItemInfo> searchResult = dao.getExhibitItem(exhibitorMailAddress);
		if (searchResult == null) {
			return null;
		}

		ItemImageInfoManager itemImageInfoManager = new ItemImageInfoManager();
		ArrayList<ItemGetInfo> result = new ArrayList<ItemGetInfo>();
		for (ItemInfo i : searchResult) {
			ItemImageGetInfo itemImageGetInfo = itemImageInfoManager.getItemImageInfo(i.getItemID());
			result.add(ItemGetInfo.create(i, itemImageGetInfo));
		}

		return result;
	}

	/** 商品を検索する。 */
	public ArrayList<ItemGetInfo> searchItem(ItemSearchInfo itemSearchInfo) {

		ItemInfoDAO itemInfoDAO = new ItemInfoDAO();
		ArrayList<ItemInfo> searchResult = itemInfoDAO.searchItemInfo(itemSearchInfo);
		if (searchResult == null) {
			return null;
		}

		ItemImageInfoManager itemImageInfoManager = new ItemImageInfoManager();
		ArrayList<ItemGetInfo> result = new ArrayList<ItemGetInfo>();
		for (ItemInfo i : searchResult) {
			ItemImageGetInfo itemImageGetInfo = itemImageInfoManager.getItemImageInfo(i.getItemID());
			result.add(ItemGetInfo.create(i, itemImageGetInfo));
		}

		return result;
	}

	/** 商品を購入する。 */
	public void BuyItem(ItemBuyInfo itemBuyInfo) {

		ItemInfoDAO itemInfoDAO = new ItemInfoDAO();
		itemInfoDAO.changeTradingState(itemBuyInfo.getTradedItemID(), Def.BUYED);

		// メッセールルームを作成する
		MessageRoomInfoManager messageRoomInfoManager = new MessageRoomInfoManager();
		messageRoomInfoManager.createMessageRoomInfo(itemBuyInfo);
	}
}
