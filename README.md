# DELIVERY 2 - FUNDAMENTALS OF PROGRAMMING
## PRELIMINARY VERSION OF THE COMPLETE PROJECT

### PROJECT INFORMATION
- **TEAM**: SAMUEL DUQUE PORRAS, CARLOS ALBERTO CUADRADO RODRÍGUEZ, DAVID SANTIAGO HERRERA REALES, ANGIE TATIANA MOSCOSO AREVALO, SANTIAGO CEBALLOS CORREA  
- **REPOSITORY**: https://github.com/santiagoCC610/ConceptosFundProgSub9  
- **JAVA VERSION**: 8  
- **IDE**: INTELLIJ IDEA / ECLIPSE FOR JAVA DEVELOPERS  

---

## UPDATED PROJECT STRUCTURE

```
ConceptosFundProgSub9/
├── src/
│   ├── GenerateInfoFiles.java
│   ├── Main.java
│   ├── ProductModel.java
│   └── SalesmanModel.java
├── input/
├── output/
├── README.md
└── missing-elements.md
```

---

## HOW TO RUN

### IMPORTANT: Please verify the installation (must be Java 8)

1. Verify installation:
   ```powershell
   java -version
   javac -version
   ```
   **Expected output:**
   ```powershell
   java version "1.8.0_202"
   javac 1.8.0_202
   ```

   If `javac` is not Java 8, adjust the PATH manually:
   ```powershell
   $env:PATH = "C:\Program Files\Java\jdk1.8.0_202\bin;" + $env:PATH
   ```

2. Create the `bin` folder to store compiled classes:
   ```powershell
   PS C:\Users\User\YourLocation\ConceptosFundProgSub9> mkdir bin
   ```

3. Compile all Java files into the `bin` directory:
   ```powershell
   PS C:\Users\User\YourLocation\ConceptosFundProgSub9> javac -d bin src\*.java
   ```

4. Run **GenerateInfoFiles** to create input files:
   ```powershell
   PS C:\Users\User\YourLocation\ConceptosFundProgSub9> java -cp bin GenerateInfoFiles
   GenerateInfoFiles: Files successfully generated at ./input
   ```

5. Run **Main** to process and produce reports:
   ```powershell
   PS C:\Users\User\YourLocation\ConceptosFundProgSub9> java -cp bin Main
   Main: Reports created in ./output
   ```

---

## OUTPUT

All generated reports will be available in the `output/` folder.
