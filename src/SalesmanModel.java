/**
 * Class SalesmanModel
 * Represents a salesman with name, ID, sales count, and total revenue.
 * Implements data validation and business logic for sales tracking.
 * 
 * @author Conceptos Fundamentales de Programación
 * @version 2.0 - Weeks 7-8 Final Delivery
 */
public class SalesmanModel {
    // Constants for validation and business rules
    private static final int MIN_SALES = 0;
    private static final double MIN_REVENUE = 0.0;
    private static final double COMMISSION_RATE = 0.10; // 10% commission
    private static final double BONUS_THRESHOLD = 50000.0; // Bonus if revenue exceeds this
    private static final double BONUS_AMOUNT = 5000.0;
    
    // Attributes
    private String salesmanId;
    private String name;
    private int salesCount;
    private double totalRevenue;
    private String region;

    /**
     * Full constructor for SalesmanModel.
     * 
     * @param salesmanId   Unique identifier for the salesman.
     * @param name         The name of the salesman (cannot be null or empty).
     * @param salesCount   The total number of sales (must be >= 0).
     * @param totalRevenue The total revenue generated (must be >= 0).
     * @param region       The sales region.
     * @throws IllegalArgumentException if any validation fails.
     */
    public SalesmanModel(String salesmanId, String name, int salesCount, double totalRevenue, String region) {
        validateSalesmanId(salesmanId);
        validateName(name);
        validateSalesCount(salesCount);
        validateRevenue(totalRevenue);
        
        this.salesmanId = salesmanId;
        this.name = name;
        this.salesCount = salesCount;
        this.totalRevenue = totalRevenue;
        this.region = (region != null && !region.trim().isEmpty()) ? region : "National";
    }

    /**
     * Simplified constructor with default region.
     * 
     * @param salesmanId   Unique identifier for the salesman.
     * @param name         The name of the salesman.
     * @param salesCount   The total number of sales.
     * @param totalRevenue The total revenue generated.
     */
    public SalesmanModel(String salesmanId, String name, int salesCount, double totalRevenue) {
        this(salesmanId, name, salesCount, totalRevenue, "National");
    }

    /**
     * Legacy constructor for backwards compatibility.
     * 
     * @param name       The name of the salesman.
     * @param salesCount The total number of sales.
     */
    public SalesmanModel(String name, int salesCount) {
        this("S" + System.currentTimeMillis() % 10000, name, salesCount, 0.0, "National");
    }

    // Validation methods
    private void validateSalesmanId(String salesmanId) {
        if (salesmanId == null || salesmanId.trim().isEmpty()) {
            throw new IllegalArgumentException("Salesman ID cannot be null or empty.");
        }
    }

    private void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Salesman name cannot be null or empty.");
        }
    }

    private void validateSalesCount(int salesCount) {
        if (salesCount < MIN_SALES) {
            throw new IllegalArgumentException("Sales count cannot be negative. Received: " + salesCount);
        }
    }

    private void validateRevenue(double revenue) {
        if (revenue < MIN_REVENUE) {
            throw new IllegalArgumentException("Revenue cannot be negative. Received: " + revenue);
        }
    }

    // Getters
    public String getSalesmanId() {
        return salesmanId;
    }

    public String getName() {
        return name;
    }

    public int getSalesCount() {
        return salesCount;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public String getRegion() {
        return region;
    }

    // Setters with validation
    public void setSalesCount(int salesCount) {
        validateSalesCount(salesCount);
        this.salesCount = salesCount;
    }

    public void setTotalRevenue(double totalRevenue) {
        validateRevenue(totalRevenue);
        this.totalRevenue = totalRevenue;
    }

    public void setRegion(String region) {
        this.region = (region != null && !region.trim().isEmpty()) ? region : "National";
    }

    /**
     * Adds a new sale to the salesman's record.
     * 
     * @param saleAmount The amount of the sale to add.
     */
    public void addSale(double saleAmount) {
        if (saleAmount < 0) {
            throw new IllegalArgumentException("Sale amount cannot be negative.");
        }
        this.salesCount++;
        this.totalRevenue += saleAmount;
    }

    /**
     * Calculates the commission earned by the salesman.
     * 
     * @return The commission amount (revenue * commission rate).
     */
    public double calculateCommission() {
        return totalRevenue * COMMISSION_RATE;
    }

    /**
     * Calculates the total earnings including commission and bonus.
     * 
     * @return Total earnings.
     */
    public double calculateTotalEarnings() {
        double commission = calculateCommission();
        double bonus = (totalRevenue >= BONUS_THRESHOLD) ? BONUS_AMOUNT : 0.0;
        return commission + bonus;
    }

    /**
     * Checks if the salesman qualifies for a bonus.
     * 
     * @return true if revenue exceeds bonus threshold, false otherwise.
     */
    public boolean qualifiesForBonus() {
        return totalRevenue >= BONUS_THRESHOLD;
    }

    /**
     * Calculates the average sale amount.
     * 
     * @return Average sale amount, or 0 if no sales.
     */
    public double getAverageSaleAmount() {
        return (salesCount > 0) ? (totalRevenue / salesCount) : 0.0;
    }

    /**
     * Returns a formatted string for CSV export.
     * 
     * @return CSV formatted string.
     */
    public String toCSV() {
        return String.format("%s;%s;%d;%.2f;%s;%.2f;%.2f", 
            salesmanId, name, salesCount, totalRevenue, region, 
            calculateCommission(), calculateTotalEarnings());
    }

    @Override
    public String toString() {
        return String.format("%s (%s) - Sales: %d, Revenue: $%.2f, Region: %s", 
            name, salesmanId, salesCount, totalRevenue, region);
    }

    /**
     * Detailed string representation for reports.
     * 
     * @return Detailed salesman information.
     */
    public String toDetailedString() {
        return String.format(
            "Salesman: %s (ID: %s)%n" +
            "  Region: %s%n" +
            "  Total Sales: %d%n" +
            "  Total Revenue: $%.2f%n" +
            "  Average Sale: $%.2f%n" +
            "  Commission (10%%): $%.2f%n" +
            "  Bonus: $%.2f%n" +
            "  Total Earnings: $%.2f",
            name, salesmanId, region, salesCount, totalRevenue,
            getAverageSaleAmount(), calculateCommission(),
            qualifiesForBonus() ? BONUS_AMOUNT : 0.0,
            calculateTotalEarnings()
        );
    }
}
