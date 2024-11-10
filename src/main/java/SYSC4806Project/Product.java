package SYSC4806Project;

import java.util.ArrayList;
import java.util.List;

/**
 * Products have a name and price that they can be sold for. Tags help buyers find types of products.
 */
public class Product {
    private final String name;
    private double price;
    private final List<Tag> tags = new ArrayList<>();

    public Product(String name, double price) {
        this.name = name;
        if (price < 0) {
            this.price = 0; // free
            System.out.println("Negative price is not allowed. Price is set to 0.");
        } else {
            this.price = price;
        }
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if (price < 0) {
            System.out.println("Negative price is not allowed. Price has not been changed.");
        } else {
            this.price = price;
        }
    }

    public List<Tag> getTags() {
        return tags;
    }

    @Override
    public String toString() {
        return "Product [name=" + name + ", price=" + price + ", tags=" + tags + "]";
    }
}
