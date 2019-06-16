import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Statement;
public class DataInterface {
	 public static  void  addStudent(String stuNo,String stuName){
	        Connection conn = DBUtil.getConn();	
	    	String sql="insert into stuinfo values (?,?)";
	    	try {   
	    		PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, stuNo);
	    		ps.setString(2, stuName);
	            ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConn();
		}	
	    }
	 public static void updateStudent(String stuNo,String stuName)
	 {
		 Connection conn = DBUtil.getConn();
			//String sql="update stuinfo set stuName=? where stuNo=?;";	
			String sql="update stuinfo set stuName='"+stuName+"' where stuNo= '"+stuNo+"'";	
			try {
		         Statement stmt = (Statement) conn.createStatement();
		         stmt.executeUpdate(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
		            DBUtil.closeConn();
			}
	
	 }
	 public static void deleteStudent(String stuNo)
	 {
		 Connection conn = DBUtil.getConn();
			String sql="delete from stuinfo where stuNo= '"+stuNo+"'";	
			try {
		         Statement stmt = (Statement) conn.createStatement();
		         stmt.executeUpdate(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
		            DBUtil.closeConn();
			}
	 }
	 public static void getStudent()
	 {
		 Constant.stu.clear();
		 Connection conn = DBUtil.getConn();	
		 Statement stmt;
		try {
		 stmt = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		
		 ResultSet rset = stmt.executeQuery("select * from stuinfo");
		 while(rset.next()){
			 String stuNo=rset.getString("stuNo");
			 String stuName=rset.getString("stuName");
			 Constant.stu.add(new Student(stuNo,stuName));
		 }
		 
		 rset.last();
		 int rowCount = rset.getRow(); //获得ResultSet的总行数
		 System.out.println(rowCount);
	
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 public static void addCall(String stuNo,String stuName)
	 {
		 Connection conn = DBUtil.getConn();	
	    	String sql="insert into stucall values (?,?)";
	    	try {   
	    		PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, stuNo);
	    		ps.setString(2, stuName); 
	            ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConn();
		}	
	 }
	 public static String getHistoryCall()
	 {
		 String result="学号\t姓名\n";
		 Constant.stu.clear();
		 Connection conn = DBUtil.getConn();	
		 Statement stmt;
		 try {
		 stmt = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);

		 ResultSet rset = stmt.executeQuery("select * from stucall");
		 while(rset.next()){
			 String stuNo=rset.getString("stuNo");
			 String stuName=rset.getString("stuName");
			 result+=stuNo+"\t"+stuName+"\n";
			System.out.println("call ::   "+stuNo+"      "+stuName);
		 }
		 return result;
		 
		 
		 } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return result;
	 }
	 public static void studentLeft(Student stu)
	 {
		 Connection conn = DBUtil.getConn();	
	    	String sql="insert into stunotcall values (?,?)";
	    	try {   
	    		PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, stu.stuNo);
	    		ps.setString(2, stu.stuName); 
	            ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConn();
		}	
	 }
	 public static void getstudentLeft()
	 {
		 Constant.stuLeft.clear();
		 Connection conn = DBUtil.getConn();	
		 Statement stmt;
		try {
		 stmt = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		
		 ResultSet rset = stmt.executeQuery("select * from stunotcall");
		 while(rset.next()){
			 String stuNo=rset.getString("stuNo");
			 String stuName=rset.getString("stuName");
			 Constant.stuLeft.add(new Student(stuNo,stuName));
		 }
		 
		 rset.last();
		 int rowCount = rset.getRow(); //获得ResultSet的总行数
		 System.out.println(rowCount);
		 
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	
}
