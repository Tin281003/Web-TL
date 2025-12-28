package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import dao.DAOAccount;
import entity.Account;

/**
 * Servlet implementation class doimatkhau
 */
public class doimatkhau extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public doimatkhau() {
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
		Account acc = (Account) session.getAttribute("user");
		String pass = acc.getPassword();

		String oldPass = request.getParameter("OldPassword");
		String changePass = request.getParameter("Password");
		String confirmPass = request.getParameter("ConfirmPassword");

		DAOAccount dao = new DAOAccount();

		String error = null;

		if (oldPass != null) {
			if (pass.equals(oldPass)) {
				if (changePass.equals(confirmPass)) {
					acc.setPassword(changePass);
					dao.updatePassword(acc);
					request.setAttribute("success", "Đổi mật khẩu thành công");
				} else {
					error = "Mật khẩu nhập lại không trùng khớp.";
				}
			} else {
				error = "Mật khẩu cũ không chính xác.";
			}
		}
		request.setAttribute("error", error);
		request.getServletContext().getRequestDispatcher("/doimatkhau.jsp").forward(request, response);
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
