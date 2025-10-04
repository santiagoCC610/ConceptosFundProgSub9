# Final delivery - Programming Fundamental Concepts

## HOW TO RUN

### IMPORTANT: Please verify the installation (must be Java 8)

1. Verify installation:
   ```powershell
   java -version
   javac -version
   ```
   Expected output:
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
   mkdir bin
   ```

3. Compile all Java files into the bin directory:
   ```powershell
   javac -d bin src\*.java
   ```

4. Run GenerateInfoFiles to create input files:
   ```powershell
   java -cp bin GenerateInfoFiles
   ```

5. Run Main to process and produce reports:
   ```powershell
   java -cp bin Main
   ```
