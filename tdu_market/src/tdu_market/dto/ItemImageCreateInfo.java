package tdu_market.dto;

import java.io.InputStream;

public class ItemImageCreateInfo {

	private final long itemID;
	private final InputStream[] itemImageBinaries;

	public ItemImageCreateInfo(long itemID, InputStream[] itemImageBinaries) {
		super();
		this.itemID = itemID;
		this.itemImageBinaries = itemImageBinaries;
	}

	public long getItemID() {
		return itemID;
	}

	public InputStream[] getItemImageBinaries() {
		return itemImageBinaries;
	}
}
