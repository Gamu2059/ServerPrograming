package tdu_market.entity_manager;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import tdu_market.dao.ItemInfoDAO;
import tdu_market.dto.ItemCreateInfo;
import tdu_market.dto.ItemGetInfo;
import tdu_market.dto.ItemImageGetInfo;
import tdu_market.dto.ItemSearchInfo;
import tdu_market.dto.ItemUpdateInfo;
import tdu_market.dto.ReturnInfo;
import tdu_market.dto.StudentGetInfo;
import tdu_market.entity_bean.ItemInfo;

public final class ItemInfoManager {

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

	public ItemGetInfo getItemInfo(long itemID) {

		ItemInfoDAO itemInfoDAO = new ItemInfoDAO();
		ItemInfo itemInfo = itemInfoDAO.getItemInfo(itemID);

		ItemImageInfoManager itemImageInfoManager = new ItemImageInfoManager();
		ItemImageGetInfo itemImageGetInfo = itemImageInfoManager.getItemImageInfo(itemID);

		return ItemGetInfo.create(itemInfo, itemImageGetInfo);
	}

	public void createItemInfo(ItemCreateInfo itemCreateInfo) {

		ItemInfoDAO itemInfoDAO = new ItemInfoDAO();
		itemInfoDAO.createItemInfo(itemCreateInfo);
	}

	public void updateItemInfo(ItemUpdateInfo itemUpdateInfo) {

		ItemInfoDAO itemInfoDAO = new ItemInfoDAO();
		itemInfoDAO.updateItemInfo(itemUpdateInfo);
	}

	public void deleteItemInfo(long itemID) {

		ItemInfoDAO itemInfoDAO = new ItemInfoDAO();
		itemInfoDAO.deleteItemInfo(itemID);
	}

	public ArrayList<ItemGetInfo> getNewItemList() {

		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -1);
		Date yesterdayDate = calendar.getTime();

		ItemSearchInfo itemSearchInfo = new ItemSearchInfo(null, -1, -1, yesterdayDate);
		return searchItem(itemSearchInfo);
	}

	public ArrayList<ItemGetInfo> getExhibitItem(String exhibitorMailAddress) {

		StudentInfoManager studentInfoManager = new StudentInfoManager();
		StudentGetInfo studentGetInfo = studentInfoManager.getStudentInfo(exhibitorMailAddress);
		if (studentGetInfo == null) {
			return null;
		}

		ItemSearchInfo itemSearchInfo = new ItemSearchInfo(studentGetInfo.getDisplayName(), -1, -1, null);
		return searchItem(itemSearchInfo);
	}

	public ArrayList<ItemGetInfo> searchItem(ItemSearchInfo itemSearchInfo) {

		ItemInfoDAO itemInfoDAO = new ItemInfoDAO();
		ArrayList<ItemInfo> searchResult = itemInfoDAO.searchItemInfo(itemSearchInfo);
		if (searchResult == null) {
			return null;
		}

		ItemImageInfoManager itemImageInfoManager = new ItemImageInfoManager();
		ArrayList<ItemGetInfo> result = new ArrayList<ItemGetInfo>();
		for(ItemInfo i : searchResult) {
			ItemImageGetInfo itemImageGetInfo = itemImageInfoManager.getItemImageInfo(i.getItemID());
			result.add(ItemGetInfo.create(i, itemImageGetInfo));
		}

		return result;
	}
}
