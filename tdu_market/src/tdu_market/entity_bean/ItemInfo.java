package tdu_market.entity_bean;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public final class ItemInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String ITEM_ID = "itemID";
	public static final String EXHIBITOR_MAIL_ADDRESS = "exhibitorMailAddress";
	public static final String ITEM_NAME = "itemName";
	public static final String DESCRIPTION = "description";
	public static final String CONDITION = "condition";
	public static final String PRICE = "price";
	public static final String TRADING_STATE = "tradingState";
	public static final String EXHIBIT_DATE = "exhibitDate";

	private long itemID;
	private String exhibitorMailAddress;
	private String itemName;
	private String description;
	private int condition;
	private int price;
	private int tradingState;
	private Date exhibitDate;

	public ItemInfo() {
		super();
	}

	public long getItemID() {
		return itemID;
	}

	public void setItemID(long itemID) {
		this.itemID = itemID;
	}

	public String getExhibitorStudentNumber() {
		return exhibitorMailAddress;
	}

	public String getExhibitorMailAddress() {
		return exhibitorMailAddress;
	}

	public void setExhibitorMailAddress(String exhibitorMailAddress) {
		this.exhibitorMailAddress = exhibitorMailAddress;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCondition() {
		return condition;
	}

	public void setCondition(int condition) {
		this.condition = condition;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getTradingState() {
		return tradingState;
	}

	public void setTradingState(int tradingState) {
		this.tradingState = tradingState;
	}

	public Date getExhibitDate() {
		return exhibitDate;
	}

	public void setExhibitDate(Date exhibitDate) {
		this.exhibitDate = exhibitDate;
	}

	@Override
	public String toString() {
		return "ItemInfo [itemID=" + itemID + ", exhibitorMailAddress=" + exhibitorMailAddress + ", itemName="
				+ itemName + ", description=" + description + ", condition=" + condition + ", price=" + price
				+ ", tradingState=" + tradingState + ", exhibitDate=" + exhibitDate + "]";
	}

	public static ItemInfo create(ResultSet resultSet) throws SQLException {

		if (resultSet == null) {
			return null;
		}

		ItemInfo itemInfo = new ItemInfo();

		itemInfo.setItemID(resultSet.getLong(ITEM_ID));
		itemInfo.setExhibitorMailAddress(resultSet.getString(EXHIBITOR_MAIL_ADDRESS));
		itemInfo.setItemName(resultSet.getString(ITEM_NAME));
		itemInfo.setDescription(resultSet.getString(DESCRIPTION));
		itemInfo.setCondition(resultSet.getInt(CONDITION));
		itemInfo.setPrice(resultSet.getInt(PRICE));
		itemInfo.setTradingState(resultSet.getInt(TRADING_STATE));
		itemInfo.setExhibitDate(resultSet.getDate(EXHIBIT_DATE));

		return itemInfo;
	}
}
