package tdu_market.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tdu_market.dto.ItemGetInfo;
import tdu_market.dto.ItemSearchInfo;
import tdu_market.entity_manager.ItemInfoManager;
import tdu_market.util.ControllerUtil;
import tdu_market.util.JspPath;

/**
 * Servlet implementation class ReferItemListPage
 */
@WebServlet("/tdu_market/controller/ManagerReferItemListPage")
public class ManagerReferItemListPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManagerReferItemListPage() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.err.println("ReferItemListPage is non implementation!");


		if (!ControllerUtil.verifyLogin(request, response)) {
			ControllerUtil.translatePage(JspPath.index, request, response);
			return;
		}
		//Stringはnull, intは-1が渡された場合に、
		//その項目を反映しない検索結果が出力される仕様になっている。

		String itemNameKeyword = request.getParameter("itemNameKeyword");
		if (itemNameKeyword != null && itemNameKeyword.trim().isEmpty()) {
			itemNameKeyword = null;
		}

		int condition = -1;
		try {
			condition = Integer.valueOf(request.getParameter("condtion")).intValue();
		} catch(NumberFormatException e) {

		}

		int maxPrice = 0;
		try {
			maxPrice = Integer.valueOf(request.getParameter("maxPrice")).intValue();
		} catch(NumberFormatException e) {

		}
		int oldestDate = -1;
		try {
			oldestDate = Integer.valueOf(request.getParameter("oldestDate")).intValue();
		} catch(NumberFormatException e) {

		}

		//検索キーワードから検索をかける
		ItemInfoManager itemInfo = new ItemInfoManager();
		//検索結果をリストへ保持
		ItemSearchInfo searchInfo = new ItemSearchInfo(itemNameKeyword,condition,maxPrice,oldestDate);
		ArrayList<ItemGetInfo> itemList = itemInfo.searchItem(searchInfo) ;
		//jspに情報を投げる。
		request.setAttribute("itemList", itemList);

		//遷移
		ControllerUtil.translatePage(JspPath.reference_item_list_by_admin, request, response);
	
		
	}

}
