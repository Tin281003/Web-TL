package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import dao.DAOAccount;
import entity.Account;
import entity.WebEmail;

/**
 * Servlet implementation class quenmatkhau
 */
public class quenmatkhau extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public quenmatkhau() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOAccount dao = new DAOAccount();
		String email = request.getParameter("Email");
		Account acc = dao.getByEmail(email);

		if (acc == null) {
			request.setAttribute("forgetEr", "Email không tồn tại");
		} else {
			request.setAttribute("forgetSucces",
					"Tài khoản đã được gửi sang Email: " + email + ". Kiểm tra Email để lấy lại tài khoản.");
			WebEmail sendEmail = new WebEmail();
			sendEmail.sendEmailForgetPassword(email, acc.getUsername(), acc.getPassword());
		}
		request.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
