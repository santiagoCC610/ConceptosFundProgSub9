import java.io.BufferedWriter;
import java.io.File; //represents files and directories 
import java.io.FileWriter; //escribe caracteres en archivos 
import java.io.IOException; 
import java.nio.file.Files; //file operations
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random; //random number generator 

public class GenerateInfoFiles {

    private static final String OUTPUT_DIR = "input"; //directory where files that are generated are stored 
    private static final Random RANDOM = new Random(12345); //random generator with fixed quantity of numbers 

    public static void main(String[] args) {
        try {
            ensureOutputDir(); //ensures the "input" folder exists 
 
            createProductsFile(20); // creates a file with twenty products

            createSalesManInfoFile(10); //creates a file with ten different persons of the store

            List<String> salesmen = readSalesmenIdentifiers(); //reads the identifier for the workers of the store 
            for (String identifier : salesmen) { //changes or iterates for each salesman 
                String[] parts = identifier.split(";"); //divides the part into type and ; number 
                String tipo = parts[0]; //document type
                String numero = parts[1]; //document number 
                int randomSalesCount = 5 + RANDOM.nextInt(46); //random number of sale between 5 and 46 
                createSalesMenFile(randomSalesCount, "sales_" + tipo + "_" + numero, tipo, numero); //generates the file or report for rhe salesman 
            }

            System.out.println("GenerateInfoFiles: Archivos generados correctamente en ./" + OUTPUT_DIR); //gives the message when was successfully created or generated the file 
        } catch (Exception e) {
            System.err.println("Error al generar archivos: " + e.getMessage()); //if it is not successful it prints this message and shows the route for next step
            e.printStackTrace(); //shows the route
            System.exit(1); //shows this code 
        }
    }

    private static void ensureOutputDir() throws IOException {
        Path p = Paths.get(OUTPUT_DIR);
        if (!Files.exists(p)) {
            Files.createDirectories(p); //this part creates the pat for the input folder and if it doesnt exist creates it 
        }
    }

    public static void createSalesMenFile(int randomSalesCount, String fileBaseName, String tipoDocumento, String numeroDocumento) throws IOException {
        List<Integer> productIds = sampleProductIds(); //gets the id of the valid products 
        File f = new File(OUTPUT_DIR, fileBaseName + ".txt");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(f))) {
            bw.write(tipoDocumento + ";" + numeroDocumento);
            bw.newLine();                                                                                        ///ayuda me perdí :( ////// 
            for (int i = 0; i < randomSalesCount; i++) {
                int pid = productIds.get(RANDOM.nextInt(productIds.size()));
                int qty = 1 + RANDOM.nextInt(10);
                bw.write(pid + ";" + qty);
                bw.newLine();
            }
        }
    }

    public static void createProductsFile(int productsCount) throws IOException {            
        File f = new File(OUTPUT_DIR, "products.txt"); //creates the new folder called products 
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(f))) {
            for (int i = 1; i <= productsCount; i++) {  //generates product count
                String name = randomProductName(i);  //generates products name from the random list 
                double price = 1.0 + RANDOM.nextInt(200) + RANDOM.nextDouble();   //creates a random price between 1 and 200
                price = Math.round(price * 100.0) / 100.0; //it round the cost to one decimal 
                bw.write(i + ";" + name + ";" + price); //writes in this order the product count, name and price
                bw.newLine(); //add a new line 
            }
        }
    }

    public static void createSalesManInfoFile(int salesmanCount) throws IOException {  
        File f = new File(OUTPUT_DIR, "salesmen_info.txt"); //file with the salesmen info 
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(f))) {
            for (int i = 0; i < salesmanCount; i++) { 
                String tipo = pickRandomDocType(); //take a salesman an add randomly a doc type
                long id = 10000000L + Math.abs(RANDOM.nextLong() % 90000000L); //quantity of numbers of the document
                String firstNames = randomFirstName(); //selects random names
                String lastNames = randomLastName(); //selects random last names 
                bw.write(tipo + ";" + id + ";" + firstNames + ";" + lastNames); //writes this line with the order tipo, id, first name and lastname 
                bw.newLine(); //ads a new line 
            }
        }
    }

    private static List<Integer> sampleProductIds() {
        List<Integer> ids = new ArrayList<>();
        try {
            Path p = Paths.get(OUTPUT_DIR, "products.txt");
            if (Files.exists(p)) {
                List<String> lines = Files.readAllLines(p);
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

    private static List<String> readSalesmenIdentifiers() throws IOException {
        List<String> identifiers = new ArrayList<>();
        Path p = Paths.get(OUTPUT_DIR, "salesmen_info.txt");
        if (!Files.exists(p)) return identifiers;
        List<String> lines = Files.readAllLines(p);
        for (String line : lines) {
            if (line.trim().isEmpty()) continue;
            String[] parts = line.split(";");
            if (parts.length >= 2) {
                identifiers.add(parts[0] + ";" + parts[1]);
            }
        }
        return identifiers;
    }

    private static String pickRandomDocType() {
        String[] types = {"CC", "CE", "TI", "NIT"};
        return types[RANDOM.nextInt(types.length)];
    }

    private static String randomProductName(int idx) {
        String[] words = {
                "Nova", "Prime", "Aero", "Ultra", "Zen",
                "Flex", "Edge", "Core", "Pulse", "Quantum",
                "Solar", "Titan", "Wave", "Fusion", "Spark"
        };
        return words[RANDOM.nextInt(words.length)] + " Product " + idx;
    }

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
