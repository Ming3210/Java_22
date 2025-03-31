import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class B2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên tệp: ");
        String fileName = scanner.nextLine();

        File file = new File(fileName);

        if (file.exists()) {
            System.out.println("Tệp đã tồn tại!");
        } else {
            try {
                if (file.createNewFile()) {
                    System.out.println("Tệp đã được tạo!");
                } else {
                    System.out.println("Không thể tạo tệp!");
                }
            } catch (IOException e) {
                System.out.println("Đã xảy ra lỗi khi tạo tệp: " + e.getMessage());
            }
        }
    }
}
