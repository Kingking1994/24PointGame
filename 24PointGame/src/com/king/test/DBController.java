package com.king.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 用于对结果数据的操作
 * @author king
 *
 */
public class DBController {
	
	/**
	 * 保存结果
	 * @param result
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static int save(Set<String> resultSet,Data data) throws Exception{
		int cnt = 0;
		//判断是否有解
		if (resultSet != null) {
			
			String datastring = Util.changeDataToString(data);
			Connection conn = DBHelper.getConnection();
			PreparedStatement stmt = null;
			
			Iterator<String> iter = resultSet.iterator();
			
			while (iter.hasNext()) {
				String sqlstring = "INSERT INTO solution (datastring,solutionstring) VALUES (?,?)";
				stmt = conn.prepareStatement(sqlstring);
				stmt.setString(1, datastring);
				stmt.setString(2, iter.next());
				stmt.execute();
				cnt++;
				
			}
			
			if(stmt!=null){
				stmt.close();
				stmt = null;
			}
		}

		return cnt;
	}
	
	/**
	 * 判断记录是否存在
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static boolean exists(Data data) throws Exception{
		Connection conn = DBHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String datastring = Util.changeDataToString(data);
		String sql = "select COUNT(*) from solution where datastring = ?";
		
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, datastring);
		rs = stmt.executeQuery();
		int result = 0;
		if (rs.next()) {
			result = rs.getInt("COUNT(*)");
		}	
		
		if (rs !=null) {
			rs.close();
			rs = null;
		}
		if (stmt !=null) {
			stmt.close();
			stmt = null;
		}
		
		if (result == 0) {
			return false;
		}else{
			return true;
		}
	}
}
