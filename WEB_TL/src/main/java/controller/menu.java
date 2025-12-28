package controller;

import java.io.IOException;
import java.util.List;

import dao.DAOFood;
import dao.DAOType;
import entity.Cart;
import entity.Food;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class menu
 */
public class menu extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<Food> ls;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public menu() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();
		if (session.getAttribute("GioHang") == null)
			session.setAttribute("GioHang", new Cart());
		if (session.getAttribute("meunType") == null)
			session.setAttribute("menuType", new DAOType().getAll());

		String page = request.getParameter("page") == null ? "1" : request.getParameter("page");

		String costFilter = request.getParameter("costFilter");
		if (costFilter == null && session.getAttribute("costFilter") != null) {
			costFilter = (String) session.getAttribute("costFilter");
		}
		String[] parts = { "0", "10000000" };
		if (costFilter != null)
			parts = costFilter.split(" AND ");

		String sort = request.getParameter("sort");
		if (session.getAttribute("sort") != null && sort == null) {
			sort = (String) session.getAttribute("sort");
		} else if (sort == null) {
			sort = "0";
		}
		String type = (String) session.getAttribute("typeSS");
		String category = (String) session.getAttribute("categorySS");
		DAOFood daoFood = new DAOFood();
		System.out.println(sort);
		System.out.println(costFilter);
		// setup number page
		int pageI = 1;
		int nextPage = 0;
		int prePage = 0;
		int totalsize = 1;
		if (category != null) {
			totalsize = daoFood.getByCategory(category, Integer.parseInt(parts[0]), Integer.parseInt(parts[1])).size();
		} else if (type != null && !type.equals("all")) {
			totalsize = daoFood.getByType(type, Integer.parseInt(parts[0]), Integer.parseInt(parts[1])).size();
		} else {
			totalsize = daoFood.getAll(Integer.parseInt(parts[0]), Integer.parseInt(parts[1])).size();
		}

		int totalPage = totalsize % 12 > 0 ? totalsize / 12 + 1 : totalsize / 12;
		try {
			pageI = Integer.valueOf(page);
			nextPage = pageI + 1;
			prePage = pageI - 1;
		} catch (Exception e) {
		}

		// setup show food
		if (category != null) {
			ls = daoFood.getByCategory(category, pageI * 12 - 11, 12, Integer.parseInt(parts[0]),
					Integer.parseInt(parts[1]));
		} else if (type != null && !type.equals("all")) {
			ls = daoFood.getByType(type, pageI * 12 - 11, 12, Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
		} else {
			ls = daoFood.getAll(pageI * 12 - 11, 12, Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
		}

		// sort
		if (sort != null)
			switch (sort) {
			case "1":// a-z
				ls = daoFood.sortByName(true, pageI * 12 - 11, 12, type, category, Integer.valueOf(parts[0]),
						Integer.valueOf(parts[1]));
				break;
			case "2":// z-a
				ls = daoFood.sortByName(false, pageI * 12 - 11, 12, type, category, Integer.valueOf(parts[0]),
						Integer.valueOf(parts[1]));
				break;
			case "3":// gia tang
				ls = daoFood.sortByPrice(true, pageI * 12 - 11, 12, type, category, Integer.valueOf(parts[0]),
						Integer.valueOf(parts[1]));
				break;
			case "4":// gia giam
				ls = daoFood.sortByPrice(false, pageI * 12 - 11, 12, type, category, Integer.valueOf(parts[0]),
						Integer.valueOf(parts[1]));
				break;
			}

		request.getSession().setAttribute("sort", sort);
		request.getSession().setAttribute("costFilter", costFilter);
		request.getSession().setAttribute("ntype", type);
		request.getSession().setAttribute("ncategory", category);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("nextPage", nextPage);
		request.setAttribute("prePage", prePage);
		request.setAttribute("currentPage", pageI);
		request.setAttribute("sort", sort);
		request.setAttribute("ls", ls);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/monngonmoingay.jsp");
		dispatcher.forward(request, response);
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
