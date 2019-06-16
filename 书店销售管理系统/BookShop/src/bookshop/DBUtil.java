/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookshop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class DBUtil{
    private static Connection conn;
   // private static final String URL = "jdbc:mysql://45.58.56.81:3306/anatomy?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true";//���ݿ����ָ�Ϊ���
    private static final String URL = "jdbc:mysql://localhost/bookshop?useUnicode=true&characterEncoding=UTF-8";//���ݿ����ָ�Ϊ���
   
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    static{
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConn(){
        try{
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    public static void closeConn(){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
 
        }
    }
   
}

