package model;

import java.io.Serializable;
/**
 * パスワード情報のBeanクラス
 */
public class PasswordInfo implements Serializable {

	private String userID;
	private String userPass;
	private String userNewPass;
	/**
	 * @return userName
	 */
	public PasswordInfo(String userID,String userPass,String userNewPass) {
		this.userID=userID;
	    this.userPass=userPass;
	    this.userNewPass=userNewPass;
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

	public String getUserNewPass() {
		return userNewPass;
	}


}
