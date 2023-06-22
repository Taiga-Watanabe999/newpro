package DAO;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import BEAN.info;

public class SelectDAO {
	
	List<info>list = new ArrayList<info>();
	
	public List<info> select() throws Exception{
		//クエリ
		String selectQuery = "SELECT * FROM 商品管理";
	
		//DBに接続
		Statement st = DBManager.getConnection().createStatement();
	
		//クエリの実行,rsに格納
		ResultSet rs = st.executeQuery(selectQuery);
		
		//rsに入っている情報をlistに格納
		while(rs.next()) {
			info productInfo = new info();
			productInfo.setId(rs.getInt("商品ID"));
			productInfo.setProductName(rs.getString("商品名"));
			productInfo.setPrice(rs.getInt("価格"));
			productInfo.setDate(rs.getString("登録日時"));
			list.add(productInfo);
		}
		
		//クローズ
		rs.close();
		st.close();
		DBManager.getConnection().close();
		
		return list;
	
	}
	
}
