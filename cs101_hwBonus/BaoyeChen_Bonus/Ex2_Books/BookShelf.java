package books;

import java.util.ArrayList;
import java.util.Collections;

public class BookShelf 
{
	public ArrayList<Book> Books;
	
	public BookShelf(ArrayList<Book> myBooks)
	{
		this.Books = myBooks;
	}
	
	public String getAuthor(String Title)
	{
		String author = "";
		for(int i = 0; i < this.Books.size(); ++i)
		{
			if(Title == this.Books.get(i).title)
			{
				author = this.Books.get(i).author;
			}
		}
		return author;
	}
	
	public void sorting()
	{
		ArrayList<String> temp = new ArrayList<String>();
		for(int i = 0; i < this.Books.size(); ++i)
		{
			temp.add(this.Books.get(i).title);
		}
		Collections.sort(temp);
		ArrayList<Book> tempe = new ArrayList<Book>();
		for(int i = 0; i < temp.size(); ++i)
		{
			tempe.add(new Book(temp.get(i), getAuthor(temp.get(i))));
		}
		this.Books = tempe;
	}
	
	public int find(String title, String author)
	{
		int position = -1;
		for(int i = 0; i < this.Books.size(); ++i)
		{
			if(this.Books.get(i).title == title && this.Books.get(i).author == author)
			{
				position = i;
			}
		}
		return position+1;
	}

}
