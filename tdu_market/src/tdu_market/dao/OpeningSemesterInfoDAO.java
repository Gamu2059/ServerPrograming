package tdu_market.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import tdu_market.dto.OpeningSemesterCreateInfo;
import tdu_market.entity_bean.OpeningSemesterInfo;

public final class OpeningSemesterInfoDAO extends DAOBase {

	public ArrayList<OpeningSemesterInfo> getOpeningSemesterInfo(String classCode) {

		Connection connection = getConnection();
		if (connection == null) {
			return null;
		}

		ArrayList<OpeningSemesterInfo> list = null;
		ResultSet resultSet = null;

		try {

			String sql = String.format("select * from \"OpeningSemesterInfo\" where \"%s\" = ?",
					OpeningSemesterInfo.CLASS_CODE);
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, classCode);

			resultSet = pstmt.executeQuery();

			while (resultSet.next()) {
				OpeningSemesterInfo openingSemesterInfo = OpeningSemesterInfo.create(resultSet);

				if (list == null) {
					list = new ArrayList<OpeningSemesterInfo>();
				}

				list.add(openingSemesterInfo);
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

	public void createOpeningSemesterInfo(OpeningSemesterCreateInfo openingSemesterCreateInfo) {

		if (openingSemesterCreateInfo == null) {
			System.err.println("createOpeningSemesterInfo : openingSemesterCreateInfo is null");
			return;
		}

		Connection connection = getConnection();
		if (connection == null) {
			return;
		}

		try {

			long[] semesterIDs = openingSemesterCreateInfo.getSemesterIDs();
			StringBuilder builder = new StringBuilder("insert into \"OpeningSemesterInfo\" values");
			for (int i = 0; i < semesterIDs.length; i++) {
				if (i > 0) {
					builder.append(",");
				}
				builder.append(" (?, ?)");
			}

			String sql = builder.toString();
			PreparedStatement pstmt = connection.prepareStatement(sql);

			for (int i = 0; i < semesterIDs.length; i++) {
				pstmt.setString(i * 2 + 1, openingSemesterCreateInfo.getClassCode());
				pstmt.setLong(i * 2 + 2, semesterIDs[i]);
			}

			int result = pstmt.executeUpdate();
			System.out.println("createOpeningSemesterInfo : " + result + "件のデータを作成");
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

	public void deleteOpeningSemesterInfo(String classCode) {

		Connection connection = getConnection();
		if (connection == null) {
			return;
		}

		try {

			String sql = String.format("delete from \"OpeningSemesterInfo\" where \"%s\" = ?",
					OpeningSemesterInfo.CLASS_CODE);
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, classCode);

			int result = pstmt.executeUpdate();
			System.out.println("deleteOpeningSemesterInfo : " + result + "件のデータを削除");
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
}
