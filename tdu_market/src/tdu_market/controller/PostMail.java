package tdu_market.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import tdu_market.dto.ReturnInfo;
import tdu_market.entity_manager.StudentInfoManager;
import tdu_market.util.ControllerUtil;
import tdu_market.controller.SendMail;
/**
 * Servlet implementation class PostMail
 */
@WebServlet("/PostMail")
public class PostMail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PostMail() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.err.println("PostMail is non implementation!");

		String mailAddress = ControllerUtil.getMailAddress(request, response);
	
		StudentInfoManager student = new StudentInfoManager();
		ReturnInfo createResult = student.createTemporaryAccount(mailAddress);
		
		if(createResult.isSuccess()) {
			SendMail mailer = new SendMail(); 
			//仮パスワード送信
			mailer.sendPassword(mailAddress,createResult.getMsg());
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
		else {
			request.setAttribute("ErrorMessage",createResult.getMsg());
			RequestDispatcher rd = request.getRequestDispatcher("hoge.jsp");
			rd.forward(request, response);
		}
	}
}
