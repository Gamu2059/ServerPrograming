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
import tdu_market.util.ControllerUtil;
import tdu_market.entity_manager.MessageRoomInfoManager;
import tdu_market.entity_manager.MessageInfoManager;
/**
 * Servlet implementation class ReferMessageBoxListPage
 */
@WebServlet("/tdu_market/controller/ReferMessageBoxListPage")
public class ReferMessageBoxListPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReferMessageBoxListPage() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.err.println("ReferMessageBoxListPage is non implementation!");

		//ログイン状態の検証
		if (!ControllerUtil.verifyLogin(request, response)) {
			return;
		}

		MessageInfoManager messageInfo = new MessageInfoManager();
		MessageRoomInfoManager messageRoomInfo = new MessageRoomInfoManager();
		String mailAddress = ControllerUtil.getMailAddress(request, response);

		//jsp側から、isSelectに"true"or"false"という文字列を送る必要あり。
		HttpSession session = request.getSession();			
		boolean isSelect = Boolean.valueOf((String)session.getAttribute("isSelect"));

		//左
		ArrayList<MessageRoomGetInfo> messageRoomInfoList = messageRoomInfo.getMessageRoomInfo(mailAddress) ;
		request.setAttribute("messageRoomInfoList", messageRoomInfoList);
		//右

		if(isSelect) {
			int roomID = Integer.valueOf(request.getParameter("roomID")).intValue();			
			ArrayList<MessageGetInfo> messageInfoList  = messageInfo.getMessageInfoWithRoomInfo(roomID);
			request.setAttribute("messageInfoList", messageInfoList);
		}
		//遷移
		ControllerUtil.translatePage("/tdu_market/Student/message.jsp", request, response);

	}
}
