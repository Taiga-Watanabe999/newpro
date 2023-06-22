package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteDAO {
	public boolean delete(int id) throws Exception {

		boolean deleteFrag = false;

		//deleteクエリ
		String deleteQuery = "DELETE FROM 商品管理 WHERE 商品ID =?";

		//DBに接続、ステートメントの作成
		try {
			PreparedStatement ps = DBManager.getConnection().prepareStatement(deleteQuery);

			//クエリの？部分に引数で受け取った数字をセット
			ps.setInt(1, id);
			ps.executeUpdate();

			//リソースの開放
			ps.close();
			DBManager.getConnection().close();
			
			//削除できた場合はtreuを返す
			deleteFrag = true;

			return deleteFrag;
		
		} catch (SQLException se) {
			//削除できなかった場合はfalseを返す
			deleteFrag = false;
			return deleteFrag;
		}

	}
}
