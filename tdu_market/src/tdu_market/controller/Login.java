package tdu_market.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//ここでは便宜的にアドレスとパスを与えている
    private final String loginId = "1@gmail.com";
    private final String password = "123";
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.err.println("Login is non implementation!");
		
	      String sentaddress = request.getParameter("mailaddress");
	        String sentPw = request.getParameter("password");
	       // System.out.println(sentPw);
	        //System.out.println(sentaddress);
	        
	        if (sentaddress.equals(loginId) && sentPw.equals(password)) {
	            HttpSession session = request.getSession();
	            session.setAttribute("loginUser", true);
	            RequestDispatcher rd = request.getRequestDispatcher("NewFile.jsp");
	            rd.forward(request, response);
	        } else {
	            request.setAttribute("loginErrorMsg", "ログイン情報が不正です。");
	            request.setAttribute("errorFlg", true);
	            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
	            rd.forward(request, response);
	        }
	    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
    }
    
	}



