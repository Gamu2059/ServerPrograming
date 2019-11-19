package tdu_market.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import tdu_market.dto.RelatedClassCreateInfo;
import tdu_market.entity_bean.RelatedClassInfo;

public final class RelatedClassInfoDAO extends DAOBase {

	public ArrayList<RelatedClassInfo> getRelatedClassInfoWithItem(long itemID) {

		Connection connection = getConnection();
		if (connection == null) {
			return null;
		}

		ArrayList<RelatedClassInfo> list = null;
		ResultSet resultSet = null;

		try {

			String sql = "select * from \"RelatedClassInfo\" where \"itemID\" = ?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setLong(1, itemID);

			resultSet = pstmt.executeQuery();

			while (resultSet.next()) {
				RelatedClassInfo relatedClassInfo = RelatedClassInfo.create(resultSet);

				if (list == null) {
					list = new ArrayList<RelatedClassInfo>();
				}

				list.add(relatedClassInfo);
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

	public ArrayList<RelatedClassInfo> getRelatedClassInfoWithSyllabus(String classCode) {

		Connection connection = getConnection();
		if (connection == null) {
			return null;
		}

		ArrayList<RelatedClassInfo> list = null;
		ResultSet resultSet = null;

		try {

			String sql = "select * from \"RelatedClassInfo\" where \"classCode\" = ?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, classCode);

			resultSet = pstmt.executeQuery();

			while (resultSet.next()) {
				RelatedClassInfo relatedClassInfo = RelatedClassInfo.create(resultSet);

				if (list == null) {
					list = new ArrayList<RelatedClassInfo>();
				}

				list.add(relatedClassInfo);
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

	public void createRelatedClassInfo(RelatedClassCreateInfo relatedClassCreateInfo) {

		if (relatedClassCreateInfo == null) {
			System.err.println("createRelatedClassInfo : relatedClassCreateInfo is null");
			return;
		}

		Connection connection = getConnection();
		if (connection == null) {
			return;
		}

		try {

			String sql = "insert into \"RelatedClassInfo\" values (?, ?)";
			PreparedStatement pstmt = connection.prepareStatement(sql);

			pstmt.setLong(1, relatedClassCreateInfo.getItemID());
			pstmt.setString(2, relatedClassCreateInfo.getClassCode());

			int result = pstmt.executeUpdate();
			System.out.println("createRelatedClassInfo : " + result + "件のデータを作成");
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

	public void deleteRelatedClassInfoWithItem(long itemID) {

		Connection connection = getConnection();
		if (connection == null) {
			return;
		}

		try {

			String sql = "delete from \"RelatedClassInfo\" where \"itemID\" = ?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setLong(1, itemID);

			int result = pstmt.executeUpdate();
			System.out.println("deleteRelatedClassInfoWithSyllabus : " + result + "件のデータを削除");
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

	public void deleteRelatedClassInfoWithSyllabus(String classCode) {

		Connection connection = getConnection();
		if (connection == null) {
			return;
		}

		try {

			String sql = "delete from \"RelatedClassInfo\" where \"classCode\" = ?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, classCode);

			int result = pstmt.executeUpdate();
			System.out.println("deleteRelatedClassInfoWithSyllabus : " + result + "件のデータを削除");
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

	public ArrayList<RelatedClassInfo> getAllRelatedClassInfo(){

		Connection connection = getConnection();
		if (connection == null) {
			return null;
		}

		ArrayList<RelatedClassInfo> list = null;
		ResultSet resultSet = null;

		try {

			String sql = "select * from \"RelatedClassInfo\"";
			PreparedStatement pstmt = connection.prepareStatement(sql);

			resultSet = pstmt.executeQuery();

			while (resultSet.next()) {
				RelatedClassInfo relatedClassInfo = RelatedClassInfo.create(resultSet);

				if (list == null) {
					list = new ArrayList<RelatedClassInfo>();
				}

				list.add(relatedClassInfo);
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
