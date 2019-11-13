package tdu_market.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tdu_market.dto.ItemGetInfo;
import tdu_market.dto.ReturnInfo;
import tdu_market.entity_manager.ItemInfoManager;
import tdu_market.entity_manager.StudentInfoManager;


/**
 * Servlet implementation class RegisterExhibitItemPage
 */
@WebServlet("/RegisterExhibitItemPage")
public class RegisterExhibitItemPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterExhibitItemPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.err.println("RegisterExhibitItemPage is non implementation!");
		HttpSession session = request.getSession();
		String mailAddress = (String)session.getAttribute("mailaddress");
		StudentInfoManager student = new StudentInfoManager();
		ReturnInfo loginResult = student.existMailAddress(mailAddress);
		if(!loginResult.isSuccess()) {
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);		
		}
		
		//存在する全出品情報を取得
		ItemInfoManager itemInfo = new ItemInfoManager();
		ArrayList<ItemGetInfo> itemList =  itemInfo.getExhibitItem(mailAddress);
		
	}


}
