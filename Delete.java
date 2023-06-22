package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DeleteDAO;
import DAO.SelectDAO;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DeleteDAO ddao = new DeleteDAO();
		try {
			if(ddao.delete(Integer.parseInt(request.getParameter("id"))) == true) {
				System.out.println("削除しました");
				
				//SELECTDAOの実行
				SelectDAO sdao = new SelectDAO();
				
				//sdao.select()で取得したリストをJSPに渡す。
				try {
					request.setAttribute("リスト", sdao.select());
				} catch (Exception e) {
					
					e.printStackTrace();
				}

				request.getRequestDispatcher("./SelectResult.jsp").forward(request, response);
			
				
				
				
				
			}else {
				System.out.println("削除できませんでした。");
			}
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
	}

}
