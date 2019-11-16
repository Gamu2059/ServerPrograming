package tdu_market.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import tdu_market.dto.StudentCreateInfo;
import tdu_market.dto.StudentSearchInfo;
import tdu_market.dto.StudentUpdateInfo;
import tdu_market.entity_bean.StudentInfo;

public final class StudentInfoDAO extends DAOBase {

	public void createStudentInfo(StudentCreateInfo studentCreateInfo) {

		Connection connection = getConnection();
		if (connection == null) {
			return;
		}

		ResultSet resultSet = null;

		try {

			String sql = "delete from \"StudentInfo\" where \"mailAddress\" = ?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, mailAddress);

			int result = pstmt.executeUpdate();
			System.out.println("deleteStudentInfo : " + result + "件のデータを削除");
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

		System.err.println("createStudentInfo is non implementation!");
		return;
	}

	public StudentInfo getStudentInfo(String mailAddress) {

		Connection connection = getConnection();
		if (connection == null) {
			return null;
		}

		StudentInfo studentInfo = null;
		ResultSet resultSet = null;

		try {

			String sql = "select * from \"StudentInfo\" where \"mailAddress\" = ?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, mailAddress);

			resultSet = pstmt.executeQuery();

			if (resultSet.next()) {
				studentInfo = StudentInfo.create(resultSet);
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

		return studentInfo;
	}

	public void updateStudentInfo(StudentUpdateInfo studentUpdateInfo) {

//		Connection connection = getConnection();
//		if (connection == null) {
//			return;
//		}
//
//		ResultSet resultSet = null;
//
//		try {
//
//			String sql = "delete from \"StudentInfo\" where \"mailAddress\" = ?";
//			PreparedStatement pstmt = connection.prepareStatement(sql);
//			pstmt.setString(1, mailAddress);
//
//			int result = pstmt.executeUpdate();
//			System.out.println("deleteStudentInfo : " + result + "件のデータを削除");
//		} catch (SQLException e) {
//			showSQLException(e);
//		} finally {
//			try {
//				if (resultSet != null) {
//					resultSet.close();
//				}
//				if (connection != null) {
//					connection.close();
//				}
//			} catch (SQLException e) {
//				showSQLException(e);
//			}
//		}
		System.err.println("updateStudentInfo is non implementation!");
	}

	public void deleteStudentInfo(String mailAddress) {

		Connection connection = getConnection();
		if (connection == null) {
			return;
		}

		ResultSet resultSet = null;

		try {

			String sql = "delete from \"StudentInfo\" where \"mailAddress\" = ?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, mailAddress);

			int result = pstmt.executeUpdate();
			System.out.println("deleteStudentInfo : " + result + "件のデータを削除");
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
		System.err.println("updateLastLogin is non implementation!");
	}

	public ArrayList<StudentInfo> searchStudentInfo(StudentSearchInfo studentSearchInfo) {
		System.err.println("searchStudentInfo is non implementation!");
		return null;
	}
}
