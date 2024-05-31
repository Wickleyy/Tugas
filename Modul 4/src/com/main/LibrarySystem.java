package com.main;

import java.util.ArrayList;
import java.util.Scanner;

import books.*;
import data.Admin;
import data.Student;

public class LibrarySystem {

    public static Book daftarBuku[] = new Book[100];
    public static ArrayList<Student> studentList = new ArrayList<>();
    public static int i = 0;

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        daftarBuku[i++] = new StoryBook("388c-e68", "Harry Potter", 8, "Story Book", "J.K Rowling");
        daftarBuku[i++] = new HistoryBook("ed90-be3", "American Revolution", 2, "History Book", "Smithsonian");
        daftarBuku[i++] = new TextBook("d95e-0c4", "The Pragmatic Programmer", 4, "Text Book", "David Thomas");

        studentList.add(0, new Student("202310370311299", "Thariq Fadhlurrahman", "Teknik", "Informatika"));
        studentList.add(1, new Student("202310370311259", "Muhammad Nabil Farras Suthan", "Teknik", "Informatika"));
        studentList.add(2, new Student("202310370311258", "Muhammad Dafa Maulana", "Teknik", "Informatika"));

        boolean isRunning = true;
        while (isRunning) {
            System.out.println("===== Library System =====");
            System.out.println("1. Login sebagai Mahasiswa");   
            System.out.println("2. Login sebagai Admin");
            System.out.println("3. Keluar");
            System.out.print("Pilih antara (1-3): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Masukkan NIM : ");
                    String nimStudent = scanner.next();
                    scanner.nextLine();
                    while(true){
                        if (nimStudent.length() != 15 ) {
                            System.out.print("Nim Harus 15 Digit!\n");
                            System.out.print("Masukkan NIM : ");
                            nimStudent = scanner.nextLine();

                        } else if (checkNim(nimStudent)){
                            Student student = new Student(nimStudent);
                            student.login();
                            break;
                        } else {
                            System.out.println("Nim tidak terdaftar!");
                            break;
                        }
                    }
                    break;
                case 2:
                    Admin admin = new Admin();
                    admin.login();
                    break;
                case 3:
                    System.out.println("Terima kasih");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }
    public static boolean checkNim(String nim) {
        for (Student student : studentList) {
            if (student.getNim().equals(nim)) {
                return true;
            }
        }
        return false;
    }
}
