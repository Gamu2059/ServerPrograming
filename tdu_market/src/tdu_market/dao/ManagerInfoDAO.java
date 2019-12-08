package tdu_market.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import tdu_market.dto.ManagerCreateInfo;
import tdu_market.dto.ManagerUpdateInfo;
import tdu_market.entity_bean.ManagerInfo;
import tdu_market.util.PasswordUtil;

public final class ManagerInfoDAO extends DAOBase {

	public void createManagerInfo(ManagerCreateInfo managerCreateInfo) {

		if (managerCreateInfo == null) {
			System.err.println("createManagerInfo : managerCreateInfo is null");
			return;
		}

		Connection connection = getConnection();
		if (connection == null) {
			return;
		}

		ResultSet resultSet = null;

		try {

			String sql = "insert into \"ManagerInfo\" (\"mailAddress\", \"hashedPassword\", \"createdDate\") values (?, ?, ?)";
			PreparedStatement pstmt = connection.prepareStatement(sql);

			String mailAddress = managerCreateInfo.getMailAddress();
			String hashedPassword = PasswordUtil.getHashedPassword(managerCreateInfo.getNonHashedPassword(),
					mailAddress);
			Timestamp createdTimestamp = new Timestamp(new java.util.Date().getTime());

			pstmt.setString(1, mailAddress);
			pstmt.setString(2, hashedPassword);
			pstmt.setTimestamp(3, createdTimestamp);

			int result = pstmt.executeUpdate();
			System.out.println("createManagerInfo : " + result + "件のデータを作成");
		} catch (SQLException e) {
			showSQLException(e);
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				showSQLException(e);
			}
		}
	}

	public ManagerInfo getManagerInfo(String mailAddress) {

		Connection connection = getConnection();
		if (connection == null) {
			return null;
		}

		ManagerInfo managerInfo = null;
		ResultSet resultSet = null;

		try {

			String sql = "select * from \"ManagerInfo\" where \"mailAddress\" = ?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, mailAddress);

			resultSet = pstmt.executeQuery();

			if (resultSet.next()) {
				managerInfo = ManagerInfo.create(resultSet);
			}
		} catch (SQLException e) {
			showSQLException(e);
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				showSQLException(e);
			}
		}

		return managerInfo;
	}

	public void updateManagerInfo(ManagerUpdateInfo managerUpdateInfo) {

		if (managerUpdateInfo == null) {
			System.err.println("updateManagerInfo : managerUpdateInfo is null");
			return;
		}

		Connection connection = getConnection();
		if (connection == null) {
			return;
		}

		ResultSet resultSet = null;

		try {

			String mailAddress = managerUpdateInfo.getMailAddress();
			String hashedPassword = PasswordUtil.getHashedPassword(managerUpdateInfo.getNonHashedPassword(),
					mailAddress);
			String displayName = managerUpdateInfo.getDisplayName();
			InputStream iconImageBinary = managerUpdateInfo.getIconImageBinary();

			int iconAvailable = 0;
			try {
				iconAvailable = iconImageBinary.available();
			} catch (IOException e) {

			}

			boolean isChangeIcon = iconAvailable > 0;

			StringBuilder builder = new StringBuilder(
					"update \"ManagerInfo\" set \"hashedPassword\" = ?, \"displayName\" = ?, \"registerState\" = 2");

			if (isChangeIcon) {
				builder.append(", \"iconImageBinary\" = ?");
			}

			builder.append(" where \"mailAddress\" = ?");
			String sql = builder.toString();
			PreparedStatement pstmt = connection.prepareStatement(sql);

			int setCount = 1;

			pstmt.setString(setCount++, hashedPassword);
			pstmt.setString(setCount++, displayName);

			if (isChangeIcon) {
				pstmt.setBinaryStream(setCount++, iconImageBinary);
			}

			pstmt.setString(setCount++, mailAddress);

			int result = pstmt.executeUpdate();
			System.out.println("updateManagerInfo : " + result + "件のデータを更新");
		} catch (SQLException e) {
			showSQLException(e);
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				showSQLException(e);
			}
		}
	}

	public void deleteManagerInfo(String mailAddress) {

		Connection connection = getConnection();
		if (connection == null) {
			return;
		}

		ResultSet resultSet = null;

		try {

			String sql = "delete from \"ManagerInfo\" where \"mailAddress\" = ?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, mailAddress);

			int result = pstmt.executeUpdate();
			System.out.println("deleteManagerInfo : " + result + "件のデータを削除");
		} catch (SQLException e) {
			showSQLException(e);
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				showSQLException(e);
			}
		}
	}

	public void updateLastLogin(String mailAddress) {

		Connection connection = getConnection();
		if (connection == null) {
			return;
		}

		ResultSet resultSet = null;

		try {

			String sql = "update \"ManagerInfo\" set \"lastLoginDate\" = ? where \"mailAddress\" = ?";
			PreparedStatement pstmt = connection.prepareStatement(sql);

			Timestamp lastLoginTimestamp = new Timestamp(new java.util.Date().getTime());

			pstmt.setTimestamp(1, lastLoginTimestamp);
			pstmt.setString(2, mailAddress);

			int result = pstmt.executeUpdate();
			System.out.println("updateLastLogin : " + result + "件のデータを更新");
		} catch (SQLException e) {
			showSQLException(e);
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				showSQLException(e);
			}
		}
	}

	public ArrayList<ManagerInfo> getAllManagerInfo() {

		Connection connection = getConnection();
		if (connection == null) {
			return null;
		}

		ArrayList<ManagerInfo> list = null;
		ResultSet resultSet = null;

		try {

			String sql = "select * from \"ManagerInfo\"";
			PreparedStatement pstmt = connection.prepareStatement(sql);

			resultSet = pstmt.executeQuery();
			while (resultSet.next()) {

				ManagerInfo managerInfo = ManagerInfo.create(resultSet);
				if (list == null) {
					list = new ArrayList<ManagerInfo>();
				}

				list.add(managerInfo);
			}
		} catch (SQLException e) {
			showSQLException(e);
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				showSQLException(e);
			}
		}

		return list;
	}

	public static void main(String[] args) {

		ManagerInfoDAO dao = new ManagerInfoDAO();
		showInfo(dao.getAllManagerInfo());

		dao.createManagerInfo(new ManagerCreateInfo("kawasumi@dendai.ac.jp", "ub85IYUBUIv"));
		showInfo(dao.getAllManagerInfo());

		dao.deleteManagerInfo("kawasumi@dendai.ac.jp");
		showInfo(dao.getAllManagerInfo());
	}

	private static void showInfo(ArrayList<ManagerInfo> list) {

		if (list == null) {
			System.out.println("list is empty");
			return;
		}

		for (ManagerInfo i : list) {
			System.out.println(i);
		}
	}
}
