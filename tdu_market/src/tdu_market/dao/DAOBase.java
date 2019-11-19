package tdu_market.dao;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class DAOBase {

	protected Connection getConnection() {

		Connection c = null;
		try {
			c = ConnectDBUtil.getConnection();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
			System.err.println("DBドライバクラスにおいて、指定した名前のクラスが存在しませんでした。");
		} catch(SQLException e) {
			showSQLException(e);
			System.err.println("DBへの接続に失敗しました。");
		}

		return c;
	}

	protected void showSQLException(SQLException e) {

		if (e == null) {
			return;
		}

		e.printStackTrace();
		System.err.println("SQLエラー : コード " + e.getErrorCode() + ", ステート " + e.getSQLState());
	}
}
