package tdu_market.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tdu_market.dto.RelatedClassGetInfo;
import tdu_market.entity_manager.RelatedClassInfoManager;
import tdu_market.util.ControllerUtil;
import tdu_market.util.JspPath;

@WebServlet("/tdu_market/controller/ManagerReferItemPage")
public class ManagerReferItemPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (!ControllerUtil.verifyLogin(request, response)) {
			ControllerUtil.translatePage(JspPath.index, request, response);
			return;
		}

		RelatedClassInfoManager itemInfoManager = new RelatedClassInfoManager();
		//出品商品情報をリストへ保持
		ArrayList<RelatedClassGetInfo> itemAndClassInfo = itemInfoManager.getRelatedClassInfoWithItem(Integer.valueOf(request.getParameter("itemID")).longValue());
		//jspに情報を投げる。
		HttpSession session = request.getSession();
		session.setAttribute("itemInfo", itemAndClassInfo);

		//遷移
		ControllerUtil.translatePage(JspPath.reference_item_detail_by_admin, request, response);
	}
}
