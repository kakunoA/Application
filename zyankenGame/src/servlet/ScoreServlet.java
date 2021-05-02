package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.GetScore;
import model.Login;
import model.ScoreLogic;
import model.SendScore;

/**
 * ジャンケン勝利ユーザーのスコア送信を行うサーブレットクラス
 */
@WebServlet("/ScoreServlet")
public class ScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int total = Integer.parseInt(request.getParameter("total"));
		HttpSession session = request.getSession();
		Login loginUser = (Login) session.getAttribute("loginUser");
		String userID = loginUser.getUserID();
		SendScore sendScore = new SendScore(userID, total);
		ScoreLogic scoreLogic = new ScoreLogic();
		List<GetScore> resultList = scoreLogic.executeGetScoreView(sendScore);
		request.setAttribute("scoreView", resultList);
		int getRanking = scoreLogic.executeGetUserRanking(sendScore);
		request.setAttribute("userRanking", getRanking);
		RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/jsp/zyankenScore.jsp");
		dispacher.forward(request, response);

	}

}
