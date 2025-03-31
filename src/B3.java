import java.io.*;

public class B3 {
    public static void main(String[] args) {
        String inputFileName = "input.txt";
        String copyFileName = "copy.txt";

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(inputFileName));
            writer.write("Đây là nội dung của file input.txt");
            System.out.println("Tệp input.txt đã được tạo với nội dung!");
        } catch (IOException e) {
            System.out.println("Lỗi khi tạo tệp input.txt: " + e.getMessage());
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                System.out.println("Lỗi khi đóng file input.txt: " + e.getMessage());
            }
        }

        BufferedReader reader = null;
        writer = null;
        try {
            reader = new BufferedReader(new FileReader(inputFileName));
            writer = new BufferedWriter(new FileWriter(copyFileName));
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Nội dung đã được sao chép sang copy.txt!");
        } catch (IOException e) {
            System.out.println("Lỗi khi sao chép tệp: " + e.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                System.out.println("Lỗi khi đóng file: " + e.getMessage());
            }
        }

        reader = null;
        try {
            reader = new BufferedReader(new FileReader(copyFileName));
            System.out.println("Nội dung của file copy.txt:");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc tệp copy.txt: " + e.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println("Lỗi khi đóng file copy.txt: " + e.getMessage());
            }
        }
    }
}