package tdu_market.entity_bean;

import java.io.Serializable;

public final class RelatedClassInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private long itemID;
	private String classCode;

	public RelatedClassInfo() {
		super();
	}

	public long getItemID() {
		return itemID;
	}

	public void setItemID(long itemID) {
		this.itemID = itemID;
	}

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}
}
