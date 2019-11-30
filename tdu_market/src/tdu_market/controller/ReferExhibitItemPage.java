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

@WebServlet("/tdu_market/controller/ReferExhibitItemPage")
public class ReferExhibitItemPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (!ControllerUtil.verifyLogin(request, response)) {
			ControllerUtil.translatePage(JspPath.index, request, response);
			return;
		}

		RelatedClassInfoManager relatedClassInfoManager = new RelatedClassInfoManager();
		ArrayList<RelatedClassGetInfo> relatedClassGetInfo = relatedClassInfoManager
				.getRelatedClassInfoWithItem(Integer.valueOf(request.getParameter("itemID")).longValue());

		HttpSession session = request.getSession();
		if (relatedClassGetInfo == null) {
			session.setAttribute("exhibitInfo", null);
		} else {
			session.setAttribute("exhibitInfo", relatedClassGetInfo.get(0));
		}

		//遷移
		ControllerUtil.translatePage(JspPath.reference_exhibit_detail, request, response);
	}
}
