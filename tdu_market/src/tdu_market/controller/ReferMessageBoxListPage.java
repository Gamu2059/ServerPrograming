package tdu_market.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tdu_market.dto.MessageGetInfo;
import tdu_market.dto.MessageRoomGetInfo;
import tdu_market.dto.StudentGetInfo;
import tdu_market.entity_manager.MessageInfoManager;
import tdu_market.entity_manager.MessageRoomInfoManager;
import tdu_market.entity_manager.StudentInfoManager;
import tdu_market.util.ControllerUtil;
import tdu_market.util.JspPath;

@WebServlet("/tdu_market/controller/ReferMessageBoxListPage")
public class ReferMessageBoxListPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.err.println("ReferMessageBoxListPage is non implementation!");

		if (!ControllerUtil.verifyLogin(request, response)) {
			ControllerUtil.translatePage(JspPath.index, request, response);
			return;
		}

		MessageInfoManager messageInfo = new MessageInfoManager();
		MessageRoomInfoManager messageRoomInfo = new MessageRoomInfoManager();

		StudentInfoManager studentInfoManager = new StudentInfoManager();

		String mailAddress = ControllerUtil.getMailAddress(request, response);

		//jsp側から、isSelectに"true"or"false"という文字列を送る必要あり。
		HttpSession session = request.getSession();

		String isSelectStr = (String) session.getAttribute("isSelect");
		boolean isSelect = false;
		if (isSelectStr != null) {
			isSelect = Boolean.parseBoolean(isSelectStr);
		}

		ArrayList<MessageRoomGetInfo> messageRoomInfoList = messageRoomInfo.getMessageRoomInfo(mailAddress);
		session.setAttribute("messageRoomInfoList", messageRoomInfoList);

		if (isSelect) {
			long roomID = -1;
			try {
				roomID = Long.parseLong(request.getParameter("roomID"));
			} catch(NumberFormatException e) {

			}

			String studentNumberString = (String) request.getParameter("studentNumber");
			ArrayList<MessageGetInfo> messageInfoList = messageInfo.getMessageInfoWithRoomInfo(roomID);
			StudentGetInfo studentGetInfo = studentInfoManager.getStudentInfo(studentNumberString, false);

			session.setAttribute("messageInfoList", messageInfoList);
			session.setAttribute("messageOpponentStudentInfo", studentGetInfo);
		} else {
			session.setAttribute("messageInfoList", null);
			session.setAttribute("messageOpponentStudentInfo", null);
		}

		ControllerUtil.translatePage(JspPath.message, request, response);
	}
}
