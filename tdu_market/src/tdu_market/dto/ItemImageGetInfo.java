package tdu_market.dto;

public class ItemImageGetInfo {

	private final long itemID;
	private final String[] itemImageBinaries;

	public ItemImageGetInfo(long itemID, String[] itemImageBinaries) {
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
