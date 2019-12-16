package tdu_market.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import tdu_market.entity_bean.MessageRoomInfo;
import tdu_market.entity_bean.RoomMemberInfo;

public final class MessageRoomInfoDAO extends DAOBase {

	public MessageRoomInfo getMessageRoomInfo(long roomID) {

		Connection connection = getConnection();
		if (connection == null) {
			return null;
		}

		MessageRoomInfo messageRoomInfo = null;
		ResultSet resultSet = null;

		try {

			String sql = String.format("select * from \"MessageRoomInfo\" where \"%s\" = ?", MessageRoomInfo.ROOM_ID);
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

	public ArrayList<MessageRoomInfo> getMessageRoomInfo(String mailAddress) {

		Connection connection = getConnection();
		if (connection == null) {
			return null;
		}

		ArrayList<MessageRoomInfo> list = null;
		ResultSet resultSet = null;

		try {

			String sql = String.format("select * from \"MessageRoomInfo\" as m, \"RoomMemberInfo\" as r "
					+ "where m.\"%s\" = r.\"%s\" and r.\"%s\" = ?",
					MessageRoomInfo.ROOM_ID,
					RoomMemberInfo.ROOM_ID,
					RoomMemberInfo.MEMBER_MAIL_ADDRESS);
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

	/** ルームを生成してルームIDを返す。 */
	public long createMessageRoomInfo() {

		Connection connection = getConnection();
		if (connection == null) {
			return -1;
		}

		ResultSet resultSet = null;
		Long roomID = null;

		try {

			String sql = String.format("insert into \"MessageRoomInfo\" (\"%s\") values (?)",
					MessageRoomInfo.CREATED_DATE);
			PreparedStatement pstmt = connection.prepareStatement(sql);

			Timestamp createdTimestamp = new Timestamp(new java.util.Date().getTime());
			pstmt.setTimestamp(1, createdTimestamp);

			int result = pstmt.executeUpdate();
			System.out.println("createMessageRoomInfo : " + result + "件のデータを作成");

			sql = String.format("select \"%s\" from \"MessageRoomInfo\" order by \"%s\" desc",
					MessageRoomInfo.ROOM_ID,
					MessageRoomInfo.ROOM_ID);
			pstmt = connection.prepareStatement(sql);
			resultSet = pstmt.executeQuery();
			if (resultSet.next()) {
				roomID = resultSet.getLong(MessageRoomInfo.ROOM_ID);
			}
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

		return roomID != null ? roomID : -1;
	}

	public void deleteMessageRoomInfo(long roomID) {

		Connection connection = getConnection();
		if (connection == null) {
			return;
		}

		try {

			String sql = String.format("delete from \"MessageRoomInfo\" where \"%s\" = ?", MessageRoomInfo.ROOM_ID);
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

	public ArrayList<MessageRoomInfo> getAllMessageRoomInfo() {

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
