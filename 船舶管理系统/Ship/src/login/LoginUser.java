/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.DBUtil;

/**
 *
 * @author QX
 */
public class LoginUser {
    	public boolean queryUser(String zh,String mm){
		Connection conn = DBUtil.getConnection();	
		String sql="select * from gly where zh=? and mm=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, zh);
			ps.setString(2, mm);
			ResultSet rs = ps.executeQuery();
		
			if(rs.next()){
				return true;
			}else{
				return false;
			}
	
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally{
			DBUtil.closeConn();
		}
		
	}
        public boolean queryStaff(String zh,String mm){
		Connection conn = DBUtil.getConnection();	
		String sql="select * from czy where zh=? and mm=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, zh);
			ps.setString(2, mm);
			ResultSet rs = ps.executeQuery();
		
			if(rs.next()){
				return true;
			}else{
				return false;
			}
	
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally{
			DBUtil.closeConn();
		}
		
	}
}
