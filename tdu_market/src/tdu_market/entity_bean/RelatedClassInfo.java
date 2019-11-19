package tdu_market.entity_bean;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class RelatedClassInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final String ITEM_ID = "itemID";
	private static final String CLASS_CODE = "classCode";

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

	@Override
	public String toString() {
		return "RelatedClassInfo [itemID=" + itemID + ", classCode=" + classCode + "]";
	}

	public static RelatedClassInfo create(ResultSet resultSet) throws SQLException {

		if (resultSet == null) {
			return null;
		}

		RelatedClassInfo relatedClassInfo = new RelatedClassInfo();

		relatedClassInfo.setItemID(resultSet.getLong(ITEM_ID));
		relatedClassInfo.setClassCode(resultSet.getString(CLASS_CODE));

		return relatedClassInfo;
	}
}
