package tdu_market.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import tdu_market.dto.MessageRoomCreateInfo;
import tdu_market.entity_bean.MessageRoomInfo;

public final class MessageRoomInfoDAO extends DAOBase {

	public MessageRoomInfo getMessageRoomInfo(long roomID) {

		Connection connection = getConnection();
		if (connection == null) {
			return null;
		}

		MessageRoomInfo messageRoomInfo = null;
		ResultSet resultSet = null;

		try {

			String sql = "select * from \"MessageRoomInfo\" where \"roomID\" = ?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setLong(1, roomID);

			resultSet = pstmt.executeQuery();
			if (resultSet.next()) {
				messageRoomInfo = MessageRoomInfo.create(resultSet);
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

		return messageRoomInfo;
	}

	public ArrayList<MessageRoomInfo> getMessageRoomInfo(String mailAddress){

		Connection connection = getConnection();
		if (connection == null) {
			return null;
		}

		ArrayList<MessageRoomInfo> list = null;
		ResultSet resultSet = null;

		try {

			String sql = "select * from \"MessageRoomInfo\" as m, \"RoomMemberInfo\" as r "
					+ "where m.\"roomID\" = r.\"roomID\" and r.\"memberMailAddress\" = ?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, mailAddress);

			resultSet = pstmt.executeQuery();
			while (resultSet.next()) {

				MessageRoomInfo messageRoomInfo = MessageRoomInfo.create(resultSet);
				if (list == null) {
					list = new ArrayList<MessageRoomInfo>();
				}

				list.add(messageRoomInfo);
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

	public void createMessageRoomInfo(MessageRoomCreateInfo messageRoomCreateInfo) {
		System.err.println("createMessageRoomInfo is non implementation!");
	}

	public void deleteMessageRoomInfo(long roomID) {

		Connection connection = getConnection();
		if (connection == null) {
			return;
		}

		try {

			String sql = "delete from \"MessgeRoomInfo\" where \"roomID\" = ?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setLong(1, roomID);

			int result = pstmt.executeUpdate();
			System.out.println("deleteMessageRoomInfo : " + result + "件のデータを削除");
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

	public ArrayList<MessageRoomInfo> getAllMessageRoomInfo(){

		Connection connection = getConnection();
		if (connection == null) {
			return null;
		}

		ArrayList<MessageRoomInfo> list = null;
		ResultSet resultSet = null;

		try {

			String sql = "select * from \"MessageRoomInfo\"";
			PreparedStatement pstmt = connection.prepareStatement(sql);

			resultSet = pstmt.executeQuery();
			while (resultSet.next()) {

				MessageRoomInfo messageRoomInfo = MessageRoomInfo.create(resultSet);
				if (list == null) {
					list = new ArrayList<MessageRoomInfo>();
				}

				list.add(messageRoomInfo);
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
