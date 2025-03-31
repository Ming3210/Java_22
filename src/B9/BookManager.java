package B9;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookManager {
    private List<Book> bookList;
    private final String fileName = "books.dat";

    public BookManager() {
        this.bookList = readBooksFromFile();
    }

    public void addBook(Book book) {
        bookList.add(book);
        saveBooksToFile();
        System.out.println("Đã thêm sách: " + book.getName());
    }

    public void updateBook(int id, String newAuthor, String newPublisher, double newPrice) {
        for (Book book : bookList) {
            if (book.getId() == id) {
                book.setAuthor(newAuthor);
                book.setPublisher(newPublisher);
                book.setPrice(newPrice);
                saveBooksToFile();
                System.out.println("Cập nhật thành công cho sách ID: " + id);
                return;
            }
        }
        System.out.println("Không tìm thấy sách có ID: " + id);
    }

    public void deleteBook(int id) {
        bookList.removeIf(book -> book.getId() == id);
        saveBooksToFile();
        System.out.println("Đã xóa sách có ID: " + id);
    }

    public void displayAllBooks() {
        System.out.println("\nDanh sách sách:");
        System.out.println("------------------------------------------------------------------------------------------------");
        for (Book book : bookList) {
            System.out.println(book);
        }
        System.out.println("------------------------------------------------------------------------------------------------");
    }

    private void saveBooksToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(bookList);
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }

    private List<Book> readBooksFromFile() {
        File file = new File(fileName);
        if (!file.exists()) return new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (List<Book>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}