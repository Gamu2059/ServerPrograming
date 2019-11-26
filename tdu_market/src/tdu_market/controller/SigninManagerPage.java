package tdu_market.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tdu_market.util.ControllerUtil;

/**
 * Servlet implementation class SigninManagerPage
 */
@WebServlet("/tdu_market/controller/SigninManagerPage")
public class SigninManagerPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SigninManagerPage() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.err.println("SigninManagerPage is non implementation!");

		/*不要なサーブレット
		//ログイン状態の検証
		if (!ControllerUtil.verifyLogin(request, response)) {
			return;
		}
		//遷移
		ControllerUtil.translatePage("/tdu_market/Admin/top_admin.jsp", request, response);
*/
	}


}
