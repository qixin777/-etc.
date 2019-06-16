package com.hk;

import java.util.Scanner;

public class Main {
	public static boolean isExit=false;
	public static Library library;
	
	public static void main(String[] args){
		
		System.out.println("============��ʼ============");
		
		library=new Library();
		
		library.enter();
		
		System.out.println("���ѽ���ͼ���ϵͳ");
		
		while(!isExit)
		{
			System.out.println("��ѡ����Ҫ���е�ͼ�����");
			System.out.println("============================");
			System.out.println("1-��ӡϵͳ�б�(��ţ��������������������ۣ�������)");
			System.out.println("2-����һ������");
			System.out.println("3-����һ������");
			System.out.println("4-ɾ��һ����");
			System.out.println("5-�뿪ϵͳ");
			System.out.println("============================");
			System.out.println("����������ѡ��(д�¶�Ӧ����Żس�����)");
		
			int index=new Scanner(System.in).nextInt();
			switch(index)
			{
				case 1:print();break;
				case 2:add();break;
				case 3:search();break;
				case 4:delete();break;
				case 5:isExit=true;System.out.println("ͼ�����Ϣ�Ѿ����£�");break;
				default:System.out.println("������󣬼����˳�");break;
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
		
		System.out.println("������Ҫ��ӵ���ţ��������������������ۣ�������(��','�ֿ�)");
		try
		{
			String str=new Scanner(System.in).nextLine();
			String strArra[]=str.split(",");
			Book book=new Book(Integer.parseInt(strArra[0]),strArra[1],strArra[2],Float.parseFloat(strArra[3]),strArra[4]);
			library.addBook(book);
			System.out.println("��ӳɹ���");
		}catch(Exception e){
			System.out.println("������󣬼�������");
		}finally
		{
			System.out.println("============================");
		}
	}
	
	public static void search()
	{
		System.out.println("������Ҫ���ҵ�ͼ������");
		try
		{
			int id=new Scanner(System.in).nextInt();
			Book book=library.searchBook(id);
			String info="";
			info+="���:"+book.getBookId()+"\n��������:"+book.getAuthor()+"\n����:"+book.getBookName()+"\n������:"+book.getBookHouse()+"\n����:"+book.getBookPrice();
			System.out.println("���ҳɹ���");
			System.out.println(info);
		}catch(Exception e)
		{
			System.out.println("������󣬼�������");
		}finally
		{
			System.out.println("============================");
		}
	}
	
	public static void delete()
	{
		System.out.println("������Ҫɾ����ͼ������");
		try
		{
			int id=new Scanner(System.in).nextInt();
			library.deleteBook(id);
			System.out.println("ɾ���ɹ�!");
		}catch(Exception e)
		{
			System.out.println("������󣬼�������");
		}finally
		{
			System.out.println("============================");
		}
	}
}
