package util;

import java.sql.*;

public class DBUtil {


    private final static String URL = "jdbc:sqlserver://127.0.0.1:1433;databaseName=work";
    private static final String USER="sa";
    private static final String PASSWORD="123";
    
    public static Connection conn=null;

    

    public static Connection getConnection(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            conn=(Connection)DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
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


    public static void main(String[] args) throws Exception{
        conn=getConnection();

        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery("select gno,name from gly");
        while(rs.next()){//如果对象中有数据，就会循环打印出来
            System.out.println(rs.getInt("gno")+","+rs.getString("name"));
        }}
      
    

}