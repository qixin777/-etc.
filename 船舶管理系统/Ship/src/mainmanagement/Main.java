/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainmanagement;


import util.DBUtil;
import login.Login;
import workplan.WorkPlan;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author QX
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        DBUtil.conn=DBUtil.getConnection();
        // TODO code application logic here
                //3.通过数据库的连接操作数据库，实现增删改查
        Statement stmt = DBUtil.conn.createStatement();
        //ResultSet executeQuery(String sqlString)：执行查询数据库的SQL语句   ，返回一个结果集（ResultSet）对象。
        ResultSet rs = stmt.executeQuery("select gno,name from gly");
        while(rs.next()){//如果对象中有数据，就会循环打印出来
            System.out.println(rs.getInt("gno")+","+rs.getString("name"));
        }
        new Login();
    }
    
}
