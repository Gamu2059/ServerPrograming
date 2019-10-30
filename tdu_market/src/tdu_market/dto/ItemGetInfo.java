package tdu_market.dto;

import java.util.Date;

public class ItemGetInfo {

	private final long itemID;
	private final String itemName;
	private final String description;
	private final int condition;
	private final int price;
	private final int tradingState;
	private final Date exhibitDate;
	private final String[] itemImageURLs;

	public ItemGetInfo(long itemID, String itemName, String description, int condition, int price, int tradingState,
			Date exhibitDate, String[] itemImageURLs) {
		super();
		this.itemID = itemID;
		this.itemName = itemName;
		this.description = description;
		this.condition = condition;
		this.price = price;
		this.tradingState = tradingState;
		this.exhibitDate = exhibitDate;
		this.itemImageURLs = itemImageURLs;
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

	public String[] getItemImageURLs() {
		return itemImageURLs;
	}
}
