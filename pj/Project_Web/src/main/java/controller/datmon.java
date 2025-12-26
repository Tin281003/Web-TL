package controller;

import java.io.IOException;

import javax.print.DocFlavor.INPUT_STREAM;

import dao.DAOFood;
import entity.Cart;
import entity.Food;
import entity.InfoBill;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class addCart
 */
public class datmon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public datmon() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String url = request.getParameter("submit");
		String qty = request.getParameter("soLuong");
		String id = request.getParameter("id");
		DAOFood dao = new DAOFood();
		Cart GioHang = (Cart) session.getAttribute("GioHang");
		
		int quantity = 1;
		
		try {
			quantity = Integer.valueOf(qty);
		} catch (Exception e) {
		}
		boolean insert = false;
		
		Food food = dao.getById(id);
		for (InfoBill b : GioHang.getBill()) {
			if (b.getFood().equals(food)) {
				insert = true;
				b.insertQuantity(quantity);
				break;
			}
		}
		if (!insert) {
			GioHang.getBill().add(new InfoBill(food, quantity));
		}
		session.setAttribute("GioHang", GioHang);
		request.getServletContext().getRequestDispatcher("/" + url).forward(request, response);
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
