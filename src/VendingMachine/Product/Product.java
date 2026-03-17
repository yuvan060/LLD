package VendingMachine.Product;

import java.time.LocalDate;

public class Product {
    /*
    For encapsulation, it is better to declare the fields as private, but for TC, i am using public access modifier
     */
    public final String name;
    public final double price;
    public final LocalDate loadDate;
    public final LocalDate expiryDate;

    public Product(String name, double price, LocalDate loadDate, LocalDate expiryDate) {
        this.name = name;
        this.price = price;
        this.loadDate = loadDate;
        this.expiryDate = expiryDate;
    }
}
