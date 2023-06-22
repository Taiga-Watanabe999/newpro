package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDAO {
	public boolean update(int price , int id) throws Exception {
		String updateQuery = "UPDATE 商品管理 SET 価格 = ? WHERE 商品ID=" + id;
		boolean updateCheck = false;
		
		try {
			PreparedStatement ps = DBManager.getConnection().prepareStatement(updateQuery);

			//クエリの？部分に引数で受け取った価格をセット
			ps.setInt(1, price);
			ps.executeUpdate();

			//リソースの開放
			ps.close();
			DBManager.getConnection().close();
			
			//更新できた場合はtreuを返す
			updateCheck = true;

			return updateCheck;
		
		} catch (SQLException se) {
			//更新できなかった場合はfalseを返す
			updateCheck = false;
			
			return updateCheck;
		}

	}
}
