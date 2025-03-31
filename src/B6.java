import java.io.*;

public class B6 {
    public static void main(String[] args) {
        String inputFile = "reverse.txt";
        String outputFile = "reverseCopy.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(inputFile))) {
            writer.write("Hello");
            System.out.println("Đã tạo file reverse.txt với nội dung.");
        } catch (IOException e) {
            System.out.println("Lỗi khi tạo file: " + e.getMessage());
        }

        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        }

        String reversedContent = content.reverse().toString();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write(reversedContent);
            System.out.println("Đã ghi nội dung đảo ngược vào file reverseCopy.txt.");
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(outputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file reverseCopy.txt: " + e.getMessage());
        }
    }
}