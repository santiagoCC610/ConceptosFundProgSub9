import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.io.File; // Represents files and directories
import java.io.FileWriter; // Writes characters in archives
import java.io.IOException; 
import java.nio.file.Files; // File operations
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random; // Random number generator

public class GenerateInfoFiles {

    private static final String OUTPUT_DIR = "input";
    private static final String FILE_PRODUCTS = "products.txt";
    private static final String FILE_SALESMEN_INFO = "salesmen_info.txt";
    private static final Random RANDOM = new Random(12345);

    /**
     * Entry point: generates products, salespeople and a sales file for each
     * salesperson listed in salesmen_info.txt.
     */
    private static final String OUTPUT_DIR = "input"; // Directory where files that are generated are stored
    private static final Random RANDOM = new Random(12345); // Random generator with fixed quantity of numbers

    public static void main(String[] args) {
        try {
            ensureOutputDir();
            ensureOutputDir(); // Ensures the "input" folder exists
 
            createProductsFile(20);
            createProductsFile(20); // Creates a file with twenty products

            createSalesManInfoFile(10);
            createSalesManInfoFile(10); // Creates a file with ten different persons of the store

            List<String> salesmen = readSalesmenIdentifiers();
            for (String identifier : salesmen) {
                String[] parts = identifier.split(";");
                String tipo = parts[0];
                String numero = parts[1];
                int randomSalesCount = 5 + RANDOM.nextInt(46);
                createSalesMenFile(randomSalesCount, "sales_" + tipo + "_" + numero, tipo, numero);
            List<String> salesmen = readSalesmenIdentifiers(); // Reads the identifier for the workers of the store
            for (String identifier : salesmen) { // Changes or iterates for each salesman
                String[] parts = identifier.split(";"); // Divides the part into type and ; number
                String tipo = parts[0]; // Document type
                String numero = parts[1]; // Document number
                int randomSalesCount = 5 + RANDOM.nextInt(46); // Random number of sale between 5 and 46
                createSalesMenFile(randomSalesCount, "sales_" + tipo + "_" + numero, tipo, numero); // Generates the file or report for rhe salesman
            }

            System.out.println("GenerateInfoFiles: Archivos generados correctamente en ./" + OUTPUT_DIR);
            System.out.println("GenerateInfoFiles: Archivos generados correctamente en ./" + OUTPUT_DIR); // Gives the message when was successfully created or generated the file
        } catch (Exception e) {
            System.err.println("Error al generar archivos: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
            System.err.println("Error al generar archivos: " + e.getMessage()); // If it is not successful it prints this message and shows the route for next step
            e.printStackTrace(); // Shows the route
            System.exit(1); // Shows this code
        }
    }

    /**
     * Ensures the output directory exists.
     */
    private static void ensureOutputDir() throws IOException {
        Path p = Paths.get(OUTPUT_DIR);
        if (!Files.exists(p)) {
            Files.createDirectories(p);
        }
    }

    /**
     * Generates a sales file for a salesperson.
     * First line: DocumentType;DocumentNumber
     * Next lines: ProductID;Quantity;
     *
     * @param randomSalesCount number of sales to generate
     * @param fileBaseName     file base name without extension
     * @param tipoDocumento    salesperson document type (e.g., CC)
     * @param numeroDocumento  salesperson document number
     */
            Files.createDirectories(p); // This part creates the pat for the input folder and if it doesn't exist it'll create it
        }
    }

    public static void createSalesMenFile(int randomSalesCount, String fileBaseName, String tipoDocumento, String numeroDocumento) throws IOException {
        List<Integer> productIds = sampleProductIds();
        List<Integer> productIds = sampleProductIds(); // Get the id of the valid products
        File f = new File(OUTPUT_DIR, fileBaseName + ".txt");
        try (BufferedWriter bw = Files.newBufferedWriter(f.toPath(), StandardCharsets.UTF_8)) {
            bw.write(tipoDocumento + ";" + numeroDocumento);
            bw.newLine();
            for (int i = 0; i < randomSalesCount; i++) {
                int pid = productIds.get(RANDOM.nextInt(productIds.size()));
                int qty = 1 + RANDOM.nextInt(10);
                // Required format: ProductID;Quantity;
                bw.write(pid + ";" + qty + ";");
                bw.newLine();
            }
        }
    }

    /**
     * Test helper overload: creates a sales file for a salesperson identified
     * by name and id. The document type is chosen pseudo-randomly. The file is
     * named "sales_<name>_<id>.txt" (spaces replaced by underscore).
     *
     * @param randomSalesCount number of sales to generate
     * @param name             salesperson name (used in the file name)
     * @param id               salesperson document number
     */
    public static void createSalesMenFile(int randomSalesCount, String name, long id) throws IOException {
        String tipo = pickRandomDocType();
        String numeroDocumento = Long.toString(id);
        String safeName = name.replaceAll("\\s+", "_");
        String baseName = "sales_" + safeName + "_" + numeroDocumento;
        createSalesMenFile(randomSalesCount, baseName, tipo, numeroDocumento);
    }

    /**
     * Generates a product file with format: ID;Name;Price
     *
     * @param productsCount number of products to generate
     */
    public static void createProductsFile(int productsCount) throws IOException {
        File f = new File(OUTPUT_DIR, FILE_PRODUCTS);
        try (BufferedWriter bw = Files.newBufferedWriter(f.toPath(), StandardCharsets.UTF_8)) {
            for (int i = 1; i <= productsCount; i++) {
                String name = randomProductName(i);
                double price = 1.0 + RANDOM.nextInt(200) + RANDOM.nextDouble();
                String priceStr = String.format(Locale.US, "%.2f", price);
                bw.write(i + ";" + name + ";" + priceStr);
                bw.newLine();
            }
        }
    }

    /**
     * Generates the salespeople info file: DocumentType;DocumentNumber;FirstNames;LastNames
     *
     * @param salesmanCount number of salespeople to generate
     */
    public static void createSalesManInfoFile(int salesmanCount) throws IOException {
        File f = new File(OUTPUT_DIR, FILE_SALESMEN_INFO);
        try (BufferedWriter bw = Files.newBufferedWriter(f.toPath(), StandardCharsets.UTF_8)) {
            for (int i = 0; i < salesmanCount; i++) {
                String tipo = pickRandomDocType();
                long id = 10000000L + Math.abs(RANDOM.nextLong() % 90000000L);
                String firstNames = randomFirstName();
                String lastNames = randomLastName();
                bw.write(tipo + ";" + id + ";" + firstNames + ";" + lastNames);
                bw.newLine();
            }
        }
    }

    /**
     * Samples product IDs from products.txt. If it does not exist, returns default
     * IDs in the range [1..10].
     */
    public static void createProductsFile(int productsCount) throws IOException {            
        File f = new File(OUTPUT_DIR, "products.txt"); // Creates the new folder called products
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(f))) {
            for (int i = 1; i <= productsCount; i++) {  // Generates product count
                String name = randomProductName(i);  // Generates products name from the random list
                double price = 1.0 + RANDOM.nextInt(200) + RANDOM.nextDouble();   // Creates a random price between 1 and 200
                price = Math.round(price * 100.0) / 100.0; // It round the cost to one decimal
                bw.write(i + ";" + name + ";" + price); // Writes in this order the product count, name and price
                bw.newLine(); // Add a new line
            }
        }
    }

    public static void createSalesManInfoFile(int salesmanCount) throws IOException {  
        File f = new File(OUTPUT_DIR, "salesmen_info.txt"); // File with the salesmen info
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(f))) {
            for (int i = 0; i < salesmanCount; i++) { 
                String tipo = pickRandomDocType(); // Take a salesman an add randomly a doc type
                long id = 10000000L + Math.abs(RANDOM.nextLong() % 90000000L); // Quantity of numbers of the document
                String firstNames = randomFirstName(); // Selects random names
                String lastNames = randomLastName(); // Selects random last names
                bw.write(tipo + ";" + id + ";" + firstNames + ";" + lastNames); // Writes this line with the order tipo, id, first name and lastname
                bw.newLine(); // Ads a new line
            }
        }
    }

    private static List<Integer> sampleProductIds() {
        List<Integer> ids = new ArrayList<>();
        try {
            Path p = Paths.get(OUTPUT_DIR, FILE_PRODUCTS);
            if (Files.exists(p)) {
                List<String> lines = Files.readAllLines(p, StandardCharsets.UTF_8);
                for (String line : lines) {
                    if (line.trim().isEmpty()) continue;
                    String[] parts = line.split(";");
                    ids.add(Integer.parseInt(parts[0]));
                }
            } else {
                for (int i = 1; i <= 10; i++) ids.add(i);
            }
        } catch (IOException e) {
            for (int i = 1; i <= 10; i++) ids.add(i);
        }
        return ids;
    }

    /**
     * Reads salesperson identifiers from salesmen_info.txt in format
     * DocumentType;DocumentNumber.
     *
     * @return list of strings "DocumentType;DocumentNumber"
     */
    private static List<String> readSalesmenIdentifiers() throws IOException {
        List<String> identifiers = new ArrayList<>();
        Path p = Paths.get(OUTPUT_DIR, FILE_SALESMEN_INFO);
        if (!Files.exists(p)) return identifiers;
        List<String> lines = Files.readAllLines(p, StandardCharsets.UTF_8);
        for (String line : lines) {
            if (line.trim().isEmpty()) continue;
            String[] parts = line.split(";");
            if (parts.length >= 2) {
                identifiers.add(parts[0] + ";" + parts[1]);
            }
        }
        return identifiers;
    }

    /**
     * Returns a random document type.
     */
    private static String pickRandomDocType() {
        String[] types = {"CC", "CE", "TI", "NIT"};
        return types[RANDOM.nextInt(types.length)];
    }

    /**
     * Generates a pseudo-random name for a product given its index.
     */
    private static String randomProductName(int idx) {
        String[] words = {
                "Nova", "Prime", "Aero", "Ultra", "Zen",
                "Flex", "Edge", "Core", "Pulse", "Quantum",
                "Solar", "Titan", "Wave", "Fusion", "Spark"
        };
        return words[RANDOM.nextInt(words.length)] + " Product " + idx;
    }

    /**
     * Returns a random first name (or combination of names).
     */
    private static String randomFirstName() {
        String[] firsts = {
                "Santiago", "María", "Juan", "Luisa", "Carlos",
                "Tatiana", "Andrés", "Catalina", "Diego", "Valentina",
                "Santiago",
                "Carlos Alberto",
                "Samuel",
                "David Santiago",
                "Angie Tatiana"
        };
        return firsts[RANDOM.nextInt(firsts.length)];
    }

    /**
     * Returns a random last name (or combination of last names).
     */
    private static String randomLastName() {
        String[] lasts = {
                "González","Rodríguez","Martínez","López","Pérez",
                "Gómez","Ramírez","Sosa","Castro","Vargas",
                "Ceballos Correa",
                "Cuadrado Rodríguez",
                "Duque Porras",
                "Herrera Reales",
                "Moscoso Arevalo"
        };
        return lasts[RANDOM.nextInt(lasts.length)];
    }
}
