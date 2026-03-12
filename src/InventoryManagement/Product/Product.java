package InventoryManagement.Product;

public class Product {
    public final long id;
    public final String name;
    public final String description;
    public final CATEGORY category;

    public Product(long id, String name, String description, CATEGORY category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
    }
}
