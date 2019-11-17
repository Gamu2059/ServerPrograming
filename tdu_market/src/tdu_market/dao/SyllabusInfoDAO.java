package tdu_market.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import tdu_market.dto.OpeningSemesterCreateInfo;
import tdu_market.dto.SyllabusCreateInfo;
import tdu_market.dto.SyllabusSearchInfo;
import tdu_market.dto.SyllabusUpdateInfo;
import tdu_market.entity_bean.SyllabusInfo;

public final class SyllabusInfoDAO extends DAOBase {

	public SyllabusInfo getSyllabusInfo(String classCode) {

		Connection connection = getConnection();
		if (connection == null) {
			return null;
		}

		SyllabusInfo syllabusInfo = null;
		ResultSet resultSet = null;

		try {

			String sql = "select * from \"SyllabusInfo\" where \"classCode\" = ?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, classCode);

			resultSet = pstmt.executeQuery();

			if (resultSet.next()) {
				syllabusInfo = SyllabusInfo.create(resultSet);
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

		return syllabusInfo;
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

	public ArrayList<SyllabusInfo> searchSyllabusInfo(SyllabusSearchInfo syllabusSearchInfo) {

		if (syllabusSearchInfo == null) {
			System.err.println("searchSyllabusInfo : syllabusSearchInfo is null");
			return null;
		}

		Connection connection = getConnection();
		if (connection == null) {
			return null;
		}

		ArrayList<SyllabusInfo> list = null;
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

			StringBuilder builder = new StringBuilder("select * from \"SyllabusInfo\" as s, \"OpeningSemesterInfo\" as o, \"SemesterInfo\" as se, \"TeacherInfo\" as t ");
			builder.append("where s.\"classCode\" = o.\"classCode\" and o.\"semesterID\" = se.\"semesterID\" and s.\"teacherID\" = t.\"teacherID\" ");

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

			while (resultSet.next()) {
				SyllabusInfo syllabusInfo = SyllabusInfo.create(resultSet);

				if (list == null) {
					list = new ArrayList<SyllabusInfo>();
				}

				list.add(syllabusInfo);
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

	public ArrayList<SyllabusInfo> getAllSyllabusInfo() {

		Connection connection = getConnection();
		if (connection == null) {
			return null;
		}

		ArrayList<SyllabusInfo> list = null;
		ResultSet resultSet = null;

		try {

			String sql = "select * from \"SyllabusInfo\"";
			PreparedStatement pstmt = connection.prepareStatement(sql);

			resultSet = pstmt.executeQuery();

			while (resultSet.next()) {
				SyllabusInfo syllabusInfo = SyllabusInfo.create(resultSet);

				if (list == null) {
					list = new ArrayList<SyllabusInfo>();
				}

				list.add(syllabusInfo);
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

		SyllabusInfoDAO dao = new SyllabusInfoDAO();
		showInfo(dao.getAllSyllabusInfo());

		SyllabusSearchInfo searchInfo = null;

		System.out.println("全検索");
		searchInfo = new SyllabusSearchInfo(null, 0, null, null, 0);
		showInfo(dao.searchSyllabusInfo(searchInfo));

		System.out.println("クラスコード検索");
		searchInfo = new SyllabusSearchInfo("69", 0, null, null, 0);
		showInfo(dao.searchSyllabusInfo(searchInfo));

		System.out.println("講義名検索");
		searchInfo = new SyllabusSearchInfo(null, 0, "モデリング", null, 0);
		showInfo(dao.searchSyllabusInfo(searchInfo));

		System.out.println("担任名検索");
		searchInfo = new SyllabusSearchInfo(null, 0, null, "森谷", 0);
		showInfo(dao.searchSyllabusInfo(searchInfo));

		System.out.println("担任名検索");
		searchInfo = new SyllabusSearchInfo(null, 0, null, "高橋", 0);
		showInfo(dao.searchSyllabusInfo(searchInfo));

		System.out.println("担任名&開講年度検索");
		searchInfo = new SyllabusSearchInfo(null, 0, null, "森谷", 2);
		showInfo(dao.searchSyllabusInfo(searchInfo));

		SyllabusCreateInfo createInfo = null;
		OpeningSemesterInfoDAO openingSemesterInfoDAO = new OpeningSemesterInfoDAO();
		OpeningSemesterCreateInfo openingSemesterCreateInfo = null;

		System.out.println("データ作成");
		createInfo = new SyllabusCreateInfo("1109046401", "メディア演習A（動画）（後前期）", 11, 9, "月3 月4", 1, "メディア演習室", null, null, null, null);
		dao.createSyllabusInfo(createInfo);
		openingSemesterCreateInfo = new OpeningSemesterCreateInfo("1109046401", new long[] {2});
		openingSemesterInfoDAO.createOpeningSemesterInfo(openingSemesterCreateInfo);

		createInfo = new SyllabusCreateInfo("1109047401", "メディア演習A（動画）（後後期）", 11, 9, "月3 月4", 1, "メディア演習室", null, null, null, null);
		dao.createSyllabusInfo(createInfo);
		openingSemesterCreateInfo = new OpeningSemesterCreateInfo("1109047401", new long[] {2});
		openingSemesterInfoDAO.createOpeningSemesterInfo(openingSemesterCreateInfo);

		System.out.println("担任名&開講年度検索");
		searchInfo = new SyllabusSearchInfo(null, 0, null, "高", 2);
		showInfo(dao.searchSyllabusInfo(searchInfo));

		System.out.println("全データ");
		showInfo(dao.getAllSyllabusInfo());

		System.out.println("データ削除");
		openingSemesterInfoDAO.deleteOpeningSemesterInfo("1109046401");
		dao.deleteSyllabusInfo("1109046401");
		openingSemesterInfoDAO.deleteOpeningSemesterInfo("1109047401");
		dao.deleteSyllabusInfo("1109047401");

		System.out.println("担任名&開講年度検索");
		searchInfo = new SyllabusSearchInfo(null, 0, null, "高", 2);
		showInfo(dao.searchSyllabusInfo(searchInfo));

		System.out.println("全データ");
		showInfo(dao.getAllSyllabusInfo());
	}

	private static void showInfo(ArrayList<SyllabusInfo> list) {

		if (list == null) {
			System.out.println("list is empty");
			return;
		}

		for (SyllabusInfo i : list) {
			System.out.println(i);
		}
	}
}
