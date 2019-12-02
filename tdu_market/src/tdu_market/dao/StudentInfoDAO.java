package tdu_market.dao;

import java.io.IOException;
import java.io.InputStream;
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

		try {

			String sql = "insert into \"StudentInfo\" (\"mailAddress\", \"hashedPassword\", \"studentNumber\", \"subjectID\", \"createdDate\") values (?, ?, ?, ?, ?)";
			PreparedStatement pstmt = connection.prepareStatement(sql);

			String mailAddress = studentCreateInfo.getMailAddress();
			String hashedPassword = PasswordUtil.getHashedPassword(studentCreateInfo.getNonHashedPassword(),
					mailAddress);
			String studentNumber = studentCreateInfo.getStudentNumber();
			long subjectID = studentCreateInfo.getSubjectID();
			Timestamp createdTimestamp = new Timestamp(new java.util.Date().getTime());

			pstmt.setString(1, mailAddress);
			pstmt.setString(2, hashedPassword);
			pstmt.setString(3, studentNumber);
			pstmt.setLong(4, subjectID);
			pstmt.setTimestamp(5, createdTimestamp);

			int result = pstmt.executeUpdate();
			System.out.println("createStudentInfo : " + result + "件のデータを作成");
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

	public StudentInfo getStudentInfo(String mailAddress, boolean isIncludeNonRegistered) {

		Connection connection = getConnection();
		if (connection == null) {
			return null;
		}

		StudentInfo studentInfo = null;
		ResultSet resultSet = null;

		try {

			StringBuilder builder = new StringBuilder("select * from \"StudentInfo\" where \"mailAddress\" = ?");
			if (!isIncludeNonRegistered) {
				builder.append(" and \"registerState\" = 2");
			}

			String sql = builder.toString();

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

	/** 学生自身が情報を変更する場合の処理。学科情報の変更は無視されます。 */
	public void updateStudentInfo(StudentUpdateInfo studentUpdateInfo) {

		if (studentUpdateInfo == null) {
			System.err.println("updateStudentInfo : studentUpdateInfo is null");
			return;
		}

		Connection connection = getConnection();
		if (connection == null) {
			return;
		}

		try {

			String mailAddress = studentUpdateInfo.getMailAddress();
			String hashedPassword = PasswordUtil.getHashedPassword(studentUpdateInfo.getNonHashedPassword(),
					mailAddress);
			String displayName = studentUpdateInfo.getDisplayName();
			String selfIntroduction = studentUpdateInfo.getSelfIntroduction();
			InputStream iconImageBinary = studentUpdateInfo.getIconImageBinary();

			int iconAvailable = 0;
			try {
				iconAvailable = iconImageBinary.available();
			} catch (IOException e) {

			}

			boolean isChangeIcon = iconAvailable > 0;

			StringBuilder builder = new StringBuilder(
					"update \"StudentInfo\" set \"hashedPassword\" = ?, \"displayName\" = ?, \"selfIntroduction\" = ?, \"registerState\" = 2");

			if (isChangeIcon) {
				builder.append(", \"iconImageBinary\" = ?");
			}

			builder.append(" where \"mailAddress\" = ?");
			String sql = builder.toString();
			PreparedStatement pstmt = connection.prepareStatement(sql);

			int setCount = 1;

			pstmt.setString(setCount++, hashedPassword);
			pstmt.setString(setCount++, displayName);
			pstmt.setString(setCount++, selfIntroduction);

			if (isChangeIcon) {
				pstmt.setBinaryStream(setCount++, iconImageBinary);
			}

			pstmt.setString(setCount++, mailAddress);

			int result = pstmt.executeUpdate();
			System.out.println("updateStudentInfo : " + result + "件のデータを更新");
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

	/** 運営が学生自身の情報を変更する場合の処理。パスワードの変更は無視されます。 */
	public void updateStudentInfoByAdmin(StudentUpdateInfo studentUpdateInfo) {

		if (studentUpdateInfo == null) {
			System.err.println("updateStudentInfoByAdmin : studentUpdateInfo is null");
			return;
		}

		Connection connection = getConnection();
		if (connection == null) {
			return;
		}

		try {

			String mailAddress = studentUpdateInfo.getMailAddress();
			String displayName = studentUpdateInfo.getDisplayName();
			long subjectID = studentUpdateInfo.getSubjectID();
			String selfIntroduction = studentUpdateInfo.getSelfIntroduction();
			InputStream iconImageBinary = studentUpdateInfo.getIconImageBinary();

			int iconAvailable = 0;
			try {
				iconAvailable = iconImageBinary.available();
			} catch (IOException e) {

			}

			boolean isChangeIcon = iconAvailable > 0;

			// 運営が更新する場合は、本登録状態にさせない
			StringBuilder builder = new StringBuilder(
					"update \"StudentInfo\" set \"displayName\" = ?, \"subjectID\" = ?, \"selfIntroduction\" = ?");

			if (isChangeIcon) {
				builder.append(", \"iconImageBinary\" = ?");
			}

			builder.append(" where \"mailAddress\" = ?");
			String sql = builder.toString();
			PreparedStatement pstmt = connection.prepareStatement(sql);

			int setCount = 1;

			pstmt.setString(setCount++, displayName);
			pstmt.setLong(setCount++, subjectID);
			pstmt.setString(setCount++, selfIntroduction);

			if (isChangeIcon) {
				pstmt.setBinaryStream(setCount++, iconImageBinary);
			}

			pstmt.setString(setCount++, mailAddress);

			int result = pstmt.executeUpdate();
			System.out.println("updateStudentInfoByAdmin : " + result + "件のデータを更新");
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

	public void deleteStudentInfo(String mailAddress) {

		Connection connection = getConnection();
		if (connection == null) {
			return;
		}

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
			boolean isIncludeNonRegistered = studentSearchInfo.isIncludeNonRegistered();

			boolean isEmptySNK = studentNumberKeyword == null;
			boolean isEmptyDNK = displayNameKeyword == null;
			boolean isEmptySujectID = subjectID < 1;

			StringBuilder builder = new StringBuilder("select * from \"StudentInfo\" ");

			if (!isEmptySNK || !isEmptyDNK || !isEmptySujectID || !isIncludeNonRegistered) {
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

			if (!isIncludeNonRegistered) {
				if (!isEmptySNK || !isEmptyDNK || !isEmptySujectID) {
					builder.append("and ");
				}

				builder.append("\"registerState\" = 2");
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
}
