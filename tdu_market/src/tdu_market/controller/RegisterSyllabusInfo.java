package tdu_market.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tdu_market.dto.ReturnInfo;
import tdu_market.dto.SyllabusCreateInfo;
import tdu_market.entity_manager.SyllabusInfoManager;
import tdu_market.util.ControllerUtil;
import tdu_market.util.JspPath;

/**
 * Servlet implementation class RegisterStudentInfo
 */
@WebServlet("/tdu_market/controller/RegisterSyllabusInfo")
public class RegisterSyllabusInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterSyllabusInfo() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//文字コードを統一
		request.setCharacterEncoding("UTF-8");

		if (!ControllerUtil.verifyLogin(request, response)) {
			ControllerUtil.translatePage(JspPath.index, request, response);
			return;
		}

		//続けて登録するかどうか
		String isContineRegist = request.getParameter("isContineRegist");

		SyllabusInfoManager syllabus = new SyllabusInfoManager();
		SyllabusCreateInfo createInfo = new SyllabusCreateInfo(request.getParameter("classCode"), request.getParameter("className"), Integer.valueOf(request.getParameter("subjectID")).longValue(), Integer.valueOf(request.getParameter("teacherID")).longValue(),request.getParameter("dates"), Integer.valueOf(request.getParameter("unitNum")).intValue()
				, request.getParameter("classRoom"),  request.getParameter("overview"), request.getParameter("target")
				, request.getParameter("requierments"), request.getParameter("evaluationMethod"),Integer.valueOf(request.getParameter("semesterID")).longValue());

		//入力情報の検証
		ReturnInfo retunResult = syllabus.validateRegisterSyllabus(createInfo);

		//シラバス情報の登録
		if(retunResult.isSuccess())	{
			syllabus.createSyllabusInfo(createInfo);
			if (isContineRegist.contains("true")) {
				ControllerUtil.translatePage(JspPath.register_syllabus_by_admin, request, response);
			}else {
				ControllerUtil.translatePage(JspPath.reference_syllabus_list_by_admin, request, response);
			}
		}
		//遷移
//		ControllerUtil.translatePage(JspPath.register_syllabus_by_admin, request, response);

	}
}
