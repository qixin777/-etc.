/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workplan;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import util.DBUtil;
import static util.DBUtil.conn;

/**
 *
 * @author QX
 */
public class WorkPlan {
    public void delete(String jno)
    {
        Connection conn = DBUtil.getConnection();
	String sql="DELETE FROM jh WHERE jno= '"+jno+"'";	
	try {
                Statement stmt = conn.createStatement();
                stmt.executeUpdate(sql);
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
            DBUtil.closeConn();
	}
    }
    public boolean add(String jno, String jnr,Date k,Date js )
    {
        Connection conn = DBUtil.getConnection();	
	String sql="insert into jh values (?,?, ?,?)";
	try {
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, jno);
		ps.setString(2, jnr);
		ps.setDate(3, k);  
		ps.setDate(4,js);
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
    public String  checkall(){
        String result="编号\t内容\t\t\t开始时间\t结束时间\t\n\n";
	Connection conn = DBUtil.getConnection();	
	String sql="select * from jh";
        System.out.println("   , kkkk  ");
	try {
             
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
                System.out.println("   , kkkk  ");
              while(rs.next()){//如果对象中有数据，就会循环打印出来
                String no=rs.getString(1);
                String jnr=rs.getString(2);
                Date k=rs.getDate(3);
                Date js=rs.getDate(4);
                result+=no+"\t"+jnr+"\t"+k+"\t"+js+"\n";
                System.out.println(no+"   ,   "+jnr+"       ,     "+k+"   ,   "+js);
        }
        return result;      
	
	} catch (SQLException e) {
		e.printStackTrace();
		return "";
	}finally{
		DBUtil.closeConn();
	}	
    }

     public boolean change(String jno, String jnr,Date k,Date js )
    {
        Connection conn = DBUtil.getConnection();	
	String sql="Update jh Set jno=?,jnr=?,ks=?,js=? where jno=?;";
	try {
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, jno);
		ps.setString(2, jnr);
		ps.setDate(3, k);  
		ps.setDate(4,js);
                ps.setString(5,jno);
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
