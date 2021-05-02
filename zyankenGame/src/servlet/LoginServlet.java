package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DBUtil;
import model.Login;
import model.LoginLogic;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String MANAGER_USER = "Z11101";
	private static final String MANAGER_PASS = "z11101";

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		DBUtil dbutil = new DBUtil();
		dbutil.dbConnection();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Login loginUser = (Login) session.getAttribute("loginUser");
		String forwardPath = "";
		if (loginUser != null) {
			session.invalidate();
			forwardPath = "/WEB-INF/jsp/logout.jsp";
		} else {
			forwardPath = "/WEB-INF/jsp/login.jsp";

		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String userID = request.getParameter("userID");
		String userPassword = request.getParameter("pass");
		Login login = new Login(userID, userPassword);
		LoginLogic loginlogic = new LoginLogic();
		Login loginUser = loginlogic.checkLogin(login);
		//管理者と一致する
		if (loginUser != null && MANAGER_USER.equals(loginUser.getUserID())

				&& MANAGER_PASS.equals(loginUser.getUserPass())) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", loginUser);
			response.sendRedirect("/zyankenGame/UserManagerServlet");
			//登録ユーザーと一致する
		} else if (loginUser != null && userID.equals(loginUser.getUserID())
				&& userPassword.equals(loginUser.getUserPass())) {

			Login notLockUser = loginlogic.checkLockUser(loginUser);
			//ロックユーザーではない時
			if (notLockUser != null) {

				HttpSession session = request.getSession();
				session.setAttribute("loginUser", loginUser);
				response.sendRedirect("/zyankenGame/ZyankenPlayServlet");
			//ロックユーザーのとき
			} else {
				RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/jsp/lockUser.jsp");
				dispacher.forward(request, response);
			}

		//登録ユーザーと一致しない場合
		} else {
			RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/jsp/loginError.jsp");
			dispacher.forward(request, response);
		}

	}

	public void destroy() {
		DBUtil dbutil = new DBUtil();
		dbutil.dbConnection();
	}

}
