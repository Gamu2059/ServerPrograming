package tdu_market.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tdu_market.dto.ItemCreateInfo;
import tdu_market.dto.ReturnInfo;
import tdu_market.entity_manager.ItemInfoManager;
import tdu_market.entity_manager.StudentInfoManager;

/**
 * Servlet implementation class RegisterItemInfo
 */
@WebServlet("/RegisterItemInfo")
public class RegisterItemInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterItemInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.err.println("RegisterItemInfo is non implementation!");
		HttpSession session = request.getSession();
		String mailAddress = (String)session.getAttribute("mailaddress");
		StudentInfoManager student = new StudentInfoManager();
		ReturnInfo loginResult = student.existMailAddress(mailAddress);
		if(!loginResult.isSuccess()) {
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);		
		}
		
		ItemInfoManager itemInfo = new ItemInfoManager();
		ItemCreateInfo createInfo = new ItemCreateInfo(request.getParameter("exhibitorMailAddress"), request.getParameter("itemName"), request.getParameter("description"),Integer.valueOf(request.getParameter("condtion")).intValue() , Integer.valueOf(request.getParameter("price")).intValue(),
				request.getParameter("relatedClassCode"), request.getParameterValues("itemImageURLs"));
		itemInfo.createItemInfo(createInfo);
	}

}
