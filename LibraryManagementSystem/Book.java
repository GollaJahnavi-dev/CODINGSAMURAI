import java.util.ArrayList;
import java.util.List;

public class Book {

    private int id;
    private String title;
    private String author;
    private String category;
    private boolean isBorrowed;
    private String borrowedBy;
    private List<String> borrowHistory;

    public Book(int id, String title, String author, String category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.isBorrowed = false;
        this.borrowedBy = "";
        this.borrowHistory = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void borrowBook(String userName) {
        if (!isBorrowed) {
            isBorrowed = true;
            borrowedBy = userName;
            borrowHistory.add(userName);
            System.out.println("Book borrowed successfully by " + userName);
        } else {
            System.out.println("Book already borrowed by " + borrowedBy);
        }
    }

    public void returnBook() {
        if (isBorrowed) {
            System.out.println("Book returned by " + borrowedBy);
            isBorrowed = false;
            borrowedBy = "";
        } else {
            System.out.println("Book was not borrowed.");
        }
    }

    public void showBorrowHistory() {
        if (borrowHistory.isEmpty()) {
            System.out.println("No borrowing history.");
        } else {
            System.out.println("Borrow History: " + borrowHistory);
        }
    }

    public void displayBook() {
        System.out.println("ID: " + id +
                " | Title: " + title +
                " | Author: " + author +
                " | Category: " + category +
                " | Status: " + (isBorrowed ? "Borrowed by " + borrowedBy : "Available"));
    }
}
