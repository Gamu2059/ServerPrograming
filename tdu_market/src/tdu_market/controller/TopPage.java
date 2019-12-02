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
import tdu_market.dto.StudentGetInfo;
import tdu_market.entity_manager.ItemInfoManager;
import tdu_market.entity_manager.StudentInfoManager;
import tdu_market.util.ControllerUtil;
import tdu_market.util.JspPath;

@WebServlet("/tdu_market/controller/TopPage")
public class TopPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (!ControllerUtil.verifyLogin(request, response)) {
			ControllerUtil.translatePage(JspPath.index, request, response);
			return;
		}

		String mailAddress = ControllerUtil.getMailAddress(request, response);
		StudentInfoManager studentInfo = new StudentInfoManager();
		// トップページに入るときには既に本登録済なので、falseを指定する
		StudentGetInfo studentGetInfo = studentInfo.getStudentInfo(mailAddress, false);

		HttpSession session = request.getSession();
		session.setAttribute("studentInfo", studentGetInfo);

		ItemInfoManager itemInfo = new ItemInfoManager();
		ArrayList<ItemGetInfo> newItemList = itemInfo.getNewItemList();
		session.setAttribute("newItemList", newItemList);

		ControllerUtil.translatePage(JspPath.student_top, request, response);
	}
}
