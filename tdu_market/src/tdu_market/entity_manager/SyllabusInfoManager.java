package tdu_market.entity_manager;

import java.util.ArrayList;

import tdu_market.dao.SyllabusInfoDAO;
import tdu_market.dto.OpeningSemesterCreateInfo;
import tdu_market.dto.ReturnInfo;
import tdu_market.dto.SyllabusCreateInfo;
import tdu_market.dto.SyllabusGetInfo;
import tdu_market.dto.SyllabusSearchInfo;
import tdu_market.dto.SyllabusUpdateInfo;

public final class SyllabusInfoManager {

	/** 指定したクラスコードが存在するか判定する。存在する場合は、trueの情報を返す。 */
	public ReturnInfo existSyllabus(String classCode) {

		SyllabusInfoDAO syllabusInfoDAO = new SyllabusInfoDAO();
		SyllabusGetInfo syllabusGetInfo = syllabusInfoDAO.getSyllabusInfo(classCode);
		boolean isExist = syllabusGetInfo != null;

		return new ReturnInfo(isExist ? "" : "講義が存在しません。", isExist);
	}

	/** 指定したシラバス情報を検証し、登録するに足るかどうかを判定する。登録可能である場合は、trueの情報を返す。 */
	public ReturnInfo validateRegisterSyllabus(SyllabusCreateInfo syllabusCreateInfo) {

		try {

			String classCode = syllabusCreateInfo.getClassCode();
			String className = syllabusCreateInfo.getClassName();
			long semesterID = syllabusCreateInfo.getSemesterID();
			long teacherID = syllabusCreateInfo.getTeacherID();

			ReturnInfo isExist = existSyllabus(classCode);
			if (isExist.isSuccess()) {
				return new ReturnInfo("同一のクラスコードを持つ講義が既に存在しています。");
			}

			if (className == null || className.trim().isEmpty()) {
				return new ReturnInfo("講義名が設定されていません。");
			}

			SemesterInfoManager semesterInfoManager = new SemesterInfoManager();
			if (!semesterInfoManager.isExistSemester(semesterID)) {
				return new ReturnInfo("対応する年度学期がありません。");
			}

			TeacherInfoManager teacherInfoManager = new TeacherInfoManager();
			if (!teacherInfoManager.isExistTeacher(teacherID)) {
				return new ReturnInfo("対応する担任がいません。");
			}

			return new ReturnInfo("", true);
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}

	/** シラバスを取得する。 */
	public SyllabusGetInfo getSyllabusInfo(String classCode) {

		SyllabusInfoDAO syllabusInfoDAO = new SyllabusInfoDAO();
		return syllabusInfoDAO.getSyllabusInfo(classCode);
	}

	/** シラバスを登録する。 */
	public void createSyllabusInfo(SyllabusCreateInfo syllabusCreateInfo) {

		SyllabusInfoDAO syllabusInfoDAO = new SyllabusInfoDAO();
		syllabusInfoDAO.createSyllabusInfo(syllabusCreateInfo);

		// 自動的に対応する開講年度情報も登録する
		OpeningSemesterInfoManager openingSemesterInfoManager = new OpeningSemesterInfoManager();
		OpeningSemesterCreateInfo createInfo = new OpeningSemesterCreateInfo(syllabusCreateInfo.getClassCode(), new long[] {syllabusCreateInfo.getSemesterID()});
		openingSemesterInfoManager.createOpeningSemesterInfo(createInfo);
	}

	/** シラバスを更新する。 */
	public void updateSyllabusInfo(SyllabusUpdateInfo syllabusUpdateInfo) {

		SyllabusInfoDAO syllabusInfoDAO = new SyllabusInfoDAO();
		syllabusInfoDAO.updateSyllabusInfo(syllabusUpdateInfo);
	}

	/** シラバスを削除する。 */
	public void deleteSyllabusInfo(String classCode) {

		// 自動的に対応する開講年度情報も削除する(こちらを先に削除しないと制約エラーとなる)
		OpeningSemesterInfoManager openingSemesterInfoManager = new OpeningSemesterInfoManager();
		openingSemesterInfoManager.deleteOpeningSemesterInfo(classCode);

		SyllabusInfoDAO syllabusInfoDAO = new SyllabusInfoDAO();
		syllabusInfoDAO.deleteSyllabusInfo(classCode);
	}

	/** シラバスを検索する。 */
	public ArrayList<SyllabusGetInfo> searchSyllabus(SyllabusSearchInfo syllabusSearchInfo) {

		SyllabusInfoDAO syllabusInfoDAO = new SyllabusInfoDAO();
		return syllabusInfoDAO.searchSyllabusInfo(syllabusSearchInfo);
	}
}
