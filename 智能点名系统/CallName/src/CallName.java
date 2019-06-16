/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author QX
 */
public class CallName {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new MainFrame();
        
        
        FileUtil.read();
        
        randomCall();
        ruleCall();
        DataInterface.getHistoryCall();
        toForm();
    }
    public static String randomCall()
    {
    	DataInterface.getStudent();
    	int no=(int) (Constant.stu.size()*Math.random());
    	System.out.println(no);
    	System.out.println(Constant.stu.size());
    	//if(no==0){no=1;}
    	Student stu=Constant.stu.get(no);
    	System.out.println("random call:  "+stu.stuNo+"\t   "+stu.stuName);
    	String result="学号"+"\t"+"姓名"+"\n"+stu.stuNo+"\t   "+stu.stuName;
    	DataInterface.addCall(stu.stuNo,stu.stuName);
    	Constant.stuCall=stu;
    	return result;
    	
    }
    public static String ruleCall()
    {
    	DataInterface.getStudent();
    	for(int i=0;i<Constant.stu.size();i++)
    	{
    		Student stu=Constant.stu.get(i);
    		try{
    			int stuNo=Integer.parseInt(stu.stuNo);
        		if(stuNo%2==0)
        		{
        			Constant.stuRule.add(stu);
        		}
    		}catch(Exception e)
    		{
    			System.out.println("kkkkkkk");
    		}
    	}
    	System.out.println("rule :: "+Constant.stuRule.size());
    	int no=(int) (Constant.stuRule.size()*Math.random());
    	Student stu=Constant.stuRule.get(no);
    	String result="学号"+"\t"+"姓名"+"\n"+stu.stuNo+"\t   "+stu.stuName;
    	DataInterface.addCall(stu.stuNo,stu.stuName);
    	Constant.stuCall=stu;
    	
    	Constant.stuRule.clear();
    	return result;
    }
    public static String priorCall(){
    	DataInterface.getstudentLeft();
    	if(Constant.stuLeft.size()==0)
		{
			System.out.println( "no people notcall");
			return "目前没有人缺勤，\n请选择随机点名，或规律点名。";
		}
    	if(Math.random()>0.5)
    	{
    		System.out.println( "prior random Call 。。。。");
    		return randomCall();
    	}else{
    		System.out.println( "prior       Call 。。。。");
    		int no=(int) (Constant.stuLeft.size()*Math.random());
        	System.out.println(no);
        	System.out.println(Constant.stuLeft.size());
        	//if(no==0){no=1;}
        	Student stu=Constant.stuLeft.get(no);
        	System.out.println("random call:  "+stu.stuNo+"\t   "+stu.stuName);
        	String result="学号"+"\t"+"姓名"+"\n"+stu.stuNo+"\t   "+stu.stuName;
        	DataInterface.addCall(stu.stuNo,stu.stuName);
        	Constant.stuCall=stu;
        	return result;
    	}
    	
    }
    
    public static String toForm()
    {
    	
    	DataInterface.getstudentLeft();
    	DataInterface.getStudent();
    	
    	for(int i=0;i<Constant.stuLeft.size();i++)
    	{
    		Student stu1=Constant.stuLeft.get(i);
    		for(int j=0;j<Constant.stu.size();j++)
    		{
    			Student stu2=Constant.stu.get(j);
    			if(stu2.stuNo.equals(stu1.stuNo))
    			{
    				stu2.changeStuGrade(5); 
    				Constant.stu.set(j, stu2);
    			}
    		}
    	}
    	
    	String result="学号"+"\t"+"姓名"+"\t"+"成绩"+"\n";
    	for(int j=0;j<Constant.stu.size();j++)
		{
			Student stu2=Constant.stu.get(j);
			System.out.println(""+stu2.stuNo);
			result+=stu2.stuNo+"\t"+stu2.stuName+"\t"+stu2.stuGrade+"\n";
		}
    	System.out.println(""+result);
    	
    	for(int j=0;j<Constant.stu.size();j++)
		{
    		Student stu2=Constant.stu.get(j);
    		stu2.recoverStuGrade();
    		Constant.stu.set(j, stu2);
    		System.out.println("  ggghh :"+stu2.stuGrade);
		}
    	return result;
    }
    

}
