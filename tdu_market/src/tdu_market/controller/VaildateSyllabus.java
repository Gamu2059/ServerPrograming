package tdu_market.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tdu_market.dto.ReturnInfo;
import tdu_market.dto.SyllabusCreateInfo;
import tdu_market.dto.SyllabusUpdateInfo;
import tdu_market.dto.TeacherGetInfo;
import tdu_market.entity_manager.SyllabusInfoManager;
import tdu_market.entity_manager.TeacherInfoManager;
import tdu_market.util.ControllerUtil;
import tdu_market.util.JspPath;

@WebServlet("/tdu_market/controller/VaildateSyllabus")
public class VaildateSyllabus extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (!ControllerUtil.verifyLogin(request, response)) {
			ControllerUtil.translatePage(JspPath.index, request, response);
			return;
		}

		request.setCharacterEncoding("UTF-8");

		//データの受け取り
		String registOrEdit = request.getParameter("registOrEdit");
		boolean isRegist = registOrEdit.equals("regist");
		boolean isEdit = registOrEdit.equals("edit");

		String classCode = request.getParameter("classCode");
		String className = request.getParameter("className");
		String subjectIDStr = request.getParameter("subjectID");
		String semesterIDStr = request.getParameter("semesterID");
		String dates = request.getParameter("dates");
		String unitNumStr = request.getParameter("unitNum");
		String classRoom = request.getParameter("classRoom");
		String teacherName = request.getParameter("teacherName");
		String overview = request.getParameter("overview");
		String target = request.getParameter("target");
		String requirements = request.getParameter("requierments");
		String evaluationMethod = request.getParameter("evaluationMethod");

		long subjectID = -1;
		long semesterID = -1;
		int unitNum = -1;

		try {
			subjectID = Long.parseLong(subjectIDStr);
			semesterID = Long.parseLong(semesterIDStr);
			unitNum = Integer.parseInt(unitNumStr);
		} catch (NumberFormatException e) {

		}

		//教員名を教員IDに変換
		long teacherID = 0;
		String confirmTeacherName = "";
		TeacherInfoManager teacherInfoManager = new TeacherInfoManager();
		for (TeacherGetInfo teacherGetInfo : teacherInfoManager.getTeacherInfoList()) {
			if (teacherGetInfo.getTeacherName().contains(teacherName)) {
				teacherID = teacherGetInfo.getTeacherID();
				confirmTeacherName = teacherGetInfo.getTeacherName();
				break;
			}
		}

		//必須入力でない部分のnull回避
		if (overview == null || overview.trim().isEmpty()) {
			overview = "※目的概要は登録されていません";
		}
		if (target == null || target.trim().isEmpty()) {
			target = "※達成目標は登録されていません";
		}
		if (requirements == null || requirements.trim().isEmpty()) {
			requirements = "※履修条件は登録されていません";
		}
		if (evaluationMethod == null || evaluationMethod.trim().isEmpty()) {
			evaluationMethod = "※評価方法は登録されていません";
		}

		SyllabusInfoManager syllabus = new SyllabusInfoManager();
		HttpSession session = request.getSession();

		SyllabusCreateInfo createInfo = new SyllabusCreateInfo(classCode, className, subjectID, teacherID, dates,
				unitNum, classRoom, overview, target, requirements, evaluationMethod, semesterID);
		session.setAttribute("confirmCreateSyllabusInfo", createInfo);
		session.setAttribute("confirmTeacherName", confirmTeacherName);

		if (isRegist) {
			ReturnInfo validateResult = syllabus.validateRegisterSyllabus(createInfo);

			if (validateResult.isSuccess()) {
				session.removeAttribute("createSyllabusErrorMessage");
				session.setAttribute("isCreate", true);
				ControllerUtil.translatePage(JspPath.confirm_syllabus_by_admin, request, response);
			} else {
				session.removeAttribute("isCreate");
				session.setAttribute("createSyllabusErrorMessage", validateResult.toString());
				ControllerUtil.translatePage(JspPath.register_syllabus_by_admin, request, response);
			}
		} else if (isEdit) {
			String previousClassCode = request.getParameter("previousClassCode");
			SyllabusUpdateInfo updateInfo = new SyllabusUpdateInfo(previousClassCode, classCode, className, subjectID,
					teacherID, dates, unitNum, classRoom, overview, target, requirements, evaluationMethod, semesterID);
			ReturnInfo validateResult = syllabus.validateUpdateSyllabusInfo(updateInfo);

			if (validateResult.isSuccess()) {
				session.removeAttribute("updateSyllabusErrorMessage");
				session.setAttribute("isCreate", false);
			} else {
				session.removeAttribute("isCreate");
				session.setAttribute("updateSyllabusErrorMessage", validateResult.toString());
			}

			session.setAttribute("updateSyllabusClassCode", previousClassCode);
			ControllerUtil.translatePage(JspPath.confirm_syllabus_by_admin, request, response);
		} else {
			throw new RuntimeException("registOrEditの文字列が無効です。 registOrEdit:" + registOrEdit);
		}
	}
}
