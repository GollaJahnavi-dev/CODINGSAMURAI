import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(book.getTitle())) {
                System.out.println("Book already exists.");
                return;
            }
        }
        books.add(book);
    }

    public void showBooks() {
        if (books.isEmpty()) {
            System.out.println("Library is empty.");
            return;
        }

        System.out.println("\nTotal Books: " + books.size());
        System.out.println("---------------------------");

        for (Book book : books) {
            book.displayBook();
        }
    }

    public void searchBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.displayBook();
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void showAvailableBooks() {
        boolean found = false;
        for (Book book : books) {
            if (!book.isBorrowed()) {
                book.displayBook();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No available books.");
        }
    }

    public void borrowBook(String title, String userName) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.borrowBook(userName);
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.returnBook();
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void showBorrowHistory(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.showBorrowHistory();
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void showBooksByCategory(String category) {
        boolean found = false;
        for (Book book : books) {
            if (book.getCategory().equalsIgnoreCase(category)) {
                book.displayBook();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found in this category.");
        }
    }
}
