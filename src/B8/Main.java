package B8;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String fileName = "products.dat";
        List<Product> products = Arrays.asList(
                new Product(1, "Laptop", 1200.50),
                new Product(2, "Phone", 800.75),
                new Product(3, "Tablet", 450.30)
        );
        writeProductsToFile(fileName, products);
        List<Product> readProducts = readProductsFromFile(fileName);

        if (readProducts != null) {
            System.out.println("\nDanh sách sản phẩm từ file:");
            for (Product p : readProducts) {
                System.out.println(p);
            }
        }
    }


    public static void writeProductsToFile(String fileName, List<Product> products) {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(fileName));
            oos.writeObject(products);
            System.out.println("Đã ghi danh sách sản phẩm vào file: " + fileName);
        } catch (IOException e) {
            System.out.println("Lỗi: Không thể ghi vào file " + fileName + ". " + e.getMessage());
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException e) {
                System.out.println("Lỗi khi đóng file sau khi ghi: " + e.getMessage());
            }
        }
    }


    public static List<Product> readProductsFromFile(String fileName) {
        ObjectInputStream ois = null;
        List<Product> products = new ArrayList<>();
        try {
            ois = new ObjectInputStream(new FileInputStream(fileName));
            products = (List<Product>) ois.readObject();
            System.out.println("Đã đọc danh sách sản phẩm từ file: " + fileName);
        } catch (FileNotFoundException e) {
            System.out.println("Lỗi: Không tìm thấy file " + fileName);
        } catch (IOException e) {
            System.out.println("Lỗi: Không thể đọc file " + fileName + ". " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Lỗi: Dữ liệu trong file không hợp lệ. " + e.getMessage());
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {
                System.out.println("Lỗi khi đóng file sau khi đọc: " + e.getMessage());
            }
        }
        return products;
    }
}
