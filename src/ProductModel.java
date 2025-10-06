/**
 * Class ProductModel
 * Represents a product with name, price, and quantity.
 * Implements data validation and business logic.
 * 
 * @author Conceptos Fundamentales de Programación
 * @version 2.0 - Weeks 7-8 Final Delivery
 */
public class ProductModel {
    // Constants for validation
    private static final double MIN_PRICE = 0.0;
    private static final int MIN_QUANTITY = 0;
    
    // Attributes
    private String name;
    private double price;
    private int quantity;
    private String category;

    /**
     * Constructor for ProductModel with full parameters.
     * 
     * @param name     The name of the product (cannot be null or empty).
     * @param price    The price of the product (must be >= 0).
     * @param quantity The quantity in stock (must be >= 0).
     * @param category The product category.
     * @throws IllegalArgumentException if any validation fails.
     */
    public ProductModel(String name, double price, int quantity, String category) {
        validateName(name);
        validatePrice(price);
        validateQuantity(quantity);
        
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = (category != null && !category.trim().isEmpty()) ? category : "General";
    }

    /**
     * Simplified constructor with default category and quantity.
     * 
     * @param name  The name of the product.
     * @param price The price of the product.
     */
    public ProductModel(String name, double price) {
        this(name, price, 0, "General");
    }

    // Validation methods
    private void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be null or empty.");
        }
    }

    private void validatePrice(double price) {
        if (price < MIN_PRICE) {
            throw new IllegalArgumentException("Price cannot be negative. Received: " + price);
        }
    }

    private void validateQuantity(int quantity) {
        if (quantity < MIN_QUANTITY) {
            throw new IllegalArgumentException("Quantity cannot be negative. Received: " + quantity);
        }
    }

    // Getters
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getCategory() {
        return category;
    }

    // Setters with validation
    public void setPrice(double price) {
        validatePrice(price);
        this.price = price;
    }

    public void setQuantity(int quantity) {
        validateQuantity(quantity);
        this.quantity = quantity;
    }

    public void setCategory(String category) {
        this.category = (category != null && !category.trim().isEmpty()) ? category : "General";
    }

    /**
     * Calculates the total value of this product in inventory.
     * 
     * @return The total value (price * quantity).
     */
    public double calculateTotalValue() {
        return price * quantity;
    }

    /**
     * Checks if the product is in stock.
     * 
     * @return true if quantity > 0, false otherwise.
     */
    public boolean isInStock() {
        return quantity > 0;
    }

    /**
     * Checks if the product is low in stock (less than 10 units).
     * 
     * @return true if quantity < 10, false otherwise.
     */
    public boolean isLowStock() {
        return quantity > 0 && quantity < 10;
    }

    /**
     * Returns a formatted string for CSV export.
     * 
     * @return CSV formatted string.
     */
    public String toCSV() {
        return String.format("%s;%.2f;%d;%s;%.2f", 
            name, price, quantity, category, calculateTotalValue());
    }

    @Override
    public String toString() {
        return String.format("%s - $%.2f (Stock: %d, Category: %s)", 
            name, price, quantity, category);
    }

    /**
     * Detailed string representation for reports.
     * 
     * @return Detailed product information.
     */
    public String toDetailedString() {
        return String.format(
            "Product: %s%n" +
            "  Price: $%.2f%n" +
            "  Quantity: %d%n" +
            "  Category: %s%n" +
            "  Total Value: $%.2f%n" +
            "  Stock Status: %s",
            name, price, quantity, category, calculateTotalValue(),
            isInStock() ? (isLowStock() ? "Low Stock" : "In Stock") : "Out of Stock"
        );
    }
}
