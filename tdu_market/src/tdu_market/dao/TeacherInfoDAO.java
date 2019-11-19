package tdu_market.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import tdu_market.entity_bean.TeacherInfo;

public final class TeacherInfoDAO extends DAOBase {

	public TeacherInfo getTeacherInfo(long teacherID) {

		Connection connection = getConnection();
		if (connection == null) {
			return null;
		}

		TeacherInfo teacherInfo = null;
		ResultSet resultSet = null;

		try {

			String sql = "select * from \"TeacherInfo\" where \"teacherID\" = ?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setLong(1, teacherID);

			resultSet = pstmt.executeQuery();

			if (resultSet.next()) {
				teacherInfo = TeacherInfo.create(resultSet);
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

		return teacherInfo;
	}

	public ArrayList<TeacherInfo> getAllTeacherInfo() {

		Connection connection = getConnection();
		if (connection == null) {
			return null;
		}

		ArrayList<TeacherInfo> list = null;
		ResultSet resultSet = null;

		try {

			String sql = "select * from \"TeacherInfo\"";
			PreparedStatement pstmt = connection.prepareStatement(sql);

			resultSet = pstmt.executeQuery();

			while (resultSet.next()) {
				TeacherInfo teacherInfo = TeacherInfo.create(resultSet);
				if (teacherInfo == null) {
					continue;
				}

				if (list == null) {
					list = new ArrayList<TeacherInfo>();
				}

				list.add(teacherInfo);
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

		TeacherInfoDAO dao = new TeacherInfoDAO();
		showInfo(dao.getAllTeacherInfo());
		System.out.println(dao.getTeacherInfo(1));
		System.out.println(dao.getTeacherInfo(6));
		System.out.println(dao.getTeacherInfo(12));
	}

	private static void showInfo(ArrayList<TeacherInfo> list) {

		if (list == null) {
			System.out.println("list is empty");
			return;
		}

		for(TeacherInfo i : list) {
			System.out.println(i);
		}
	}
}
