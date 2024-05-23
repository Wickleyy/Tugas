import java.util.Scanner;

public class Main {
    private static String[] bookList = {
        "001\tBook 1\tAuthor 1\tCategory 1\t10",
        "002\tBook 2\tAuthor 2\tCategory 2\t15",
        "003\tBook 3\tAuthor 3\tCategory 3\t20"
    };
    private static String[] userStudent = {"123456789", "987654321"};

    public static void main(String[] args) {
        Menu();
    }

    public static void Menu() {
        int pilihanUser;
        String username;
        String password;

        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("==== Library ====");
        System.out.println("1. Login sebagai mahasiswa");
        System.out.println("2. Login sebagai dosen");
        System.out.println("3. EXIT");
        System.out.print("Choose option (1/3): ");
        pilihanUser = keyboard.nextInt();

        switch (pilihanUser) {
            case 1: 
                inputNim();
                break;
            case 2:
                System.out.print("Masukkan username: ");
                username = keyboard.next();
                System.out.print("Masukkan password: ");
                password = keyboard.next();
                if (username.equals("admin")&&password.equals("admin")){
                    menuAdmin();
                } else {
                    System.out.print("Tidak berhasil login sebagai Dosen!");
                }
                break;
            case 3:
                System.out.println("adios");
                keyboard.close();
                break;
            default:
                System.out.print("Pilihan tidak ada. Harap pilih angka 1-3");
        }
    }

    public static void inputNim(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan NIM: ");
        String NIM = scanner.nextLine();
        Student student = checkNim(NIM);
        if (String.valueOf(NIM).length() == 15) {
            menuStudent(student);
        } else {
            System.out.println("Tidak berhasil login sebagai Mahasiswa!");
        }
        scanner.close();
    }
    
    public static Student checkNim(String NIM) {
        for (String user : userStudent) {
            if (user.equals(NIM)) {
                return new Student("John Doe", "Engineering", "Computer Science");
            }
        }
        return null;
    }

    public static void menuAdmin() {
        Admin admin = new Admin("admin", "password");
        Scanner scanner = new Scanner(System.in);
            System.out.println("==== Admin Menu ====");
            System.out.println("1. Add Student");
            System.out.println("2. Display registered students");
            System.out.println("3. Logout");
            System.out.println("Choose option (1-3): ");
            int pilihanUser = scanner.nextInt();
            switch (pilihanUser) {
                case 1:
                    admin.addStudent();
                    break;
                case 2:
                    admin.displayStudent();
                    break;
                case 3:
                    System.out.println("Logging out from admin account");
                    Menu();
                    break;
                default:
                    System.out.println("Mohon untuk memasukkan angka 1-3");
                    break;
            }
        scanner.close();
    }

    public static void menuStudent(Student student) {
        //boolean logout = false;
        System.out.println("Berhasil login sebagai Mahasiswa!");
        Scanner scanner = new Scanner(System.in);
            System.out.println("==== Student Menu ====");
            System.out.println("1. Buku terpinjam");
            System.out.println("2. Pinjam buku");
            System.out.println("3. Logout");
            System.out.println("Choose option (1-3): ");
            int pilihanUser = scanner.nextInt();
            switch (pilihanUser) {
                case 1:
                    System.out.println("List buku yang dipinjam:");
                    System.out.println("Tidak ada list buku yang dimpinjam");
                    break;
                case 2:
                    student.displayBooks(bookList);
                    System.out.print("Masukkan id buku yang ingin dipinjam (input 99 untuk kembali): ");
                    String idBuku = scanner.nextLine();
                    if (idBuku.equals("001") || idBuku.equals("002") || idBuku.equals("003")) {
                        System.out.println("Buku berhasil dipinjam.");      
                    } else if (idBuku.equals("99")) {
                        System.out.println("Logout.....");
                    } else {
                        System.out.println("ID buku tidak valid.");
                    }
                    break;
                case 3:
                    System.out.println("Berhasil logout");
                    Menu();
                    break;
                default:
                    System.out.println("Pilihan tidak ada");
                    break;
            }
        scanner.close();
        }
    }

