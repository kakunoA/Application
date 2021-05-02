package test;

import java.util.List;

import dao.ZyankenDAO;
import model.DBUtil;
import model.GetScore;
import model.SendScore;

public class TestScore {
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		DBUtil dbutil = new DBUtil();
		dbutil.dbConnection();
		SendScore sendscore = new SendScore("suzuki", 5);
		ZyankenDAO zdo = new ZyankenDAO();
		zdo.sendScoreInfo(sendscore);
		/*sendscore = new SendScore("suzuki", 6);
		zdo = new ZyankenDAO();
		zdo.sendScoreInfo(sendscore);
		sendscore = new SendScore("suzuki", 7);
		zdo = new ZyankenDAO();
		zdo.sendScoreInfo(sendscore);
		sendscore = new SendScore("suzuki", 8);
		zdo = new ZyankenDAO();
		zdo.sendScoreInfo(sendscore);
		sendscore = new SendScore("suzuki", 9);
		zdo = new ZyankenDAO();
		zdo.sendScoreInfo(sendscore);*/
		List<GetScore> result = zdo.getScoreTable();
		dbutil.dbConnectionClose();
		for(int i=0;i<result.size();i++) {
			System.out.println(result.get(i).getRank());
			System.out.println(result.get(i).getUserID());
			System.out.println(result.get(i).getTotal());
			System.out.println("-------------------------");
		}


	}

}
