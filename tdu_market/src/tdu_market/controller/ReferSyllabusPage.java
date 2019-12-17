package tdu_market.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tdu_market.dto.RelatedClassGetInfo;
import tdu_market.dto.SyllabusGetInfo;
import tdu_market.entity_manager.RelatedClassInfoManager;
import tdu_market.entity_manager.SyllabusInfoManager;
import tdu_market.util.ControllerUtil;
import tdu_market.util.JspPath;

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

		if (!ControllerUtil.verifyLogin(request, response)) {
			ControllerUtil.translatePage(JspPath.index, request, response);
			return;
		}

		HttpSession session = request.getSession();

		if (session.getAttribute("syllabusInfo") != null) {
			session.removeAttribute("syllabusInfo");
		}
		if (session.getAttribute("getInfo") != null) {
			session.removeAttribute("getInfo");
		}

		RelatedClassInfoManager syllabusInfoManager = new RelatedClassInfoManager();
		//getInfoにシラバス情報を格納
		ArrayList<RelatedClassGetInfo> getInfo = syllabusInfoManager
				.getRelatedClassInfoWithSyllabus(request.getParameter("selectSyllabus"));

		//jspに情報を投げる。
		if (getInfo == null) {
			SyllabusInfoManager syllabusManager = new SyllabusInfoManager();
			SyllabusGetInfo syllabusInfo = syllabusManager.getSyllabusInfo(request.getParameter("selectSyllabus"));
			session.setAttribute("syllabusInfo", syllabusInfo);
		} else {
			session.setAttribute("getInfo", getInfo);
		}
		//遷移
		ControllerUtil.translatePage(JspPath.reference_syllabus_detail, request, response);

	}

}
