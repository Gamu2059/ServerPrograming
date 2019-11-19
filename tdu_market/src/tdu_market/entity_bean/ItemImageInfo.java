package tdu_market.entity_bean;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class ItemImageInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final String IMAGE_ID = "imageID";
	private static final String ITEM_ID = "itemID";
	private static final String IMAGE_BINARY = "imageBinary";

	private long imageID;
	private long itemID;
	private String imageBinary;

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

	public String getImageBinary() {
		return imageBinary;
	}

	public void setImageBinary(String imageBinary) {
		this.imageBinary = imageBinary;
	}

	@Override
	public String toString() {
		return "ItemImageInfo [imageID=" + imageID + ", itemID=" + itemID + ", imageBinary=" + imageBinary + "]";
	}

	public static ItemImageInfo create(ResultSet resultSet) throws SQLException {

		if (resultSet == null) {
			return null;
		}

		ItemImageInfo itemImageInfo = new ItemImageInfo();

		itemImageInfo.setImageID(resultSet.getLong(IMAGE_ID));
		itemImageInfo.setItemID(resultSet.getLong(ITEM_ID));
		itemImageInfo.setImageBinary(resultSet.getString(IMAGE_BINARY));

		return itemImageInfo;
	}
}
