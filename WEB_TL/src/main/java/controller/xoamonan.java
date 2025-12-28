package controller;

import java.io.IOException;
import java.util.List;

import dao.DAOFood;
import entity.Food;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class xoamonan
 */
public class xoamonan extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public xoamonan() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DAOFood dao = new DAOFood();
		int id = Integer.valueOf(request.getParameter("id"));
		String arlert = dao.deleteById(id) ? "Xóa món ăn thành công" : "Xóa món ăn thất bại";
		List<Food> lsFood = dao.getAll();
		request.setAttribute("arlert", arlert);
		request.setAttribute("lsFood", lsFood);
		request.getServletContext().getRequestDispatcher("/quanlymonan.jsp").forward(request, response);
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
