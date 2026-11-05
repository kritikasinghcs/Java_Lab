import java.util.Scanner;

class Book {
    int bookId;
    String title;
    String author;
    double price;

    static int count = 0;

    Book(int bookId, String title, String author, double price) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.price = price;
        count++;
    }

    void display() {
        System.out.println("Book ID: " + bookId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }

    // Search by Book ID
    void search(int id) {
        if (bookId == id) {
            System.out.println("Book found:");
            display();
        } else {
            System.out.println("Book ID does not match.");
        }
    }

    // Search by Title
    void search(String bookTitle) {
        if (title.equalsIgnoreCase(bookTitle)) {
            System.out.println("Book found:");
            display();
        } else {
            System.out.println("Book title does not match.");
        }
    }

    // Returns the costlier book
    Book costlier(Book b) {
        if (this.price > b.price)
            return this;
        else
            return b;
    }
}

public class BookDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Book b1 = new Book(101, "Java Programming", "James Gosling", 550);
        Book b2 = new Book(102, "Python Programming", "Guido van Rossum", 650);
        Book b3 = new Book(103, "Data Structures", "Mark Allen", 500);

        System.out.println("--- Book 1 ---");
        b1.display();

        System.out.println("\n--- Book 2 ---");
        b2.display();

        System.out.println("\n--- Book 3 ---");
        b3.display();

        System.out.println("\nTotal number of books created: " + Book.count);

        System.out.println("\n--- Search by Book ID ---");
        System.out.print("Enter Book ID to search: ");
        int id = sc.nextInt();
        b1.search(id);
        b2.search(id);
        b3.search(id);

        sc.nextLine();

        System.out.println("\n--- Search by Title ---");
        System.out.print("Enter Book Title to search: ");
        String title = sc.nextLine();

        b1.search(title);
        b2.search(title);
        b3.search(title);

        System.out.println("\n--- Costlier Book ---");
        Book expensive = b1.costlier(b2);

        System.out.println("The costlier book is:");
        expensive.display();

        sc.close();
    }
}