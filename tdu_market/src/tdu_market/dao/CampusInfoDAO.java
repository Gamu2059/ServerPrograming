package tdu_market.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import tdu_market.dto.CampusCreateInfo;
import tdu_market.entity_bean.CampusInfo;

public final class CampusInfoDAO extends DAOBase {

	public CampusInfo getCampusInfo(long campusID) {

		Connection connection = getConnection();
		if (connection == null) {
			return null;
		}

		CampusInfo campusInfo = null;
		ResultSet resultSet = null;

		try {

			String sql = "select * from \"CampusInfo\" where \"campusID\" = ?";
			PreparedStatement pstmt = connection.prepareStatement(sql);

			pstmt.setLong(1, campusID);
			resultSet = pstmt.executeQuery();

			if (resultSet.next()) {
				campusInfo = CampusInfo.create(resultSet);
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

		return campusInfo;
	}

	public void createCampusInfo(CampusCreateInfo campusCreateInfo) {

		if (campusCreateInfo == null) {
			System.err.println("createCampusInfo : campusCreateInfo is null");
			return;
		}

		Connection connection = getConnection();
		if (connection == null) {
			return;
		}

		try {

			String sql = "insert into \"CampusInfo\" (\"campusName\") values (?)";
			PreparedStatement pstmt = connection.prepareStatement(sql);

			pstmt.setString(1, campusCreateInfo.getCampusName());

			int result = pstmt.executeUpdate();
			System.out.println("createCampusInfo : " + result + "件のデータ作成");
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

	public void deleteCampusInfo(long campusID) {

		Connection connection = getConnection();
		if (connection == null) {
			return;
		}

		try {

			String sql = "delete from \"CampusInfo\" where \"campusID\" = ?";
			PreparedStatement pstmt = connection.prepareStatement(sql);

			pstmt.setLong(1, campusID);

			int result = pstmt.executeUpdate();
			System.out.println("deleteCampusInfo : " + result + "件のデータ削除");
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

	public ArrayList<CampusInfo> getAllCampusInfo() {

		Connection connection = getConnection();
		if (connection == null) {
			return null;
		}

		ArrayList<CampusInfo> list = null;
		ResultSet resultSet = null;

		try {

			String sql = "select * from \"CampusInfo\"";
			PreparedStatement pstmt = connection.prepareStatement(sql);

			resultSet = pstmt.executeQuery();

			while (resultSet.next()) {
				CampusInfo campusInfo = CampusInfo.create(resultSet);
				if (campusInfo == null) {
					continue;
				}

				if (list == null) {
					list = new ArrayList<CampusInfo>();
				}

				list.add(campusInfo);
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

		ArrayList<CampusInfo> list;
		CampusInfoDAO dao = new CampusInfoDAO();
		showInfo(dao.getAllCampusInfo());

		CampusCreateInfo cInfo = new CampusCreateInfo("神田");
		dao.createCampusInfo(cInfo);
		showInfo(dao.getAllCampusInfo());

		dao.deleteCampusInfo(3);
		showInfo(dao.getAllCampusInfo());

		CampusInfo c = dao.getCampusInfo(2);
		System.out.println(c);
		c = dao.getCampusInfo(3);
		System.out.println(c);
	}

	private static void showInfo(ArrayList<CampusInfo> list) {

		for(CampusInfo i : list) {
			System.out.println(i);
		}
	}
}
