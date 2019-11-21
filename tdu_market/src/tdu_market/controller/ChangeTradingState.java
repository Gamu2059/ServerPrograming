package tdu_market.controller;

import java.io.IOException;
import tdu_market.entity_manager.MessageRoomInfoManager;
import tdu_market.entity_manager.MessageInfoManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tdu_market.dto.MessageRoomChangeInfo;
import tdu_market.util.ControllerUtil;

/**
 * Servlet implementation class ChangeTradingState
 */
@WebServlet("/ChangeTradingState")
public class ChangeTradingState extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangeTradingState() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.err.println("ChangeTradingState is non implementation!");

		//ログイン状態の検証
		if (!ControllerUtil.verifyLogin(request, response)) {
			return;
		}
		
		HttpSession session = request.getSession();			
		int roomID = Integer.valueOf((String)session.getAttribute("roomID"));
		int roomState = Integer.valueOf((String)session.getAttribute("roomState"));

		MessageRoomInfoManager roomInfo = new MessageRoomInfoManager();
		MessageRoomChangeInfo changeInfo = new MessageRoomChangeInfo (roomID,roomState);
		roomInfo.changeStateMessageRoomInfo(changeInfo);
		
	}

}
