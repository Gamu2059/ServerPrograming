package tdu_market.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import tdu_market.dto.RoomMemberCreateInfo;
import tdu_market.entity_bean.RoomMemberInfo;

public final class RoomMemberInfoDAO extends DAOBase {

	public ArrayList<RoomMemberInfo> getRoomMemberInfoWithMailAddress(String memberMailAddress) {

		Connection connection = getConnection();
		if (connection == null) {
			return null;
		}

		ArrayList<RoomMemberInfo> list = null;
		ResultSet resultSet = null;

		try {

			String sql = "select * from \"RoomMemberInfo\" where \"memberMailAddress\" = ?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, memberMailAddress);

			resultSet = pstmt.executeQuery();
			while (resultSet.next()) {

				RoomMemberInfo roomMemberInfo = RoomMemberInfo.create(resultSet);
				if (list == null) {
					list = new ArrayList<RoomMemberInfo>();
				}

				list.add(roomMemberInfo);
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

	public ArrayList<RoomMemberInfo> getRoomMemberInfoWithRoomInfo(long roomID) {

		Connection connection = getConnection();
		if (connection == null) {
			return null;
		}

		ArrayList<RoomMemberInfo> list = null;
		ResultSet resultSet = null;

		try {

			String sql = "select * from \"RoomMemberInfo\" where \"roomID\" = ?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setLong(1, roomID);

			resultSet = pstmt.executeQuery();
			while (resultSet.next()) {

				RoomMemberInfo roomMemberInfo = RoomMemberInfo.create(resultSet);
				if (list == null) {
					list = new ArrayList<RoomMemberInfo>();
				}

				list.add(roomMemberInfo);
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

	public void createRoomMemberInfo(RoomMemberCreateInfo roomMemberCreateInfo) {

		if (roomMemberCreateInfo == null) {
			System.err.println("createRoomMemberInfo : roomMemberCreateInfo is null");
			return;
		}

		Connection connection = getConnection();
		if (connection == null) {
			return;
		}

		try {

			String[] memberMailAddresses = roomMemberCreateInfo.getMemberMailAddresses();
			StringBuilder builder = new StringBuilder("insert into \"RoomMemberInfo\" values");
			for (int i = 0; i < memberMailAddresses.length; i++) {
				if (i > 0) {
					builder.append(",");
				}
				builder.append(" (?, ?)");
			}

			String sql = builder.toString();
			PreparedStatement pstmt = connection.prepareStatement(sql);

			for (int i = 0; i < memberMailAddresses.length; i++) {
				pstmt.setLong(i * 2 + 1, roomMemberCreateInfo.getRoomID());
				pstmt.setString(i * 2 + 2, memberMailAddresses[i]);
			}

			int result = pstmt.executeUpdate();
			System.out.println("createRoomMemberInfo : " + result + "件のデータを作成");
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

	public void deleteRoomMemberInfoWithMessageRoom(long roomID) {

		Connection connection = getConnection();
		if (connection == null) {
			return;
		}

		try {

			String sql = "delete from \"RoomMemberInfo\" where \"roomID\" = ?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setLong(1, roomID);

			int result = pstmt.executeUpdate();
			System.out.println("deleteRoomMemberInfoWithMessageRoom : " + result + "件のデータを削除");
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

	public void deleteRoomMemberInfoWithMemberMailAddress(String memberMailAddress) {

		Connection connection = getConnection();
		if (connection == null) {
			return;
		}

		try {

			String sql = "delete from \"RoomMemberInfo\" where \"memberMailAddress\" = ?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, memberMailAddress);

			int result = pstmt.executeUpdate();
			System.out.println("deleteRoomMemberInfoWithMemberMailAddress : " + result + "件のデータを削除");
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

	public ArrayList<RoomMemberInfo> getAllRoomMemberInfo() {

		Connection connection = getConnection();
		if (connection == null) {
			return null;
		}

		ArrayList<RoomMemberInfo> list = null;
		ResultSet resultSet = null;

		try {

			String sql = "select * from \"RoomMemberInfo\"";
			PreparedStatement pstmt = connection.prepareStatement(sql);

			resultSet = pstmt.executeQuery();
			while (resultSet.next()) {

				RoomMemberInfo roomMemberInfo = RoomMemberInfo.create(resultSet);
				if (list == null) {
					list = new ArrayList<RoomMemberInfo>();
				}

				list.add(roomMemberInfo);
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
