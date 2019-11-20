package tdu_market.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import tdu_market.entity_bean.SemesterInfo;

public final class SemesterInfoDAO extends DAOBase {

	public SemesterInfo getSemesterInfo(long semesterID) {

		Connection connection = getConnection();
		if (connection == null) {
			return null;
		}

		SemesterInfo semesterInfo = null;
		ResultSet resultSet = null;

		try {

			String sql = "select * from \"SemesterInfo\" where \"semesterID\" = ?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setLong(1, semesterID);

			resultSet = pstmt.executeQuery();

			if (resultSet.next()) {
				semesterInfo = SemesterInfo.create(resultSet);
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

		return semesterInfo;
	}

	public ArrayList<SemesterInfo> getAllSemesterInfo() {

		Connection connection = getConnection();
		if (connection == null) {
			return null;
		}

		ArrayList<SemesterInfo> list = null;
		ResultSet resultSet = null;

		try {

			String sql = "select * from \"SemesterInfo\"";
			PreparedStatement pstmt = connection.prepareStatement(sql);

			resultSet = pstmt.executeQuery();

			while (resultSet.next()) {
				SemesterInfo semesterInfo = SemesterInfo.create(resultSet);
				if (semesterInfo == null) {
					continue;
				}

				if (list == null) {
					list = new ArrayList<SemesterInfo>();
				}

				list.add(semesterInfo);
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

		SemesterInfoDAO dao = new SemesterInfoDAO();
		showInfo(dao.getAllSemesterInfo());
		System.out.println(dao.getSemesterInfo(2));
	}

	private static void showInfo(ArrayList<SemesterInfo> list) {

		if (list == null) {
			System.out.println("list is empty");
			return;
		}

		for(SemesterInfo i : list) {
			System.out.println(i);
		}
	}
}
