package tdu_market.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tdu_market.dto.SyllabusGetInfo;
import tdu_market.dto.SyllabusUpdateInfo;
import tdu_market.entity_manager.SyllabusInfoManager;
import tdu_market.util.ControllerUtil;
import tdu_market.util.JspPath;

@WebServlet("/tdu_market/controller/UpdateSyllabusInfo")
public class UpdateSyllabusInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (!ControllerUtil.verifyLogin(request, response)) {
			ControllerUtil.translatePage(JspPath.index, request, response);
			return;
		}

		request.setCharacterEncoding("UTF-8");

		String previousClassCode = request.getParameter("previousClassCode");
		String classCode = request.getParameter("classCode");
		String className = request.getParameter("className");
		String subjectIDStr = request.getParameter("subjectID");
		String semesterIDStr = request.getParameter("semesterID");
		String teacherIDStr = request.getParameter("teacherID");
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
		long teacherID = -1;
		int unitNum = -1;

		try {
			subjectID = Long.parseLong(subjectIDStr);
			semesterID = Long.parseLong(semesterIDStr);
			teacherID = Long.parseLong(teacherIDStr);
			unitNum = Integer.parseInt(unitNumStr);
		} catch (NumberFormatException e) {

		}

		SyllabusUpdateInfo updateInfo = new SyllabusUpdateInfo(previousClassCode, classCode, className, subjectID,
				teacherID, dates, unitNum, classRoom, overview, target, requirements, evaluationMethod, semesterID);
		SyllabusInfoManager syllabus = new SyllabusInfoManager();
		syllabus.updateSyllabusInfo(updateInfo);

		HttpSession session = request.getSession();

		//シラバス情報の一覧を再取得
		SyllabusInfoManager syllabusInfo = new SyllabusInfoManager();
		ArrayList<SyllabusGetInfo> syllabusInfoList = syllabusInfo.getAllSyllabus();
		session.setAttribute("syllabusInfoList", syllabusInfoList);

		//不要なsessionの破棄
		session.removeAttribute("updateSyllabusClassCode");

		//ページ遷移
		ControllerUtil.translatePage(JspPath.reference_syllabus_list_by_admin, request, response);
	}
}
