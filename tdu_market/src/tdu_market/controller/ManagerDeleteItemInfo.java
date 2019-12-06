package tdu_market.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tdu_market.dto.ItemGetInfo;
import tdu_market.entity_manager.ItemInfoManager;
import tdu_market.util.ControllerUtil;
import tdu_market.util.JspPath;

/**
 * Servlet implementation class ManagerDeleteIntemInfo
 */
@WebServlet("/tdu_market/controller/ManagerDeleteItemInfo")
public class ManagerDeleteItemInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerDeleteItemInfo() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.err.println("ManagerDeleteItemInfo is non implementation!");

		if (!ControllerUtil.verifyLogin(request, response)) {
			ControllerUtil.translatePage(JspPath.index, request, response);
			return;
		}

		//削除処理
		ItemInfoManager itemInfo = new ItemInfoManager();
		itemInfo.deleteItemInfo(Integer.valueOf(request.getParameter("itemID")));

		//出品商品一覧を再取得
		ArrayList<ItemGetInfo> itemList =  itemInfo.getExhibitItem(request.getParameter("studentMailAddress"));
		//jspに情報を投げる。
		HttpSession session = request.getSession();
		session.setAttribute("exhibitItemList",itemList);

		//遷移
		ControllerUtil.translatePage(JspPath.reference_exhibit_item_by_admin, request, response);
	}

}
