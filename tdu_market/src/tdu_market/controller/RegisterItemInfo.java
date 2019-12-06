package tdu_market.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import tdu_market.dto.ItemCreateInfo;
import tdu_market.dto.ReturnInfo;
import tdu_market.entity_manager.ItemInfoManager;
import tdu_market.util.ControllerUtil;
import tdu_market.util.JspPath;

@WebServlet("/tdu_market/controller/RegisterItemInfo")
@MultipartConfig(maxFileSize = 1024 * 1024)
public class RegisterItemInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (!ControllerUtil.verifyLogin(request, response)) {
			ControllerUtil.translatePage(JspPath.index, request, response);
			return;
		}

		request.setCharacterEncoding("UTF-8");
		
		String mailAddress = ControllerUtil.getMailAddress(request, response);
		String itemName = request.getParameter("itemName");
		String description = request.getParameter("description");
		String conditionStr = request.getParameter("condtion");
		String priceStr = request.getParameter("price");
		String relatedClassCodeWithClassName = request.getParameter("relatedClassCode");
		String relatedClassCode = relatedClassCodeWithClassName.substring(0, 10);
		System.out.println(relatedClassCode);

		int condition = -1;
		try {
			condition = Integer.parseInt(conditionStr);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		int price = -1;
		try {
			price = Integer.parseInt(priceStr);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		Part image1 = request.getPart("itemImageURLs_1");
		Part image2 = request.getPart("itemImageURLs_2");
		Part image3 = request.getPart("itemImageURLs_3");
		Part image4 = request.getPart("itemImageURLs_4");
		
		InputStream[] iss = new InputStream[4];
		iss[0] = image1.getInputStream();
		iss[1] = image2.getInputStream();
		iss[2] = image3.getInputStream();
		iss[3] = image4.getInputStream();
		
		HttpSession session = request.getSession();
		ItemCreateInfo createInfo = new ItemCreateInfo(mailAddress, itemName, description, condition, price,
				relatedClassCode, iss);
		session.setAttribute("info", createInfo);
		ItemInfoManager itemInfo = new ItemInfoManager();
		ReturnInfo validateResult = itemInfo.validateRegisterExhibitItem(createInfo);
		
		if (validateResult.isSuccess()) {
			itemInfo.createItemInfo(createInfo);
			//セッションを破棄
			session.removeAttribute("info");
//			ControllerUtil.translatePage(JspPath.confirm_register_exhibit, request, response);
			// 出品物一覧へ遷移する
			ReferExhibitItemListPage referExhibitItemListPage = new ReferExhibitItemListPage();
			referExhibitItemListPage.doGet(request, response);
		} else {
			ControllerUtil.translatePage(JspPath.register_exhibit, request, response);
		}
	}
}
