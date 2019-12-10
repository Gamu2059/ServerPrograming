package tdu_market.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

import tdu_market.dto.ItemCreateInfo;
import tdu_market.dto.ItemGetInfo;
import tdu_market.dto.ItemGetInfoByAdmin;
import tdu_market.dto.ItemSearchInfo;
import tdu_market.dto.ItemUpdateInfo;
import tdu_market.dto.StudentGetInfo;
import tdu_market.dto.SyllabusGetInfo;
import tdu_market.entity_bean.ItemInfo;
import tdu_market.entity_bean.ItemInfoByAdmin;
import tdu_market.entity_bean.SyllabusInfo;

public final class ItemInfoDAO extends DAOBase {

	public ItemInfo getItemInfo(long itemID) {

		Connection connection = getConnection();
		if (connection == null) {
			return null;
		}

		ItemInfo itemInfo = null;
		ResultSet resultSet = null;

		try {

			String sql = "select * from \"ItemInfo\" where \"" + ItemInfo.ITEM_ID + "\" = ?";
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

	public long createItemInfo(ItemCreateInfo itemCreateInfo) {

		if (itemCreateInfo == null) {
			System.err.println("createItemInfo : itemCreateInfo is null");
			return -1;
		}

		Connection connection = getConnection();
		if (connection == null) {
			return -1;
		}

		Long itemID = null;
		ResultSet resultSet = null;

		try {

			String sql = String.format(
					"insert into \"ItemInfo\" (\"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\") values (?, ?, ?, ?, ?, ?, 0)",
					ItemInfo.EXHIBITOR_MAIL_ADDRESS,
					ItemInfo.ITEM_NAME,
					ItemInfo.DESCRIPTION,
					ItemInfo.CONDITION,
					ItemInfo.PRICE,
					ItemInfo.EXHIBIT_DATE,
					ItemInfo.TRADING_STATE);
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

			sql = String.format("select \"%s\" from \"ItemInfo\" order by \"%s\" desc limit 1",
					ItemInfo.ITEM_ID,
					ItemInfo.ITEM_ID);
			pstmt = connection.prepareStatement(sql);

			resultSet = pstmt.executeQuery();

			if (resultSet.next()) {
				itemID = resultSet.getLong(ItemInfo.ITEM_ID);
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

		return itemID != null ? itemID : -1;
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

			String sql = String.format(
					"update \"ItemInfo\" set \"%s\" = ?, \"%s\" = ?, \"%s\" = ?, \"%s\" = ? where \"%s\" = ?",
					ItemInfo.ITEM_NAME,
					ItemInfo.DESCRIPTION,
					ItemInfo.CONDITION,
					ItemInfo.PRICE,
					ItemInfo.ITEM_ID);
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

	public void changeTradingState(long itemID, int tradingState) {

		Connection connection = getConnection();
		if (connection == null) {
			return;
		}

		try {

			String sql = String.format("update \"ItemInfo\" set \"%s\" = ? where \"%s\" = ?",
					ItemInfo.TRADING_STATE,
					ItemInfo.ITEM_ID);
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, tradingState);
			pstmt.setLong(2, itemID);

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

			String sql = String.format("delete from \"ItemInfo\" where \"%s\" = ?", ItemInfo.ITEM_ID);
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

			String sql = String.format("select * from \"ItemInfo\" where \"%s\" = ?", ItemInfo.EXHIBITOR_MAIL_ADDRESS);
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
			int oldestDate = itemSearchInfo.getOldestDate();

			boolean isEmptyINK = itemNameKeyword == null;
			boolean isEmptyCondition = condition < 1;
			boolean isEmptyMaxPrice = maxPrice < 0;
			boolean isEmptyOldestDate = oldestDate < 0;

			StringBuilder builder = new StringBuilder("select * from \"ItemInfo\" ");

			if (!isEmptyINK || !isEmptyCondition || !isEmptyMaxPrice || !isEmptyOldestDate) {
				builder.append("where ");
			}

			if (!isEmptyINK) {
				builder.append(String.format("\"%s\" like ? ", ItemInfo.ITEM_NAME));
			}

			if (!isEmptyCondition) {
				if (!isEmptyINK) {
					builder.append("and ");
				}

				builder.append(String.format("\"%s\" = ? ", ItemInfo.CONDITION));
			}

			if (!isEmptyMaxPrice) {
				if (!isEmptyINK || !isEmptyCondition) {
					builder.append("and ");
				}

				builder.append(String.format("\"%s\" <= ? ", ItemInfo.PRICE));
			}

			if (!isEmptyOldestDate) {
				if (!isEmptyINK || !isEmptyCondition || !isEmptyMaxPrice) {
					builder.append("and ");
				}

				builder.append(String.format("\"%s\" >= ? ", ItemInfo.EXHIBIT_DATE));
			}

			String sql = builder.toString();
			PreparedStatement pstmt = connection.prepareStatement(sql);

			int setCount = 1;

			if (!isEmptyINK) {
				pstmt.setString(setCount, String.format("%%%s%%", itemNameKeyword));
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

			Calendar calendar = Calendar.getInstance();
			if (!isEmptyOldestDate) {
				calendar.add(Calendar.DAY_OF_MONTH, -oldestDate);
				pstmt.setDate(setCount, new Date(calendar.getTime().getTime()));
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

	/** 運営が商品を検索するために用意した、複数情報をまとめて検索するメソッド */
	public ArrayList<ItemGetInfoByAdmin> searchItemInfoByManager(ItemSearchInfo itemSearchInfo) {

		if (itemSearchInfo == null) {
			System.err.println("searchItemInfoByManager : itemSearchInfo is null");
			return null;
		}

		Connection connection = getConnection();
		if (connection == null) {
			return null;
		}

		ArrayList<ItemGetInfoByAdmin> list = null;
		ResultSet resultSet = null;

		try {

			String itemNameKeyword = itemSearchInfo.getItemNameKeyword();
			int condition = itemSearchInfo.getCondition();
			int maxPrice = itemSearchInfo.getMaxPrice();
			int oldestDate = itemSearchInfo.getOldestDate();

			boolean isEmptyINK = itemNameKeyword == null;
			boolean isEmptyCondition = condition < 1;
			boolean isEmptyMaxPrice = maxPrice < 0;
			boolean isEmptyOldestDate = oldestDate < 0;

			StringBuilder builder = new StringBuilder(String.format(
					"select * from \"ItemInfoByAdminView\" as i, \"SyllabusInfoView\" as s where s.\"%s\" = i.\"%s\" ",
					SyllabusInfo.CLASS_CODE,
					SyllabusInfo.CLASS_CODE));

			if (!isEmptyINK) {
				builder.append(String.format("and \"%s\" like ? ", ItemInfo.ITEM_NAME));
			}

			if (!isEmptyCondition) {
				builder.append(String.format("and \"%s\" = ? ", ItemInfo.CONDITION));
			}

			if (!isEmptyMaxPrice) {
				builder.append(String.format("and \"%s\" <= ? ", ItemInfo.PRICE));
			}

			if (!isEmptyOldestDate) {
				builder.append(String.format("and \"%s\" >= ? ", ItemInfo.EXHIBIT_DATE));
			}

			String sql = builder.toString();
			PreparedStatement pstmt = connection.prepareStatement(sql);

			int setCount = 1;

			if (!isEmptyINK) {
				pstmt.setString(setCount, String.format("%%%s%%", itemNameKeyword));
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

			Calendar calendar = Calendar.getInstance();
			if (!isEmptyOldestDate) {
				calendar.add(Calendar.DAY_OF_MONTH, -oldestDate);
				pstmt.setDate(setCount, new Date(calendar.getTime().getTime()));
				setCount++;
			}

			resultSet = pstmt.executeQuery();

			while (resultSet.next()) {
				ItemInfoByAdmin itemInfo = ItemInfoByAdmin.create(resultSet);
				if (itemInfo == null) {
					continue;
				}

				ItemGetInfo itemGetInfo = ItemGetInfo.create(itemInfo.getItemInfo(), null);
				StudentGetInfo studentGetInfo = StudentGetInfo.create(itemInfo.getStudentInfo());
				SyllabusGetInfo syllabusGetInfo = SyllabusGetInfo.create(itemInfo.getSyllabusInfo(), itemInfo.getSemesterInfo(), itemInfo.getTeacherInfo());

				if (list == null) {
					list = new ArrayList<ItemGetInfoByAdmin>();
				}

				list.add(new ItemGetInfoByAdmin(itemGetInfo, studentGetInfo, syllabusGetInfo));

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

	public ArrayList<ItemInfo> getAllItemInfo() {

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
