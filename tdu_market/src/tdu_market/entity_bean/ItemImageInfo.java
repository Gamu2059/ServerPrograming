package tdu_market.entity_bean;

import java.io.Serializable;

public final class ItemImageInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private long imageID;
	private long itemID;
	private String imageURL;

	public ItemImageInfo() {
		super();
	}

	public long getImageID() {
		return imageID;
	}

	public void setImageID(long imageID) {
		this.imageID = imageID;
	}

	public long getItemID() {
		return itemID;
	}

	public void setItemID(long itemID) {
		this.itemID = itemID;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
}
