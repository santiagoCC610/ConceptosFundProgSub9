import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.List;
import java.util.ArrayList;

/**
 * CLASS Main
 * RESPONSIBLE FOR PROCESSING INPUT FILES AND GENERATING REPORTS.
 * THIS CLASS IS PART OF DELIVERY 2.
 */
public class Main {

    private static final String INPUT_DIR = "input";
    private static final String OUTPUT_DIR = "output";

    public static void main(String[] args) {
        try {
            ensureOutputDir();

            Map<Integer, ProductModel> products = loadProducts();
            Map<String, SalesmanModel> salesmen = loadSalesmen();

            processSalesFiles(products, salesmen);

            generateVendorsReport(salesmen);
            generateProductsReport(products);

            System.out.println("Main: Reports created in ./" + OUTPUT_DIR);

        } catch (Exception e) {
            System.err.println("Error in execution: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static void ensureOutputDir() throws IOException {
        Path p = Paths.get(OUTPUT_DIR);
        if (!Files.exists(p)) {
            Files.createDirectories(p);
        }
    }

    private static Map<Integer, ProductModel> loadProducts() throws IOException {
        Map<Integer, ProductModel> map = new HashMap<>();
        Path p = Paths.get(INPUT_DIR, "products.txt");
        try (BufferedReader br = Files.newBufferedReader(p)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length >= 3) {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    double price = Double.parseDouble(parts[2]);
                    map.put(id, new ProductModel(id, name, price));
                }
            }
        }
        return map;
    }

    private static Map<String, SalesmanModel> loadSalesmen() throws IOException {
        Map<String, SalesmanModel> map = new HashMap<>();
        Path p = Paths.get(INPUT_DIR, "salesmen_info.txt");
        try (BufferedReader br = Files.newBufferedReader(p)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length >= 4) {
                    String key = parts[0] + ";" + parts[1];
                    String name = parts[2] + " " + parts[3];
                    map.put(key, new SalesmanModel(key, name));
                }
            }
        }
        return map;
    }

    private static void processSalesFiles(Map<Integer, ProductModel> products,
                                          Map<String, SalesmanModel> salesmen) throws IOException {
        File dir = new File(INPUT_DIR);
        File[] files = dir.listFiles((d, name) -> name.startsWith("sales_") && name.endsWith(".txt"));
        if (files == null) return;

        for (File f : files) {
            try (BufferedReader br = new BufferedReader(new FileReader(f))) {
                String header = br.readLine(); // first line: TipoDoc;NumeroDoc
                if (header == null) continue;
                SalesmanModel sm = salesmen.get(header);
                if (sm == null) continue;

                String line;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(";");
                    if (parts.length >= 2) {
                        int pid = Integer.parseInt(parts[0]);
                        int qty = Integer.parseInt(parts[1]);
                        ProductModel prod = products.get(pid);
                        if (prod != null) {
                            double total = prod.getPrice() * qty;
                            sm.addSalesAmount(total);
                            prod.addUnitsSold(qty);
                        }
                    }
                }
            }
        }
    }

    private static void generateVendorsReport(Map<String, SalesmanModel> salesmen) throws IOException {
        File f = new File(OUTPUT_DIR, "vendors_report.csv");

        Map<String, SalesmanModel> sorted = salesmen.values().stream()
                .sorted(Comparator.comparingDouble((SalesmanModel s) -> s.getTotalSales()).reversed())
                .collect(Collectors.toMap(
                        s -> s.getKey(), s -> s,
                        (a, b) -> a, LinkedHashMap::new
                ));

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(f))) {
            for (SalesmanModel sm : sorted.values()) {
                bw.write(sm.getName() + ";" + String.format(Locale.US, "%.2f", sm.getTotalSales()));
                bw.newLine();
            }
        }
    }

    private static void generateProductsReport(Map<Integer, ProductModel> products) throws IOException {
        File f = new File(OUTPUT_DIR, "products_report.csv");

        Map<Integer, ProductModel> sorted = products.values().stream()
                .sorted(Comparator.comparingInt((ProductModel p) -> p.getUnitsSold()).reversed())
                .collect(Collectors.toMap(
                        p -> p.getId(), p -> p,
                        (a, b) -> a, LinkedHashMap::new
                ));

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(f))) {
            for (ProductModel p : sorted.values()) {
                bw.write(p.getName() + ";" + String.format(Locale.US, "%.2f", p.getPrice()) + ";" + p.getUnitsSold());
                bw.newLine();
            }
        }
    }
}
