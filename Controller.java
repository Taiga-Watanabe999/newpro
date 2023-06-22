package Controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.info;
import DAO.InsertDAO;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
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
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		info info = new info();
		InsertDAO idao = new InsertDAO();

		//daoクラスに値をセット
		info.setId(Integer.parseInt(request.getParameter("id")));
		info.setProductName(request.getParameter("productName"));
		info.setPrice(Integer.parseInt(request.getParameter("price")));

		//現在の時刻等を取得、String型に変換
		Date dateObj = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String date = format.format(dateObj);

		//InsertDAOで接続、データの追加
		try {
			idao.insert(info.getId(), info.getProductName(), info.getPrice(), date);
			
			RequestDispatcher rd = request.getRequestDispatcher("/Show");
		    rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace(); // 例外のスタックトレースを表示する
			// 例外発生時の処理を記述する
		}
	}

}
