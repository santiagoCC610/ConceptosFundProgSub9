    import java.io.BufferedWriter;
    import java.io.File; // Represents files and directories
    import java.io.FileWriter; // Writes characters to files
    import java.io.IOException;
    import java.nio.file.Files; // File operations
    import java.nio.file.Path;
    import java.nio.file.Paths;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.Random; // Random number generator
    import java.util.Locale;

    // Developed by SAMUEL DUQUE PORRAS, CARLOS ALBERTO CUADRADO RODRÍGUEZ, DAVID SANTIAGO HERRERA REALES, ANGIE TATIANA MOSCOSO AREVALO & SANTIAGO CEBALLOS CORREA

    public class GenerateInfoFiles {

        /**
         * Directory where the generated files will be stored.
         */
        private static final String OUTPUT_DIR = "input";

        /**
         * Pseudo-random generator with a fixed seed to make results reproducible.
         */
        private static final Random RANDOM = new Random(12345);

        public static void main(String[] args) {
            try {
                ensureOutputDir();

                // 1) Generate pseudo-random product catalog.
                createProductsFile(20);

                // 2) Generate pseudo-random salesmen info.
                createSalesManInfoFile(10);

                // 3) For each salesman, generate a pseudo-random sales file.
                List<String> salesmen = readSalesmenIdentifiers();
                for (String identifier : salesmen) {
                    String[] parts = identifier.split(";");
                    String documentType = parts[0];
                    String documentNumber = parts[1];
                    int randomSalesCount = 5 + RANDOM.nextInt(46);
                    createSalesMenFile(randomSalesCount, "sales_" + documentType + "_" + documentNumber, documentType, documentNumber);
                }

                System.out.println("GenerateInfoFiles: Files successfully generated at ./" + OUTPUT_DIR);
            } catch (Exception e) {
                System.err.println("Error generating files: " + e.getMessage());
                e.printStackTrace();
                System.exit(1);
            }
        }

        /**
         * Ensures the output directory exists. If it does not exist, it is created.
         *
         * @throws IOException if the directory cannot be created
         */
        private static void ensureOutputDir() throws IOException {
            Path p = Paths.get(OUTPUT_DIR);
            if (!Files.exists(p)) {
                Files.createDirectories(p);
            }
        }

        /**
         * Generates a sales file for a given salesman.
         * The file will have the following structure:
         * - First line: <TipoDocumentoVendedor>;<NumeroDocumentoVendedor>
         * - One line per sale: <IDProducto>;<CantidadVendida>
         *
         * @param randomSalesCount number of sale lines to generate (>= 0)
         * @param fileBaseName     base file name (without extension) for the output file
         * @param tipoDocumento    document type for the salesman (e.g., CC, CE, TI, NIT)
         * @param numeroDocumento  document number for the salesman
         * @throws IOException if the file cannot be written
         */
        public static void createSalesMenFile(int randomSalesCount, String fileBaseName, String tipoDocumento, String numeroDocumento) throws IOException {
            List<Integer> productIds = sampleProductIds();
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

        /**
         * Convenience overload that follows the required signature in the assignment:
         * createSalesMenFile(int randomSalesCount, String name, long id).
         * This method will:
         * - Use the provided {@code name} to compose the output file name.
         * - Use a default document type ("CC") and the provided {@code id} as the document number.
         *
         * @param randomSalesCount number of sale lines to generate (>= 0)
         * @param name             salesman name, used only to build the output file name
         * @param id               salesman identifier used as document number (first line)
         * @throws IOException if the file cannot be written
         */
        public static void createSalesMenFile(int randomSalesCount, String name, long id) throws IOException {
            String sanitizedName = (name == null || name.trim().isEmpty())
                    ? "unknown"
                    : name.trim().replaceAll("[^A-Za-z0-9_\\-]+", "_");
        String fileBaseName = "sales_" + sanitizedName + "_" + id;
        createSalesMenFile(randomSalesCount, fileBaseName, "CC", Long.toString(id));
    }

    /**
     * Generates a products catalog file named {@code products.txt} with the following structure:
     * - One product per line: <IDProducto>;<NombreProducto>;<PrecioPorUnidad>
     *
     * @param productsCount number of products to generate (>= 1)
     * @throws IOException if the file cannot be written
     */
    public static void createProductsFile(int productsCount) throws IOException {
        File f = new File(OUTPUT_DIR, "products.txt");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(f))) {
            for (int i = 1; i <= productsCount; i++) {
                String name = randomProductName(i);
                double price = 1.0 + RANDOM.nextInt(200) + RANDOM.nextDouble();
                price = Math.round(price * 100.0) / 100.0; // round to 2 decimals
                String priceStr = String.format(Locale.US, "%.2f", price);
                bw.write(i + ";" + name + ";" + priceStr);
                bw.newLine();
            }
        }
    }

    /**
     * Generates a salesmen information file named {@code salesmen_info.txt} with the following structure:
     * - One salesman per line: <TipoDocumento>;<NumeroDocumento>;<Nombres>;<Apellidos>
     *
     * @param salesmanCount number of salesmen to generate (>= 1)
     * @throws IOException if the file cannot be written
     */
    public static void createSalesManInfoFile(int salesmanCount) throws IOException {
        File f = new File(OUTPUT_DIR, "salesmen_info.txt");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(f))) {
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

    /**
     * Picks a random valid document type.
     */
    private static String pickRandomDocType() {
        String[] types = {"CC", "CE", "TI", "NIT"};
        return types[RANDOM.nextInt(types.length)];
    }

    /**
     * Generates a pseudo-random product name using a small dictionary and the product index.
     */
    private static String randomProductName(int productIndex) {
        String[] words = {
                "Nova", "Prime", "Aero", "Ultra", "Zen",
                "Flex", "Edge", "Core", "Pulse", "Quantum",
                "Solar", "Titan", "Wave", "Fusion", "Spark"
        };
        return words[RANDOM.nextInt(words.length)] + " Product " + productIndex;
    }

    /**
     * Returns a pseudo-random first name.
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
     * Returns a pseudo-random last name.
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
