package model;

import dao.ZyankenDAO;
/**
 * ログイン処理を行うクラス
 */
public class LoginLogic {
	/**
	 * ログインユーザーチェックを行うメソッド
	 * @param login フォームから送られてきたログインユーザー情報
	 * @return loginUser 登録ログインユーザー情報（DBからの返却値）
	 */

	public Login checkLogin(Login login) {
		ZyankenDAO dao=new ZyankenDAO();
		Login loginUser=dao.findLoginUser(login);
		return loginUser;
	}
	/**
	 * ログインユーザーが現時点で管理者がロックしているかチェックするメソッド
	 * @param login フォームから送られてきたログインユーザー情報
	 * @return notLockUser 登録ログインユーザー情報（DBからの返却値）
	 */
	public Login checkLockUser(Login login) {
		ZyankenDAO dao=new ZyankenDAO();
		Login notLockUser=dao.findNotLockUser(login);
		return notLockUser;

	}
}
