/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hb;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.DBUtil;

/**
 *
 * @author QX
 */
public class HBInfor {
        public String  checkall(){
        String result="编号\t保养结果\n";
	Connection conn = DBUtil.getConnection();	
	String sql="select * from hb";
        System.out.println("   , kkkk  ");
	try {
             
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
                System.out.println("   , kkkk  ");
              while(rs.next()){//如果对象中有数据，就会循环打印出来
                String hno=rs.getString(1);
                String jg=rs.getString(2);
                result+= hno+"\t"+jg+"\n";
                System.out.println(hno+"   ,   "+jg);
        }
        return result;      
	
	} catch (SQLException e) {
		e.printStackTrace();
		return "";
	}finally{
		DBUtil.closeConn();
	}	
    }
    public boolean add(String hno, String hres )
    {
        Connection conn = DBUtil.getConnection();	
	String sql="insert into hb values (?,?)";
	try {
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, hno);
		ps.setString(2, hres);
		int i = ps.executeUpdate();
		if(i>0)
		{
			return true;
		}
	return false;	
	} catch (SQLException e) {
		e.printStackTrace();
		return false;
	}finally{
		DBUtil.closeConn();
	}
    }
}
