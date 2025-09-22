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

1. Run GenerateInfoFiles to create input files:
   ```
   javac -d . src/GenerateInfoFiles.java
   java GenerateInfoFiles
   ```
2. Run Main to process and produce reports:
   ```
   javac -d . src/*.java
   java Main
   ```

Reports will be available in the `output/` folder.
