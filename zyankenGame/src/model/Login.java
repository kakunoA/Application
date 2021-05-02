package model;

import java.io.Serializable;
/**
 * ログイン情報Beanクラス
 */
public class Login implements Serializable {
	private String userID;
	private String userPass;
	/**
	 * @return userName
	 */
	public Login(String userID,String userPass) {
		this.userID=userID;
	    this.userPass=userPass;
	}

	public String getUserID() {
		return userID;
	}
	/**
	 * @return userPass
	 */
	public String getUserPass() {
		return userPass;
	}
}
