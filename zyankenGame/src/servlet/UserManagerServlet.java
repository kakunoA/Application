package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Login;
import model.UserManageLogic;

/**
 * 管理者ユーザーがユーザー登録やユーザーロック、ユーザーロック解除を行った時の画面遷移を管理するサーブレットクラス
 */
@WebServlet("/UserManagerServlet")
public class UserManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserManageLogic userManageLogic = new UserManageLogic();
		List<String> targetLockUserList = userManageLogic.lockReleaseUserListGet();
		request.setAttribute("targetLockUserList", targetLockUserList);
		List<String> targetLockReleaseUserList = userManageLogic.lockUserListGet();
		request.setAttribute("targetLockReleaseUserList", targetLockReleaseUserList);
		String forwardPath = "/WEB-INF/jsp/manageUser.jsp";
		RequestDispatcher dispacher = request.getRequestDispatcher(forwardPath);
		dispacher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String registerUserID = request.getParameter("userID");
		String registerPassword = request.getParameter("password");
		String lockUser = request.getParameter("rockOperation");
		String lockReleaseUser = request.getParameter("rockReleaseOperation");
		UserManageLogic userManageLogic = new UserManageLogic();
		if (registerUserID != null && registerPassword != null && lockUser == null && lockReleaseUser == null) {
			Login registerInfo = new Login(registerUserID, registerPassword);

			if (userManageLogic.userRegisterCheck(registerInfo)) {
				request.setAttribute("registerMessage", "登録しました。");
			} else {
				request.setAttribute("registerMessage", "登録失敗しました。登録するユーザーを見直してください。");
			}
		} else if (registerUserID == null && registerPassword == null && lockUser != null && lockReleaseUser == null) {
			if (userManageLogic.userLockCheck(lockUser)) {
				request.setAttribute("rockMessage", "ロックしました。");
			} else {
				request.setAttribute("rockMessage", "ロック失敗しました。ロックするユーザーを見直してください。");
			}
		} else if (registerUserID == null && registerPassword == null && lockUser == null && lockReleaseUser != null) {
			if (userManageLogic.userLockRelease(lockReleaseUser)) {
				request.setAttribute("rockReleaseMessage", "ロック解除しました。");
			} else {
				request.setAttribute("rockReleaseMessage", "ロック解除失敗しました。ロック解除するユーザーを見直してください。");
			}
		}

		List<String> targetLockUserList = userManageLogic.lockReleaseUserListGet();
		request.setAttribute("targetLockUserList", targetLockUserList);
		List<String> targetLockReleaseUserList = userManageLogic.lockUserListGet();
		request.setAttribute("targetLockReleaseUserList", targetLockReleaseUserList);
		String forwardPath = "/WEB-INF/jsp/manageUser.jsp";
		RequestDispatcher dispacher = request.getRequestDispatcher(forwardPath);
		dispacher.forward(request, response);

	}

}
