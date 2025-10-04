/**
 * Class SalesmanModel
 * Represents a salesman with a name and total sales count.
 */
public class SalesmanModel {
    private String name;
    private int sales;

    /**
     * Constructor for SalesmanModel.
     * @param name  The name of the salesman.
     * @param sales The total number of sales.
     */
    public SalesmanModel(String name, int sales) {
        this.name = name;
        this.sales = sales;
    }

    public String getName() {
        return name;
    }

    public int getSales() {
        return sales;
    }

    @Override
    public String toString() {
        return name + " - Sales: " + sales;
    }
}
