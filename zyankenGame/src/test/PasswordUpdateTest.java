package test;

import dao.ZyankenDAO;
import model.DBUtil;
import model.PasswordInfo;

public class PasswordUpdateTest {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		DBUtil dbutil=new DBUtil();
		dbutil.dbConnection();
		PasswordInfo passInfo = new PasswordInfo("suzuki", "suzuki11", "suzuki00");
		ZyankenDAO zdo = new ZyankenDAO();
		boolean result=zdo.upDateLoginUserPassword(passInfo);
		if(result) {
			System.out.println("パスワード変更しました");
		}else {
			System.out.println("パスワード変更失敗");
		}
		dbutil.dbConnectionClose();

	}

}
