import java.io.*;

public class B5 {
    public static void main(String[] args) {
        String fileName = "cauthu.txt";

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(fileName));
            writer.write("Văn Lâm\nTiến Linh\nXuân Sơn\nHoàng Đức\nVăn Hậu");
            System.out.println("Đã tạo file cauthu.txt với danh sách cầu thủ.");
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

        BufferedReader reader = null;
        String longestName = "";
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.length() > longestName.length()) {
                    longestName = line;
                }
            }
            System.out.println("Tên cầu thủ dài nhất: " + longestName);
            System.out.println("Độ dài của tên đó: " + longestName.length());
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
    }
}
