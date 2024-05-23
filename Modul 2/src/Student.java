public class Student {
    String name;
    String faculty;
    String programStudi;

    public Student(String name, String faculty, String programStudi) {
        this.name = name;
        this.faculty = faculty;
        this.programStudi = programStudi;
    }

    public static void displayBooks(String[] bookList) {
        System.out.println("==== Book List ====");
        System.out.println("ID\tNama Buku\tAuthor\tCategory\tStock");
        for (String book : bookList) {
            System.out.println(book);
        }
    }

    public void logout() {
        System.out.println("Logging out...");
    }
}
