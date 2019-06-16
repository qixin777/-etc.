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
    
    //打印系统列表
    public void printfInfo()
    {
    	
    	for(Book book:vectorBook)
    	{
    		String info="";
    		info+="书号:"+book.getBookId()+"\n作者姓名:"+book.getAuthor()+"\n书名:"+book.getBookName()+"\n定价:"+book.getBookPrice()+"\n出版社:"+book.getBookHouse()+"\n";
    		System.out.println(info);
    	}
    }
    //增加一本书
    public void addBook(Book book)
    {
    	vectorBook.addElement(book);
    }
    //删除一本书
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
    //查找一本书
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
    //离开系统
    public void exit()
    {
    	try
    	{
    		int i=0;
    		for(Book book:vectorBook)
    		{
    			if(i==0)
    			{
    				SerializeAndDeserialize.SerializeBook(fileName,book,true);//序列化Book对象
    			}else{
    				SerializeAndDeserialize.SerializeBook(fileName,book,false);//序列化Book对象
    			}
    			
    			i++;
    		}
    		
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    //进入系统
    public void enter()
    {
    	try
    	{
    		vectorBook= SerializeAndDeserialize.DeserializeBook(fileName);//反序列Book对象
    		
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    	}

    }
}
