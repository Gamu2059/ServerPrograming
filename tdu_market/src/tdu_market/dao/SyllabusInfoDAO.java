package tdu_market.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import tdu_market.dto.SyllabusCreateInfo;
import tdu_market.dto.SyllabusGetInfo;
import tdu_market.dto.SyllabusSearchInfo;
import tdu_market.dto.SyllabusUpdateInfo;
import tdu_market.entity_bean.DepartmentInfo;
import tdu_market.entity_bean.SemesterInfo;
import tdu_market.entity_bean.SyllabusInfo;
import tdu_market.entity_bean.TeacherInfo;

public final class SyllabusInfoDAO extends DAOBase {

	public SyllabusGetInfo getSyllabusInfo(String classCode) {

		Connection connection = getConnection();
		if (connection == null) {
			return null;
		}

		SyllabusGetInfo syllabusGetInfo = null;
		ResultSet resultSet = null;

		try {

			String sql = "select * from \"SyllabusInfo\" as s, \"OpeningSemesterInfo\" as o, \"SemesterInfo\" as se, \"TeacherInfo\" as t "
					+ "where s.\"classCode\" = o.\"classCode\" and o.\"semesterID\" = se.\"semesterID\" and s.\"teacherID\" = t.\"teacherID\" and s.\"classCode\" = ?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, classCode);

			resultSet = pstmt.executeQuery();

			if (resultSet.next()) {
				SyllabusInfo syllabusInfo = SyllabusInfo.create(resultSet);
				SemesterInfo semesterInfo = SemesterInfo.create(resultSet);
				TeacherInfo teacherInfo = TeacherInfo.create(resultSet);

				DepartmentInfoDAO departmentInfoDAO = new DepartmentInfoDAO();
				ArrayList<DepartmentInfo> departmentInfoList = departmentInfoDAO.getDepartmentInfoWithSubject(syllabusInfo.getSubjectID(), true);
				DepartmentInfo departmentInfo = null;
				if (departmentInfoList != null && departmentInfoList.size() > 0) {
					departmentInfo = departmentInfoList.get(0);
				}

				syllabusGetInfo = SyllabusGetInfo.create(syllabusInfo, semesterInfo, teacherInfo, departmentInfo);
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

		return syllabusGetInfo;
	}

	public void createSyllabusInfo(SyllabusCreateInfo syllabusCreateInfo) {

		if (syllabusCreateInfo == null) {
			System.err.println("createSyllabusInfo : syllabusCreateInfo is null");
			return;
		}

		Connection connection = getConnection();
		if (connection == null) {
			return;
		}

		try {

			String sql = "insert into \"SyllabusInfo\" values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt = connection.prepareStatement(sql);

			pstmt.setString(1, syllabusCreateInfo.getClassCode());
			pstmt.setString(2, syllabusCreateInfo.getClassName());
			pstmt.setLong(3, syllabusCreateInfo.getSubjectID());
			pstmt.setLong(4, syllabusCreateInfo.getTeacherID());
			pstmt.setString(5, syllabusCreateInfo.getDates());
			pstmt.setInt(6, syllabusCreateInfo.getUnitNum());
			pstmt.setString(7, syllabusCreateInfo.getClassRoom());
			pstmt.setString(8, syllabusCreateInfo.getOverview());
			pstmt.setString(9, syllabusCreateInfo.getTarget());
			pstmt.setString(10, syllabusCreateInfo.getRequirements());
			pstmt.setString(11, syllabusCreateInfo.getEvaluationMethod());

			int result = pstmt.executeUpdate();
			System.out.println("createManagerInfo : " + result + "件のデータを作成");
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

	public void updateSyllabusInfo(SyllabusUpdateInfo syllabusUpdateInfo) {

		if (syllabusUpdateInfo == null) {
			System.err.println("updateSyllabusInfo : syllabusUpdateInfo is null");
			return;
		}

		Connection connection = getConnection();
		if (connection == null) {
			return;
		}

		try {

			String sql = "update \"SyllabusInfo\" "
					+ "set \"classCode\" = ?, \"className\" = ?, \"subjectID\" = ?, \"teacherID\" = ?, \"dates\" = ?, \"unitNum\" = ?, "
					+ "\"classRoom\" = ?, \"overview\" = ?, \"target\" = ?, \"requirements\" = ?, \"evaluationMethod\" = ? "
					+ "where \"classCode\" = ?";
			PreparedStatement pstmt = connection.prepareStatement(sql);

			pstmt.setString(1, syllabusUpdateInfo.getClassCode());
			pstmt.setString(2, syllabusUpdateInfo.getClassName());
			pstmt.setLong(3, syllabusUpdateInfo.getSubjectID());
			pstmt.setLong(4, syllabusUpdateInfo.getTeacherID());
			pstmt.setString(5, syllabusUpdateInfo.getDates());
			pstmt.setInt(6, syllabusUpdateInfo.getUnitNum());
			pstmt.setString(7, syllabusUpdateInfo.getClassRoom());
			pstmt.setString(8, syllabusUpdateInfo.getOverview());
			pstmt.setString(9, syllabusUpdateInfo.getTarget());
			pstmt.setString(10, syllabusUpdateInfo.getRequirements());
			pstmt.setString(11, syllabusUpdateInfo.getEvaluationMethod());
			pstmt.setString(12, syllabusUpdateInfo.getPreviousClassCode());

			int result = pstmt.executeUpdate();
			System.out.println("updateSyllabusInfo : " + result + "件のデータを更新");
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

	public void deleteSyllabusInfo(String classCode) {

		Connection connection = getConnection();
		if (connection == null) {
			return;
		}

		try {

			String sql = "delete from \"SyllabusInfo\" where \"classCode\" = ?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, classCode);

			int result = pstmt.executeUpdate();
			System.out.println("deleteSyllabusInfo : " + result + "件のデータを削除");
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

	public ArrayList<SyllabusGetInfo> searchSyllabusInfo(SyllabusSearchInfo syllabusSearchInfo) {

		if (syllabusSearchInfo == null) {
			System.err.println("searchSyllabusInfo : syllabusSearchInfo is null");
			return null;
		}

		Connection connection = getConnection();
		if (connection == null) {
			return null;
		}

		ArrayList<SyllabusGetInfo> list = null;
		ResultSet resultSet = null;

		try {

			String classCodeKeyword = syllabusSearchInfo.getClassCodeKeyword();
			String classNameKeyword = syllabusSearchInfo.getClassNameKeyword();
			String teacherNameKeyword = syllabusSearchInfo.getTeacherNameKeyword();
			long subjectID = syllabusSearchInfo.getSubjectID();
			long semesterID = syllabusSearchInfo.getSemesterID();

			boolean isEmptyCCK = classCodeKeyword == null;
			boolean isEmptyCNK = classNameKeyword == null;
			boolean isEmptyTNK = teacherNameKeyword == null;
			boolean isEmptySujectID = subjectID < 1;
			boolean isEmptySemesterID = semesterID < 1;

			StringBuilder builder = new StringBuilder(
					"select * from \"SyllabusInfo\" as s, \"OpeningSemesterInfo\" as o, \"SemesterInfo\" as se, \"TeacherInfo\" as t ");
			builder.append(
					"where s.\"classCode\" = o.\"classCode\" and o.\"semesterID\" = se.\"semesterID\" and s.\"teacherID\" = t.\"teacherID\" ");

			if (!isEmptyCCK) {
				builder.append("and s.\"classCode\" like ? ");
			}

			if (!isEmptyCNK) {
				builder.append("and s.\"className\" like ? ");
			}

			if (!isEmptyTNK) {
				builder.append("and t.\"teacherName\" like ? ");
			}

			if (!isEmptySujectID) {
				builder.append("and s.\"subjectID\" = ? ");
			}

			if (!isEmptySemesterID) {
				builder.append("and se.\"semesterID\" = ? ");
			}

			String sql = builder.toString();
			PreparedStatement pstmt = connection.prepareStatement(sql);

			int setCount = 1;

			if (!isEmptyCCK) {
				pstmt.setString(setCount, String.format("%%%s%%", classCodeKeyword));
				setCount++;
			}

			if (!isEmptyCNK) {
				pstmt.setString(setCount, String.format("%%%s%%", classNameKeyword));
				setCount++;
			}

			if (!isEmptyTNK) {
				pstmt.setString(setCount, String.format("%%%s%%", teacherNameKeyword));
				setCount++;
			}

			if (!isEmptySujectID) {
				pstmt.setLong(setCount, subjectID);
				setCount++;
			}

			if (!isEmptySemesterID) {
				pstmt.setLong(setCount, semesterID);
				setCount++;
			}

			resultSet = pstmt.executeQuery();

			DepartmentInfoDAO departmentInfoDAO = new DepartmentInfoDAO();
			while (resultSet.next()) {
				SyllabusInfo syllabusInfo = SyllabusInfo.create(resultSet);
				SemesterInfo semesterInfo = SemesterInfo.create(resultSet);
				TeacherInfo teacherInfo = TeacherInfo.create(resultSet);

				ArrayList<DepartmentInfo> departmentInfoList = departmentInfoDAO.getDepartmentInfoWithSubject(syllabusInfo.getSubjectID(), true);
				DepartmentInfo departmentInfo = null;
				if (departmentInfoList != null && departmentInfoList.size() > 0) {
					departmentInfo = departmentInfoList.get(0);
				}

				SyllabusGetInfo syllabusGetInfo = SyllabusGetInfo.create(syllabusInfo, semesterInfo, teacherInfo, departmentInfo);

				if (list == null) {
					list = new ArrayList<SyllabusGetInfo>();
				}

				list.add(syllabusGetInfo);
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

	public ArrayList<SyllabusGetInfo> getAllSyllabusInfo() {

		Connection connection = getConnection();
		if (connection == null) {
			return null;
		}

		ArrayList<SyllabusGetInfo> list = null;
		ResultSet resultSet = null;

		try {

			String sql = "select * from \"SyllabusInfo\" as s, \"OpeningSemesterInfo\" as o, \"SemesterInfo\" as se, \"TeacherInfo\" as t "
					+ "where s.\"classCode\" = o.\"classCode\" and o.\"semesterID\" = se.\"semesterID\" and s.\"teacherID\" = t.\"teacherID\"";
			PreparedStatement pstmt = connection.prepareStatement(sql);

			resultSet = pstmt.executeQuery();

			DepartmentInfoDAO departmentInfoDAO = new DepartmentInfoDAO();
			while (resultSet.next()) {
				SyllabusInfo syllabusInfo = SyllabusInfo.create(resultSet);
				SemesterInfo semesterInfo = SemesterInfo.create(resultSet);
				TeacherInfo teacherInfo = TeacherInfo.create(resultSet);

				ArrayList<DepartmentInfo> departmentInfoList = departmentInfoDAO.getDepartmentInfoWithSubject(syllabusInfo.getSubjectID(), true);
				DepartmentInfo departmentInfo = null;
				if (departmentInfoList != null && departmentInfoList.size() > 0) {
					departmentInfo = departmentInfoList.get(0);
				}

				SyllabusGetInfo syllabusGetInfo = SyllabusGetInfo.create(syllabusInfo, semesterInfo, teacherInfo, departmentInfo);

				if (list == null) {
					list = new ArrayList<SyllabusGetInfo>();
				}

				list.add(syllabusGetInfo);
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
