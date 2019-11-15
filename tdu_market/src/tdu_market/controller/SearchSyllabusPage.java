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

import tdu_market.dto.ReturnInfo;
import tdu_market.dto.SyllabusGetInfo;
import tdu_market.dto.SyllabusSearchInfo;
import tdu_market.entity_manager.StudentInfoManager;
import tdu_market.entity_manager.SyllabusInfoManager;
import tdu_market.util.ControllerUtil;

/**
 * Servlet implementation class SearchSyllabusPage
 */
@WebServlet("/SearchSyllabusPage")
public class SearchSyllabusPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchSyllabusPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.err.println("SearchSyllabusPage is non implementation!");

		if (!ControllerUtil.verifyLogin(request, response)) {
			return;
		}
	}
}
