package tdu_market.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import tdu_market.dto.ItemImageCreateInfo;
import tdu_market.entity_bean.ItemImageInfo;

public final class ItemImageInfoDAO extends DAOBase {

	public ArrayList<ItemImageInfo> getItemImageInfo(long itemID) {

		Connection connection = getConnection();
		if (connection == null) {
			return null;
		}

		ArrayList<ItemImageInfo> list = null;
		ResultSet resultSet = null;

		try {

			String sql = "select * from \"ItemImageInfo\" where \"" + ItemImageInfo.ITEM_ID + "\" = ?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setLong(1, itemID);

			resultSet = pstmt.executeQuery();

			while (resultSet.next()) {
				ItemImageInfo itemImageInfo = ItemImageInfo.create(resultSet);

				if (list == null) {
					list = new ArrayList<ItemImageInfo>();
				}

				list.add(itemImageInfo);
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

	public void createItemImageInfo(ItemImageCreateInfo itemImageCreateInfo) {

		if (itemImageCreateInfo == null) {
			System.err.println("createItemImageInfo : itemImageCreateInfo is null");
			return;
		}

		Connection connection = getConnection();
		if (connection == null) {
			return;
		}

		try {

			InputStream[] imageBinaries = itemImageCreateInfo.getItemImageBinaries();
			ArrayList<InputStream> imageList = null;
			for (int i = 0; i < imageBinaries.length; i++) {

				int iconAvailable = 0;
				try {
					iconAvailable = imageBinaries[i].available();
				} catch (IOException e) {

				}

				if (iconAvailable > 0) {
					if (imageList == null) {
						imageList = new ArrayList<InputStream>();
					}

					imageList.add(imageBinaries[i]);
				}
			}

			if (imageList == null) {
				return;
			}

			StringBuilder builder = new StringBuilder("insert into \"ItemImageInfo\" (\"" + ItemImageInfo.ITEM_ID
					+ "\", \"" + ItemImageInfo.IMAGE_BINARY + "\") values");
			for (int i = 0; i < imageList.size(); i++) {
				if (i > 0) {
					builder.append(",");
				}
				builder.append(" (?, ?)");
			}

			String sql = builder.toString();
			PreparedStatement pstmt = connection.prepareStatement(sql);

			for (int i = 0; i < imageList.size(); i++) {
				pstmt.setLong(i * 2 + 1, itemImageCreateInfo.getItemID());
				pstmt.setBinaryStream(i * 2 + 2, imageList.get(i));
			}

			int result = pstmt.executeUpdate();
			System.out.println("createItemImageInfo : " + result + "件のデータを作成");
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

	public void deleteItemImageInfo(long itemID) {

		Connection connection = getConnection();
		if (connection == null) {
			return;
		}

		try {

			String sql = "delete from \"ItemImageInfo\" where \"" + ItemImageInfo.ITEM_ID + "\" = ?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setLong(1, itemID);

			int result = pstmt.executeUpdate();
			System.out.println("deleteItemImageInfo : " + result + "件のデータを削除");
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

	public ArrayList<ItemImageInfo> getAllItemImageInfo() {

		Connection connection = getConnection();
		if (connection == null) {
			return null;
		}

		ArrayList<ItemImageInfo> list = null;
		ResultSet resultSet = null;

		try {

			String sql = "select * from \"ItemImageInfo\"";
			PreparedStatement pstmt = connection.prepareStatement(sql);

			resultSet = pstmt.executeQuery();

			while (resultSet.next()) {
				ItemImageInfo itemImageInfo = ItemImageInfo.create(resultSet);

				if (list == null) {
					list = new ArrayList<ItemImageInfo>();
				}

				list.add(itemImageInfo);
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
