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
                //3.ͨ�����ݿ�����Ӳ������ݿ⣬ʵ����ɾ�Ĳ�
        Statement stmt = DBUtil.conn.createStatement();
        //ResultSet executeQuery(String sqlString)��ִ�в�ѯ���ݿ��SQL���   ������һ���������ResultSet������
        ResultSet rs = stmt.executeQuery("select gno,name from gly");
        while(rs.next()){//��������������ݣ��ͻ�ѭ����ӡ����
            System.out.println(rs.getInt("gno")+","+rs.getString("name"));
        }
        new Login();
    }
    
}
