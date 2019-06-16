package com.hk;

import java.util.Scanner;

public class Main {
	public static boolean isExit=false;
	public static Library library;
	
	public static void main(String[] args){
		
		System.out.println("============开始============");
		
		library=new Library();
		
		library.enter();
		
		System.out.println("您已进入图书馆系统");
		
		while(!isExit)
		{
			System.out.println("请选择您要进行的图书操作");
			System.out.println("============================");
			System.out.println("1-打印系统列表(书号，作者姓名，书名，定价，出版社)");
			System.out.println("2-增加一本新书");
			System.out.println("3-查找一本新书");
			System.out.println("4-删除一本书");
			System.out.println("5-离开系统");
			System.out.println("============================");
			System.out.println("清输入您的选择(写下对应的序号回车即可)");
		
			int index=new Scanner(System.in).nextInt();
			switch(index)
			{
				case 1:print();break;
				case 2:add();break;
				case 3:search();break;
				case 4:delete();break;
				case 5:isExit=true;System.out.println("图书馆信息已经更新！");break;
				default:System.out.println("输入错误，即将退出");break;
			}
		}
		
		library.exit();
	}
	
	public static void print()
	{
		library.printfInfo();
		System.out.println("============================");
	}
	
	public static void add()
	{
		
		System.out.println("输入你要添加的书号，作者姓名，书名，定价，出版社(以','分开)");
		try
		{
			String str=new Scanner(System.in).nextLine();
			String strArra[]=str.split(",");
			Book book=new Book(Integer.parseInt(strArra[0]),strArra[1],strArra[2],Float.parseFloat(strArra[3]),strArra[4]);
			library.addBook(book);
			System.out.println("添加成功！");
		}catch(Exception e){
			System.out.println("输入错误，即将返回");
		}finally
		{
			System.out.println("============================");
		}
	}
	
	public static void search()
	{
		System.out.println("请输入要查找的图书的书号");
		try
		{
			int id=new Scanner(System.in).nextInt();
			Book book=library.searchBook(id);
			String info="";
			info+="书号:"+book.getBookId()+"\n作者姓名:"+book.getAuthor()+"\n书名:"+book.getBookName()+"\n出版社:"+book.getBookHouse()+"\n定价:"+book.getBookPrice();
			System.out.println("查找成功！");
			System.out.println(info);
		}catch(Exception e)
		{
			System.out.println("输入错误，即将返回");
		}finally
		{
			System.out.println("============================");
		}
	}
	
	public static void delete()
	{
		System.out.println("请输入要删除的图书的书号");
		try
		{
			int id=new Scanner(System.in).nextInt();
			library.deleteBook(id);
			System.out.println("删除成功!");
		}catch(Exception e)
		{
			System.out.println("输入错误，即将返回");
		}finally
		{
			System.out.println("============================");
		}
	}
}
