import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private boolean checkedOut;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.checkedOut = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void checkOut() {
        checkedOut = true;
    }

    public void checkIn() {
        checkedOut = false;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Checked Out: " + checkedOut;
    }
}

class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public Book findBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public void checkOutBook(String title) {
        Book book = findBook(title);
        if (book != null && !book.isCheckedOut()) {
            book.checkOut();
            System.out.println("You have checked out: " + book.getTitle());
        } else {
            System.out.println("Book not found or already checked out.");
        }
    }

    public void checkInBook(String title) {
        Book book = findBook(title);
        if (book != null && book.isCheckedOut()) {
            book.checkIn();
            System.out.println("You have checked in: " + book.getTitle());
        } else {
            System.out.println("Book not found or not checked out.");
        }
    }

    public void displayBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Check Out Book");
            System.out.println("3. Check In Book");
            System.out.println("4. Search for a Book");
            System.out.println("5. Display All Books");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    library.addBook(new Book(title, author));
                    System.out.println("Book added successfully!");
                    break;
                case 2:
                    System.out.print("Enter book title to check out: ");
                    String checkOutTitle = scanner.nextLine();
                    library.checkOutBook(checkOutTitle);
                    break;
                case 3:
                    System.out.print("Enter book title to check in: ");
                    String checkInTitle = scanner.nextLine();
                    library.checkInBook(checkInTitle);
                    break;
                case 4:
                    System.out.print("Enter book title to search: ");
                    String searchTitle = scanner.nextLine();
                    Book foundBook = library.findBook(searchTitle);
                    if (foundBook != null) {
                        System.out.println("Book found: " + foundBook);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 5:
                    library.displayBooks();
                    break;
                case 6:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
