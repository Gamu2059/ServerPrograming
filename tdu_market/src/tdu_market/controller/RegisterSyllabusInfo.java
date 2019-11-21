package tdu_market.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tdu_market.dto.StudentUpdateInfo;
import tdu_market.dto.ReturnInfo;
import tdu_market.dto.SyllabusCreateInfo;
import tdu_market.entity_manager.StudentInfoManager;
import tdu_market.entity_manager.SyllabusInfoManager;
import tdu_market.util.ControllerUtil;

/**
 * Servlet implementation class RegisterStudentInfo
 */
@WebServlet("/RegisterSyllabusInfo")
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

		if (!ControllerUtil.verifyLogin(request, response)) {
			return;
		}

		SyllabusInfoManager syllabus = new SyllabusInfoManager();
		SyllabusCreateInfo createInfo = new SyllabusCreateInfo(request.getParameter("classCode"), request.getParameter("className"), Integer.valueOf(request.getParameter("semesterID")).longValue(), request.getParameter("dates"), Integer.valueOf(request.getParameter("unitNum")).intValue()
				, request.getParameter("classRoom"), Integer.valueOf(request.getParameter("teacherID")).longValue(), request.getParameter("overview"), request.getParameter("target")
				, request.getParameter("requierments"), request.getParameter("evaluationMethod"));

		ReturnInfo retunResult = syllabus.validateRegisterSyllabus(createInfo);


		//シラバス情報の登録
		if(retunResult.isSuccess())	{
			syllabus.createSyllabusInfo(createInfo);
		}
	}

}
