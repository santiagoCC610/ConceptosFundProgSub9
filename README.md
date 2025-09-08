## Entrega 1 - Conceptos Fundamentales de Programación

Project in **Java 8** that generates input files for a sales system. This repository corresponds to the **first delivery (Entrega 1)** of the module *Conceptos Fundamentales de Programación* and focuses exclusively on generating well-formed pseudo-random input files.

---

## Project structure
- `src/` → Java source code
  - `GenerateInfoFiles.java` → Main class that generates the input test files
- `input/` → Auto-generated files after running the program:
  - `products.txt` → Product list with ID, name, and unit price
  - `salesmen_info.txt` → Salesmen information
  - `sales_<TipoDoc>_<Numero>.txt` → Sales associated with each salesman

---

## How to run (IntelliJ IDEA)
1. Open the project in **IntelliJ IDEA** (`File → Open → Select project folder`).
2. Ensure folder `src/` is marked as **Sources Root**.
3. Open `GenerateInfoFiles.java`.
4. Right-click the class → **Run 'GenerateInfoFiles.main()'**.
5. Output files will be created in the `input/` folder.

## How to run (Eclipse)
1. File → Import → Existing Projects into Workspace → Select this folder.
2. Ensure `src/` is on the Build Path (right-click `src/` → Build Path → Use as Source Folder).
3. Open `GenerateInfoFiles.java` and run as **Java Application**.

---

## File formats (as required by the assignment)
- **Products file** (`products.txt`):
  - Format per line: `IDProducto;NombreProducto;PrecioPorUnidadProducto`
- **Salesmen info file** (`salesmen_info.txt`):
  - Format per line: `TipoDocumento;NumeroDocumento;Nombres;Apellidos`
- **Sales per salesman** (`sales_<TipoDoc>_<Numero>.txt`):
  - First line: `TipoDocumentoVendedor;NumeroDocumentoVendedor`
  - Then one sale per line: `IDProducto;CantidadVendida`

All files are CSV-like, using semicolons `;` as separators.

---

## What this delivery includes (Entrega 1)
- Generation of coherent, pseudo-random input data:
  - `createProductsFile(int productsCount)`
  - `createSalesManInfoFile(int salesmanCount)`
  - `createSalesMenFile(int randomSalesCount, String fileBaseName, String tipoDocumento, String numeroDocumento)`
  - Convenience overload required by spec: `createSalesMenFile(int randomSalesCount, String name, long id)`
- English Javadoc and clean code conventions for readability.

---

## Requirements
- **Java 8 (JDK 1.8)**
- IDE: **IntelliJ IDEA** or **Eclipse for Java Developers**

---

## Example (snippet) of generated files
`products.txt` (first lines):
```
1;Ultra Product 1;123.45
2;Prime Product 2; 98.00
...
```

`salesmen_info.txt` (first lines):
```
CC;12345678;Juan;Pérez
TI;87654321;María;González
...
```

`sales_CC_12345678.txt` (first lines):
```
CC;12345678
1;3
5;1
...
```

---

## Notes
- Random generator has a fixed seed for reproducibility.
- Output folder `input/` is created automatically if it does not exist.
