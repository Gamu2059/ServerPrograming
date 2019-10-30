package tdu_market.dto;

public class ItemImageCreateInfo {

	private final long itemID;
	private final String[] itemImageURLs;

	public ItemImageCreateInfo(long itemID, String[] itemImageURLs) {
		super();
		this.itemID = itemID;
		this.itemImageURLs = itemImageURLs;
	}

	public long getItemID() {
		return itemID;
	}

	public String[] getItemImageURLs() {
		return itemImageURLs;
	}
}
