package tdu_market.dto;

public final class ReturnInfo {

	private final String msg;
	private final boolean isSuccess;

	public ReturnInfo(String msg, boolean isSuccess) {
		super();
		this.msg = msg;
		this.isSuccess = isSuccess;
	}

	public String getMsg() {
		return msg;
	}

	public boolean isSuccess() {
		return isSuccess;
	}
}
