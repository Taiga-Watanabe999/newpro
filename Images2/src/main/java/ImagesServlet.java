
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class ImagesServlet
 */
@WebServlet("/ImagesServlet")
@MultipartConfig
public class ImagesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ImagesServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		electDAO ins= new SelectDAO();
		int id= Integer.parseInt(request.getParameter("id"));
		String path= ins.display(id);
		request.setAttribute("path", path);
		RequestDispatcher rd= request.getRequestDispatcher("./ImageDisplay.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// ファイルのパートを取得
		Part filePart = request.getPart("image");

		// ファイルの保存先を指定
		String fileName = filePart.getSubmittedFileName();
		String savePath = "src/main/webapp/images/" + fileName;

		// ファイルを保存
		try (InputStream inputStream = filePart.getInputStream();
				OutputStream outputStream = new FileOutputStream(savePath)) {
			byte[] buffer = new byte[1024];
			int bytesRead;
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
			}
		}

		// ファイルの保存が完了したら処理を続ける
		// ...
	}

}
