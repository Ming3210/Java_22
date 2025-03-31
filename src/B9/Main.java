package B9;

public class Main {
    public static void main(String[] args) {
        BookManager manager = new BookManager();

        manager.addBook(new Book(1, "Lập trình Java", "Nguyễn Văn A", "NXB Trẻ", 120000));
        manager.addBook(new Book(2, "Dữ liệu và Giải thuật", "Lê Văn B", "NXB Giáo dục", 150000));
        manager.addBook(new Book(3, "Học máy cơ bản", "Trần Thị C", "NXB Khoa học", 200000));

        manager.displayAllBooks();

        manager.updateBook(2, "Lê Văn B+", "NXB Mới", 180000);

        manager.displayAllBooks();

        manager.deleteBook(1);

        manager.displayAllBooks();
    }
}