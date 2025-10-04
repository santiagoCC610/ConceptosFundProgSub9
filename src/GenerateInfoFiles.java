import java.io.File;
import java.io.PrintWriter;

/**
 * Class GenerateInfoFiles
 * Generates the input files (data.txt and data.csv) with sample data.
 * Does not require user interaction.
 */
public class GenerateInfoFiles {
    public static void main(String[] args) {
        try {
            File inputDir = new File("input");
            if (!inputDir.exists()) {
                inputDir.mkdirs();
            }

            // --- TXT File ---
            PrintWriter txtWriter = new PrintWriter("input/data.txt", "UTF-8");
            txtWriter.println("Product1,100");
            txtWriter.println("Product2,200");
            txtWriter.println("Product3,300");
            txtWriter.close();

            // --- CSV File ---
            PrintWriter csvWriter = new PrintWriter("input/data.csv", "UTF-8");
            csvWriter.println("ProductName;Price");
            csvWriter.println("Product1;100");
            csvWriter.println("Product2;200");
            csvWriter.println("Product3;300");
            csvWriter.close();

            System.out.println("GenerateInfoFiles: Files successfully created in ./input");
        } catch (Exception e) {
            System.err.println("Error in GenerateInfoFiles: " + e.getMessage());
        }
    }
}
