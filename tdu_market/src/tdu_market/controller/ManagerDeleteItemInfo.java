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
import tdu_market.util.DialogUtil;
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.err.println("ManagerDeleteItemInfo is non implementation!");

		if (!ControllerUtil.verifyLogin(request, response)) {
			ControllerUtil.translatePage(JspPath.index, request, response);
			return;
		}

		HttpSession session = request.getSession();

		ItemInfoManager itemInfo = new ItemInfoManager();

		//商品情報の複数件削除
		String[] itemIDs = request.getParameterValues("itemIDs");
		if (itemIDs != null) {
			for (String info : itemIDs) {
				itemInfo.deleteItemInfo(Integer.parseInt(info));
			}
		}

		//削除処理
		if (request.getParameter("itemID") != null) {
			itemInfo.deleteItemInfo(Integer.valueOf(request.getParameter("itemID")));
		}
		//セッションからアイテム情報を削除する
		session.removeAttribute("itemInfo");

		//遷移先を分岐させる
		String whereFromToItemPage = (String) session.getAttribute("whereFromToItemPage");
		String inItemList = (String) request.getParameter("whereFromToItemPage");
		if (whereFromToItemPage != null) {
			//遷移元が商品一覧
			if (whereFromToItemPage.equals("fromItemList")) {
				//遷移元の破棄
				session.removeAttribute("whereFromToItemPage");
				ManagerReferItemListPage managerReferItemListPage = new ManagerReferItemListPage();
				managerReferItemListPage.doPost(request, response);
			}

			//遷移元が出品一覧
			if (whereFromToItemPage.equals("fromExhibitList")) {
				if (inItemList != null) {
					if (inItemList.equals("fromItemList")) {
						//商品一覧を更新する
						ManagerReferItemListPage managerReferItemListPage = new ManagerReferItemListPage();
						managerReferItemListPage.doPost(request, response);
					}
				} else {
					//出品商品一覧を再取得
					ArrayList<ItemGetInfo> exhibitItemList = itemInfo
							.getExhibitItem(request.getParameter("studentMailAddress"));
					session.setAttribute("exhibitItemList", exhibitItemList);
					//遷移元の破棄
					session.removeAttribute("whereFromToItemPage");
					ControllerUtil.translatePage(JspPath.reference_exhibit_item_by_admin, request, response);
				}
			}
		} else {
			if (inItemList != null) {
				if (inItemList.equals("fromItemList")) {
					//ダイアログの設定
					DialogUtil.setDialog("商品情報を削除しました。", request, response);
					ManagerReferItemListPage managerReferItemListPage = new ManagerReferItemListPage();
					managerReferItemListPage.doPost(request, response);
				}
			} else {
				//遷移
				ManagerReferItemListPage managerReferItemListPage = new ManagerReferItemListPage();
				managerReferItemListPage.doPost(request, response);
			}
		}
	}
}
