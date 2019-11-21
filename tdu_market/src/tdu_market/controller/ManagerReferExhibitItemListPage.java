package tdu_market.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tdu_market.dto.ItemGetInfo;
import tdu_market.entity_manager.ItemInfoManager;
import tdu_market.util.ControllerUtil;

/**
 * Servlet implementation class ManagerReferExhibitItemListPage
 */
@WebServlet("/ManagerReferExhibitItemListPage")
public class ManagerReferExhibitItemListPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerReferExhibitItemListPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.err.println("ManagerReferExhibitItemListPage is non implementation!");

		//ログイン状態の検証
		if (!ControllerUtil.verifyLogin(request, response)) {
			return;
		}
		//セッションからメールアドレスを取得
		String mailAddress = ControllerUtil.getMailAddress(request, response);
		
		//出品情報を取得
		ItemInfoManager itemInfo = new ItemInfoManager();
		ArrayList<ItemGetInfo> itemList =  itemInfo.getExhibitItem(mailAddress);
		//jspに情報を投げる。
		request.setAttribute("itemList",itemList);
	}


}
