package B4;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        String fileName = "student.dat";
        Student student = new Student("Ha Duc Luong", 20, 8.5);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(student);
            System.out.println("Đã ghi đối tượng vào file student.dat");
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi đối tượng: " + e.getMessage());
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            Student readStudent = (Student) ois.readObject();
            System.out.println("Đã đọc đối tượng từ file student.dat");
            System.out.println("Thông tin đối tượng: " + readStudent);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Lỗi khi đọc đối tượng: " + e.getMessage());
        }
    }
}
