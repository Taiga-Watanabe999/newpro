package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.SearchDAO;

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Search() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SearchDAO searchDAO = new SearchDAO();

	

		//sdao.select()で取得したリストをJSPに渡す。
		try {
			
			 String column = request.getParameter("検索");
	         int value = Integer.parseInt(request.getParameter("値"));
			request.setAttribute("リスト",
					searchDAO.search(column, value));
		} catch (Exception e) {

			e.printStackTrace();
		}

		request.getRequestDispatcher("./SelectResult.jsp").forward(request, response);
	}

}
