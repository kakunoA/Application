package test;

import model.DBUtil;
import model.Login;
import model.LoginLogic;

public class LoginLogicTest {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		DBUtil dbutil=new DBUtil();
		dbutil.dbConnection();
		Login login=new Login("suzuki","suzuki00");
		LoginLogic loginlogic=new LoginLogic();
		Login result=loginlogic.checkLogin(login);
		System.out.println(result.getUserID());
		dbutil.dbConnectionClose();

	}

}
