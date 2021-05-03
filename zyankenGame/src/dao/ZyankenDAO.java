package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.GetScore;
import model.Login;
import model.PasswordInfo;
import model.SendScore;
/**
 * DB操作を行うDAOクラス
 */
public class ZyankenDAO {
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/zyankenGame";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	private static Connection conn;

	 /**
     * DB接続を確立するメソッド
     */
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	 /**
     * DB接続の切断を行うメソッド
     */
	public void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}

	 /**
     * ログインチェックを行うメソッド
     * @param login formから送られてきたユーザー情報
     * @return findLoginUser DBに登録済みのログインユーザー情報
     */
	public Login findLoginUser(Login login) {
		Login loginUser = null;
		String sql = "SELECT USER_ID,PASSWORD FROM LOGININFO WHERE USER_ID=? AND PASSWORD=?";
		PreparedStatement pSmt = null;
		try {
			pSmt = conn.prepareStatement(sql);
			pSmt.setString(1, login.getUserID());
			pSmt.setString(2, login.getUserPass());
			ResultSet rs = pSmt.executeQuery();
			if (rs.next()) {
				String userID = rs.getString("USER_ID");
				String userPass = rs.getString("PASSWORD");
				loginUser = new Login(userID, userPass);
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return null;
		}
		return loginUser;

	}

	 /**
     * ユーザーIDに紐づくパスワードを変更するメソッド
     * @param passwordInfo formから送られてきたユーザー情報
     * @return クエリ実行結果（true:実行成功 false:実行失敗）
     */
	public boolean upDateLoginUserPassword(PasswordInfo passwordInfo) {
		int result = 0;
		String sql = "UPDATE LOGININFO SET PASSWORD=? WHERE USER_ID=? AND PASSWORD=?";
		PreparedStatement pSmt = null;
		try {

			pSmt = conn.prepareStatement(sql);
			pSmt.setString(1, passwordInfo.getUserNewPass());
			pSmt.setString(2, passwordInfo.getUserID());
			pSmt.setString(3, passwordInfo.getUserPass());
			result = pSmt.executeUpdate();
			if (result == 1) {
				conn.commit();
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO 自動生成された catch ブロック
				e1.printStackTrace();
			}
			e.printStackTrace();
			return false;
		}
		return true;

	}

	 /**
     * ジャンケンでユーザーが勝った時の結果をテーブルに反映するメソッド
     * @param  score ユーザーのスコア情報
     */
	public void sendScoreInfo(SendScore score) {
		int result = 0;
		String sql = "INSERT INTO SCOREINFO(USER_ID,TOTAL) VALUES(?,?)";
		PreparedStatement pSmt = null;
		try {
			pSmt = conn.prepareStatement(sql);
			pSmt.setString(1, score.getUserID());
			pSmt.setInt(2, score.getTotal());
			result = pSmt.executeUpdate();
			if (result == 1) {
				conn.commit();
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO 自動生成された catch ブロック
				e1.printStackTrace();
			}
		}

	}

	 /**
     * ジャンケンのスコア一覧を取得するメソッド
     * @return scoreList ジャンケンスコア一覧を表示
     */
	public List<GetScore> getScoreTable() {

		List<GetScore> scoreList = new ArrayList<GetScore>();
		String sql = "SELECT USER_ID,TOTAL FROM SCOREINFO ORDER BY TOTAL ASC";
		PreparedStatement pSmt = null;
		int giveRanking = 1;
		try {
			pSmt = conn.prepareStatement(sql);
			ResultSet rs = pSmt.executeQuery();
			while (rs.next()) {
				String userID = rs.getString("USER_ID");
				int total = rs.getInt("TOTAL");
				int ranking = giveRanking;
				GetScore getScore = new GetScore(userID, total, ranking);
				scoreList.add(getScore);
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return null;
		}
		//順位決める
		int i = 0;
		while (i < scoreList.size()) {
			int j = i + 1;
			while (j < scoreList.size() && scoreList.get(j).getTotal() == scoreList.get(i).getTotal()) {
				scoreList.get(j).setRank(giveRanking);
				j = j + 1;
			}
			if (j < scoreList.size()) {
				giveRanking = j + 1;
				scoreList.get(j).setRank(giveRanking);
			}
			i = j;

		}

		return scoreList;

	}

	 /**
     * ジャンケンのスコア一覧で上位8名分のみを取得するメソッド
     * @param  scoreList ジャンケンのスコア一覧リスト
     * @return viewList ジャンケンスコア上位8名分リスト
     */
	public List<GetScore> getScoreView(List<GetScore> scoreList) {
		List<GetScore> viewList = new ArrayList<GetScore>();
		int limit = 8;
		if (limit < scoreList.size()) {
			for (int i = 0; i < limit; i++) {
				viewList.add(scoreList.get(i));
			}

		} else {
			viewList = scoreList;
		}
		return viewList;

	}

	 /**
     * ジャンケンでユーザーが勝ったときのスコアを表示するメソッド
     * @param score プレイユーザーのスコア scoreList スコアテーブル
     * @return getRanking ジャンケン勝利ユーザーのランキング
     */
	public int getUserRanking(SendScore score, List<GetScore> scoreList) {
		int getRanking = 0;
		for (GetScore factor : scoreList) {
			if (factor.getTotal() == score.getTotal() && factor.getUserID() == score.getUserID()) {
				getRanking = factor.getRank();
				break;
			}
		}

		return getRanking;

	}

	 /**
     * プレイユーザーの追加を行うメソッド
     * @param  login フォームから送られてきた追加ユーザー情報
     * @return クエリ実行結果（true:実行成功 false:実行失敗）
     */
	public boolean addLoginUser(Login login) {
		int result = 0;
		String sql = "INSERT INTO LOGININFO(USER_ID,PASSWORD) VALUES(?,?)";
		PreparedStatement pSmt = null;
		try {

			pSmt = conn.prepareStatement(sql);
			pSmt.setString(1, login.getUserID());
			pSmt.setString(2, login.getUserPass());
			result = pSmt.executeUpdate();
			if (result == 1) {
				conn.commit();
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO 自動生成された catch ブロック
				e1.printStackTrace();
			}
			e.printStackTrace();
			return false;
		}
		return true;

	}


	 /**
    * ロックユーザーを追加するメソッド
    * @param loginUser フォームから送られてきたロック対象ユーザー
    * @return クエリ実行結果（true:実行成功 false:実行失敗）
    */
	public boolean addLockLoginUser(String loginUser) {
		int result = 0;
		String sql = "INSERT INTO LOCKINFO(USER_ID,LOCK_TIMESTAMP) VALUES(?,?)";
		PreparedStatement pSmt = null;
		try {

			pSmt = conn.prepareStatement(sql);
			pSmt.setString(1, loginUser);
			Date dateObj = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			pSmt.setString(2, format.format(dateObj));
			result = pSmt.executeUpdate();
			if (result == 1) {
				conn.commit();
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO 自動生成された catch ブロック
				e1.printStackTrace();
			}
			e.printStackTrace();
			return false;
		}
		return true;

	}

	 /**
    * ロックユーザーテーブルからロックユーザーを解除するメソッド
    * @param lockUser フォームから送られてきたロック解除対象ユーザー
    * @return クエリ実行結果（true:実行成功 false:実行失敗）
    */
	public boolean deleteLockUser(String lockUser) {
		int result = 0;
		String sql = "DELETE FROM LOCKINFO WHERE USER_ID=?";
		PreparedStatement pSmt = null;
		try {
			pSmt = conn.prepareStatement(sql);
			pSmt.setString(1, lockUser);
			result = pSmt.executeUpdate();
			if (result == 1) {
				conn.commit();
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO 自動生成された catch ブロック
				e1.printStackTrace();
			}
			e.printStackTrace();
			return false;
		}
		return true;

	}


	 /**
	    * ロックされているユーザー一覧を取得するメソッド
	    * @return userList  ロックされているユーザー一覧
	    */
	public List<String> getReleaseLockUser() {
		List<String> userList = new ArrayList<String>();
		String sql = "SELECT USER_ID FROM LOCKINFO";
		PreparedStatement pSmt = null;
		try {
			pSmt = conn.prepareStatement(sql);
			ResultSet rs = pSmt.executeQuery();
			while (rs.next()) {
				userList.add(rs.getString("USER_ID"));

			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return null;
		}
		return userList;
	}

	 /**
	    * ロックされていないユーザー一覧を取得するメソッド
	    * @return userList  ロックされていないユーザー一覧
	    */
	public List<String> getTargetLockUser() {
		List<String> userList = new ArrayList<String>();
		String sql = "SELECT USER_ID FROM LOGININFO L1 WHERE NOT EXISTS (SELECT * FROM LOCKINFO L2 WHERE L1.USER_ID=L2.USER_ID) AND L1.USER_ID<>'K10001'";
		PreparedStatement pSmt = null;
		try {
			pSmt = conn.prepareStatement(sql);
			ResultSet rs = pSmt.executeQuery();
			while (rs.next()) {
				userList.add(rs.getString("USER_ID"));

			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return null;
		}
		return userList;
	}

	 /**
	    * ログインユーザーが現時点でロック中でないかをチェックするメソッド
	    * @param login  フォームから送られてきたログインユーザー
	    */
	public Login findNotLockUser(Login login) {
		Login loginUser = null;
		String sql = "SELECT USER_ID,PASSWORD FROM LOGININFO L1 WHERE NOT EXISTS (SELECT * FROM LOCKINFO L2 WHERE L1.USER_ID=L2.USER_ID) AND L1.USER_ID=? and L1.PASSWORD=?";
		PreparedStatement pSmt = null;
		try {
			pSmt = conn.prepareStatement(sql);
			pSmt.setString(1, login.getUserID());
			pSmt.setString(2, login.getUserPass());
			ResultSet rs = pSmt.executeQuery();
			if (rs.next()) {
				String userID = rs.getString("USER_ID");
				String userPass = rs.getString("PASSWORD");
				loginUser = new Login(userID, userPass);
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return null;
		}
		return loginUser;

	}

}
