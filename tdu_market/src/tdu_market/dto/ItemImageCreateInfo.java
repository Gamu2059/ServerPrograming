package tdu_market.dto;

public class ItemImageCreateInfo {

	private final long itemID;
	private final String[] itemImageBinaries;

	public ItemImageCreateInfo(long itemID, String[] itemImageBinaries) {
		super();
		this.itemID = itemID;
		this.itemImageBinaries = itemImageBinaries;
	}

	public long getItemID() {
		return itemID;
	}

	public String[] getItemImageBinaries() {
		return itemImageBinaries;
	}
}
