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
 * Servlet implementation class ManagerSearchSyllabusInfo
 */
@WebServlet("/tdu_market/controller/ManagerSearchSyllabusInfo")
public class ManagerSearchSyllabusInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerSearchSyllabusInfo() {
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

		//文字コードを変換する
		request.setCharacterEncoding("UTF-8");

		//検索データを取得する
		String classCodeKeyword = request.getParameter("classCodeKeyword");
		long subjectID = Integer.valueOf(request.getParameter("subjectID")) ;
		String classNameKeyword = request.getParameter("classNameKeyword");
		String teacherNameKeyword = request.getParameter("teacherNameKeyword");
		long semesterID = Integer.valueOf(request.getParameter("semesterID"));

		//検索を行う
		SyllabusInfoManager syllabusInfoManager = new SyllabusInfoManager();
		SyllabusSearchInfo syllabusSearchInfo = new SyllabusSearchInfo(classCodeKeyword, subjectID, classNameKeyword, teacherNameKeyword, semesterID);

		//検索結果を出力する
		ArrayList<SyllabusGetInfo> syllabusGetInfos = syllabusInfoManager.searchSyllabus(syllabusSearchInfo);

		//検索結果をjspに送信する
		HttpSession session = request.getSession();
		session.setAttribute("syllabusInfoList", syllabusGetInfos);

		//遷移
		ControllerUtil.translatePage(JspPath.reference_item_list_by_admin, request, response);

	}

}
