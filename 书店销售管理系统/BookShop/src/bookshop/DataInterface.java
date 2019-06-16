/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookshop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author QX
 */
public class DataInterface {
    public String  allstore(){
        String result="图书编号\t图书名称\t图书价格\t库存数量\t销售数量\n";

	Connection conn = DBUtil.getConn();	
	String sql="select * from store";
	try {   
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
              
              while(rs.next()){//如果对象中有数据，就会循环打印出来
                String bookID=rs.getString(1);
                String bookName=rs.getString(2);
                String bookPrice=rs.getString(3);
                String bookSum=rs.getString(4);
                String bookSale=rs.getString(4);
              
                result+= bookID+"\t"+bookName+"\t"+bookPrice+"\t"+bookSum+"\t"+bookSale+"\n";
                System.out.println(bookID+"   ,   "+bookName+"   ,   "+bookPrice+"  , "+bookSum);
              }
        return result;      
	
	} catch (SQLException e) {
		e.printStackTrace();
		return "";
	}finally{
		DBUtil.closeConn();
	}	
    }
    public String  checkall(){
        String result="图书编号\t图书名称\t图书价格\t销售数量\n";
        int saleCount=0;
        float saleMoney=0;
	Connection conn = DBUtil.getConn();	
	String sql="select bookID,bookName,bookPrice,bookSale from store";
	try {   
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
              
              while(rs.next()){//如果对象中有数据，就会循环打印出来
                String bookID=rs.getString(1);
                String bookName=rs.getString(2);
                String bookPrice=rs.getString(3);
                String bookSum=rs.getString(4);
                saleMoney+=Integer.parseInt(bookSum)*Float.parseFloat(bookPrice);
                saleCount+=Integer.parseInt(bookSum);
                result+= bookID+"\t"+bookName+"\t"+bookPrice+"\t"+bookSum+"\n";
                System.out.println(bookID+"   ,   "+bookName+"   ,   "+bookPrice+"  , "+bookSum);
              }
              result+="销售总量：    "+saleCount+"\n";
              result+="销售总额：    "+saleMoney+"\n";
              System.out.println("销售总量：    "+saleCount);
              System.out.println("销售总额：    "+saleMoney);
        return result;      
	
	} catch (SQLException e) {
		e.printStackTrace();
		return "";
	}finally{
		DBUtil.closeConn();
	}	
    }
    public String  search(String id){
        String result="图书编号\t图书名称\t图书价格\t销售数量\n";
        int saleCount=0;
        float saleMoney=0;
	Connection conn = DBUtil.getConn();	
	String sql="select * from sum where bookID=?";
	try {   
		PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
              
              while(rs.next()){//如果对象中有数据，就会循环打印出来
                String bookID=rs.getString(1);
                String bookName=rs.getString(2);
                String bookPrice=rs.getString(3);
                String bookSum=rs.getString(4);
                saleMoney+=Integer.parseInt(bookSum)*Float.parseFloat(bookPrice);
                saleCount+=Integer.parseInt(bookSum);
                result+= bookID+"\t"+bookName+"\t"+bookPrice+"\t"+bookSum+"\n";
                System.out.println(bookID+"   ,   "+bookName+"   ,   "+bookPrice+"  , "+bookSum);
              }
            //  result+="销售总量：    "+saleCount+"\n";
            //  result+="销售总额：    "+saleMoney+"\n";
             // System.out.println("销售总量：    "+saleCount);
              System.out.println(result);
        return result;      
	
	} catch (SQLException e) {
		e.printStackTrace();
		return "";
	}finally{
		DBUtil.closeConn();
	}	
    }
    public String  intoStock(String bookID,String bookSupplier,int bookNum){
        String result="图书编号\t供应商\t进货数量\n";
	Connection conn = DBUtil.getConn();	
	String sql="insert into stock values (?,?,?)";
	try {   
		PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, bookID);
		ps.setString(2, bookSupplier);
		ps.setInt(3, bookNum);  
                ps.executeUpdate();
                result+= bookID+"\t"+bookSupplier+"\t"+bookNum+"\n";
                System.out.println(result);
                sql="select bookLeft from store where bookID=?;";
               
                ps = conn.prepareStatement(sql);
                ps.setString(1, bookID);
                ResultSet rs = ps.executeQuery();
                int num=0;
                 while(rs.next()){
                    num=rs.getInt(1);
                    System.out.println(num);
                }
                sql="Update store Set bookLeft=? where bookID=?;";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, num+bookNum);
		ps.setString(2, bookID);
                ps.executeUpdate();
        return result;      
	
	} catch (SQLException e) {
		e.printStackTrace();
		return result;
	}finally{
		DBUtil.closeConn();
                 return result;
	}
       
    }
    public String returnBook(String bookID,int bookNum){
        String result="图书编号\t退货数量\n";
	Connection conn = DBUtil.getConn();	
	String sql="insert into returnbook values (?,?)";
	try {   
		PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, bookID);
		ps.setInt(2, bookNum);
                ps.executeUpdate();
                result+= bookID+"\t"+bookNum+"\n";
                System.out.println(result);
                sql="select bookLeft,bookSale from store where bookID=?;";
                ps = conn.prepareStatement(sql);
                ps.setString(1, bookID);
                ResultSet rs = ps.executeQuery();
                int numLeft=0;
                int numSale=0;
                 while(rs.next()){
                    numLeft=rs.getInt(1);
                    System.out.println(numLeft);
                    numSale=rs.getInt(2);
                    System.out.println(numSale);
                }
                sql="Update store Set bookLeft=?,bookSale=? where bookID=?;";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, numLeft+bookNum);
                ps.setInt(2, numSale-bookNum);
		ps.setString(3, bookID);
                ps.executeUpdate();
                return result;
	} catch (SQLException e) {
		e.printStackTrace();
                return result;
	}finally{
		DBUtil.closeConn();
          
	}
       
    }
     public String saleBook(String bookID,int bookNum){
        String result="图书编号\t销售数量\n";
	Connection conn = DBUtil.getConn();	
	String sql="insert into sale values (?,?)";
	try {   
		PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, bookID);
		ps.setInt(2, bookNum);
                ps.executeUpdate();
                result+= bookID+"\t"+bookNum+"\n";
                System.out.println(result);
                sql="select bookLeft,bookSale from store where bookID=?;";
                ps = conn.prepareStatement(sql);
                ps.setString(1, bookID);
                ResultSet rs = ps.executeQuery();
                int numLeft=0;
                int numSale=0;
                 while(rs.next()){
                    numLeft=rs.getInt(1);
                    System.out.println(numLeft);
                    numSale=rs.getInt(2);
                    System.out.println(numSale);
                }
                sql="Update store Set bookLeft=?,bookSale=? where bookID=?;";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, numLeft-bookNum);
                ps.setInt(2, numSale+bookNum);
		ps.setString(3, bookID);
                ps.executeUpdate();
       
                return result;
	} catch (SQLException e) {
		e.printStackTrace();
                return result;
	}finally{
		DBUtil.closeConn();
          
	}
       
    }
}
