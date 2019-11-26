package tdu_market.controller;

import java.io.IOException;
import tdu_market.entity_manager.MessageRoomInfoManager;
import tdu_market.entity_manager.MessageInfoManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tdu_market.dto.MessageCreateInfo;
import tdu_market.util.ControllerUtil;

/**
 * Servlet implementation class PostMessage
 */
@WebServlet("/tdu_market/controller/PostMessage")
public class PostMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PostMessage() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.err.println("PostMessage is non implementation!");

		//ログイン状態の検証
		if (!ControllerUtil.verifyLogin(request, response)) {
			return;
		}
		MessageInfoManager messageInfo = new MessageInfoManager();
		MessageCreateInfo createInfo = new MessageCreateInfo(Integer.valueOf(request.getParameter("roomID")).longValue(),request.getParameter("studentNumber"),request.getParameter("content"));
		messageInfo.createMessageInfo(createInfo);
		//遷移
		ControllerUtil.translatePage("/tdu_market/Student/message.jsp", request, response);

	}

}
