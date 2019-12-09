package tdu_market.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

			String sql = "select * from \"CampusInfo\" where \"" + CampusInfo.CAMPUS_ID + "\" = ?";
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

}
