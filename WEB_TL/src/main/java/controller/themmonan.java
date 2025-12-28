package controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import dao.DAOFood;
import entity.Food;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

/**
 * Servlet implementation class themmonan
 */
@MultipartConfig()
public class themmonan extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public themmonan() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "/themmonan.jsp";
		DAOFood dao = new DAOFood();

		String nameFood = request.getParameter("name");
		String price = request.getParameter("price");
		String discount = request.getParameter("discount");
		String describe = request.getParameter("describe");
		String ingredient = request.getParameter("ingredient");
		try {
			Part part = request.getPart("Img");
			String urlImg = nameFood;

			String realPath = request.getServletContext().getRealPath("/imgFood");
			if (!Files.exists(Paths.get(realPath))) {
				Files.createDirectory(Paths.get(realPath));
			}
			part.write(realPath + "/" + urlImg + ".jpg");
			Food food = new Food(nameFood, Double.valueOf(price), Integer.valueOf(discount), urlImg, describe, null,
					ingredient);
			dao.add(food);
			url = "/quanlymonan";
		} catch (Exception e) {
		}
		// TODO: handle exception
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
