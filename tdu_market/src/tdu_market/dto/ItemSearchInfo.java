package tdu_market.dto;

import java.util.Date;

public class ItemSearchInfo {

	private final String itemNameKeyword;
	private final int condition;
	private final int maxPrice;
	private final Date oldestDate;

	public ItemSearchInfo(String itemNameKeyword, int condition, int maxPrice, Date oldestDate) {
		super();
		this.itemNameKeyword = itemNameKeyword;
		this.condition = condition;
		this.maxPrice = maxPrice;
		this.oldestDate = oldestDate;
	}

	public String getItemNameKeyword() {
		return itemNameKeyword;
	}

	public int getCondition() {
		return condition;
	}

	public int getMaxPrice() {
		return maxPrice;
	}

	public Date getOldestDate() {
		return oldestDate;
	}
}
