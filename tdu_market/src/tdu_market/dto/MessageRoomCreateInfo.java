package tdu_market.dto;

public class MessageRoomCreateInfo {

	private final String beginTraderStudentNumber;
	private final long tradedItemID;

	public MessageRoomCreateInfo(String beginTraderStudentNumber, long tradedItemID) {
		super();
		this.beginTraderStudentNumber = beginTraderStudentNumber;
		this.tradedItemID = tradedItemID;
	}

	public String getBeginTraderStudentNumber() {
		return beginTraderStudentNumber;
	}

	public long getTradedItemID() {
		return tradedItemID;
	}
}
