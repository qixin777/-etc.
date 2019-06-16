package com.hk;

import java.util.Vector;
import java.util.Scanner;
import java.text.MessageFormat;

public class Library {
//    Scanner input=new Scanner(System.in);
    Vector<Book> vectorBook;
    String fileName="D://data//out.pl";
    
    public Library()
    {
    	vectorBook=new Vector<Book>();
    }
    
    public Library(Vector<Book> vec)
    {
    	vectorBook=vec;
    }
    
    //��ӡϵͳ�б�
    public void printfInfo()
    {
    	
    	for(Book book:vectorBook)
    	{
    		String info="";
    		info+="���:"+book.getBookId()+"\n��������:"+book.getAuthor()+"\n����:"+book.getBookName()+"\n����:"+book.getBookPrice()+"\n������:"+book.getBookHouse()+"\n";
    		System.out.println(info);
    	}
    }
    //����һ����
    public void addBook(Book book)
    {
    	vectorBook.addElement(book);
    }
    //ɾ��һ����
    public void deleteBook(int BookId)
    {
    	for(Book bk:vectorBook)
    	{
    		if(BookId==bk.getBookId())
    		{
    			vectorBook.remove(bk);
    			break;
    		}
    	}
    	
    }
    //����һ����
    public Book searchBook(int BookId)
    {
    	for(Book bk:vectorBook)
    	{
    		if(BookId==bk.getBookId())
    		{
    			return bk;
    		}
    	}
    	return null;
    }
    //�뿪ϵͳ
    public void exit()
    {
    	try
    	{
    		int i=0;
    		for(Book book:vectorBook)
    		{
    			if(i==0)
    			{
    				SerializeAndDeserialize.SerializeBook(fileName,book,true);//���л�Book����
    			}else{
    				SerializeAndDeserialize.SerializeBook(fileName,book,false);//���л�Book����
    			}
    			
    			i++;
    		}
    		
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    //����ϵͳ
    public void enter()
    {
    	try
    	{
    		vectorBook= SerializeAndDeserialize.DeserializeBook(fileName);//������Book����
    		
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    	}

    }
}
