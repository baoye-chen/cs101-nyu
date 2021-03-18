package books;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		ArrayList<Book> mybooks = new ArrayList<Book>(4);
		mybooks.add(new Book("C++", "John"));
		mybooks.add(new Book("Java", "Josh"));
		mybooks.add(new Book("Python", "James"));
		mybooks.add(new Book("Matlab", "Jane"));
		
		BookShelf myShelf = new BookShelf(mybooks);
		System.out.println("My current bookshelf is: ");
		for(int i = 0; i < myShelf.Books.size(); i++)
		{
			System.out.println(i+1 + ". " + myShelf.Books.get(i).title + " by " + myShelf.Books.get(i).author);
		}
		myShelf.sorting();
		System.out.println("My bookshelf after sorting: ");
		for(int i = 0; i < myShelf.Books.size(); i++)
		{
			System.out.println(i+1 + ". " + myShelf.Books.get(i).title + " by " + myShelf.Books.get(i).author);
		}
		
		System.out.println("The book \"Python\" by James is found at position: " + myShelf.find("Python", "James"));
	}

}
