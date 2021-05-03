package model;

import dao.ZyankenDAO;
/**
 * パスワード変更を行うクラス
 */
public class PasswordUpdateLogic {
	/**
	 *  パスワード変更を行うメソッド
	 * @param passwordInfo フォームから送られてきたユーザー情報
	 * @return result パスワード変更の処理結果
	 */
	public boolean execute(PasswordInfo passwordInfo) {
		boolean result;
		ZyankenDAO dao=new ZyankenDAO();
		result=dao.upDateLoginUserPassword(passwordInfo);
		return result;

	}

}
