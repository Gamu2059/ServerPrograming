package tdu_market.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tdu_market.dto.ManagerUpdateInfo;
import tdu_market.entity_manager.ManagerInfoManager;
import tdu_market.util.ControllerUtil;

/**
 * Servlet implementation class RegisterManagerInfo
 */
@WebServlet("/RegisterManagerInfo")
public class RegisterManagerInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterManagerInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.err.println("RegisterManagerInfo is non implementation!");
		ManagerInfoManager manager = new ManagerInfoManager();
		if (!ControllerUtil.verifyLogin(request, response)) {
			return;
		}

		//入力フォームの必要事項が入力されているかチェック
		//ここではjsp側でしているため、していない
		//

		/*
		 * StudentUpdateInfoでは引数にメールアドレスも受け取っているが、こちらではいらないのか？
		 */
		ManagerUpdateInfo managerInfo = new ManagerUpdateInfo( request.getParameter("nonHashedPassword"), request.getParameter("displayName"), Integer.valueOf(request.getParameter("departmentValue")).longValue(), request.getParameter("iconImageURL"));

		//アカウントの仮登録状態を登録済みに、各種情報を入力されたものに変更。
		manager.makeManagerInfoRegistered(managerInfo);
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);		
	}

}
