package tdu_market.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import tdu_market.dto.StudentCreateInfo;
import tdu_market.dto.StudentSearchInfo;
import tdu_market.dto.StudentUpdateInfo;
import tdu_market.entity_bean.StudentInfo;

public final class StudentInfoDAO {

	public StudentInfo createStudentInfo(StudentCreateInfo studentCreateInfo) throws Exception {

		boolean result = false;
		String sql = "select * from account where id=? and password=?";

		try {

			Connection connection = ConnectDBUtil.getConnection();

			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());

			ResultSet resultSet = pstmt.executeQuery();

			if (resultSet.next())
				result = true;

			resultSet.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		try {

			Class.forName(DRIVER_CLASS_NAME);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		System.err.println("createStudentInfo is non implementation!");
		return null;
	}

	public StudentInfo getStudentInfo(String mailAddress) {

		boolean result = false;
		String sql = "select * from student_info where mailAddress=?";

		try {

			Connection connection = ConnectDBUtil.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(sql);

			pstmt.setString(1, mailAddress);
			ResultSet resultSet = pstmt.executeQuery();

			resultSet.close();
			connection.close();


		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateStudentInfo(StudentUpdateInfo studentUpdateInfo) {
		System.err.println("updateStudentInfo is non implementation!");
	}

	public void deleteStudentInfo(String mailAddress) {
		System.err.println("deleteStudentInfo is non implementation!");
	}

	public void updateLastLogin(String mailAddress) {
		System.err.println("updateLastLogin is non implementation!");
	}

	public ArrayList<StudentInfo> searchStudentInfo(StudentSearchInfo studentSearchInfo) {
		System.err.println("searchStudentInfo is non implementation!");
		return null;
	}
}
