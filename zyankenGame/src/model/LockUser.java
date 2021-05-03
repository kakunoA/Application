package model;

import java.io.Serializable;
/**
 * ロックユーザー情報Beanクラス
 */
public class LockUser implements Serializable {
	private String userID;
	private String rockDateTime;

	public LockUser(String userID,String rockDateTime) {
		this.userID=userID;
		this.rockDateTime=rockDateTime;
	}

	/**
	 * @return userID
	 */
	public String getUserID() {
		return userID;
	}

	/**
	 * @return rockDateTime
	 */
	public String getRockDateTime() {
		return rockDateTime;
	}

}
