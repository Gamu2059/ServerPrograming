package tdu_market.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tdu_market.dto.ItemGetInfoByAdmin;
import tdu_market.dto.ItemSearchInfo;
import tdu_market.entity_manager.ItemInfoManager;
import tdu_market.util.ControllerUtil;
import tdu_market.util.JspPath;

/**
 * Servlet implementation class ReferItemListPage
 */
@WebServlet("/tdu_market/controller/ManagerReferItemListPage")
public class ManagerReferItemListPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManagerReferItemListPage() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.err.println("ReferItemListPage is non implementation!");

		if (!ControllerUtil.verifyLogin(request, response)) {
			ControllerUtil.translatePage(JspPath.index, request, response);
			return;
		}
		//Stringはnull, intは-1が渡された場合に、
		//その項目を反映しない検索結果が出力される仕様になっている。

		String itemNameKeyword = null;
		try {
			itemNameKeyword = request.getParameter("itemNameKeyword");
		} catch (NumberFormatException e) {
		}

		int condition = -1;
		try {
			condition = Integer.valueOf(request.getParameter("condtion")).intValue();
		} catch (NumberFormatException e) {
		}

		int maxPrice = -1;
		try {
			maxPrice = Integer.valueOf(request.getParameter("maxPrice")).intValue();
		} catch (NumberFormatException e) {
		}

		int oldestDate = -1;
		try {
			oldestDate = Integer.valueOf(request.getParameter("oldestDate")).intValue();
		} catch (NumberFormatException e) {
		}

		//検索キーワードから検索をかける
		ItemInfoManager itemInfo = new ItemInfoManager();
		//検索結果をリストへ保持
		ItemSearchInfo searchInfo = new ItemSearchInfo(itemNameKeyword, condition, maxPrice, oldestDate);
		//		ArrayList<ItemGetInfo> itemListInfo = itemInfo.searchItem(searchInfo) ;
		ArrayList<ItemGetInfoByAdmin> searchResult = itemInfo.searchItemByManager(searchInfo);

		//		//商品と授業IDの関連付けられた情報(ロード時間がかかる理由はここ)
		//		RelatedClassInfoManager relatedInfoManager = new RelatedClassInfoManager();
		//		Map<Long, String> relatedItemIdAndSyllabusIdMap = new HashMap<Long, String>();
		//		for(ItemGetInfo _itemListInfo :itemListInfo) {
		//			String classCode = "";
		//			if(relatedInfoManager.getRelatedClassInfoWithItem(_itemListInfo.getItemID())!=null) {
		//				classCode = relatedInfoManager.getRelatedClassInfoWithItem(_itemListInfo.getItemID()).get(0).getSyllabusGetInfo().getClassName();
		//			}
		//			relatedItemIdAndSyllabusIdMap.put(_itemListInfo.getItemID(), classCode );
		//		}
		//
		//		//商品と出品者名が関連付けられた情報(ロード時間がかかる理由はここ)
		//		StudentInfoManager studentInfoManager = new StudentInfoManager();
		//		Map<Long, String> relatedItemIdAndStudentNameMap = new HashMap<Long, String>();
		//		for(ItemGetInfo _itemListInfo:itemListInfo) {
		//			String studentName = "取得出来ませんでした";
		//			if(studentInfoManager.getStudentInfo(_itemListInfo.getExhibitorMailAddress(), false)!=null) {
		//				studentName = studentInfoManager.getStudentInfo(_itemListInfo.getExhibitorMailAddress(), false).getDisplayName();
		//			}
		//			relatedItemIdAndStudentNameMap.put(_itemListInfo.getItemID(), studentName);
		//		}

		//jspに情報を投げる。
		HttpSession session = request.getSession();
		session.setAttribute("itemListInfo", searchResult);
		//		session.setAttribute("relatedItemIdAndSyllabusIdMap", relatedItemIdAndSyllabusIdMap);
		//		session.setAttribute("relatedItemIdAndStudentNameMap", relatedItemIdAndStudentNameMap );

		//遷移
		ControllerUtil.translatePage(JspPath.reference_item_list_by_admin, request, response);

	}

}
