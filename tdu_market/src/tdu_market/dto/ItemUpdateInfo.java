package tdu_market.dto;

import java.io.InputStream;

public class ItemUpdateInfo {

	private final long itemID;
	private final String itemName;
	private final String description;
	private final int condition;
	private final int price;
	private final String relatedClassCode;
	private final InputStream[] itemImageBinaries;

	public ItemUpdateInfo(long itemID, String itemName, String description, int condition, int price,
			String relatedClassCode, InputStream[] itemImageBinaries) {
		super();
		this.itemID = itemID;
		this.itemName = itemName;
		this.description = description;
		this.condition = condition;
		this.price = price;
		this.relatedClassCode = relatedClassCode;
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

	public String getRelatedClassCode() {
		return relatedClassCode;
	}

	public InputStream[] getItemImageBinaries() {
		return itemImageBinaries;
	}
}
