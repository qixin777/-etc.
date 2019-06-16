package com.hk;

import java.io.Serializable;

public class Book implements Serializable{
	private static final long serialVersionUID = -5809782578272943999L;
	
    private int BookId;//书号
    private String BookName;//标题
    private String Author;//作者姓名
    private float BookPrice;//价格
    private String BookHouse;//出版社
    
    public Book()
    {
  
    }
    
    public Book(int BookId,String Author,String BookName,float BookPrice,String BookHouse){
        this.BookId=BookId;
        this.BookName=BookName;
        this.Author=Author;
        this.BookPrice=BookPrice;
        this.BookHouse=BookHouse;
    }
    
    public void setBookId(int BookId){
        this.BookId=BookId;
        
    }
    public void setBookName(String BookName){
        this.BookName=BookName;
    }
    public void setAuthor(String Author){
        this.Author=Author;
    }
    public void setBookPrice(int BookPrice){
        this.BookPrice=BookPrice;
    }
    public void setBookHouse(String BookHouse){
        this.BookHouse=BookHouse;
    }
    public int getBookId(){
        return BookId;
    }
    public String getBookName(){
        return BookName;
    }
    public String getAuthor(){
        return Author;
    }
    public float getBookPrice(){
        return BookPrice;
    }
    public String getBookHouse(){
        return BookHouse;
    }
}
