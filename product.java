import java.util.*;
import java.util.stream.Collectors;

class Product {
    String name;
    String category;
    double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " ($" + price + ")";
    }
}

public class ProductProcessor {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", "Electronics", 1200),
                new Product("Phone", "Electronics", 800),
                new Product("Tablet", "Electronics", 600),
                new Product("Sofa", "Furniture", 1500),
                new Product("Chair", "Furniture", 200),
                new Product("Desk", "Furniture", 450),
                new Product("Shirt", "Clothing", 50),
                new Product("Jacket", "Clothing", 120)
        );

        // Group products by category
        Map<String, List<Product>> productsByCategory = products.stream()
                .collect(Collectors.groupingBy(p -> p.category));
        
        System.out.println("Products grouped by category: " + productsByCategory);

        // Find the most expensive product in each category
        Map<String, Optional<Product>> mostExpensiveByCategory = products.stream()
                .collect(Collectors.groupingBy(
                        p -> p.category,
                        Collectors.maxBy(Comparator.comparingDouble(p -> p.price))
                ));
        
        System.out.println("Most expensive product in each category: " + mostExpensiveByCategory);

        // Calculate the average price of all products
        double averagePrice = products.stream()
                .mapToDouble(p -> p.price)
                .average()
                .orElse(0);
        
        System.out.println("Average price of all products: $" + averagePrice);
    }
}