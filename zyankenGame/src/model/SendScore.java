package model;

import java.io.Serializable;
/**
 * スコア情報のBeanクラス
 */
public class SendScore  implements Serializable{
	private String userID;
	private int total;

	public SendScore(String userID, int total) {
		this.userID = userID;
		this.total = total;
	}

	/**
	 * @return userID
	 */
	public String getUserID() {
		return userID;
	}

	/**
	 * @return total
	 */
	public int getTotal() {
		return total;
	}

}
