package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.DAOBill;
import dao.DAOInfoBill;
import entity.Cart;
import entity.InfoBill;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class quanlydonhang
 */
public class quanlydonhang extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public quanlydonhang() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DAOBill daoBill = new DAOBill();
		DAOInfoBill daoInfoBill = new DAOInfoBill();

		List<Cart> lsBill = daoBill.getAll();
		for (Cart cart : lsBill) {
			cart.setPrice(daoInfoBill.price(cart.getId()));
		}
		request.setAttribute("lsBill", lsBill);
		request.getServletContext().getRequestDispatcher("/quanlydonhang.jsp").forward(request, response);
	}

	String formatString(String s, int maxLength) throws IndexOutOfBoundsException {
		if (s == null) {
			return s;
		}
		if (s.length() > maxLength) {
			s = s.substring(0, maxLength) + "...";
		}
		return s;
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
