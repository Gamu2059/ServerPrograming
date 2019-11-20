package tdu_market.dto;

public class ItemBuyInfo {

	private final String beginTraderMailAddress;
	private final long tradedItemID;

	public ItemBuyInfo(String beginTraderMailAddress, long tradedItemID) {
		super();
		this.beginTraderMailAddress = beginTraderMailAddress;
		this.tradedItemID = tradedItemID;
	}

	public String getBeginTraderMailAddress() {
		return beginTraderMailAddress;
	}

	public long getTradedItemID() {
		return tradedItemID;
	}
}
