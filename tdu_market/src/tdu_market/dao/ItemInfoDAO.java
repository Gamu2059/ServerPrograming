package tdu_market.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import tdu_market.dto.ItemCreateInfo;
import tdu_market.dto.ItemSearchInfo;
import tdu_market.dto.ItemUpdateInfo;
import tdu_market.entity_bean.ItemInfo;

public final class ItemInfoDAO extends DAOBase {

	public ItemInfo getItemInfo(long itemID) {

		Connection connection = getConnection();
		if (connection == null) {
			return null;
		}

		ItemInfo itemInfo = null;
		ResultSet resultSet = null;

		try {

			String sql = "select * from \"ItemInfo\" where \"itemID\" = ?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setLong(1, itemID);

			resultSet = pstmt.executeQuery();

			if (resultSet.next()) {
				itemInfo = ItemInfo.create(resultSet);
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

		return itemInfo;
	}

	public void createItemInfo(ItemCreateInfo itemCreateInfo) {

		if (itemCreateInfo == null) {
			System.err.println("createItemInfo : itemCreateInfo is null");
			return;
		}

		Connection connection = getConnection();
		if (connection == null) {
			return;
		}

		try {

			String sql = "insert into \"ItemInfo\" (\"exhibitorMailAddress\", \"itemName\", \"description\", \"condition\", \"price\", \"exhibitDate\") values (?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt = connection.prepareStatement(sql);

			Timestamp exhibitTimestamp = new Timestamp(new java.util.Date().getTime());

			pstmt.setString(1, itemCreateInfo.getExhibitorMailAddress());
			pstmt.setString(2, itemCreateInfo.getItemName());
			pstmt.setString(3, itemCreateInfo.getDescription());
			pstmt.setInt(4, itemCreateInfo.getCondition());
			pstmt.setInt(5, itemCreateInfo.getPrice());
			pstmt.setTimestamp(6, exhibitTimestamp);

			int result = pstmt.executeUpdate();
			System.out.println("createItemInfo : " + result + "件のデータを作成");
		} catch (SQLException e) {
			showSQLException(e);
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				showSQLException(e);
			}
		}
	}

	public void updateItemInfo(ItemUpdateInfo itemUpdateInfo) {

		if (itemUpdateInfo == null) {
			System.err.println("updateItemInfo : itemUpdateInfo is null");
			return;
		}

		Connection connection = getConnection();
		if (connection == null) {
			return;
		}

		try {

			String sql = "update \"ItemInfo\" "
					+ "set \"itemName\" = ?, \"description\" = ?, \"condition\" = ?, \"price\" = ? "
					+ "where \"itemID\" = ?";
			PreparedStatement pstmt = connection.prepareStatement(sql);

			pstmt.setString(1, itemUpdateInfo.getItemName());
			pstmt.setString(2, itemUpdateInfo.getDescription());
			pstmt.setInt(3, itemUpdateInfo.getCondition());
			pstmt.setInt(4, itemUpdateInfo.getPrice());
			pstmt.setLong(5, itemUpdateInfo.getItemID());

			int result = pstmt.executeUpdate();
			System.out.println("updateItemInfo : " + result + "件のデータを更新");
		} catch (SQLException e) {
			showSQLException(e);
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				showSQLException(e);
			}
		}
	}

	public void deleteItemInfo(long itemID) {

		Connection connection = getConnection();
		if (connection == null) {
			return;
		}

		try {

			String sql = "delete from \"ItemInfo\" where \"itemID\" = ?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setLong(1, itemID);

			int result = pstmt.executeUpdate();
			System.out.println("deleteItemInfo : " + result + "件のデータを削除");
		} catch (SQLException e) {
			showSQLException(e);
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				showSQLException(e);
			}
		}
	}

	public ArrayList<ItemInfo> getExhibitItem(String exhibitorMailAddress) {

		Connection connection = getConnection();
		if (connection == null) {
			return null;
		}

		ArrayList<ItemInfo> list = null;
		ResultSet resultSet = null;

		try {

			String sql = "select * from \"ItemInfo\" where \"exhibitorMailAddress\" = ?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, exhibitorMailAddress);

			resultSet = pstmt.executeQuery();

			while (resultSet.next()) {
				ItemInfo itemInfo = ItemInfo.create(resultSet);

				if (list == null) {
					list = new ArrayList<ItemInfo>();
				}

				list.add(itemInfo);
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

	public ArrayList<ItemInfo> searchItemInfo(ItemSearchInfo itemSearchInfo) {

		if (itemSearchInfo == null) {
			System.err.println("searchItemInfo : itemSearchInfo is null");
			return null;
		}

		Connection connection = getConnection();
		if (connection == null) {
			return null;
		}

		ArrayList<ItemInfo> list = null;
		ResultSet resultSet = null;

		try {

			String itemNameKeyword = itemSearchInfo.getItemNameKeyword();
			int condition = itemSearchInfo.getCondition();
			int maxPrice = itemSearchInfo.getMaxPrice();
			java.util.Date oldestDate = itemSearchInfo.getOldestDate();

			boolean isEmptyINK = itemNameKeyword == null;
			boolean isEmptyCondition = condition < 1;
			boolean isEmptyMaxPrice = maxPrice < 0;
			boolean isEmptyOldestDate = oldestDate == null;

			StringBuilder builder = new StringBuilder("select * from \"ItemInfo\" ");

			if (!isEmptyINK || !isEmptyCondition || !isEmptyMaxPrice || !isEmptyOldestDate) {
				builder.append("where ");
			}

			if (!isEmptyINK) {
				builder.append("s.\"itemName\" like ? ");
			}

			if (!isEmptyCondition) {
				if (!isEmptyINK) {
					builder.append("and ");
				}

				builder.append("s.\"condition\" = ? ");
			}

			if (!isEmptyMaxPrice) {
				if (!isEmptyINK || !isEmptyCondition) {
					builder.append("and ");
				}

				builder.append("s.\"price\" <= ? ");
			}

			if (!isEmptyOldestDate) {
				if (!isEmptyINK || !isEmptyCondition || !isEmptyOldestDate) {
					builder.append("and ");
				}

				builder.append("s.\"exhibitDate\" >= ? ");
			}

			String sql = builder.toString();
			PreparedStatement pstmt = connection.prepareStatement(sql);

			int setCount = 1;

			if (!isEmptyINK) {
				pstmt.setString(setCount, itemNameKeyword);
				setCount++;
			}

			if (!isEmptyCondition) {
				pstmt.setInt(setCount, condition);
				setCount++;
			}

			if (!isEmptyMaxPrice) {
				pstmt.setInt(setCount, maxPrice);
				setCount++;
			}

			if (!isEmptyOldestDate) {
				pstmt.setDate(setCount, new Date(oldestDate.getTime()));
				setCount++;
			}

			resultSet = pstmt.executeQuery();

			while (resultSet.next()) {
				ItemInfo itemInfo = ItemInfo.create(resultSet);

				if (list == null) {
					list = new ArrayList<ItemInfo>();
				}

				list.add(itemInfo);
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

	public ArrayList<ItemInfo> getAllItemInfo(){

		Connection connection = getConnection();
		if (connection == null) {
			return null;
		}

		ArrayList<ItemInfo> list = null;
		ResultSet resultSet = null;

		try {

			String sql = "select * from \"ItemInfo\"";
			PreparedStatement pstmt = connection.prepareStatement(sql);

			resultSet = pstmt.executeQuery();

			while (resultSet.next()) {
				ItemInfo itemInfo = ItemInfo.create(resultSet);

				if (list == null) {
					list = new ArrayList<ItemInfo>();
				}

				list.add(itemInfo);
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
}
