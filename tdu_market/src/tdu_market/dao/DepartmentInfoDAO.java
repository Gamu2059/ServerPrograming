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
				sql = "select * " +
						"from \"DegreeInfo\" as d, \"FacultyInfo\" as f, \"SubjectInfo\" as s " +
						"where d.\"degreeID\" = f.\"degreeID\" and f.\"facultyID\" = s.\"facultyID\" and d.\"degreeID\" = ?";
			} else {
				sql = "select * " +
						"from \"DegreeInfo\" as d, \"FacultyInfo\" as f, \"SubjectInfo\" as s " +
						"where d.\"degreeID\" = f.\"degreeID\" and f.\"facultyID\" = s.\"facultyID\" and f.\"facultySymbol\" <> ' ' and d.\"degreeID\" = ?";
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
				sql = "select * " +
						"from \"DegreeInfo\" as d, \"FacultyInfo\" as f, \"SubjectInfo\" as s " +
						"where d.\"degreeID\" = f.\"degreeID\" and f.\"facultyID\" = s.\"facultyID\" and f.\"facultyID\" = ?";
			} else {
				sql = "select * " +
						"from \"DegreeInfo\" as d, \"FacultyInfo\" as f, \"SubjectInfo\" as s " +
						"where d.\"degreeID\" = f.\"degreeID\" and f.\"facultyID\" = s.\"facultyID\" and f.\"facultySymbol\" <> ' ' and f.\"facultyID\" = ?";
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
				sql = "select * " +
						"from \"DegreeInfo\" as d, \"FacultyInfo\" as f, \"SubjectInfo\" as s " +
						"where d.\"degreeID\" = f.\"degreeID\" and f.\"facultyID\" = s.\"facultyID\" and s.\"subjectID\" = ?";
			} else {
				sql = "select * " +
						"from \"DegreeInfo\" as d, \"FacultyInfo\" as f, \"SubjectInfo\" as s " +
						"where d.\"degreeID\" = f.\"degreeID\" and f.\"facultyID\" = s.\"facultyID\" and f.\"facultySymbol\" <> ' ' and s.\"subjectID\" = ?";
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
				sql = "select * " +
						"from \"DegreeInfo\" as d, \"FacultyInfo\" as f, \"SubjectInfo\" as s " +
						"where d.\"degreeID\" = f.\"degreeID\" and f.\"facultyID\" = s.\"facultyID\"";
			} else {
				sql = "select * " +
						"from \"DegreeInfo\" as d, \"FacultyInfo\" as f, \"SubjectInfo\" as s " +
						"where d.\"degreeID\" = f.\"degreeID\" and f.\"facultyID\" = s.\"facultyID\" and f.\"facultySymbol\" <> ' '";
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

	public static void main(String[] args) {

		DepartmentInfoDAO dao = new DepartmentInfoDAO();
		System.out.println("ALL not include normal");
		showInfo(dao.getAllDepartmentInfo(false));

		System.out.println("ALL include normal");
		showInfo(dao.getAllDepartmentInfo(true));

		System.out.println("DEGREE");
		showInfo(dao.getDepartmentInfoWithDegree(1, false));

		System.out.println("FACULTY");
		showInfo(dao.getDepartmentInfoWithFaculty(1, false));

		System.out.println("SUBJECT");
		showInfo(dao.getDepartmentInfoWithSubject(11, false));
	}

	private static void showInfo(ArrayList<DepartmentInfo> list) {

		if (list == null) {
			System.out.println("List is empty.");
			return;
		}

		for (DepartmentInfo i : list) {
			System.out.println(i);
		}
	}
}
