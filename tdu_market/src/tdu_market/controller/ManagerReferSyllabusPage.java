package tdu_market.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tdu_market.dto.SyllabusGetInfo;
import tdu_market.entity_manager.SyllabusInfoManager;
import tdu_market.util.ControllerUtil;
import tdu_market.util.JspPath;


/**
 * Servlet implementation class ReferSyllabusPage
 */
@WebServlet("/tdu_market/controller/ManagerReferSyllabusPage")
public class ManagerReferSyllabusPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManagerReferSyllabusPage() {
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

		SyllabusInfoManager syllabusInfo = new SyllabusInfoManager();
		//getInfoにシラバス情報を格納
		SyllabusGetInfo getInfo = syllabusInfo.getSyllabusInfo(request.getParameter("classCode"));
		//jspに情報を投げる。
		request.setAttribute("getInfo", getInfo);

		//遷移
		ControllerUtil.translatePage("/tdu_market/Admin/reference_syllabus_by_admin.jsp", request, response);

	}


}
