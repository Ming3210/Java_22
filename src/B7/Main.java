package B7;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String filename = "data.txt";
        createFileWithSampleData(filename);
        List<Country> countries = readCountriesFromFile(filename);

        System.out.println("Danh sách quốc gia:");
        System.out.println("-----------------------------------");
        for (Country country : countries) {
            System.out.println(country);
        }
        System.out.println("-----------------------------------");
    }

    public static void createFileWithSampleData(String filename) {
        File file = new File(filename);
        if (!file.exists()) {
            BufferedWriter writer = null;
            try {
                writer = new BufferedWriter(new FileWriter(file));
                writer.write("1,AU,Australia\n");
                writer.write("2,CN,China\n");
                writer.write("3,AU,Australia\n");
                writer.write("4,CN,China\n");
                writer.write("5,JP,Japan\n");
                writer.write("6,CN,China\n");
                writer.write("7,JP,Japan\n");
                writer.write("8,TH,Thailand\n");
                System.out.println("Đã tạo file data.txt với dữ liệu mẫu.");
            } catch (IOException e) {
                System.out.println("Lỗi khi tạo file: " + e.getMessage());
            } finally {
                try {
                    if (writer != null) {
                        writer.close();
                    }
                } catch (IOException e) {
                    System.out.println("Lỗi khi đóng file sau khi ghi: " + e.getMessage());
                }
            }
        }
    }

    public static List<Country> readCountriesFromFile(String filename) {
        List<Country> countries = new ArrayList<>();
        File file = new File(filename);
        if (!file.exists()) {
            System.out.println("File không tồn tại!");
            return countries;
        }

        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(",");
                if (data.length == 3) {
                    try {
                        int id = Integer.parseInt(data[0].trim());
                        String code = data[1].trim();
                        String name = data[2].trim();
                        countries.add(new Country(id, code, name));
                    } catch (NumberFormatException e) {
                        System.out.println("Lỗi: Dữ liệu không hợp lệ trong dòng - " + String.join(",", data));
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Lỗi: Không tìm thấy file!");
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        return countries;
    }
}