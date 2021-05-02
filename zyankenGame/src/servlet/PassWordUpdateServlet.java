package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Login;
import model.PasswordInfo;
import model.PasswordUpdateLogic;

/**
 * パスワード変更に応じて画面遷移を制御するクラス
 */
@WebServlet("/PassWordUpdateServlet")
public class PassWordUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/passwordUpdate.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userID = request.getParameter("userID");
		String userPassword = request.getParameter("nowpass");
		String userNewPassword = request.getParameter("newpass");
		PasswordInfo passwordInfo = new PasswordInfo(userID, userPassword, userNewPassword);
		PasswordUpdateLogic passUpdateLogin = new PasswordUpdateLogic();
		boolean result = passUpdateLogin.execute(passwordInfo);
		if (result) {
			Login loginUser=new Login(passwordInfo.getUserID(),passwordInfo.getUserNewPass());
			request.setAttribute("loginUser", loginUser);
		}
		RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/jsp/passwordUpdateResult.jsp");
		dispacher.forward(request, response);
	}

}
