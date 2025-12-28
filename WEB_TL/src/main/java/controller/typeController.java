package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class typeController
 */
public class typeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public typeController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession ss = request.getSession();
		String typeSS = (String) ss.getAttribute("typeSS");
		String type = request.getParameter("type");
		String categorySS = (String) ss.getAttribute("categorySS");
		String category = request.getParameter("category");

		if (type == null && category != null) {
			ss.removeAttribute("typeSS");
		} else if (!type.equals(typeSS)) {
			ss.setAttribute("typeSS", type);
		}
		if (category == null) {
			ss.removeAttribute("categorySS");
		} else if (!category.equals(categorySS)) {
			ss.setAttribute("categorySS", category);
		} 
		
		ss.removeAttribute("sort");
		ss.removeAttribute("costFilter");

		request.getServletContext().getRequestDispatcher("/menu").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
