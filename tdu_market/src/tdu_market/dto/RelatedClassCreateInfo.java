package tdu_market.dto;

public class RelatedClassCreateInfo {

	private final long itemID;
	private final String classCode;

	public RelatedClassCreateInfo(long itemID, String classCode) {
		super();
		this.itemID = itemID;
		this.classCode = classCode;
	}

	public long getItemID() {
		return itemID;
	}

	public String getClassCode() {
		return classCode;
	}
}
