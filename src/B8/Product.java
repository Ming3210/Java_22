package B8;

import java.io.Serializable;

class Product implements Serializable {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("ID: %-5d | Tên: %-15s | Giá %.2f VNĐ", id, name, price);
    }
}
