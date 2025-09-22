import java.io.Serializable;

/**
 * SalesmanModel represents a salesman identified by type;number and a name.
 * Implements Serializable to support future serialization features.
 */
public class SalesmanModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String key; // type;number
    private final String name;
    private double totalSales = 0.0;

    public SalesmanModel(String key, String name) {
        this.key = key;
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public double getTotalSales() {
        return totalSales;
    }

    public void addSalesAmount(double amount) {
        this.totalSales += amount;
    }
}
