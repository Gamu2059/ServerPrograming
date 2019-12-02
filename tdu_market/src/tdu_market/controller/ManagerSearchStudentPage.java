package tdu_market.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tdu_market.dto.DepartmentGetInfo;
import tdu_market.entity_manager.DepartmentInfoManager;
import tdu_market.util.ControllerUtil;
import tdu_market.util.JspPath;

/**
 * Servlet implementation class SearchSyllabusPage
 */
@WebServlet("/tdu_market/controller/ManagerSearchStudentPage")
public class ManagerSearchStudentPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManagerSearchStudentPage() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//ログイン検証
		if (!ControllerUtil.verifyLogin(request, response)) {
			ControllerUtil.translatePage(JspPath.index, request, response);
			return;
		}

		HttpSession session = request.getSession();

		//必要なデータ
		//学科情報
		if( session.getAttribute("departmentInfoList") == null ) {
			DepartmentInfoManager departmentInfoManager = new DepartmentInfoManager();
			ArrayList<DepartmentGetInfo> departmentGetInfos = departmentInfoManager.getAllDepartmentInfoList(true);
			//送信する
			session.setAttribute("departmentInfoList", departmentGetInfos );
		}

		//遷移
		ControllerUtil.translatePage(JspPath.search_student, request, response);

	}
}