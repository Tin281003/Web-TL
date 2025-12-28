package controller;

import java.io.IOException;

import dao.DAOAccount;
import entity.Account;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class dangky
 */
public class dangky extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public dangky() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String name = request.getParameter("name");
		String phoneNumber = request.getParameter("PhoneNumber");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		String url = "/dangky.jsp";
		DAOAccount dao = new DAOAccount();
		Account accName = dao.getById(username);
		Account accEmail = dao.getByEmail(email);
		if (username != null) {
			if (accEmail == null && accName == null) {
				accName = new Account(username, password, email, phoneNumber, address, name);
				dao.add(accName);
				request.getSession().setAttribute("user", accName);
				url = "/trangchu.jsp";
			} else {
				request.setAttribute("name", name);
				request.setAttribute("phone", phoneNumber);
				request.setAttribute("address", address);
				request.setAttribute("er_Register", true);
			}
		}
		request.getServletContext().getRequestDispatcher(url).forward(request, response);
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
