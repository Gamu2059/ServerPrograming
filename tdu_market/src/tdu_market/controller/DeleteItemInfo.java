package tdu_market.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tdu_market.entity_manager.ItemInfoManager;
import tdu_market.util.ControllerUtil;
import tdu_market.util.DialogUtil;
import tdu_market.util.JspPath;
import tdu_market.util.ServletPath;

/**
 * Servlet implementation class DeleteItemInfo
 */
@WebServlet("/tdu_market/controller/DeleteItemInfo")
public class DeleteItemInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteItemInfo() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.err.println("DeleteItemInfo is non implementation!");

		if (!ControllerUtil.verifyLogin(request, response)) {
			ControllerUtil.translatePage(JspPath.index, request, response);
			return;
		}
		//削除処理
		ItemInfoManager itemInfo = new ItemInfoManager();
		itemInfo.deleteItemInfo(Integer.valueOf(request.getParameter("itemID")));
		
		HttpSession session = request.getSession();
		//ダイアログの表示処理
		DialogUtil.setDialog("出品を削除しました。", request, response);
		// 遷移
		ControllerUtil.translatePage(ServletPath.ReferExhibitItemListPage, request, response);

	}

}
