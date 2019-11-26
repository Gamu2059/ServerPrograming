package tdu_market.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tdu_market.dto.RelatedClassGetInfo;
import tdu_market.entity_manager.RelatedClassInfoManager;
import tdu_market.util.ControllerUtil;

/**
 * Servlet implementation class ReferSyllabusPage
 */
@WebServlet("/tdu_market/controller/ReferSyllabusPage")
public class ReferSyllabusPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReferSyllabusPage() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.err.println("ReferSyllabusPage is non implementation!");

		if (!ControllerUtil.verifyLogin(request, response)) {
			return;
		}

		RelatedClassInfoManager syllabusInfoManager = new RelatedClassInfoManager();
		//getInfoにシラバス情報を格納
		ArrayList<RelatedClassGetInfo> getInfo = syllabusInfoManager
				.getRelatedClassInfoWithSyllabus(request.getParameter("classCode"));
		//jspに情報を投げる。
		request.setAttribute("getInfo", getInfo);
		//遷移
		ControllerUtil.translatePage("/tdu_market/Student/reference_syllabus_detail.jsp", request, response);

	}

}
