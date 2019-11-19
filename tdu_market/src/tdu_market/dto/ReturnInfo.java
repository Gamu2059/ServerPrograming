package tdu_market.dto;

public final class ReturnInfo {

	private final String msg;
	private final boolean isSuccess;

	/** isSuccessをfalseに設定するコンストラクタ */
	public ReturnInfo(String msg) {
		this(msg, false);
	}

	/** デフォルトコンストラクタ */
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

	@Override
	public String toString() {
		return "ReturnInfo [msg=" + msg + ", isSuccess=" + isSuccess + "]";
	}
}
