import java.util.Comparator;



public class BookComparator implements Comparator<Book>{
	private int index;
	public BookComparator(int index)
	{
		super();
		this.index=index;
	}
	@Override
	public int compare(Book o1, Book o2) {
		// TODO Auto-generated method stub
		String category1;
		String category2;
		String author1;
		String author2;
		int num1;
		int num2;
		switch(index)
		{
			case 0:		
				category1=o1.getCategory();
				category2=o1.getCategory();
				if(category1.equals(category2))
				{
					return 0;
				}else 
				{
					return -1;
				}
		case 1:		
				author1=o1.getAuthor();
				author2=o2.getAuthor();
				if(author1.equals(author2))
				{
					return 0;
				}else 
				{
					return -1;
				}
		case 2:		
			num1=o1.getCopies();
			num2=o2.getCopies();
			if(num1>=num2)
			{
				return 0;
			}else 
			{
				return -1;
			}
		default:break;
			
		}
		return -1;
		
	}

}
