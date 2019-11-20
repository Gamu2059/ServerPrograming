package tdu_market.dto;

import java.util.Date;

import tdu_market.entity_bean.ItemInfo;

public class ItemGetInfo {

	private final long itemID;
	private final String itemName;
	private final String description;
	private final int condition;
	private final int price;
	private final int tradingState;
	private final Date exhibitDate;

	private final String exhibitorMailAddress;
	private final String[] itemImageBinaries;

	public ItemGetInfo(long itemID, String itemName, String description, int condition, int price, int tradingState,
			Date exhibitDate, String exhibitorMailAddress, String[] itemImageBinaries) {
		super();
		this.itemID = itemID;
		this.itemName = itemName;
		this.description = description;
		this.condition = condition;
		this.price = price;
		this.tradingState = tradingState;
		this.exhibitDate = exhibitDate;
		this.exhibitorMailAddress = exhibitorMailAddress;
		this.itemImageBinaries = itemImageBinaries;
	}

	public long getItemID() {
		return itemID;
	}

	public String getItemName() {
		return itemName;
	}

	public String getDescription() {
		return description;
	}

	public int getCondition() {
		return condition;
	}

	public int getPrice() {
		return price;
	}

	public int getTradingState() {
		return tradingState;
	}

	public Date getExhibitDate() {
		return exhibitDate;
	}

	public String getExhibitorMailAddress() {
		return exhibitorMailAddress;
	}

	public String[] getItemImageBinaries() {
		return itemImageBinaries;
	}

	public static ItemGetInfo create(ItemInfo itemInfo, ItemImageGetInfo itemImageGetInfo) {

		if (itemInfo == null) {
			return null;
		}

		long itemID = itemInfo.getItemID();
		String name = itemInfo.getItemName();
		String desc = itemInfo.getDescription();
		int cond = itemInfo.getCondition();
		int price = itemInfo.getPrice();
		int state = itemInfo.getTradingState();
		Date exhibitDate = itemInfo.getExhibitDate();

		String exhibitorMailAddress = itemInfo.getExhibitorMailAddress();
		String[] binaries = null;

		if (itemImageGetInfo != null) {
			binaries = itemImageGetInfo.getItemImageURLs();
		}

		return new ItemGetInfo(itemID, name, desc, cond, price, state, exhibitDate, exhibitorMailAddress, binaries);
	}
}
