package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.gson.Gson;

import dao.DAOAccount;
import dao.DAOFeedBack;
import dao.DAOInfoBill;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class quanlythongke
 */
public class quanlythongke extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public quanlythongke() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DAOInfoBill daoInfoBill = new DAOInfoBill();
		DAOAccount daoAccount = new DAOAccount();
		DAOFeedBack daoFeedback = new DAOFeedBack();

		Map<String, Integer> allSeller = daoInfoBill.categorySeller();
		allSeller = allSeller.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue,
						LinkedHashMap::new));

		List<Integer> lsData = new ArrayList<Integer>();

		List<String> lsLabel = new ArrayList<String>();
		List<String> label = new ArrayList<String>();

		List<String> colors = new ArrayList<String>();
		List<String> color = new ArrayList<String>();
		color.add("blue");
		color.add("teal");
		color.add("purple");
		color.add("red");
		int i = 0;
		for (Map.Entry<String, Integer> entry : allSeller.entrySet()) {
			lsData.add(entry.getValue());
			lsLabel.add(entry.getKey());
			if (i < 4) {
				label.add(entry.getKey());
				colors.add(color.get(i++));
			} else
				colors.add("gray");
		}

		request.setAttribute("allUser", daoAccount.countAll());
		request.setAttribute("turnover", daoInfoBill.turnover());
		request.setAttribute("allBill", daoInfoBill.countAll());
		request.setAttribute("allFeedback", daoFeedback.countAll());

		request.setAttribute("datas", new Gson().toJson(lsData));
		request.setAttribute("colors", new Gson().toJson(colors));
		request.setAttribute("labels", new Gson().toJson(lsLabel));

		request.setAttribute("color", color);
		request.setAttribute("label", label);

		request.getServletContext().getRequestDispatcher("/quanlythongke.jsp").forward(request, response);
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
