package model;

import java.util.ArrayList;
import java.util.List;

import dao.ZyankenDAO;
/**
 * 管理者ユーザーがユーザー登録・ユーザーロック・ユーザーロック解除を行うクラス
 */
public class UserManageLogic {
	/**
	 * ロックユーザーを取得するメソッド
	 * @return ロックユーザー一覧のリスト
	 */
	public List<String> lockUserListGet() {
		ZyankenDAO zdao = new ZyankenDAO();
		List<String> lockUserList = zdao.getReleaseLockUser();
		if (lockUserList == null) {
			return new ArrayList<String>();
		}

		return lockUserList;

	}
	/**
	 * ロックしていないユーザー一覧を取得するメソッド
	 * @return ロックしていないユーザー一覧のリスト
	 */
	public List<String> lockReleaseUserListGet() {
		ZyankenDAO zdao = new ZyankenDAO();
		List<String> lockReleaseUserList = zdao.getTargetLockUser();
		if (lockReleaseUserList == null) {
			return new ArrayList<String>();
		}
		return lockReleaseUserList;

	}

	/**
	 * ユーザー登録を行うメソッド
	 * @param login フォームから送られてきた登録ユーザー情報
	 * @return resultFlag ユーザー登録の処理結果（true:成功 false:失敗）
	 */
	public boolean userRegisterCheck(Login login) {

		ZyankenDAO zdao = new ZyankenDAO();
		Boolean resultFlag = zdao.addLoginUser(login);
		return resultFlag;

	}

	/**
	 * ユーザーロックを行うメソッド
	 * @param loginUser ロック対象のユーザー
	 * @return resultFlag ユーザーロックの処理結果（true:成功 false:失敗）
	 */
	public boolean userLockCheck(String loginUser) {
		ZyankenDAO zdao = new ZyankenDAO();
		Boolean resultFlag = zdao.addLockLoginUser(loginUser);
		return resultFlag;
	}
	/**
	 * ユーザーロック解除を行うメソッド
	 * @param logckUser ロック解除対象のユーザー
	 * @return resultFlag ロック解除の処理結果（true:成功 false:失敗）
	 */
	public boolean userLockRelease(String lockUser) {
		ZyankenDAO zdao = new ZyankenDAO();
		Boolean resultFlag = zdao.deleteLockUser(lockUser);
		return resultFlag;
	}

}
