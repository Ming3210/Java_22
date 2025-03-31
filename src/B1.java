import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class B1 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập văn bản: ");
        String text = scanner.nextLine();

        FileWriter writer = new FileWriter("output.txt");
        writer.write(text);
        writer.close();

        BufferedReader reader = new BufferedReader(new FileReader("output.txt"));
        System.out.println("Nội dung file: " + reader.readLine());
        reader.close();
    }
}
