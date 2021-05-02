package model;

import dao.ZyankenDAO;

/**
 * DB接続の初期設定を行うクラス
 */
public class DBUtil {
	/**
	* DB接続を行うメソッド
	*/
	public void dbConnection() {
		ZyankenDAO dao = new ZyankenDAO();
		dao.getConnection();
	}

	/**
	 * DB接続の切断を行うメソッド
	 */
	public void dbConnectionClose() {
		ZyankenDAO dao = new ZyankenDAO();
		dao.closeConnection();
	}

}
