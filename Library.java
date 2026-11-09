import java.io.*;
import java.util.ArrayList;                                                     //For Dynamic Storage of books

public class Library
{
    private ArrayList<Book> books;                                              //Stores multiple Book object
    private final String FILE_NAME = "books.txt";                               //books.txt is file to store books.

    public Library()                                                            //Constructor
    {
        books = new ArrayList<>();
        loadBooks();
    }

    public void addBook(Book book)                                              //Add A Book.
    {
        //The Workflow here is-:
        //Add Book-> Update ArrayList-> Save to File-> Show Success Message

        books.add(book);                                                        //Adds A Book Object to the list.
        if(saveBooks())
        {
            System.out.println("Book Added Successfully!");
        }
        else
        {
            System.out.println("Book could not be saved!");
        }
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
    
    public Book searchBook(int bookId)                                          //Search for Book.
    {
        for(int i=0;i<books.size();i++)
        {
            Book book = books.get(i);

            if(book.getBookId() == bookId)
                return book;
        }
        return null;                                                            //indicates that no matching book was found.
    }
    private boolean saveBooks()                                                    //private cuz only needed to called by Library class methods listed.
    {
        try
        {
            //FileWriter writes characters into a file.
            //BufferedWriter wraps around it and improves writing efficiency by data buffer.
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));

            for(int i=0;i<books.size();i++)
            {
                Book book = books.get(i);

                writer.write(book.getBookId() + "," + book.getTitle() + "," + book.getAuthor() + "," + book.isAvailable() + "\n");
            }
            writer.close();
            return true;
        }

        //If file can't be written cuz of any permissions problem or disk error.
        //It displays error instead of crashing immediately.
        catch(IOException e)
        {
            System.out.println("Error saving books: ");
            return false;
        }
        }
    private void loadBooks()
    {
        File file = new File(FILE_NAME);                                        //Creates File Object representing books.txt

        if(!file.exists())                                                      //Checking File Existence.
        {
            return;
        }

        try
        {
            //Same as BufferedWriter and FileWriter concept but for Reading.
            BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));

            String line;

            //reader.readLine() reads one line from file.
            while((line = reader.readLine()) != null)
            {
                String[] data = line.split(",", -1);

                int id = Integer.parseInt(data[0]);                             //data[0]=Book ID
                String title = data[1];                                         //data[1]=Book Title
                String author = data[2];                                        //data[2]=Author
                boolean available = Boolean.parseBoolean(data[3]);              //data[3]=Availability

                Book book = new Book(id, title, author);
                book.setAvailable(available);

                books.add(book);
            }

            reader.close();
        }
        catch(Exception e)
        {
            System.out.println("Error loading books: ");
        }
    }
}
