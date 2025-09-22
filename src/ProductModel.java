import java.io.Serializable;

/**
 * ProductModel represents a product with id, name and price.
 * This class implements Serializable to allow future serialization.
 */
public class ProductModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private final int id;
    private final String name;
    private final double price;
    private int unitsSold = 0;

    public ProductModel(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getUnitsSold() {
        return unitsSold;
    }

    public void addUnitsSold(int qty) {
        this.unitsSold += qty;
    }
}
