//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int pilihanUser;
        long NIM;
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
                System.out.print("Masukkan NIM: ");
                NIM = keyboard.nextLong();
                if (String.valueOf(NIM).length() == 15) {
                    System.out.println("Berhasil login sebagai Mahasiswa!");
                } else {
                    System.out.println("Tidak berhasil login sebagai Mahasiswa!");
                }
                break;
            case 2:
                System.out.print("Masukkan username: ");
                username = keyboard.next();
                System.out.print("Masukkan password: ");
                password = keyboard.next();
                if (username.equals("admin")&&password.equals("admin")){
                    System.out.print("Berhasil login sebagai Dosen!");
                } else {
                    System.out.print("Tidak berhasil login sebagai Dosen!");
                }
                break;
            case 3:
                System.out.println("adios");
            default:
                System.out.print("Pilihan tidak ada. Harap pilih angka 1-3");
        }
    }
}
