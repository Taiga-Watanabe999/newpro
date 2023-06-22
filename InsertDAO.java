package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertDAO {

	public void insert(int id, String productName, int price, String date) throws Exception {
		String insertQuery = null;

		try {
			//インサートクエリ
			insertQuery = "INSERT INTO 商品管理(商品ID,商品名,価格,登録日時) values (?,?,?,?)";

			//DBに接続
			PreparedStatement ps = DBManager.getConnection().prepareStatement(insertQuery);

			//クエリの？部分に引数で受け取っid,pn,dateをセット
			ps.setInt(1, id);
			ps.setString(2, productName);
			ps.setInt(3, price);
			ps.setString(4, date);

			//クエリの実行
			ps.executeUpdate();

			//リソースの解放
			ps.close();
			DBManager.getConnection().close();

		} catch (SQLException se) {
			se.printStackTrace();
			throw new Exception("データベースへの挿入中にエラーが発生しました。", se);
		}

	}
}