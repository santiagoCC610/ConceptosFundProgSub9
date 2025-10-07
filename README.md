# Product and Salesman Management System
## Conceptos Fundamentales de Programación - Semanas 7 y 8

[![Java Version](https://img.shields.io/badge/Java-8-orange)](https://www.oracle.com/java/technologies/javase/javase8-archive-downloads.html)
[![Status](https://img.shields.io/badge/Status-Completed-success)](https://github.com)
[![License](https://img.shields.io/badge/License-Educational-blue)](LICENSE)

---

## PROJECT DESCRIPTION

Complete business management system developed in Java that allows:

- **Generate** test data automatically (products, salesmen, sales)
- **Process** and analyze business information
- **Calculate** commissions, bonuses, inventories and statistics
- **Generate** detailed reports in multiple formats (TXT, CSV)
- **Validate** data with robust error handling

###  Main Features

- **Data Models:** ProductModel and SalesmanModel with complete validation
- **Automatic Generation:** 15 products, 10 salesmen, 30 sales
- **Complete Analysis:** Inventories, commissions, bonuses, rankings, statistics
- **6 Reports:** Product analysis, salesmen, sales and executive summary
- **Best Practices:** OOP, validations, Javadoc documentation, clean code

---

##  PROJECT STRUCTURE

```
ConceptosFundProgSub9-1/
├── src/                          # Source code
│   ├── GenerateInfoFiles.java   # Input data generator
│   ├── Main.java                 # Processor and report generator
│   ├── ProductModel.java         # Product model with business logic
│   └── SalesmanModel.java        # Salesman model with commission calculation
│
├── bin/                          # Compiled classes (.class)
│
├── input/                        # Input files (automatically generated)
│   ├── data.txt                  # Simple product data
│   ├── data.csv                  # Structured product data
│   ├── products.txt              # Complete inventory with categories
│   ├── salesmen.txt              # Salesman database
│   └── sales_records.csv         # Transaction records
│
├── output/                       # Generated reports
│   ├── product_report.txt        # Detailed product analysis
│   ├── product_report.csv        # Exportable product data
│   ├── salesmen_report.txt       # Salesman performance analysis
│   ├── salesmen_report.csv       # Exportable salesman data
│   ├── sales_records_report.txt  # Transaction report
│   └── executive_summary.txt     # System executive summary
│
├── README.md                     # This execution guide
├── DOCUMENTACION.md              # Complete technical documentation (30+ pages)
└── conclusion.txt                # Detailed project conclusions
```

---

##  SYSTEM REQUIREMENTS

### Required Software

- **Java Development Kit (JDK) 8 or higher**
- **Terminal/PowerShell** with access to `java` and `javac` commands
- **Text editor** or IDE (optional: IntelliJ IDEA, Eclipse, VSCode)

### Supported Operating Systems

- Windows 10/11
- macOS
- Linux

---

##  INSTALLATION AND EXECUTION GUIDE

###  Step 0: Verify Java Installation

```powershell
# Verify Java Runtime version
java -version

# Verify Java compiler version
javac -version
```

**Expected output:**
```
java version "1.8.0_202"
Java(TM) SE Runtime Environment (build 1.8.0_202-b08)
javac 1.8.0_202
```

** If `javac` is not available:**

```powershell
# Windows: Configure PATH temporarily
$env:PATH = "C:\Program Files\Java\jdk1.8.0_202\bin;" + $env:PATH

# Verify again
javac -version
```

---

###  Step 1: Compile the Project

```powershell
# Create directory for compiled classes
mkdir bin

# Compile all Java files
javac -d bin src\*.java
```

**Expected result:**
```
✓ No compilation errors
✓ .class files created in bin/
```

** Troubleshooting:**

If "cannot find symbol" error appears, make sure to compile all files together:
```powershell
javac -d bin src\GenerateInfoFiles.java src\Main.java src\ProductModel.java src\SalesmanModel.java
```

---

###  Step 2: Generate Input Data

```powershell
# Run the data generator
java -cp bin GenerateInfoFiles
```

**Expected output:**
```
============================================================
GENERATION OF INPUT FILES - WEEKS 7-8
============================================================
[OK] Created directory: input
[OK] Generated: data.txt (10 simple product entries)
[OK] Generated: data.csv (15 products)
[OK] Generated: products.txt (15 products)
[OK] Generated: salesmen.txt (10 salesmen)
[OK] Generated: sales_records.csv (30 sales records)
============================================================
All input files successfully created in ./input
============================================================
```

** Verification:**
```powershell
# List created files
dir input\

# Should display:
# - data.txt
# - data.csv
# - products.txt
# - salesmen.txt
# - sales_records.csv
```

---

###  Step 3: Process Data and Generate Reports

```powershell
# Run the main processor
java -cp bin Main
```

**Expected output:**
```
======================================================================
DATA PROCESSING AND REPORT GENERATION - WEEKS 7-8
======================================================================
[OK] Created directory: output

[PROCESSING] Product Data...
[OK] Product reports generated (15 products)

[PROCESSING] Salesmen Data...
[OK] Salesmen reports generated (10 salesmen)

[PROCESSING] Sales Records...
[OK] Sales records report generated (30 records)

[PROCESSING] Executive Summary...
[OK] Executive summary generated
======================================================================
All reports successfully created in ./output
======================================================================
```

** Verification:**
```powershell
# List generated reports
dir output\

# Should display:
# - product_report.txt
# - product_report.csv
# - salesmen_report.txt
# - salesmen_report.csv
# - sales_records_report.txt
# - executive_summary.txt
```

---

##  RESULTS REVIEW

### Open Generated Reports

```powershell
# Windows - Open with Notepad
notepad output\executive_summary.txt
notepad output\product_report.txt
notepad output\salesmen_report.txt

# Open CSV with Excel (if installed)
start output\product_report.csv
start output\salesmen_report.csv
```

### Report Contents

1. **product_report.txt** - Complete inventory analysis:
   - Total inventory value
   - Low stock products
   - Distribution by categories
   - Detailed list sorted by value

2. **salesmen_report.txt** - Performance analysis:
   - Total revenue generated
   - Calculated commissions (10%)
   - Salesmen with bonus ($50,000+)
   - Top 5 performers
   - Regional distribution

3. **sales_records_report.txt** - Individual transactions:
   - List of all sales
   - Total and average sales

4. **executive_summary.txt** - Project summary:
   - Demonstrated functionalities
   - Project structure
   - Generated reports

5. **CSV Files** - Exportable data for Excel analysis

---

##  USE CASES

### Case 1: Inventory Analysis

```powershell
# 1. Generate data
java -cp bin GenerateInfoFiles

# 2. Process
java -cp bin Main

# 3. Review product report
notepad output\product_report.txt
```

**Information obtained:**
- Total inventory value
- Products that need restocking
- Product distribution by category
- Most valuable products

### Case 2: Commission Calculation

```powershell
# Review salesmen report
notepad output\salesmen_report.txt
```

**Information obtained:**
- Each salesman's commission (10% of revenue)
- Salesmen qualifying for bonus ($5,000)
- Best salesmen ranking
- Average sale per salesman

### Case 3: Export to Excel

```powershell
# Open CSV files with Excel
start output\product_report.csv
start output\salesmen_report.csv
```

**Usage:**
- Additional analysis in Excel
- Chart creation
- Custom filtering and sorting
- Sharing with other systems

---

## TROUBLESHOOTING

### Error: "javac is not recognized as a command"

**Cause:** Java JDK is not in the system PATH.

**Solution:**
```powershell
# Option 1: Add to PATH temporarily
$env:PATH = "C:\Program Files\Java\jdk1.8.0_202\bin;" + $env:PATH

# Option 2: Use full path
"C:\Program Files\Java\jdk1.8.0_202\bin\javac" -d bin src\*.java
```

### Error: "main class not found or loaded"

**Cause:** Incorrect classpath or files not compiled.

**Solution:**
```powershell
# Recompile
javac -d bin src\*.java

# Execute with correct classpath
java -cp bin GenerateInfoFiles
java -cp bin Main
```

### Error: "Error writing file"

**Cause:** Insufficient permissions or disk full.

**Solution:**
```powershell
# Run as administrator or verify permissions
# Ensure disk space (needs ~5MB)
```

### Reports are empty

**Cause:** GenerateInfoFiles was not executed first.

**Solution:**
```powershell
# Step 1: Generate data
java -cp bin GenerateInfoFiles

# Step 2: Process data
java -cp bin Main
```

---

## ADDITIONAL DOCUMENTATION

### Complete Documentation

For detailed technical information, system architecture, diagrams and explanations of each component, see:

** [DOCUMENTACION.md](DOCUMENTACION.md)** - 30+ pages including:
- System architecture
- Documentation of each class and method
- Flow diagrams
- Applied best practices
- Detailed examples
- References and resources

### Project Conclusions

For learnings, challenges faced and results obtained, see:

** [conclusion.txt](conclusion.txt)** - Detailed conclusions including:
- What was learned in the project
- Professional applications
- Challenges and solutions
- Developed competencies
- Next steps

---

##  DEMONSTRATED CONCEPTS

This project demonstrates mastery of:

### Object-Oriented Programming
- Classes with appropriate encapsulation
- Constructors with validation
- Methods with clear responsibilities
- Method and constructor overloading

### File Handling
- Reading TXT and CSV files
- Formatted writing with PrintWriter
- Directory management
- UTF-8 encoding

### Data Structures
- ArrayList for dynamic collections
- HashMap for grouping
- Sorting with Comparator
- Filtering and searching operations

### Business Logic
- Data validation
- Commission and bonus calculations
- Statistics generation
- Complex business rules

### Best Practices
- Clean and readable code
- Complete Javadoc documentation
- Exception handling
- Constants instead of magic values
- Separation of responsibilities

---

## SUPPORT

If you encounter problems:

1. Verify that Java 8 is correctly installed
2. Make sure to compile before executing
3. Run GenerateInfoFiles before Main
4. Review the Troubleshooting section
5. Consult the complete documentation in DOCUMENTACION.md

---

## CREDITS

**Course:** Fundamental Programming Concepts  
**Delivery:** Weeks 7 and 8 - Final Submission  
**Version:** 2.0  
**Date:** October 2024  
**Language:** Java 8 (JDK 1.8.0)  
**Paradigm:** Object-Oriented Programming  

---

##  FEATURED CHARACTERISTICS

### Clear Console Interface
- Informative messages with professional formatting
- Visual separators for better readability
- Status codes ([OK], [ERROR], [WARNING])
- Detailed progress of each operation

### Complete Analysis
- 15 products in 5 different categories
- 10 salesmen distributed in 5 regions
- 30 sales transactions
- 6 complete reports generated

### Realistic Business Logic
- Logical prices according to product type
- Automatic commission calculation (10%)
- Performance bonus system ($50,000+)
- Low inventory detection (<10 units)
- Business rankings and statistics

### Robust Validation
- Validation in constructors
- Validation in setters
- Descriptive error messages
- Invalid data handling without stopping the process

---

## QUICK START

For experienced users:

```powershell
# 1. Compile
javac -d bin src\*.java

# 2. Generate data
java -cp bin GenerateInfoFiles

# 3. Process and generate reports
java -cp bin Main

# 4. View summary
notepad output\executive_summary.txt
```

---

## IMPORTANT NOTES

- The project requires Java 8 or higher
- Files are generated in `input/` and `output/` directories
- CSV files use semicolon (;) as separator
- Encoding is UTF-8 to support special characters
- Data is randomly generated but reproducibly
- The project works without external dependencies
- All processing is automatic (no user input required)

---

## NEXT STEPS AFTER EXECUTION

1. **Review generated reports** in the `output/` folder
2. **Consult technical documentation** in `DOCUMENTACION.md`
3. **Read conclusions** in `conclusion.txt`
4. **Explore source code** in `src/` to understand the implementation
5. **Experiment with modifications** (add products, change business rules)

---

** Thank you for using the Product and Salesman Management System!**

**© 2025 - Conceptos Fundamentales de Programación - Entrega Final Semanas 7 y 8**
