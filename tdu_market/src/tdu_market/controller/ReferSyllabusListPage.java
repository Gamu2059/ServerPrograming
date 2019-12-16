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
import tdu_market.dto.SyllabusSearchInfo;
import tdu_market.entity_manager.SyllabusInfoManager;
import tdu_market.util.ControllerUtil;
import tdu_market.util.JspPath;

/**
 * Servlet implementation class ReferSyllabusListPage
 */
@WebServlet("/tdu_market/controller/ReferSyllabusListPage")
public class ReferSyllabusListPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReferSyllabusListPage() {
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


		SyllabusInfoManager syllabusInfo = new SyllabusInfoManager();
		//Stringはnull, intは-1が渡された場合に、
				//その項目を反映しない検索結果が出力される仕様になっている。

				String classCode = request.getParameter("classCode");
				if (classCode != null && classCode.trim().isEmpty()) {
					classCode = null;
				}

				long departmentID = -1;
				try {
					departmentID = Integer.valueOf(request.getParameter("departmentID")).longValue();
				} catch(NumberFormatException e) {

				}

				String classNameKeyword = request.getParameter("classNameKeyword");
				if (classNameKeyword != null && classNameKeyword.trim().isEmpty()) {
					classNameKeyword = null;
				}

				String searcherNameKeyword = request.getParameter("tearcherNameKeyword");
				if (searcherNameKeyword != null && searcherNameKeyword.trim().isEmpty()) {
					searcherNameKeyword = null;
				}
				long semesterID = -1;
				try {
					semesterID = Integer.valueOf(request.getParameter("semesterID")).longValue();
				} catch(NumberFormatException e) {

				}


		SyllabusSearchInfo searchInfo = new SyllabusSearchInfo(classCode,departmentID,classNameKeyword,searcherNameKeyword,semesterID);
		//シラバス検索情報を格納
		ArrayList<SyllabusGetInfo> searchResult = syllabusInfo.searchSyllabus(searchInfo) ;
		//jspに情報を投げる。
		HttpSession session = request.getSession();
		session.setAttribute("searchResult", searchResult);
		//遷移
		ControllerUtil.translatePage(JspPath.reference_syllabus_list, request, response);

	}

}
