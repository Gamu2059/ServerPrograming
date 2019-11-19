package tdu_market.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import tdu_market.dto.StudentCreateInfo;
import tdu_market.dto.StudentSearchInfo;
import tdu_market.dto.StudentUpdateInfo;
import tdu_market.entity_bean.StudentInfo;
import tdu_market.util.PasswordUtil;

public final class StudentInfoDAO extends DAOBase {

	public void createStudentInfo(StudentCreateInfo studentCreateInfo) {

		if (studentCreateInfo == null) {
			System.err.println("createStudentInfo : studentCreateInfo is null");
			return;
		}

		Connection connection = getConnection();
		if (connection == null) {
			return;
		}

		ResultSet resultSet = null;

		try {

			String sql = "insert into \"StudentInfo\" (\"mailAddress\", \"hashedPassword\", \"studentNumber\", \"createdDate\") values (?, ?, ?, ?)";
			PreparedStatement pstmt = connection.prepareStatement(sql);

			String mailAddress = studentCreateInfo.getMailAddress();
			String hashedPassword = PasswordUtil.getHashedPassword(studentCreateInfo.getNonHashedPassword(),
					mailAddress);
			String studentNumber = studentCreateInfo.getStudentNumber();
			Timestamp createdTimestamp = new Timestamp(new java.util.Date().getTime());

			pstmt.setString(1, mailAddress);
			pstmt.setString(2, hashedPassword);
			pstmt.setString(3, studentNumber);
			pstmt.setTimestamp(4, createdTimestamp);

			int result = pstmt.executeUpdate();
			System.out.println("createStudentInfo : " + result + "件のデータを作成");
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

		if (studentUpdateInfo == null) {
			System.err.println("updateStudentInfo : studentUpdateInfo is null");
			return;
		}

		Connection connection = getConnection();
		if (connection == null) {
			return;
		}

		ResultSet resultSet = null;

		try {

			String sql = "update \"StudentInfo\" "
					+ "set \"hashedPassword\" = ?, \"displayName\" = ?, \"subjectID\" = ?, \"selfIntroduction\" = ?, \"iconImageBinary\" = ?, \"registerState\" = 2 "
					+ "where \"mailAddress\" = ?";
			PreparedStatement pstmt = connection.prepareStatement(sql);

			String mailAddress = studentUpdateInfo.getMailAddress();
			String hashedPassword = PasswordUtil.getHashedPassword(studentUpdateInfo.getNonHashedPassword(),
					mailAddress);
			String displayName = studentUpdateInfo.getDisplayName();
			long subjectID = studentUpdateInfo.getSubjectID();
			String selfIntroduction = studentUpdateInfo.getSelfIntroduction();
			String iconImageBinary = studentUpdateInfo.getIconImageBinary();

			pstmt.setString(1, hashedPassword);
			pstmt.setString(2, displayName);
			pstmt.setLong(3, subjectID);
			pstmt.setString(4, selfIntroduction);
			pstmt.setString(5, iconImageBinary);
			pstmt.setString(6, mailAddress);

			int result = pstmt.executeUpdate();
			System.out.println("updateStudentInfo : " + result + "件のデータを更新");
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

		Connection connection = getConnection();
		if (connection == null) {
			return;
		}

		ResultSet resultSet = null;

		try {

			String sql = "update \"StudentInfo\" set \"lastLoginDate\" = ? where \"mailAddress\" = ?";
			PreparedStatement pstmt = connection.prepareStatement(sql);

			Timestamp lastLoginTimestamp = new Timestamp(new java.util.Date().getTime());

			pstmt.setTimestamp(1, lastLoginTimestamp);
			pstmt.setString(2, mailAddress);

			int result = pstmt.executeUpdate();
			System.out.println("updateLastLogin : " + result + "件のデータを更新");
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

	public ArrayList<StudentInfo> searchStudentInfo(StudentSearchInfo studentSearchInfo) {

		if (studentSearchInfo == null) {
			System.err.println("searchStudentInfo : studentSearchInfo is null");
			return null;
		}

		Connection connection = getConnection();
		if (connection == null) {
			return null;
		}

		ArrayList<StudentInfo> list = null;
		ResultSet resultSet = null;

		try {

			String studentNumberKeyword = studentSearchInfo.getStudentNumberKeyword();
			String displayNameKeyword = studentSearchInfo.getDisplayNameKeyword();
			long subjectID = studentSearchInfo.getSubjectID();

			boolean isEmptySNK = studentNumberKeyword == null;
			boolean isEmptyDNK = displayNameKeyword == null;
			boolean isEmptySujectID = subjectID < 1;

			StringBuilder builder = new StringBuilder("select * from \"StudentInfo\" ");

			if (!isEmptySNK || !isEmptyDNK || !isEmptySujectID) {
				builder.append("where ");
			}

			if (!isEmptySNK) {
				builder.append("\"studentNumber\" like ? ");
			}

			if (!isEmptyDNK) {
				if (!isEmptySNK) {
					builder.append("and ");
				}

				builder.append("\"displayName\" like ? ");
			}

			if (!isEmptySujectID) {
				if (!isEmptySNK || !isEmptyDNK) {
					builder.append("and ");
				}

				builder.append("\"subjectID\" = ? ");
			}

			String sql = builder.toString();
			PreparedStatement pstmt = connection.prepareStatement(sql);

			int setCount = 1;

			if (!isEmptySNK) {
				pstmt.setString(setCount, String.format("%%%s%%", studentNumberKeyword));
				setCount++;
			}

			if (!isEmptyDNK) {
				pstmt.setString(setCount, String.format("%%%s%%", displayNameKeyword));
				setCount++;
			}

			if (!isEmptySujectID) {
				pstmt.setLong(setCount, subjectID);
				setCount++;
			}

			resultSet = pstmt.executeQuery();
			while (resultSet.next()) {

				StudentInfo studentInfo = StudentInfo.create(resultSet);
				if (list == null) {
					list = new ArrayList<StudentInfo>();
				}

				list.add(studentInfo);
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

	public ArrayList<StudentInfo> getAllStudentInfo() {

		Connection connection = getConnection();
		if (connection == null) {
			return null;
		}

		ArrayList<StudentInfo> list = null;
		ResultSet resultSet = null;

		try {

			String sql = "select * from \"StudentInfo\"";
			PreparedStatement pstmt = connection.prepareStatement(sql);

			resultSet = pstmt.executeQuery();
			while (resultSet.next()) {

				StudentInfo studentInfo = StudentInfo.create(resultSet);
				if (list == null) {
					list = new ArrayList<StudentInfo>();
				}

				list.add(studentInfo);
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

		StudentInfoDAO dao = new StudentInfoDAO();

		StudentSearchInfo searchInfo;
		searchInfo = new StudentSearchInfo(null, 0, null);
		showInfo(dao.searchStudentInfo(searchInfo));

		searchInfo = new StudentSearchInfo("", 0, null);
		showInfo(dao.searchStudentInfo(searchInfo));

		searchInfo = new StudentSearchInfo(null, 0, "");
		showInfo(dao.searchStudentInfo(searchInfo));

		searchInfo = new StudentSearchInfo(null, 11, null);
		showInfo(dao.searchStudentInfo(searchInfo));

		searchInfo = new StudentSearchInfo("3", 11, null);
		showInfo(dao.searchStudentInfo(searchInfo));

		searchInfo = new StudentSearchInfo("17", 11, "し");
		showInfo(dao.searchStudentInfo(searchInfo));

		StudentCreateInfo studentCreateInfo = new StudentCreateInfo("18fi005@ms.dendai.ac.jp", "agiab6BYhr4",
				"18fi005");
		dao.createStudentInfo(studentCreateInfo);
		showInfo(dao.getAllStudentInfo());

		dao.deleteStudentInfo("18fi005@ms.dendai.ac.jp");
		dao.deleteStudentInfo("17fi002@ms.dendai.ac.jp");
		showInfo(dao.getAllStudentInfo());

		dao.updateLastLogin("17fi103@ms.dendai.ac.jp");
		showInfo(dao.getAllStudentInfo());
	}

	private static void showInfo(ArrayList<StudentInfo> list) {

		if (list == null) {
			System.out.println("list is empty");
			return;
		}

		for (StudentInfo i : list) {
			System.out.println(i);
		}
	}
}
