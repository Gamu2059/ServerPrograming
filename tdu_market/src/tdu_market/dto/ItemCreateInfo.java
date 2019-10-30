package tdu_market.dto;

public class ItemCreateInfo {

	private final String exhibitorStudentNumber;
	private final String itemName;
	private final String description;
	private final int condition;
	private final int price;
	private final String relatedClassCode;
	private final String[] itemImageURLs;

	public ItemCreateInfo(String exhibitorStudentNumber, String itemName, String description, int condition, int price,
			String relatedClassCode, String[] itemImageURLs) {
		super();
		this.exhibitorStudentNumber = exhibitorStudentNumber;
		this.itemName = itemName;
		this.description = description;
		this.condition = condition;
		this.price = price;
		this.relatedClassCode = relatedClassCode;
		this.itemImageURLs = itemImageURLs;
	}

	public String getExhibitorStudentNumber() {
		return exhibitorStudentNumber;
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

	public String[] getItemImageURLs() {
		return itemImageURLs;
	}
}
