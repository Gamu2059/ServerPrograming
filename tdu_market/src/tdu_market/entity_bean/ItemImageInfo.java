package tdu_market.entity_bean;

import java.io.InputStream;
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
	private InputStream imageBinary;

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

	public InputStream getImageBinary() {
		return imageBinary;
	}

	public void setImageBinary(InputStream imageBinary) {
		this.imageBinary = imageBinary;
	}

	@Override
	public String toString() {
		// 画像はとても重いので表示しない
		return "ItemImageInfo [imageID=" + imageID + ", itemID=" + itemID + "]";
	}

	public static ItemImageInfo create(ResultSet resultSet) throws SQLException {

		if (resultSet == null) {
			return null;
		}

		ItemImageInfo itemImageInfo = new ItemImageInfo();

		itemImageInfo.setImageID(resultSet.getLong(IMAGE_ID));
		itemImageInfo.setItemID(resultSet.getLong(ITEM_ID));
		itemImageInfo.setImageBinary(resultSet.getBinaryStream(IMAGE_BINARY));

		return itemImageInfo;
	}
}
