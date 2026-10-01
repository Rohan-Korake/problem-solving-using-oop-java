import java.io.*;

class LMS {
    String bookName, authorName, ISBN;
    int availableStock, publicationYear;

    LMS(String bookName, String authorName, String ISBN,
            int availableStock, int publicationYear) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.ISBN = ISBN;
        this.availableStock = availableStock;
        this.publicationYear = publicationYear;
    }

    void issueBook() {
        if (availableStock > 0) {
            availableStock--;
            System.out.println("Book issued successfully!");
            System.out.println("Available stock: " + availableStock);
        } else {
            System.out.println("Sorry, the book is currently unavailable.");
        }
    }

    void returnBook() {
        availableStock++;
        System.out.println("Book returned successfully!");
        System.out.println("Available stock: " + availableStock);
    }

    void updateBook(String bookName, String authorName,
            int availableStock, int publicationYear) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.availableStock = availableStock;
        this.publicationYear = publicationYear;

        System.out.println("Book details updated successfully!");
    }

    void displayBook() {
        System.out.println("\n----- Book Details -----");
        System.out.println("Book Name       : " + bookName);
        System.out.println("Author Name     : " + authorName);
        System.out.println("ISBN            : " + ISBN);
        System.out.println("Available Stock : " + availableStock);
        System.out.println("Publication Year: " + publicationYear);
        System.out.println("------------------------");
    }
}

public class librarySystem {

    public static void main(String[] args) throws IOException {

        int choice = 0;

        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        LMS book = null;

        do {
            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Update Book");
            System.out.println("5. Display Book");
            System.out.println("6. Exit");

            System.out.print("Enter the choice code (1/2/3/4/5/6): ");

            choice = Integer.parseInt(buffer.readLine());

            switch (choice) {

                case 1:
                    System.out.println("\n----- Add Book -----");

                    System.out.print("Enter book name: ");
                    String bookName = buffer.readLine();

                    System.out.print("Enter author name: ");
                    String authorName = buffer.readLine();

                    System.out.print("Enter ISBN: ");
                    String ISBN = buffer.readLine();

                    System.out.print("Enter available stock: ");
                    int stock = Integer.parseInt(buffer.readLine());

                    System.out.print("Enter publication year: ");
                    int year = Integer.parseInt(buffer.readLine());

                    book = new LMS(
                            bookName,
                            authorName,
                            ISBN,
                            stock,
                            year);

                    System.out.println("Book added successfully!");
                    break;

                case 2:
                    if (book != null) {
                        book.issueBook();
                    } else {
                        System.out.println("Please add a book first.");
                    }
                    break;

                case 3:
                    if (book != null) {
                        book.returnBook();
                    } else {
                        System.out.println("Please add a book first.");
                    }
                    break;

                case 4:
                    if (book != null) {

                        System.out.println("\n----- Update Book -----");

                        System.out.print("Enter new book name: ");
                        String newBookName = buffer.readLine();

                        System.out.print("Enter new author name: ");
                        String newAuthorName = buffer.readLine();

                        System.out.print("Enter new stock: ");
                        int newStock = Integer.parseInt(buffer.readLine());

                        System.out.print("Enter new publication year: ");
                        int newYear = Integer.parseInt(buffer.readLine());

                        book.updateBook(
                                newBookName,
                                newAuthorName,
                                newStock,
                                newYear);

                    } else {
                        System.out.println("Please add a book first.");
                    }
                    break;

                case 5:
                    if (book != null) {
                        book.displayBook();
                    } else {
                        System.out.println("No book available.");
                    }
                    break;

                case 6:
                    System.out.println("Saving Data....");
                    System.out.println("Exiting... Goodbye!");
                    break;

                default:
                    System.out.println(
                            "Invalid choice! Please enter a valid option.");
            }

        } while (choice != 6);
    }
}