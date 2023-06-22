package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import BEAN.info;

public class SearchDAO {
	public List<info> search(String column, int value) throws Exception {
		
		List<info> list = new ArrayList<info>();
		String columnName = column;
		
		
		
		
		try {
			String searchQuery = "SELECT * FROM 商品管理 WHERE" + columnName +"= ?";

			//DBに接続
			PreparedStatement ps = DBManager.getConnection().prepareStatement(searchQuery);

			//クエリの？部分に値をセット
			ps.setInt(1, value);

			//クエリの実行,結果をrsに格納
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				info productInfo = new info();
				productInfo.setId(rs.getInt("商品ID"));
				productInfo.setProductName(rs.getString("商品名"));
				productInfo.setPrice(rs.getInt("価格"));
				productInfo.setDate(rs.getString("登録日時"));
				list.add(productInfo);
			}

			//リソースの解放
			rs.close();
			ps.close();
			DBManager.getConnection().close();
			
			return list;

		} catch (SQLException se) {
			se.printStackTrace();
			throw new Exception("データベースへの挿入中にエラーが発生しました。", se);
		}

	}
}
