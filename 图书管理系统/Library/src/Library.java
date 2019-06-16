

import java.util.Vector;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.text.MessageFormat;

public class Library {
    Vector<Book> vectorBook;
    String fileName="D://data//out.pl";
    int bookIndex;
    
    public Library()
    {
    	vectorBook=new Vector<Book>();
    }
    
    public Library(Vector<Book> vec)
    {
    	vectorBook=vec;
    }
    

    public void display(){
    	
    	for(Book book:vectorBook)
    	{
    		System.out.println(book.toString());
    	}
    }
    //增加一本书
    public void addBook(Book book)
    {
    	vectorBook.addElement(book);
    }
    //删除一本书
    public void deleteBook(String ISBN)
    {
    	for(Book bk:vectorBook)
    	{
    		if(ISBN.equals(bk.getBookISBN()))
    		{
    			vectorBook.remove(bk);
    			break;
    		}
    	}
    	
    }
    //查找一本书
    public Book searchBook(String ISBN)
    {
    	for(Book bk:vectorBook)
    	{
    		if(ISBN.equals(bk.getBookISBN()))
    		{
    			return bk;
    		}
    	}
    	return null;
    }
  //查找一本书
    public Book searchBookISBN(String ISBN)
    {	
    	Book bk = null;
    	for(int i=0;i<vectorBook.size();i++)
    	{
    		if(ISBN.equals(vectorBook.get(i).getBookISBN()))
    		{
    			bookIndex=i;
    			bk=vectorBook.get(i);
    			System.out.println(bk.toString());
    			return bk;
    		}
    	}
    	return null;
    }
  //查找一本书
    public Book searchBookAT(String at)
    {
    	StringTokenizer st=new StringTokenizer(at,"+");
		int index=0;
		String title="";
		String author="";
    	while(st.hasMoreElements())
		{
    		String si=(String) st.nextElement();
    		if(index==0)
    		{
    			title=si;
    		}else{
    			author=si.substring(1);
    		}
			index++;
		}

    	 Vector<Book> titleBook=new Vector<Book>();;
    	for(Book bk:vectorBook)
    	{
    		int j=0;
    		for(int i=0;i<title.length();i++){

    			if(title.charAt(i)==bk.getBookTitle().charAt(j)){
    				j++;
    			}
    			if(j==bk.getBookTitle().length()){
    				break;
    			}
    			
    		}
    		if(j==title.length()-1)
    		{
    			titleBook.add(bk);
    		}

    	}
    	for(Book bk:titleBook)
    	{
    		int j=0;
    		for(int i=0;i<author.length();i++){
 
    			if(author.charAt(i)==bk.getAuthor().charAt(j)){
    				j++;
    			}
    			if(j==bk.getAuthor().length()){
    				break;
    			}
    			
    		}
    		//System.out.println(j+"  "+author.length());
    		if(j==author.length())
    		{
    			System.out.println(bk.toString());
    			
    			return bk;
    		}
    		

    	}
    	return null;
    }
    public  Vector<Book> searchBookKW(String kw){
    	Vector<Book> resultBook=new Vector<Book>();
    	for(Book bk:vectorBook)
    	{
    		int j=0;
    	
    		String ISBN=bk.getBookISBN();
    		
    		for(int i=0;i<ISBN.length();i++){
    			if(ISBN.charAt(i)==kw.charAt(j)){
    				j++;
    			}
    		}
    		if(j==kw.length())
    		{
    			resultBook.add(bk);
    			continue;
    		}
    		
    		String title=bk.getBookTitle();
    		j=0;
    		for(int i=0;i<title.length();i++){
    			if(title.charAt(i)==kw.charAt(j)){
    				j++;
    			}
    			if(j==kw.length())
    			{
    				break;
    			}
    		}
    		if(j==kw.length())
    		{
    			resultBook.add(bk);continue;
    		}
    		
    		String author=bk.getAuthor();
    		j=0;
    		for(int i=0;i<author.length();i++){
    			if(author.charAt(i)==kw.charAt(j)){
    				j++;
    			}
    		}
    		if(j==kw.length())
    		{
    			resultBook.add(bk);continue;
    		}
    		
    		String category=bk.getCategory();
    		j=0;
    		for(int i=0;i<category.length();i++){
    			if(category.charAt(i)==kw.charAt(j)){
    				j++;
    			}
    		}
    		if(j==kw.length())
    		{
    			resultBook.add(bk);continue;
    		}
    	}
    	Collections.sort(resultBook,new BookComparator(2));
		return resultBook;
    	
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
