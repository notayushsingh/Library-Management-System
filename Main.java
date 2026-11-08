import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();
        int choice;

        do
        {
            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Books");
            System.out.println("2. Display All Books");
            System.out.println("3. Search Book");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch(choice)
            {
                case 1:
                    System.out.println("Enter Book ID");
                    int id=sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author Name: ");
                    String author = sc.nextLine();

                    Book book = new Book(id, title, author);
                    library.addBook(book);
                    break;

                case 2:
                    library.displayBooks();
                    break;
                    
                case 3:
                    System.out.print("Enter Book ID to search: ");
                    int searchId = sc.nextInt();

                    Book found=library.searchBook(searchId);
                    if(found != null)
                    {
                        System.out.println("Book Found!");
                        System.out.println("Title: " + found.getTitle());
                        System.out.println("Author: " + found.getAuthor());
                        System.out.println("Available: " + found.isAvailable());
                    }
                    else
                    {
                        System.out.println("Book not found.");
                    }
                    break;
                
                case 4:
                    System.out.println("Thank you for using our library");
                    break;

                default:
                    System.out.println("Invalid Choice! Try Again.");
            }
        }
        while(choice!=4);
        sc.close();
    }
}
