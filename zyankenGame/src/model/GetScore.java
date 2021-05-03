package model;

import java.io.Serializable;
/**
 * ユーザーのジャンケンスコア
 */
public class GetScore  implements Serializable{
	private String userID;
	private int total;
	private int rank;

	public  GetScore(String userID,int total,int rank) {
		this.userID=userID;
		this.total=total;
		this.rank=rank;
	}

	/**
	 * @return userID
	 */
	public String getUserID() {
		return userID;
	}

	/**
	 * @return total
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * @return rank
	 */
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank=rank;
	}


}
