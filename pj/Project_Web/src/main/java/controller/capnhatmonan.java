package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import dao.DAOFood;
import entity.Food;

/**
 * Servlet implementation class capnhatmonan
 */
public class capnhatmonan extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public capnhatmonan() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String discount = request.getParameter("discount");
		String ingredient = request.getParameter("ingredient");
		String describe = request.getParameter("describe");

		DAOFood dao = new DAOFood();
		Food food = dao.getById(id);
		food.setName(name);
		food.setPrice(Double.valueOf(price));
		food.setDiscount(Integer.valueOf(discount));
		food.setIngredient(ingredient);
		food.setDescribe(describe);

		dao.update(food);
		request.getServletContext().getRequestDispatcher("/quanlymonan").forward(request, response);
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
