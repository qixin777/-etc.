/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package czy;

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
public class Operater {
     public String  checkWork(){
        String result="编号\t姓名\t是否工作\n\n";
	Connection conn = DBUtil.getConnection();	
	String sql="select * from czy";
        System.out.println("   , kkkk  ");
	try {
             
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
                System.out.println("   , kkkk  ");
              while(rs.next()){//如果对象中有数据，就会循环打印出来
                String no=rs.getString(1);
                String name=rs.getString(2);
                String iswork=rs.getString(7);
                result+=no+"\t"+name+"\t"+iswork+"\n";
                System.out.println(no+"\t"+name+"\t"+iswork);
        }
        return result;      
	
	} catch (SQLException e) {
		e.printStackTrace();
		return "";
	}finally{
		DBUtil.closeConn();
	}	
    }
}
