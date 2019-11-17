package tdu_market.dto;

public class ItemCreateInfo {

	private final String exhibitorMailAddress;
	private final String itemName;
	private final String description;
	private final int condition;
	private final int price;

	public ItemCreateInfo(String exhibitorMailAddress, String itemName, String description, int condition, int price) {
		super();
		this.exhibitorMailAddress = exhibitorMailAddress;
		this.itemName = itemName;
		this.description = description;
		this.condition = condition;
		this.price = price;
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
}
