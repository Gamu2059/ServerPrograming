package tdu_market.entity_bean;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class ItemInfoByAdmin implements Serializable {

	private static final long serialVersionUID = 1L;

	private ItemInfo itemInfo;
	private StudentInfo studentInfo;
	private SyllabusInfo syllabusInfo;
	private SemesterInfo semesterInfo;
	private TeacherInfo teacherInfo;

	public ItemInfoByAdmin() {
		super();
	}

	public ItemInfo getItemInfo() {
		return itemInfo;
	}

	public void setItemInfo(ItemInfo itemInfo) {
		this.itemInfo = itemInfo;
	}

	public StudentInfo getStudentInfo() {
		return studentInfo;
	}

	public void setStudentInfo(StudentInfo studentInfo) {
		this.studentInfo = studentInfo;
	}

	public SyllabusInfo getSyllabusInfo() {
		return syllabusInfo;
	}

	public void setSyllabusInfo(SyllabusInfo syllabusInfo) {
		this.syllabusInfo = syllabusInfo;
	}

	public SemesterInfo getSemesterInfo() {
		return semesterInfo;
	}

	public void setSemesterInfo(SemesterInfo semesterInfo) {
		this.semesterInfo = semesterInfo;
	}

	public TeacherInfo getTeacherInfo() {
		return teacherInfo;
	}

	public void setTeacherInfo(TeacherInfo teacherInfo) {
		this.teacherInfo = teacherInfo;
	}

	public static ItemInfoByAdmin create(ResultSet resultSet) {

		if (resultSet == null) {
			return null;
		}

		ItemInfo itemInfo = null;
		StudentInfo studentInfo = null;
		SyllabusInfo syllabusInfo = null;
		SemesterInfo semesterInfo = null;
		TeacherInfo teacherInfo = null;

		try {
			itemInfo = ItemInfo.create(resultSet);
		} catch(SQLException e) {

		}

		try {
			studentInfo = StudentInfo.create(resultSet);
		} catch(SQLException e) {

		}

		try {
			syllabusInfo = SyllabusInfo.create(resultSet);
		} catch(SQLException e) {

		}

		try {
			semesterInfo = SemesterInfo.create(resultSet);
		} catch(SQLException e) {

		}

		try {
			teacherInfo = TeacherInfo.create(resultSet);
		} catch(SQLException e) {

		}

		ItemInfoByAdmin itemInfoByAdmin = new ItemInfoByAdmin();
		itemInfoByAdmin.setItemInfo(itemInfo);
		itemInfoByAdmin.setStudentInfo(studentInfo);
		itemInfoByAdmin.setSyllabusInfo(syllabusInfo);
		itemInfoByAdmin.setSemesterInfo(semesterInfo);
		itemInfoByAdmin.setTeacherInfo(teacherInfo);

		return itemInfoByAdmin;
	}
}
