package B9;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookManager {
    private List<Book> bookList;
    private final String fileName = "books.dat";

    public BookManager() {
        try {
            this.bookList = readBooksFromFile();
        } catch (Exception e) {
            System.out.println("Lỗi khi đọc dữ liệu sách: " + e.getMessage());
            this.bookList = new ArrayList<>();
        }
    }

    public void addBook(Book book) {
        try {
            bookList.add(book);
            saveBooksToFile();
            System.out.println("Đã thêm sách: " + book.getName());
        } catch (Exception e) {
            System.out.println("Lỗi khi thêm sách: " + e.getMessage());
        }
    }

    public void updateBook(int id, String newAuthor, String newPublisher, double newPrice) {
        try {
            boolean found = false;
            for (Book book : bookList) {
                if (book.getId() == id) {
                    book.setAuthor(newAuthor);
                    book.setPublisher(newPublisher);
                    book.setPrice(newPrice);
                    found = true;
                    break;
                }
            }
            if (found) {
                saveBooksToFile();
                System.out.println("Cập nhật thành công cho sách ID: " + id);
            } else {
                System.out.println("Không tìm thấy sách có ID: " + id);
            }
        } catch (Exception e) {
            System.out.println("Lỗi khi cập nhật sách: " + e.getMessage());
        }
    }

    public void deleteBook(int id) {
        try {
            boolean removed = bookList.removeIf(book -> book.getId() == id);
            if (removed) {
                saveBooksToFile();
                System.out.println("Đã xóa sách có ID: " + id);
            } else {
                System.out.println("Không tìm thấy sách có ID: " + id);
            }
        } catch (Exception e) {
            System.out.println("Lỗi khi xóa sách: " + e.getMessage());
        }
    }

    public void displayAllBooks() {
        try {
            if (bookList.isEmpty()) {
                System.out.println("Danh sách sách trống.");
            } else {
                System.out.println("\nDanh sách sách:");
                System.out.println("------------------------------------------------------------------------------------------------");
                for (Book book : bookList) {
                    System.out.println(book);
                }
                System.out.println("------------------------------------------------------------------------------------------------");
            }
        } catch (Exception e) {
            System.out.println("Lỗi khi hiển thị danh sách sách: " + e.getMessage());
        }
    }

    private void saveBooksToFile() throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(bookList);
        } catch (IOException e) {
            throw new IOException("Lỗi khi ghi file: " + e.getMessage());
        }
    }

    private List<Book> readBooksFromFile() throws IOException, ClassNotFoundException {
        File file = new File(fileName);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (List<Book>) ois.readObject();
        } catch (FileNotFoundException e) {
            throw new IOException("Lỗi: Không tìm thấy file " + fileName);
        } catch (IOException e) {
            throw new IOException("Lỗi khi đọc file: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException("Lỗi: Dữ liệu trong file không hợp lệ.");
        }
    }
}