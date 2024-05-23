import java.util.Scanner;
import java.util.ArrayList;

class Student extends User{
    private String name;
    private String nim;
    private String faculty;
    private String programStudi;
    private ArrayList<Book> borrowedBooks;
    private int loanDuration;

    public Student(String name, String nim, String faculty, String programStudi) {
        this.name = name;
        this.nim = nim;
        this.faculty = faculty;
        this.programStudi = programStudi;
        this.borrowedBooks = new ArrayList<>();
    }

    public Student(String nim) {
        for (Student student : Main.userStudent) {
            if (student.getNim().equals(nim)) {
                this.name = student.getName();
                this.nim = student.getNim();
                this.faculty = student.getFaculty();
                this.programStudi = student.getProgram();
                this.borrowedBooks = student.getBorrowedBooks();
                break;
            }
        }
    }

    public String getNim() { return nim; }

    public void menuStudent(Scanner scanner) {
        while (true) {
            System.out.println("=== Student Menu ===");
            System.out.println("1. Buku terpinjam");
            System.out.println("2. Pinjam buku");
            System.out.println("3. Pinjam Buku atau Logout");
            System.out.print("Choose option (1-3): ");
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    System.out.println("Buku terpinjam:");
                    displayBorrowedBooks();
                    break;
                case "2":
                    displayBooks();
                    borrowBook(scanner);
                    break;
                case "3":
                    System.out.println("Kembali ke menu awal...");
                    return;
                default:
                    System.out.println("Opsi tidak vvalid");
            }
        }
    }
    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    public void displayBorrowedBooks() {
        if (borrowedBooks.isEmpty()) {
            System.out.println("Belum ada buku yang dipinjam");
        } else {
            System.out.println("=================================================================================");
            System.out.println("|| No. || Id Buku        || Nama Buku    || Author       || Category   || Durasi ||");
            System.out.println("=================================================================================");
            int index = 1;
            for (Book book : borrowedBooks) {
                System.out.println("|| " + index + "  || " + book.getId() + " || " + book.getTitle() + " || " + book.getAuthor() + " || " + book.getCategory() + " || " + book.getLoanDuration() + " ||" );
                index++;
            }
            System.out.println("=================================================================================");
        }
    }

    public void displayBooks() {
        System.out.println("================================================================");
        System.out.println("|| No. || Id Buku || Nama Buku || Author || Category || Stock ||");
        int index = 1;
        for (Book book : Main.bookList) {
            System.out.println("|| " + index + "  || " + book.getId() + " || " + book.getTitle() + " || " + book.getAuthor() + " || " + book.getCategory() + "  || " + book.getStock() + " ||");
            index++;
        }
        System.out.println("================================================================");
    }
    public void borrowBook(Scanner scanner) {
        System.out.print("Masukkan list no buku yang ingin dipinjam: ");
        int bookIndex = Integer.parseInt(scanner.nextLine()) - 1;
        if (bookIndex < 0 || bookIndex >= Main.bookList.size()) {
            System.out.println("Buku yang dipilih tidak ada");
            return;
        }

        Book selectedBook = Main.bookList.get(bookIndex);
        System.out.print("Masukkan durasi peminjaman buku (hari): ");
        int loanDuration = Integer.parseInt(scanner.nextLine());

        if (selectedBook.getStock() > 0) {
            selectedBook.setStock(selectedBook.getStock() - 1);
            selectedBook.setLoanDuration(loanDuration); 
            borrowBook(selectedBook);
            System.out.println("Buku '" + selectedBook.getTitle() + "' sukses dipinjam selama " + loanDuration + " hari");
        } else {
            System.out.println("Maaf, stok buku yang dipilih kosong");
        }
    }

    public void setLoanDuration(int loanDuration) {
        this.loanDuration = loanDuration;
    }

    public int getLoanDuration() {
        return loanDuration;
    }
    public String getName() { return name; }
    public String getFaculty() { return faculty; }
    public String getProgram() { return programStudi; }
    public ArrayList<Book> getBorrowedBooks() { return borrowedBooks; }
}

