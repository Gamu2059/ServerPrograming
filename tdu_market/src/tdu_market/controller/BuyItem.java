package tdu_market.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tdu_market.entity_manager.ItemInfoManager;
import tdu_market.dto.ItemBuyInfo;
import tdu_market.util.ControllerUtil;

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
		// TODO Auto-generated method stub
		System.err.println("BuyItem is non implementation!");
		//ログイン状態の検証
		if (!ControllerUtil.verifyLogin(request, response)) {
			return;
		}


		ItemBuyInfo buyInfo = new ItemBuyInfo(request.getParameter("beginTraderMailAddress"), Integer.valueOf(request.getParameter("tradedItemID")));
		ItemInfoManager itemInfo = new ItemInfoManager();
		//アイテム購入処理
		itemInfo.BuyItem(buyInfo);
		
		// メッセージ画面へ遷移
		ControllerUtil.translatePage("/tdu_market/Student/message.jsp", request, response);
	}

}
