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
import tdu_market.dto.RelatedClassGetInfo;
import tdu_market.entity_manager.ItemInfoManager;
import tdu_market.entity_manager.RelatedClassInfoManager;
import tdu_market.util.ControllerUtil;
import tdu_market.util.JspPath;

/**
 * Servlet implementation class ReferItemPage
 */
@WebServlet("/tdu_market/controller/ReferItemPage")
public class ReferItemPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReferItemPage() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.err.println("ReferItemPage is non implementation!");

		if (!ControllerUtil.verifyLogin(request, response)) {
			ControllerUtil.translatePage(JspPath.index, request, response);
			return;
		}

		RelatedClassInfoManager relatedClassInfoManager = new RelatedClassInfoManager();
		//出品商品情報をリストへ保持
		ArrayList<RelatedClassGetInfo> relatedClassGetInfo = relatedClassInfoManager
				.getRelatedClassInfoWithItem(Integer.valueOf(request.getParameter("itemID")).longValue());
		//自分の出品情報を取得
		ItemInfoManager itemInfo = new ItemInfoManager();
		ArrayList<ItemGetInfo> itemList =  itemInfo.getExhibitItem(ControllerUtil.getMailAddress(request, response));
		
		//jsp情報を投げる。

		HttpSession session = request.getSession();
		session.setAttribute("itemInfo", relatedClassGetInfo);
		session.setAttribute("itemList", itemList);

		//遷移
		ControllerUtil.translatePage(JspPath.reference_item_detail, request, response);

	}


}


