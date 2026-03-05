import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Library library = new Library();
        Scanner sc = new Scanner(System.in);

        library.addBook(new Book(1, "Java Basics", "John Doe", "Computer Science"));
        library.addBook(new Book(2, "Data Structures", "Jane Smith", "Computer Science"));
        library.addBook(new Book(3, "Operating Systems", "Andrew Tanenbaum", "Computer Science"));
        library.addBook(new Book(4, "Digital Electronics", "Morris Mano", "Electrical"));
        library.addBook(new Book(5, "Electrical Machines", "P.S. Bimbhra", "Electrical"));
        library.addBook(new Book(6, "Thermodynamics", "Yunus Cengel", "Mechanical"));
        library.addBook(new Book(7, "Strength of Materials", "Bansal", "Mechanical"));
        library.addBook(new Book(8, "Rich Dad Poor Dad", "Robert Kiyosaki", "Business"));
        library.addBook(new Book(9, "The Alchemist", "Paulo Coelho", "Novel"));
        library.addBook(new Book(10, "Pride and Prejudice", "Jane Austen", "Fiction"));

        while (true) {

            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Show All Books");
            System.out.println("2. Search Book");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. View Books by Category");
            System.out.println("6. Show Available Books");
            System.out.println("7. View Borrow History");
            System.out.println("8. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    library.showBooks();
                    break;

                case 2:
                    System.out.print("Enter Book Title: ");
                    library.searchBook(sc.nextLine());
                    break;

                case 3:
                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Your Name: ");
                    String name = sc.nextLine();
                    library.borrowBook(title, name);
                    break;

                case 4:
                    System.out.print("Enter Book Title: ");
                    library.returnBook(sc.nextLine());
                    break;

                case 5:
                    System.out.print("Enter Category: ");
                    library.showBooksByCategory(sc.nextLine());
                    break;

                case 6:
                    library.showAvailableBooks();
                    break;

                case 7:
                    System.out.print("Enter Book Title: ");
                    library.showBorrowHistory(sc.nextLine());
                    break;

                case 8:
                    System.out.println("Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
