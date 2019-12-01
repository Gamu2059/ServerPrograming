package tdu_market.controller;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tdu_market.dto.ItemGetInfo;
import tdu_market.dto.ReturnInfo;
import tdu_market.entity_manager.ItemInfoManager;
import tdu_market.entity_manager.StudentInfoManager;
import tdu_market.entity_manager.SyllabusInfoManager;
import tdu_market.util.ControllerUtil;
import tdu_market.util.JspPath;
import tdu_market.dto.*;

/**
 * Servlet implementation class RegisterExhibitItemPage
 */
@WebServlet("/tdu_market/controller/RegisterExhibitItemPage")
public class RegisterExhibitItemPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterExhibitItemPage() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		if (!ControllerUtil.verifyLogin(request, response)) {
			ControllerUtil.translatePage(JspPath.index, request, response);
			return;
		}
		else {
			//遷移
			//ControllerUtil.translatePage(JspPath.register_exhibit, request, response);

		}
		SyllabusInfoManager syllabusInfoManager = new SyllabusInfoManager();
		ArrayList<SyllabusGetInfo> syllabusInfo = syllabusInfoManager.getAllSyllabus();



		HttpSession session = request.getSession();

		session.setAttribute("classNameList", syllabusInfo);

		/*
		 * RequestDispatcher rd =
		 * request.getRequestDispatcher("Student/register_exhibit.jsp");//
		 * 確認画面に投げてたけど（ないけど）そもそも登録画面に遷移でいいよね？ rd.forward(request, response);
		 */
		ControllerUtil.translatePage(JspPath.register_exhibit, request, response);

	}


}
