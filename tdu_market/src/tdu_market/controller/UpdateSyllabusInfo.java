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

/**
 * Servlet implementation class UpdateSyllabusInfo
 */
@WebServlet("/tdu_market/controller/UpdateSyllabusInfo")
public class UpdateSyllabusInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateSyllabusInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		if (!ControllerUtil.verifyLogin(request, response)) {
			ControllerUtil.translatePage(JspPath.index, request, response);
			return;
		}

		SyllabusInfoManager syllabus = new SyllabusInfoManager();
		SyllabusUpdateInfo updateInfo = new SyllabusUpdateInfo(request.getParameter("previousClassCode"),request.getParameter("classCode"), request.getParameter("className"), Integer.valueOf(request.getParameter("subjectID")).longValue(),
				Integer.valueOf(request.getParameter("teacherID")).longValue(),request.getParameter("dates"), Integer.valueOf(request.getParameter("unitNum")).intValue()
				, request.getParameter("classRoom"),  request.getParameter("overview"), request.getParameter("target")
				, request.getParameter("requierments"), request.getParameter("evaluationMethod"));
		//シラバス情報の更新
		syllabus.updateSyllabusInfo(updateInfo);

		HttpSession session = request.getSession();

		//シラバス情報の一覧を再取得
		SyllabusInfoManager syllabusInfo = new SyllabusInfoManager();
		ArrayList<SyllabusGetInfo> syllabusInfoList = syllabusInfo.getAllSyllabus();
		session.setAttribute("syllabusInfoList", syllabusInfoList);

		//不要なsessionの破棄
		session.removeAttribute("isCreate");
		session.removeAttribute("updateSyllabusClassCode");

		//ページ遷移
		ControllerUtil.translatePage(JspPath.reference_syllabus_list_by_admin, request, response);

	}

}
