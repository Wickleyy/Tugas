import java.util.Scanner;
import java.util.ArrayList;

class Main {
    static ArrayList<Book> bookList = new ArrayList<>();
    static ArrayList<Student> userStudent = new ArrayList<>();

    public static void main(String[] args) {
        inisialisasiData();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("===== Library System =====");
            System.out.println("1. Login sebagai Mahasiswa");
            System.out.println("2. Login sebagai Admin");
            System.out.println("3. Exit");
            System.out.print("Choose option (1-3): ");
            String pilihanUser = scanner.nextLine();
            switch (pilihanUser) {
                case "1":
                    inputNim(scanner);
                    break;
                case "2":
                    Admin admin = new Admin();
                    admin.menuAdmin(scanner);
                    break;
                case "3":
                    System.out.println("adios");
                    System.exit(0);
                default:
                    System.out.println("Opsi tidak valid");
            }
        }
    }

    public static void inputNim(Scanner scanner) {
        System.out.print("Enter your NIM (input 99 for back): ");
        String nim = scanner.nextLine();
        if (nim.equals("99")) {
            return;
        } else if (checkNim(nim)) {
            Student student = new Student(nim);
            student.menuStudent(scanner); 
        } else {
            System.out.println("Invalid NIM. Please try again.");
            inputNim(scanner);
        }
    }

    public static boolean checkNim(String nim) {
        for (Student student : userStudent) {
            if (student.getNim().equals(nim)) {
                return true;
            }
        }
        return false;
    }

    public static void inisialisasiData() {
        
        bookList.add(new Book("388c-e681-9152", "title", "author", "Sejarah", 8));
        bookList.add(new Book("ed90-be30-5cdb", "title", "author", "Cerita", 0));
        bookList.add(new Book("d95e-0c4a-9523", "title", "author", "Novel", 3));

        userStudent.add(new Student("Thariq Fadhlurrahman", "202310370311299", "Teknik", "Informatika"));
        userStudent.add(new Student("Muhammad Nabil Farras Suthan", "20231037031259", "Teknik", "Informatika"));
        userStudent.add(new Student("Muhammad Daffa Maulana", "202310370311258", "Teknik", "Informatika"));
    }
}


