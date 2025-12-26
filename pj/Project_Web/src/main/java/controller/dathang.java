package controller;

import java.io.IOException;

import dao.DAOAccount;
import dao.DAOBill;
import dao.DAOInfoBill;
import entity.Account;
import entity.Cart;
import entity.InfoBill;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class dathang
 */
public class dathang extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public dathang() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String name = request.getParameter("billingName");
		String phone = request.getParameter("billingPhone");
		String address = request.getParameter("billingAddress");
		String note = request.getParameter("note");

		Cart cart = (Cart) request.getSession().getAttribute("GioHang");
		cart.setEmail(email);
		cart.setNameCustomer(name);
		cart.setPhone(phone);
		cart.setAddress(address);
		cart.setNote(note);

		Account acc = (Account) request.getSession().getAttribute("user");
		DAOBill daoBill = new DAOBill();
		DAOInfoBill daoInfoBill = new DAOInfoBill();

		int idAccount = -1;
		if (acc != null) {
			DAOAccount daoAccount = new DAOAccount();
			idAccount = daoAccount.getId(acc.getUsername());
		}
		boolean success = false;
		if (idAccount == -1) {
			success = daoBill.add(cart);
		} else {
			success = daoBill.add(cart, idAccount);
		}

		int billID = 0;
		if (success) {
			billID = daoBill.getIdNewest();
		} else
			billID = -1;

		for (InfoBill bill : cart.getBill()) {
			daoInfoBill.add(bill, billID);
		}

		request.getSession().removeAttribute("GioHang");

		request.getServletContext().getRequestDispatcher("/trangchu").forward(request, response);
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
