import java.util.ArrayList;                                                     //For Dynamic Storage of books

public class Library
{
    private ArrayList<Book> books;                                              //Stores multiple Book object

    public Library()                                                            //Constructor
    {
        books = new ArrayList<>();
    }

    public void addBook(Book book)                                              //Add A Book.
    {
        books.add(book);                                                        //Adds A Book Object to the list.
        System.out.println("Book Added Successfully!");
    }

    public void displayBooks()                                                  //Display All Books.
    {
        if(books.isEmpty())
        {
            System.out.println("No Books Available.");
            return;
        }

        for(int i=0;i<books.size();i++)
        {
            Book book=books.get(i);

            System.out.println("-----------------");
            System.out.println("BOOK ID: " + book.getBookId());
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Available: " + book.isAvailable());
        }
    }
    
    public Book searchBook(int bookId)
    {
        for(int i=0;i<books.size();i++)
        {
            Book book = books.get(i);

            if(book.getBookId() == bookId)
                return book;
        }
        return null;                                                            //indicates that no matching book was found.
    }
}
