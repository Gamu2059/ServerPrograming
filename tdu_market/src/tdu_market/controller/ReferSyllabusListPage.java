package tdu_market.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tdu_market.dto.SyllabusGetInfo;
import tdu_market.dto.SyllabusSearchInfo;
import tdu_market.entity_manager.SyllabusInfoManager;
import tdu_market.util.ControllerUtil;

/**
 * Servlet implementation class ReferSyllabusListPage
 */
@WebServlet("/ReferSyllabusListPage")
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
		System.err.println("ReferSyllabusListPage is non implementation!");
		
		if (!ControllerUtil.verifyLogin(request, response)) {
			return;
		}

		SyllabusInfoManager syllabusInfo = new SyllabusInfoManager();
		SyllabusSearchInfo searchInfo = new SyllabusSearchInfo(request.getParameter("classCode"), Integer.valueOf(request.getParameter("departmentID")).longValue(), request.getParameter("classNameKeyword"),request.getParameter("seacherNameKeyword"),
				 Integer.valueOf(request.getParameter("semesterID")).longValue());
		//シラバス検索情報を格納
		ArrayList<SyllabusGetInfo> searchResult = syllabusInfo.searchSyllabus(searchInfo) ;
		//jspに情報を投げる。
		request.setAttribute("searchResult", searchResult);

	}

}
