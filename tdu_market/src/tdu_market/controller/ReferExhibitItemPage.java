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
import tdu_market.util.JspPath;

/**
 * Servlet implementation class ReferExhibitItemPage
 */
@WebServlet("/tdu_market/controller/ReferExhibitItemPage")
public class ReferExhibitItemPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReferExhibitItemPage() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.err.println("ReferExhibitItemPage is non implementation!");

		//ログイン状態の検証
		if (!ControllerUtil.verifyLogin(request, response)) {
			return;
		}

		//出品情報を取得
		RelatedClassInfoManager itemInfo = new RelatedClassInfoManager();
		ArrayList<RelatedClassGetInfo> relatedClassGetInfo = itemInfo
				.getRelatedClassInfoWithItem(Integer.valueOf(request.getParameter("itemID")).longValue());
		//jspに情報を投げる。

		request.setAttribute("exhibitInfo", relatedClassGetInfo);
		//遷移
		ControllerUtil.translatePage(JspPath.reference_exhibit_detail, request, response);


	}

}
