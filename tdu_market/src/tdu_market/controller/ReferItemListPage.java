package tdu_market.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tdu_market.dto.ItemGetInfo;
import tdu_market.dto.ItemSearchInfo;
import tdu_market.dto.ReturnInfo;
import tdu_market.entity_manager.ItemInfoManager;
import tdu_market.entity_manager.StudentInfoManager;


import java.text.SimpleDateFormat;
/**
 * Servlet implementation class ReferItemListPage
 */
@WebServlet("/ReferItemListPage")
public class ReferItemListPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReferItemListPage() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.err.println("ReferItemListPage is non implementation!");

		HttpSession session = request.getSession();
		String mailAddress = (String)session.getAttribute("mailaddress");
		StudentInfoManager student = new StudentInfoManager();
		ReturnInfo loginResult = student.existMailAddress(mailAddress);
		if(!loginResult.isSuccess()) {
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);		
		}


		//String to Date型変換  
		Date sqlDate = java.sql.Date.valueOf(request.getParameter("oldestDate"));

		//検索キーワードから検索をかける
		ItemSearchInfo searchInfo = new ItemSearchInfo(request.getParameter("itemNameKeyword"), Integer.valueOf(request.getParameter("condtion")).intValue(), Integer.valueOf(request.getParameter("maxPrice")).intValue(), sqlDate);
		ItemInfoManager itemInfo = new ItemInfoManager();
		//検索結果をリストへ保持
		ArrayList<ItemGetInfo> itemList = itemInfo.searchItem(searchInfo) ;
		//リストをviewへ戻す処理...？
		// ~~~~~~
		
	}

}
