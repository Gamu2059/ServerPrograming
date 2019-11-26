package tdu_market.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tdu_market.dto.ItemGetInfo;
import tdu_market.dto.ReturnInfo;
import tdu_market.entity_manager.StudentInfoManager;
import tdu_market.entity_manager.ItemInfoManager;
import tdu_market.util.ControllerUtil;

/**
 * Servlet implementation class TopPage
 */
@WebServlet("/tdu_market/controller/TopPage")
public class TopPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TopPage() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.err.println("TopPage is non implementation!");
		HttpSession session = request.getSession();

		//ログイン状態の検証
		if (!ControllerUtil.verifyLogin(request, response)) {
			return;
		}

		//新着商品を取得する
		ItemInfoManager itemInfo = new ItemInfoManager();
		ArrayList<ItemGetInfo> newItemList = itemInfo.getNewItemList();
		//jspに情報を投げる。
		session.setAttribute("newItemList", newItemList);
		ControllerUtil.translatePage("/tdu_market/Student/student_top.jsp", request, response);
		//遷移
		ControllerUtil.translatePage("/tdu_market/Student/student_top.jsp", request, response);

	}


}
