package B4;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        String fileName = "student.dat";
        Student student = new Student("Ha Duc Luong", 20, 8.5);

        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(fileName));
            oos.writeObject(student);
            System.out.println("Đã ghi đối tượng vào file student.dat");
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi đối tượng: " + e.getMessage());
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException e) {
                System.out.println("Lỗi khi đóng file ghi: " + e.getMessage());
            }
        }

        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(fileName));
            Student readStudent = (Student) ois.readObject();
            System.out.println("Đã đọc đối tượng từ file student.dat");
            System.out.println("Thông tin đối tượng: " + readStudent);
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc đối tượng: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Không tìm thấy lớp Student: " + e.getMessage());
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {
                System.out.println("Lỗi khi đóng file đọc: " + e.getMessage());
            }
        }
    }
}