import java.io.BufferedWriter;
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

    private static final String OUTPUT_DIR = "input"; // Directory where files that are generated are stored
    private static final Random RANDOM = new Random(12345); // Random generator with fixed quantity of numbers

    public static void main(String[] args) {
        try {
            ensureOutputDir(); // Ensures the "input" folder exists
 
            createProductsFile(20); // Creates a file with twenty products

            createSalesManInfoFile(10); // Creates a file with ten different persons of the store

            List<String> salesmen = readSalesmenIdentifiers(); // Reads the identifier for the workers of the store
            for (String identifier : salesmen) { // Changes or iterates for each salesman
                String[] parts = identifier.split(";"); // Divides the part into type and ; number
                String tipo = parts[0]; // Document type
                String numero = parts[1]; // Document number
                int randomSalesCount = 5 + RANDOM.nextInt(46); // Random number of sale between 5 and 46
                createSalesMenFile(randomSalesCount, "sales_" + tipo + "_" + numero, tipo, numero); // Generates the file or report for rhe salesman
            }

            System.out.println("GenerateInfoFiles: Archivos generados correctamente en ./" + OUTPUT_DIR); // Gives the message when was successfully created or generated the file
        } catch (Exception e) {
            System.err.println("Error al generar archivos: " + e.getMessage()); // If it is not successful it prints this message and shows the route for next step
            e.printStackTrace(); // Shows the route
            System.exit(1); // Shows this code
        }
    }

    private static void ensureOutputDir() throws IOException {
        Path p = Paths.get(OUTPUT_DIR);
        if (!Files.exists(p)) {
            Files.createDirectories(p); // This part creates the pat for the input folder and if it doesn't exist it'll create it
        }
    }

    public static void createSalesMenFile(int randomSalesCount, String fileBaseName, String tipoDocumento, String numeroDocumento) throws IOException {
        List<Integer> productIds = sampleProductIds(); // Get the id of the valid products
        File f = new File(OUTPUT_DIR, fileBaseName + ".txt");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(f))) {
            bw.write(tipoDocumento + ";" + numeroDocumento);
            bw.newLine();
            for (int i = 0; i < randomSalesCount; i++) {
                int pid = productIds.get(RANDOM.nextInt(productIds.size()));
                int qty = 1 + RANDOM.nextInt(10);
                bw.write(pid + ";" + qty);
                bw.newLine();
            }
        }
    }

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
        List<Integer> ids = new ArrayList<>(); // Create a list to store product IDs
        try {
            Path p = Paths.get(OUTPUT_DIR, "products.txt"); // Define the path to the products file
            if (Files.exists(p)) { // Check if the file exists
                List<String> lines = Files.readAllLines(p); // Read all lines from the file
                for (String line : lines) { // Iterate through each line
                    if (line.trim().isEmpty()) continue; // Skip empty lines
                    String[] parts = line.split(";"); // Split the line by semicolon
                    ids.add(Integer.parseInt(parts[0])); // Add the first part (product ID) to the list
                }
            } else {
                for (int i = 1; i <= 10; i++) ids.add(i); // If file doesn't exist, add default IDs from 1 to 10
            }
        } catch (IOException e) {
            for (int i = 1; i <= 10; i++) ids.add(i); // In case of error, add default IDs from 1 to 10
        }
        return ids;// Return the list of product IDs
    }

    private static List<String> readSalesmenIdentifiers() throws IOException {
        List<String> identifiers = new ArrayList<>(); // Create a list to store salesman identifiers
        Path p = Paths.get(OUTPUT_DIR, "salesmen_info.txt"); // Define the path to the salesmen info file
        if (!Files.exists(p)) return identifiers; // If the file doesn't exist, return empty list
        List<String> lines = Files.readAllLines(p); // Read all lines from the file
        for (String line : lines) { // Iterate through each line
            if (line.trim().isEmpty()) continue; // Skip empty lines
            String[] parts = line.split(";"); // Split the line by semicolon
            if (parts.length >= 2) { // If the line has at least two parts, add identifier (type;number)
                identifiers.add(parts[0] + ";" + parts[1]);
            }
        }
        return identifiers; // Return the list of identifiers
    }

    private static String pickRandomDocType() {
        String[] types = {"CC", "CE", "TI", "NIT"}; // Define possible document types
        return types[RANDOM.nextInt(types.length)]; // Return a random document type from the array
    }

    private static String randomProductName(int idx) { // Define a list of product name prefixes
        String[] words = {
                "Nova", "Prime", "Aero", "Ultra", "Zen",
                "Flex", "Edge", "Core", "Pulse", "Quantum",
                "Solar", "Titan", "Wave", "Fusion", "Spark"
        };
        return words[RANDOM.nextInt(words.length)] + " Product " + idx; // Return a random prefix combined with "Product" and the index
    }

    private static String randomFirstName() { // Define a list of possible first name
        String[] firsts = {
                "Santiago", "María", "Juan", "Luisa", "Carlos",
                "Tatiana", "Andrés", "Catalina", "Diego", "Valentina",
                "Santiago",
                "Carlos Alberto",
                "Samuel",
                "David Santiago",
                "Angie Tatiana"
        };
        return firsts[RANDOM.nextInt(firsts.length)]; // Return a random first name from the array
    }

    private static String randomLastName() { // Define a list of possible last names
        String[] lasts = {
                "González","Rodríguez","Martínez","López","Pérez",
                "Gómez","Ramírez","Sosa","Castro","Vargas",
                "Ceballos Correa",
                "Cuadrado Rodríguez",
                "Duque Porras",
                "Herrera Reales",
                "Moscoso Arevalo"
        };
        return lasts[RANDOM.nextInt(lasts.length)]; // Return a random last name from the array
    }
}
