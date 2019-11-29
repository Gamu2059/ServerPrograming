package tdu_market.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tdu_market.dto.ManagerGetInfo;
import tdu_market.entity_manager.ManagerInfoManager;
import tdu_market.util.ControllerUtil;
import tdu_market.util.JspPath;

/**
 * Servlet implementation class ReferManagerPage
 */
@WebServlet("/tdu_market/controller/ReferManagerPage")
public class ReferManagerPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReferManagerPage() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.err.println("ReferManagerPage is non implementation!");

		ManagerInfoManager manager = new ManagerInfoManager();
		//ログイン状態の検証
		if (!ControllerUtil.verifyLogin(request, response)) {
			return;
		}
		//セッションからメールアドレスを取得
		String mailAddress = ControllerUtil.getMailAddress(request, response);

		//DBから運営情報を取得する
		ManagerGetInfo managerInfo = manager.getManagerInfo(mailAddress);
		//jspに情報を投げる。
		request.setAttribute("manaerInfo", managerInfo);
		//遷移
		ControllerUtil.translatePage(JspPath.edit_profile_admin, request, response);

	}


}
