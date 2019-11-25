package tdu_market.dto;

public class ItemSearchInfo {

	private final String itemNameKeyword;
	private final int condition;
	private final int maxPrice;
	private final int oldestDate;

	public ItemSearchInfo(String itemNameKeyword, int condition, int maxPrice, int oldestDate) {
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

	public int getOldestDate() {
		return oldestDate;
	}
}
