import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Class GenerateInfoFiles
 * Generates comprehensive input files (data.txt, data.csv, products.txt, salesmen.txt, sales_records.csv)
 * with realistic sample data for testing and demonstration.
 * Does not require user interaction.
 * 
 * @author Conceptos Fundamentales de Programación
 * @version 2.0 - Weeks 7-8 Final Delivery
 */
public class GenerateInfoFiles {
    // Constants for data generation
    private static final String INPUT_DIR = "input";
    private static final String ENCODING = "UTF-8";
    private static final Random random = new Random(42); // Seed for reproducibility

    // Product data arrays
    private static final String[] PRODUCT_NAMES = {
        "Laptop", "Mouse", "Keyboard", "Monitor", "Headphones",
        "USB Cable", "SSD Drive", "RAM Module", "Graphics Card", "Motherboard",
        "CPU", "Power Supply", "Cooling Fan", "Webcam", "Microphone"
    };

    private static final String[] CATEGORIES = {
        "Computers", "Peripherals", "Components", "Audio", "Accessories"
    };

    // Salesman data arrays
    private static final String[] SALESMAN_NAMES = {
        "Juan Pérez", "María González", "Carlos Rodríguez", "Ana Martínez",
        "Luis Hernández", "Carmen López", "José García", "Laura Sánchez",
        "Miguel Torres", "Isabel Ramírez"
    };

    private static final String[] REGIONS = {
        "Norte", "Sur", "Este", "Oeste", "Centro"
    };

    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("GENERATION OF INPUT FILES - WEEKS 7-8");
        System.out.println("=".repeat(60));
        
        try {
            // Create input directory if it doesn't exist
            File inputDir = new File(INPUT_DIR);
            if (!inputDir.exists()) {
                if (inputDir.mkdirs()) {
                    System.out.println("[OK] Created directory: " + INPUT_DIR);
                }
            }

            // Generate all files
            generateSimpleProductData();
            generateDetailedProductData();
            generateSalesmenData();
            generateSalesRecords();
            
            System.out.println("=".repeat(60));
            System.out.println("All input files successfully created in ./" + INPUT_DIR);
            System.out.println("=".repeat(60));
            
        } catch (Exception e) {
            System.err.println("[ERROR] Failed to generate files: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Generates simple product data for backward compatibility (data.txt).
     */
    private static void generateSimpleProductData() throws Exception {
        PrintWriter txtWriter = new PrintWriter(INPUT_DIR + "/data.txt", ENCODING);
        
        for (int i = 0; i < 10; i++) {
            String productName = PRODUCT_NAMES[i];
            double price = 50.0 + (random.nextDouble() * 950.0); // Price between 50 and 1000
            txtWriter.println(String.format("%s,%.2f", productName, price));
        }
        
        txtWriter.close();
        System.out.println("[OK] Generated: data.txt (10 simple product entries)");
    }

    /**
     * Generates detailed product data in CSV format (data.csv and products.txt).
     */
    private static void generateDetailedProductData() throws Exception {
        // CSV format
        PrintWriter csvWriter = new PrintWriter(INPUT_DIR + "/data.csv", ENCODING);
        csvWriter.println("ProductName;Price;Quantity;Category");
        
        // Detailed TXT format
        PrintWriter productsWriter = new PrintWriter(INPUT_DIR + "/products.txt", ENCODING);
        productsWriter.println("# PRODUCT INVENTORY DATABASE");
        productsWriter.println("# Format: Name|Price|Quantity|Category");
        productsWriter.println("#" + "-".repeat(58));
        
        List<ProductModel> products = new ArrayList<ProductModel>();
        
        for (int i = 0; i < PRODUCT_NAMES.length; i++) {
            String name = PRODUCT_NAMES[i];
            double price = generateProductPrice(name);
            int quantity = random.nextInt(100) + 1; // 1-100 units
            String category = CATEGORIES[i % CATEGORIES.length];
            
            // Create product using model
            ProductModel product = new ProductModel(name, price, quantity, category);
            products.add(product);
            
            // Write to CSV
            csvWriter.println(String.format("%s;%.2f;%d;%s", 
                name, price, quantity, category));
            
            // Write to TXT
            productsWriter.println(String.format("%s|%.2f|%d|%s", 
                name, price, quantity, category));
        }
        
        csvWriter.close();
        productsWriter.close();
        
        System.out.println("[OK] Generated: data.csv (" + PRODUCT_NAMES.length + " products)");
        System.out.println("[OK] Generated: products.txt (" + PRODUCT_NAMES.length + " products)");
    }

    /**
     * Generates salesman data (salesmen.txt).
     */
    private static void generateSalesmenData() throws Exception {
        PrintWriter salesmenWriter = new PrintWriter(INPUT_DIR + "/salesmen.txt", ENCODING);
        salesmenWriter.println("# SALESMEN DATABASE");
        salesmenWriter.println("# Format: ID|Name|SalesCount|Revenue|Region");
        salesmenWriter.println("#" + "-".repeat(58));
        
        for (int i = 0; i < SALESMAN_NAMES.length; i++) {
            String id = String.format("S%04d", 1001 + i);
            String name = SALESMAN_NAMES[i];
            int salesCount = random.nextInt(50) + 10; // 10-59 sales
            double revenue = salesCount * (500 + random.nextDouble() * 1500); // Revenue varies
            String region = REGIONS[i % REGIONS.length];
            
            salesmenWriter.println(String.format("%s|%s|%d|%.2f|%s", 
                id, name, salesCount, revenue, region));
        }
        
        salesmenWriter.close();
        System.out.println("[OK] Generated: salesmen.txt (" + SALESMAN_NAMES.length + " salesmen)");
    }

    /**
     * Generates sales records combining products and salesmen (sales_records.csv).
     */
    private static void generateSalesRecords() throws Exception {
        PrintWriter salesWriter = new PrintWriter(INPUT_DIR + "/sales_records.csv", ENCODING);
        salesWriter.println("SaleID;SalesmanID;SalesmanName;ProductName;Quantity;UnitPrice;TotalAmount;Date");
        
        int recordCount = 30; // Generate 30 sales records
        
        for (int i = 0; i < recordCount; i++) {
            int saleId = 5001 + i;
            int salesmanIdx = random.nextInt(SALESMAN_NAMES.length);
            String salesmanId = String.format("S%04d", 1001 + salesmanIdx);
            String salesmanName = SALESMAN_NAMES[salesmanIdx];
            
            int productIdx = random.nextInt(PRODUCT_NAMES.length);
            String productName = PRODUCT_NAMES[productIdx];
            double unitPrice = generateProductPrice(productName);
            int quantity = random.nextInt(5) + 1; // 1-5 units per sale
            double totalAmount = unitPrice * quantity;
            
            String date = String.format("2024-10-%02d", (i % 28) + 1);
            
            salesWriter.println(String.format("%d;%s;%s;%s;%d;%.2f;%.2f;%s",
                saleId, salesmanId, salesmanName, productName, 
                quantity, unitPrice, totalAmount, date));
        }
        
        salesWriter.close();
        System.out.println("[OK] Generated: sales_records.csv (" + recordCount + " sales records)");
    }

    /**
     * Generates consistent prices for products based on their name.
     */
    private static double generateProductPrice(String productName) {
        // Price ranges based on product type
        switch (productName) {
            case "Laptop":
                return 800 + random.nextDouble() * 1200; // 800-2000
            case "Monitor":
                return 200 + random.nextDouble() * 600; // 200-800
            case "Graphics Card":
                return 300 + random.nextDouble() * 900; // 300-1200
            case "CPU":
                return 200 + random.nextDouble() * 600; // 200-800
            case "Motherboard":
                return 150 + random.nextDouble() * 350; // 150-500
            case "RAM Module":
            case "SSD Drive":
                return 80 + random.nextDouble() * 220; // 80-300
            case "Power Supply":
                return 60 + random.nextDouble() * 140; // 60-200
            case "Headphones":
            case "Webcam":
            case "Microphone":
                return 30 + random.nextDouble() * 170; // 30-200
            case "Mouse":
            case "Keyboard":
            case "Cooling Fan":
                return 20 + random.nextDouble() * 80; // 20-100
            case "USB Cable":
                return 5 + random.nextDouble() * 20; // 5-25
            default:
                return 50 + random.nextDouble() * 200; // Default range
        }
    }
}
