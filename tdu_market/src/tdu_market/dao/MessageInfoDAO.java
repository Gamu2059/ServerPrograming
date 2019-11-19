package tdu_market.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import tdu_market.dto.MessageCreateInfo;
import tdu_market.entity_bean.MessageInfo;

public final class MessageInfoDAO extends DAOBase {

	public MessageInfo getMessageInfo(long messageID) {

		Connection connection = getConnection();
		if (connection == null) {
			return null;
		}

		MessageInfo messageInfo = null;
		ResultSet resultSet = null;

		try {

			String sql = "select * from \"MessageInfo\" where \"messageID\" = ?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setLong(1, messageID);

			resultSet = pstmt.executeQuery();
			if (resultSet.next()) {
				messageInfo = MessageInfo.create(resultSet);
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

		return messageInfo;
	}

	public ArrayList<MessageInfo> getMessageInfoWithRoomInfo(long roomID) {

		Connection connection = getConnection();
		if (connection == null) {
			return null;
		}

		ArrayList<MessageInfo> list = null;
		ResultSet resultSet = null;

		try {

			String sql = "select * from \"MessageInfo\" where \"roomID\" = ?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setLong(1, roomID);

			resultSet = pstmt.executeQuery();
			while (resultSet.next()) {

				MessageInfo messageInfo = MessageInfo.create(resultSet);
				if (list == null) {
					list = new ArrayList<MessageInfo>();
				}

				list.add(messageInfo);
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

	public MessageInfo getLatestMessageInfo(long roomID) {

		Connection connection = getConnection();
		if (connection == null) {
			return null;
		}

		MessageInfo messageInfo = null;
		ResultSet resultSet = null;

		try {

			String sql = "select * from \"MessageInfo\" where \"roomID\" = ? order by \"postDate\" desc";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setLong(1, roomID);

			resultSet = pstmt.executeQuery();
			if (resultSet.next()) {
				messageInfo = MessageInfo.create(resultSet);
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

		return messageInfo;
	}

	public void createMessageInfo(MessageCreateInfo messageCreateInfo) {

		if (messageCreateInfo == null) {
			System.err.println("createMessageInfo : messageCreateInfo is null");
			return;
		}

		Connection connection = getConnection();
		if (connection == null) {
			return;
		}

		try {

			String sql = "insert into \"MessageInfo\" (\"roomID\", \"postMailAddress\", \"postContent\", \"postDate\") values (?, ?, ?, ?)";
			PreparedStatement pstmt = connection.prepareStatement(sql);

			Date postDate = new Date(new java.util.Date().getTime());

			pstmt.setLong(1, messageCreateInfo.getRoomID());
			pstmt.setString(2, messageCreateInfo.getPostMailAddress());
			pstmt.setString(3, messageCreateInfo.getPostContent());
			pstmt.setDate(4, postDate);

			int result = pstmt.executeUpdate();
			System.out.println("createMessageInfo : " + result + "件のデータを作成");
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

	public void deleteMessageInfoWithMessageRoom(long roomID) {

		Connection connection = getConnection();
		if (connection == null) {
			return;
		}

		try {

			String sql = "delete from \"MessgeInfo\" where \"roomID\" = ?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setLong(1, roomID);

			int result = pstmt.executeUpdate();
			System.out.println("deleteMessageInfoWithMessageRoom : " + result + "件のデータを削除");
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

	public void deleteMessageInfoWithMailAddress(String mailAddress) {

		Connection connection = getConnection();
		if (connection == null) {
			return;
		}

		try {

			String sql = "delete from \"MessgeInfo\" where \"postMailAddress\" = ?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, mailAddress);

			int result = pstmt.executeUpdate();
			System.out.println("deleteMessageInfoWithMailAddress : " + result + "件のデータを削除");
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

	public ArrayList<MessageInfo> getAllMessageInfo() {

		Connection connection = getConnection();
		if (connection == null) {
			return null;
		}

		ArrayList<MessageInfo> list = null;
		ResultSet resultSet = null;

		try {

			String sql = "select * from \"MessageInfo\"";
			PreparedStatement pstmt = connection.prepareStatement(sql);

			resultSet = pstmt.executeQuery();
			while (resultSet.next()) {

				MessageInfo messageInfo = MessageInfo.create(resultSet);
				if (list == null) {
					list = new ArrayList<MessageInfo>();
				}

				list.add(messageInfo);
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
