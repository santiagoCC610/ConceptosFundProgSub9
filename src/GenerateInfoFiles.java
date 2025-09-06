import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenerateInfoFiles {

    private static final String OUTPUT_DIR = "input";
    private static final Random RANDOM = new Random(12345);

    public static void main(String[] args) {
        try {
            ensureOutputDir();

            createProductsFile(20);

            createSalesManInfoFile(10);

            List<String> salesmen = readSalesmenIdentifiers();
            for (String identifier : salesmen) {
                String[] parts = identifier.split(";");
                String tipo = parts[0];
                String numero = parts[1];
                int randomSalesCount = 5 + RANDOM.nextInt(46); // entre 5 y 50 ventas
                createSalesMenFile(randomSalesCount, "sales_" + tipo + "_" + numero, tipo, numero);
            }

            System.out.println("GenerateInfoFiles: Archivos generados correctamente en ./" + OUTPUT_DIR);
        } catch (Exception e) {
            System.err.println("Error al generar archivos: " + e.getMessage());
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

    public static void createProductsFile(int productsCount) throws IOException {
        File f = new File(OUTPUT_DIR, "products.txt");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(f))) {
            for (int i = 1; i <= productsCount; i++) {
                String name = randomProductName(i);
                double price = 1.0 + RANDOM.nextInt(200) + RANDOM.nextDouble(); // 1.0 .. 200.999
                price = Math.round(price * 100.0) / 100.0; // redondear a 2 decimales
                bw.write(i + ";" + name + ";" + price);
                bw.newLine();
            }
        }
    }

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
                // fallback por si no existe products.txt
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
