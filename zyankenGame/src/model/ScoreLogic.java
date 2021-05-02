package model;

import java.util.List;

import dao.ZyankenDAO;
/**
 * ジャンケンスコア表示とユーザーのランキングを表示するクラス
 */
public class ScoreLogic {
	/**
	 * ジャンケンスコアを表示するメソッド
	 * @param sendScore ジャンケン勝利ユーザーのスコア情報
	 * @return resultList ジャンケンスコア上位8位までの表
	 */
	public List<GetScore> executeGetScoreView(SendScore sendScore) {
		ZyankenDAO zdao = new ZyankenDAO();
		zdao.sendScoreInfo(sendScore);
		List<GetScore> resultList = zdao.getScoreTable();
		resultList = zdao.getScoreView(resultList);
		return resultList;

	}
	/**
	 * ジャンケン勝利ユーザーのスコアランキングを表示するメソッド
	 * @param sendScore ジャンケン勝利ユーザーのスコア情報
	 * @return resultRanking ジャンケン勝利ユーザーのスコアランキング
	 */
	public int executeGetUserRanking(SendScore sendScore) {
		ZyankenDAO zdao = new ZyankenDAO();
		List<GetScore> resultList = zdao.getScoreTable();
		int resultRanking = zdao.getUserRanking(sendScore, resultList);
		return resultRanking;

	}

}
