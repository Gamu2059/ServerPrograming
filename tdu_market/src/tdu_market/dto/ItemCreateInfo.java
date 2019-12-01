package tdu_market.dto;

import java.io.InputStream;

public class ItemCreateInfo {

	private final String exhibitorMailAddress;
	private final String itemName;
	private final String description;
	private final int condition;
	private final int price;

	private final String relatedClassCode;

	private final InputStream[] itemImageBinaries;

	public ItemCreateInfo(String exhibitorMailAddress, String itemName, String description, int condition, int price,
			String relatedClassCode, InputStream[] itemImageBinaries) {
		super();
		this.exhibitorMailAddress = exhibitorMailAddress;
		this.itemName = itemName;
		this.description = description;
		this.condition = condition;
		this.price = price;
		this.relatedClassCode = relatedClassCode;
		this.itemImageBinaries = itemImageBinaries;
	}

	public String getExhibitorMailAddress() {
		return exhibitorMailAddress;
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
