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
import tdu_market.entity_manager.SyllabusInfoManager;
import tdu_market.util.ControllerUtil;
import tdu_market.util.DialogUtil;
import tdu_market.util.JspPath;

/**
 * Servlet implementation class DeleteSyllabusInfo
 */
@WebServlet("/tdu_market/controller/DeleteSyllabusInfo")
public class DeleteSyllabusInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteSyllabusInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		if (!ControllerUtil.verifyLogin(request, response)) {
			ControllerUtil.translatePage(JspPath.index, request, response);
			return;
		}

		SyllabusInfoManager syllabusInfoManager = new SyllabusInfoManager();

		//シラバス情報の複数件削除
		String[] classCodes = request.getParameterValues("classCodes");
		System.out.println(classCodes);
		if (classCodes != null) {
			for (String classes : classCodes) {
				syllabusInfoManager.deleteSyllabusInfo(classes);
			}
		}

		//シラバス情報の削除
		String classCode = request.getParameter("classCode");
		if (classCode != null) {
			syllabusInfoManager.deleteSyllabusInfo(classCode);
		}

		//シラバス情報一覧の更新
		ArrayList<SyllabusGetInfo> syllabusGetInfo = new ArrayList<SyllabusGetInfo>();
		syllabusGetInfo = syllabusInfoManager.getAllSyllabus();

		//jspに送信する
		HttpSession session = request.getSession();
		session.setAttribute("syllabusInfoList", syllabusGetInfo);

		//ダイアログメッセージ
		DialogUtil.setDialog("シラバスを削除しました。", request, response);

		// 遷移
		ControllerUtil.translatePage(JspPath.reference_syllabus_list_by_admin, request, response);

	}

}
