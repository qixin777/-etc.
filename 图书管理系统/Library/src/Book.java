

import java.io.Serializable;

public class Book implements Serializable{
	private static final long serialVersionUID = -5809782578272943999L;
	
    private String ISBN;//书号
    private String Title;//标题
    private String Author;//作者姓名
    private String Category;//类别
    private int Copies;//copies
    private int CopiesAvailable;//copies avaliable
    private float BookPrice;//价格
    private String BookHouse;//出版社
    
    public Book()
    {
  
    }
    
    public Book(String ISBN,String Title,String Author,String Category,int Copies,int CopiesAvailable){
        this.ISBN=ISBN;
        this.Title=Title;
        this.Author=Author;
        this.Category=Category;
        this.Copies=Copies;
        this.CopiesAvailable=CopiesAvailable;
    }
    
    public void setBookISBN(String ISBN){
        this.ISBN=ISBN;
    }
    public void setTitle(String BookName){
        this.Title=BookName;
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
    
    public void setCategory(String Category)
    {
    	this.Category=Category;
    }
    public void setCopies(int Copies)
    {
    	this.Copies=Copies;
    }
    public void setCopiesAvailable(int CopiesAvailable)
    {
    	this.CopiesAvailable=CopiesAvailable;
    }
    
    
    
    
    public String getBookISBN(){
        return ISBN;
    }
    public String getBookTitle(){
        return Title;
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
    
    public String getCategory()
    {
    	return this.Category;
    }
    public int getCopies()
    {
    	return this.Copies;
    }
    public int getCopiesAvailable()
    {
    	return this.CopiesAvailable;
    }
    
    public String toString(){
    	if(Title.length()<16)
    	{
    		return ISBN+"\t"+Title+"\t\t\t"+Author
    				+"\t"+Category+"\t\t"+Copies+"\t\t"+CopiesAvailable+"\n";
        	
    	}else if(Title.length()>26){
    		return ISBN+"\t"+Title+"\t"+Author
    				+"\t"+Category+"\t\t"+Copies+"\t\t"+CopiesAvailable+"\n";
        	
    	}
    	else{
    		return ISBN+"\t"+Title+"\t\t"+Author
    				+"\t"+Category+"\t\t"+Copies+"\t\t"+CopiesAvailable+"\n";
        	
    	}
		
    }
}
