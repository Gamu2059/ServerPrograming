package tdu_market.entity_bean;

import java.io.Serializable;
import java.util.Date;

public final class ItemInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private long itemID;
	private String exhibitorStudentNumber;
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
		return exhibitorStudentNumber;
	}

	public void setExhibitorStudentNumber(String exhibitorStudentNumber) {
		this.exhibitorStudentNumber = exhibitorStudentNumber;
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
}
