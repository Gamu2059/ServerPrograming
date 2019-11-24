package tdu_market.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tdu_market.dto.RelatedClassGetInfo;
import tdu_market.entity_manager.RelatedClassInfoManager;
import tdu_market.util.ControllerUtil;

/**
 * Servlet implementation class ReferItemPage
 */
@WebServlet("/ReferItemPage")
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
			return;
		}

		RelatedClassInfoManager itemInfo = new RelatedClassInfoManager();
		//出品商品情報をリストへ保持
		ArrayList<RelatedClassGetInfo> relatedClassGetInfo = itemInfo
				.getRelatedClassInfoWithItem(Integer.valueOf(request.getParameter("itemID")).longValue());
		//jspに情報を投げる。
		request.setAttribute("relatedClassGetInfo", relatedClassGetInfo);

	}

}
