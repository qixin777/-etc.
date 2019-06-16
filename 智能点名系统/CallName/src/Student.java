
public class Student {
	String stuNo;
	String stuName;
	int stuGrade=100;
	public Student(String stuNo,String stuName)
	{
		this.stuNo=stuNo;
		this.stuName=stuName;
	}
	public void  recoverStuGrade()
	{
		this.stuGrade=100;
	}
	public void changeStuGrade(int stuGrade)
	{
		this.stuGrade-=stuGrade;
	}
	public String toString()
	{
		return stuNo+"\t"+stuName;
	}

}
