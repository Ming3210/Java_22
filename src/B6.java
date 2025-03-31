import java.io.*;

public class B6 {
    public static void main(String[] args) {
        String inputFile = "reverse.txt";
        String outputFile = "reverseCopy.txt";

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(inputFile));
            writer.write("Hello");
            System.out.println("Đã tạo file reverse.txt với nội dung.");
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

        StringBuilder content = new StringBuilder();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(inputFile));
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println("Lỗi khi đóng file sau khi đọc: " + e.getMessage());
            }
        }

        String reversedContent = content.reverse().toString();

        try {
            writer = new BufferedWriter(new FileWriter(outputFile));
            writer.write(reversedContent);
            System.out.println("Đã ghi nội dung đảo ngược vào file reverseCopy.txt.");
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                System.out.println("Lỗi khi đóng file sau khi ghi: " + e.getMessage());
            }
        }

        try {
            reader = new BufferedReader(new FileReader(outputFile));
            String line;
            System.out.println("Nội dung file reverseCopy.txt:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file reverseCopy.txt: " + e.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println("Lỗi khi đóng file sau khi đọc: " + e.getMessage());
            }
        }
    }
}
