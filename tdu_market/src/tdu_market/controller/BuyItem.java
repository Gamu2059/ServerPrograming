package tdu_market.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tdu_market.dto.ItemBuyInfo;
import tdu_market.entity_manager.ItemInfoManager;
import tdu_market.util.ControllerUtil;
import tdu_market.util.DialogUtil;
import tdu_market.util.JspPath;

/**
 * Servlet implementation class BuyItem
 */
@WebServlet("/tdu_market/controller/BuyItem")
public class BuyItem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BuyItem() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (!ControllerUtil.verifyLogin(request, response)) {
			ControllerUtil.translatePage(JspPath.index, request, response);
			return;
		}


		ItemBuyInfo buyInfo = new ItemBuyInfo(request.getParameter("beginTraderMailAddress"), Integer.valueOf(request.getParameter("tradedItemID")));
		ItemInfoManager itemInfo = new ItemInfoManager();
		//アイテム購入処理
		itemInfo.BuyItem(buyInfo);
		DialogUtil.setDialog("取引を申し込みました。<br>相手からの連絡をお待ちください。", request, response);

		// メッセージ画面へ遷移
		//ControllerUtil.translatePage(JspPath.message, request, response);
		ReferMessageBoxListPage messagePage = new ReferMessageBoxListPage();
		messagePage.doGet(request, response);
	}

}
