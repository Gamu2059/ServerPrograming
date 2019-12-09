package tdu_market.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import tdu_market.entity_bean.DepartmentInfo;

/** 学位、学部、学科などをまとめて取り扱うDAO */
public final class DepartmentInfoDAO extends DAOBase {

	public ArrayList<DepartmentInfo> getDepartmentInfoWithDegree(long degreeID, boolean isIncludeNormalSubject) {

		Connection connection = getConnection();
		if (connection == null) {
			return null;
		}

		ArrayList<DepartmentInfo> list = null;
		ResultSet resultSet = null;

		try {

			String sql;
			if (isIncludeNormalSubject) {
				sql = "select * from \"DepartmentInfoView\" where \"" + DepartmentInfo.DEGREE_ID + "\" = ?";
			} else {
				sql = "select * from \"DepartmentInfoView\" where \"" + DepartmentInfo.FACULTY_SYMBOL + "\" <> ' ' and d.\"" + DepartmentInfo.DEGREE_ID + "\" = ?";
			}

			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setLong(1, degreeID);

			resultSet = pstmt.executeQuery();

			while (resultSet.next()) {
				DepartmentInfo departmentInfo = DepartmentInfo.create(resultSet);

				if (list == null) {
					list = new ArrayList<DepartmentInfo>();
				}

				list.add(departmentInfo);
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

	public ArrayList<DepartmentInfo> getDepartmentInfoWithFaculty(long facultyID, boolean isIncludeNormalSubject) {

		Connection connection = getConnection();
		if (connection == null) {
			return null;
		}

		ArrayList<DepartmentInfo> list = null;
		ResultSet resultSet = null;

		try {

			String sql;
			if (isIncludeNormalSubject) {
				sql = "select * from \"DepartmentInfoView\" where \"" + DepartmentInfo.FACULTY_ID + "\" = ?";
			} else {
				sql = "select * from \"DepartmentInfoView\" where \"" + DepartmentInfo.FACULTY_SYMBOL + "\" <> ' ' and d.\"" + DepartmentInfo.FACULTY_ID + "\" = ?";
			}

			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setLong(1, facultyID);

			resultSet = pstmt.executeQuery();

			while (resultSet.next()) {
				DepartmentInfo departmentInfo = DepartmentInfo.create(resultSet);

				if (list == null) {
					list = new ArrayList<DepartmentInfo>();
				}

				list.add(departmentInfo);
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

	public ArrayList<DepartmentInfo> getDepartmentInfoWithSubject(long subjectID, boolean isIncludeNormalSubject) {

		Connection connection = getConnection();
		if (connection == null) {
			return null;
		}

		ArrayList<DepartmentInfo> list = null;
		ResultSet resultSet = null;

		try {

			String sql;
			if (isIncludeNormalSubject) {
				sql = "select * from \"DepartmentInfoView\" where \"" + DepartmentInfo.SUBJECT_ID + "\" = ?";
			} else {
				sql = "select * from \"DepartmentInfoView\" where \"" + DepartmentInfo.FACULTY_SYMBOL + "\" <> ' ' and d.\"" + DepartmentInfo.SUBJECT_ID + "\" = ?";
			}

			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setLong(1, subjectID);

			resultSet = pstmt.executeQuery();

			while (resultSet.next()) {
				DepartmentInfo departmentInfo = DepartmentInfo.create(resultSet);

				if (list == null) {
					list = new ArrayList<DepartmentInfo>();
				}

				list.add(departmentInfo);
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

	public ArrayList<DepartmentInfo> getAllDepartmentInfo(boolean isIncludeNormalSubject) {

		Connection connection = getConnection();
		if (connection == null) {
			return null;
		}

		ArrayList<DepartmentInfo> list = null;
		ResultSet resultSet = null;

		try {

			String sql;
			if (isIncludeNormalSubject) {
				sql = "select * from \"DepartmentInfoView\"";
			} else {
				sql = "select * from \"DepartmentInfoView\" where \"" + DepartmentInfo.FACULTY_SYMBOL + "\" <> ' '";
			}

			PreparedStatement pstmt = connection.prepareStatement(sql);

			resultSet = pstmt.executeQuery();

			while (resultSet.next()) {
				DepartmentInfo departmentInfo = DepartmentInfo.create(resultSet);

				if (list == null) {
					list = new ArrayList<DepartmentInfo>();
				}

				list.add(departmentInfo);
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
