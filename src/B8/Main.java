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
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(products);
            System.out.println("da ghi danh sach san pham vao file " + fileName);
        } catch (IOException e) {
            System.out.println("loi: khong the ghi vao file " + fileName + ". " + e.getMessage());
        }
        List<Product> readProducts = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            readProducts = (List<Product>) ois.readObject();
            System.out.println("da doc danh sach san pham tu file " + fileName);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("loi: khong the doc file " + fileName + ". " + e.getMessage());
        }

        if (readProducts != null) {
            System.out.println("\nDanh sach san pham:");
            for (Product p : readProducts) {
                System.out.println(p.toString());
            }
        }
    }
}