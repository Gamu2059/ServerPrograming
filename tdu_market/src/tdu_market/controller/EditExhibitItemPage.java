package tdu_market.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tdu_market.dto.ItemGetInfo;
import tdu_market.dto.RelatedClassGetInfo;
import tdu_market.dto.SyllabusGetInfo;
import tdu_market.entity_manager.ItemInfoManager;
import tdu_market.entity_manager.SyllabusInfoManager;
import tdu_market.util.ControllerUtil;
import tdu_market.util.JspPath;

/**
 * Servlet implementation class EditExhibitItemPage
 */
@WebServlet("/tdu_market/controller/EditExhibitItemPage")
public class EditExhibitItemPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditExhibitItemPage() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		if (!ControllerUtil.verifyLogin(request, response)) {
			ControllerUtil.translatePage(JspPath.index, request, response);
			return;
		}

		request.setCharacterEncoding("UTF-8");

		//商品情報を取得する

		ItemInfoManager itemInfo = new ItemInfoManager();
		SyllabusInfoManager syllabusinfo = new SyllabusInfoManager();

		String id = request.getParameter("itemID");
		String code = request.getParameter("classCode");
		System.out.println(id);
		id = id.trim();


		SyllabusGetInfo syllabus = syllabusinfo.getSyllabusInfo(code);
		ItemGetInfo item = itemInfo.getItemInfo(Integer.valueOf(id).longValue());

		RelatedClassGetInfo info = new RelatedClassGetInfo(item,syllabus);

		HttpSession session = request.getSession();

		//jspに情報を投げる。
		session.setAttribute("relatedClassGetInfo",info);//ここはどこのjspで取得している？？？
		//遷移
		ControllerUtil.translatePage(JspPath.edit_exhibit, request, response);


		/*
		request.setAttribute("itemID",info.getItemID());
		request.setAttribute("itemName",info.getItemName());
		request.setAttribute("description",info.getDescription());
		request.setAttribute("condtion",info.getCondition());
		request.setAttribute("price",info.getPrice());
		request.setAttribute("TradingState",info.getTradingState());
		request.setAttribute("ExhibitDate",info.getExhibitDate());
		request.setAttribute("itemImageURLs",info.getItemImageURLs());
		*/

	}

}
