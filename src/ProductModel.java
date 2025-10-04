/**
 * Class ProductModel
 * Represents a simple product with a name and price.
 */
public class ProductModel {
    private String name;
    private int price;

    /**
     * Constructor for ProductModel.
     * @param name  The name of the product.
     * @param price The price of the product.
     */
    public ProductModel(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " - $" + price;
    }
}
