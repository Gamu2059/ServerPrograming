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
 * Servlet implementation class ManagerReferExhibitItemListPage
 */
@WebServlet("/tdu_market/controller/ManagerReferExhibitItemListPage")
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
		//学生メールアドレスの取得
		String mailAddress = (String)request.getParameter("studentMailAddress");

		//出品情報を取得
		ItemInfoManager itemInfo = new ItemInfoManager();
		ArrayList<ItemGetInfo> itemList =  itemInfo.getExhibitItem(mailAddress);
		//jspに情報を投げる。
		HttpSession session = request.getSession();
		session.setAttribute("exhibitItemList",itemList);
		//遷移
		ControllerUtil.translatePage(JspPath.reference_exhibit_item_by_admin, request, response);

	}


}
