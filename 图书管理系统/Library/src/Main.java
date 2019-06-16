

import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;


public class Main {
	public static boolean isExit=false;
	public static Library library;
	public static void menu()
	{
		library.enter();
		System.out.println("Library");
		System.out.println("Welcome to the library management system, functions provided include the following:");
		System.out.println("○ Add – to add a new book");
		System.out.println("○ Update – to update book info");
		System.out.println("○ Search – to enquire about book info");
		System.out.println("○ Delete – to delete a book");
		System.out.println("○ Display– to display book(s) info");
		System.out.println("○ Quit – to exit from the current level of interactions");
	}
	public static void getCommand()
	{
		System.out.println("Enter your command here(Enter ‘Quit’ at any time to exit from current level):");
		String command=new Scanner(System.in).nextLine();
		command=command.toLowerCase();
		switch(command){
		case "add":add();break;
		case "update":update();break;
		case "search":search();break;
		case "delete":delete();break;
		case "display":display();break;
		case "quit":isExit=true;quit();break;
		}
	}
	public static void add(){
		System.out.println("Enter a new book ISBN:");
		String ISBN=new Scanner(System.in).nextLine();
		System.out.println("ISBN: "+ISBN+" Entered.");
		
		System.out.println("Enter the title:");
		String title=new Scanner(System.in).nextLine();
		System.out.println("Title: "+title+" Entered.");
		
		System.out.println("Enter the author:");
		String auther=new Scanner(System.in).nextLine();
		System.out.println("Author: "+auther+" Entered.");
		
		System.out.println("Enter category:");
		String category=new Scanner(System.in).nextLine();
		System.out.println("Category: "+category+" Entered");
		
		System.out.println("Enter total copy number:");
		int copyNumber=new Scanner(System.in).nextInt();
		int copyAvaliable=copyNumber-0;
		System.out.println("Ready to add book: "+ISBN+"; "+title+"; "+auther+"; "+category+";"+copyNumber+";"+copyAvaliable);
		
		System.out.println("Enter ‘Y’ to add new book. Anything else to quit: ");
		String isY=new Scanner(System.in).nextLine();
		if(isY.equals("Y"))
		{
			if(searchBookAT(title+" "+" "+auther)!=null)
			{
				Book book=new Book(ISBN,title,auther,category,copyNumber,copyAvaliable);
				book.toString();
				library.addBook(book);
				System.out.println("New book added successfully");
			}else{
				System.out.println("This book has been added.");
			}
		}
		System.out.println("Note: automatically exit from current level.");
	}
	public static void delete()
	{
		System.out.println("Enter the book’s ISBN or title + author:");
		String findBook=new Scanner(System.in).nextLine();
		
		boolean isISBN=true;
		for(int i=0;i<findBook.length();i++)
		{
			char c=findBook.charAt(i);
			if(c<48||c>57){
				 isISBN=false;
			}
		}
		Book b=new Book();
		
		if(isISBN)
		{
			b=searchBookISBN(findBook);
		}else{
			b=searchBookAT(findBook);
		}
		
		System.out.println("Enter ‘Y’ to delete the book. Anything else to quit: ");
		String isY=new Scanner(System.in).nextLine();
		if(isY.equals("Y"))
		{
			if(b.getCopiesAvailable()!=b.getCopies())
			{
				System.out.println("Sorry this book cannot be deleted. There are "+(b.getCopies()-b.getCopiesAvailable())+" copies have been lent out.");
			}else{
				if(isISBN)
				{
					deleteBookISBN(findBook);
					System.out.println("Book with ISBN "+findBook+" has been deleted successfully.");
				}else{
					deleteBookAT(findBook);
					System.out.println("Book with title + author"+findBook+" has been deleted successfully.");
				}
			}
		}
		System.out.println("Note: automatically exit from current level.");
		
	}
	public static void deleteBookISBN(String ISBN)
	{
		library.deleteBook(ISBN);
	}
	public static void deleteBookAT(String at)
	{
		Book b=searchBookAT(at);
		
		library.vectorBook.remove(b);
	}
	public static Book searchBookISBN(String ISBN)
	{
		System.out.println("ISBN\t\tTITLE\t\t\t\tAUTHOR\t\tCATEGORY\tTOTAL_COPIES\tAVAILABLE_COPIES");
		return library.searchBookISBN(ISBN);
	}
	public static Book searchBookAT(String at)
	{
		System.out.println("ISBN\t\tTITLE\t\t\t\tAUTHOR\t\tCATEGORY\tTOTAL_COPIES\tAVAILABLE_COPIES");
		return library.searchBookAT(at);
	}
	public static void searchBookKW(String kw)
	{
		Vector<Book> resultBook=library.searchBookKW(kw);
		for(Book bk:resultBook){
			System.out.println(bk.toString());;
		}
	}
	public static void search()
	{
		System.out.println("Enter your keyword:");
		String keyword1=new Scanner(System.in).nextLine();
		searchBookKW(keyword1);
		System.out.println("Enter ‘Y’ to search other books, anything else to quit: ");
		String isY=new Scanner(System.in).nextLine();
		while(isY.equals("Y"))
		{
			System.out.println("Enter your keyword:");
			String keyword2=new Scanner(System.in).nextLine();
			searchBookKW(keyword2);
			System.out.println("Enter ‘Y’ to search other books, anything else to quit: ");
			isY=new Scanner(System.in).nextLine();
		}
		System.out.println("Note: automatically exit from current level.");
	}
	public static void update()
	{
		System.out.println("Enter ISBN:");
		String ISBN=new Scanner(System.in).nextLine();
		Book b=searchBookISBN(ISBN);
		if(b==null)
		{
			return;
		}
		System.out.println("Enter type of information you want to update, ‘T’ for title, ‘A’ for author, ‘C’ for category, ‘TC’ for total copy number, ‘AC’ for available number:");
		String type=new Scanner(System.in).nextLine();
		String updateInfo="";
		switch (type){
		case "T":System.out.println("Enter title:");
			updateInfo=new Scanner(System.in).nextLine();
			System.out.println("Book "+ISBN+"‘s title has been updated from "+b.getBookTitle()+" to "+updateInfo);
			b.setTitle(updateInfo);break;
		case "A":System.out.println("Enter author:");
			updateInfo=new Scanner(System.in).nextLine();
			System.out.println("Book "+ISBN+"‘s  author has been updated from "+b.getAuthor()+" to "+updateInfo);
			b.setAuthor(updateInfo);break;
		case "C":System.out.println("Enter category:");
			updateInfo=new Scanner(System.in).nextLine();
			System.out.println("Book "+ISBN+"‘s category has been updated from "+b.getCategory()+" to "+updateInfo);
			b.setCategory(updateInfo);
			
			break;
		case "TC":System.out.println("Enter your new total copy number:");
		
			updateInfo=new Scanner(System.in).nextLine();
			System.out.println("Book "+ISBN+"‘s total copy number has been updated from "+b.getCopies()+" to "+updateInfo);
			
			b.setCopies(Integer.parseInt(updateInfo));break;
		case "AC":System.out.println("Enter your new total copy available number:");
			updateInfo=new Scanner(System.in).nextLine();
			System.out.println("Book "+ISBN+"‘s total copy avaliable number has been updated from "+b.getCopiesAvailable()+" to "+updateInfo);
			
			b.setCopiesAvailable(Integer.parseInt(updateInfo));break;
		}
		library.vectorBook.set(library.bookIndex, b);
		System.out.println("Note: automatically exit from current level.");
	}
	public static void display()
	{
		System.out.println("Enter ‘C’ for displaying group by category, or ‘A’ for displaying group by author:");
		String disType=new Scanner(System.in).nextLine();
		if(disType.equals("C"))
		{
			Collections.sort(library.vectorBook,new BookComparator(0));
		}else if(disType.equals("A")){
			Collections.sort(library.vectorBook,new BookComparator(1));
		}
		System.out.println("ISBN\t\tTITLE\t\t\t\tAUTHOR\t\tCATEGORY\tTOTAL_COPIES\tAVAILABLE_COPIES");
		library.display();;
	}
	public static void quit(){
		library.exit();
	}
	
	public static void main(String[] args){
		library=new Library();
		menu();
		while(!isExit){
			getCommand();
		}
	}
		

}
