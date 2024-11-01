package SYSC4806Project;

import java.util.ArrayList;
import java.util.List;

// TODO: protect against negative prices

/**
 * Products have a name and price that they can be sold for. Tags help buyers find types of products.
 */
public class Product {
    private final String name;
    private double price;
    private final List<Tag> tags = new ArrayList<>();

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<Tag> getTags() {
        return tags;
    }

    @Override
    public String toString() {
        return "Product [name=" + name + ", price=" + price + ", tags=" + tags + "]";
    }
}
