package tdu_market.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

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

@WebServlet("/tdu_market/controller/VaildateExhibitItem")
@MultipartConfig(maxFileSize = 1024 * 1024)
public class VaildateExhibitItem extends HttpServlet {
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
		String relatedClassCode = request.getParameter("relatedClassCode");

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

		/*InputStream[] iss = null;
		Collection<Part> parts = request.getParts();
		if (parts != null) {
			iss = new InputStream[parts.size()];
			int i = 0;
			/*for (Part p : parts) {
				if (p.getName().equals("itemImageURLs_1") || p.getName().equals("itemImageURLs_2") ||
						p.getName().equals("itemImageURLs_3") || p.getName().equals("itemImageURLs_4")) {
					iss[i] = p.getInputStream();
					i++;
					System.out.println(i + " : " +iss[i]);
				}
				/*
				 * iss[i] = p.getInputStream(); i++;
				 */
			//}
		//}
		Part image1 = request.getPart("itemImageURLs_1");
		Part image2 = request.getPart("itemImageURLs_2");
		Part image3 = request.getPart("itemImageURLs_3");
		Part image4 = request.getPart("itemImageURLs_4");
		
		InputStream iStream1 = image1.getInputStream();
		InputStream iStream2 = image2.getInputStream();
		InputStream iStream3 = image3.getInputStream();
		InputStream iStream4 = image4.getInputStream();
		
		InputStream[] iss = new InputStream[4];
		iss[0] = iStream1;
		iss[1] = iStream2;
		iss[2] = iStream3;
		iss[3] = iStream4;

		ItemCreateInfo createInfo = new ItemCreateInfo(mailAddress, itemName, description, condition, price,
				relatedClassCode, iss);
		ItemInfoManager itemInfo = new ItemInfoManager();
		ReturnInfo validateResult = itemInfo.validateRegisterExhibitItem(createInfo);

		HttpSession session = request.getSession();

		if (validateResult.isSuccess()) {

			session.setAttribute("createInfo", createInfo);
			ControllerUtil.translatePage(JspPath.confirm_register_exhibit, request, response);
		} else {

			session.setAttribute("info", createInfo);
			ControllerUtil.translatePage(JspPath.register_exhibit, request, response);

		}
	}
}
