package jp.co.aforce.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jp.co.aforce.bean.Login;
import jp.co.aforce.dao.LoginDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/LoginSample/jsp/login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();

		// リクエストパラメータの取得
		String userid=request.getParameter("userid");
		String password=request.getParameter("password");

		// DAOの生成
		LoginDAO dao=new LoginDAO();
		// Beanの生成
		Login login;
		try {
			login = dao.search(userid, password);
			if (login != null) {
				session.setAttribute("login", login);
				request.getRequestDispatcher("/jsp/loginsuccess.jsp").forward(request, response);
			}else {
				session.setAttribute("errormsg", "ユーザIDもしくはパスワードが違います。");
				response.sendRedirect("/LoginSample/jsp/login.jsp");
			}
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		
	}

}
