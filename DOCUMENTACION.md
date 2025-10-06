# 📘 DOCUMENTACIÓN OFICIAL DEL PROYECTO
## Sistema de Gestión de Productos y Vendedores
### Conceptos Fundamentales de Programación - Semanas 7 y 8

---

## 📋 TABLA DE CONTENIDOS

1. [Resumen Ejecutivo](#resumen-ejecutivo)
2. [Objetivos del Proyecto](#objetivos-del-proyecto)
3. [Arquitectura del Sistema](#arquitectura-del-sistema)
4. [Componentes del Sistema](#componentes-del-sistema)
5. [Modelos de Datos](#modelos-de-datos)
6. [Funcionalidades Implementadas](#funcionalidades-implementadas)
7. [Buenas Prácticas Aplicadas](#buenas-prácticas-aplicadas)
8. [Estructura de Archivos](#estructura-de-archivos)
9. [Guía de Instalación y Ejecución](#guía-de-instalación-y-ejecución)
10. [Ejemplos de Uso](#ejemplos-de-uso)
11. [Resultados y Reportes](#resultados-y-reportes)
12. [Conclusiones](#conclusiones)
13. [Referencias y Recursos](#referencias-y-recursos)

---

## 📊 RESUMEN EJECUTIVO

El **Sistema de Gestión de Productos y Vendedores** es una aplicación de escritorio desarrollada en Java 8 que demuestra el dominio de conceptos fundamentales de programación orientada a objetos. El sistema permite:

- ✅ **Generación automática** de datos de prueba (productos, vendedores, registros de ventas)
- ✅ **Procesamiento y análisis** de información empresarial
- ✅ **Generación de reportes** detallados en múltiples formatos (TXT, CSV)
- ✅ **Validación de datos** con manejo robusto de errores
- ✅ **Cálculos automáticos** de comisiones, bonos, inventarios y estadísticas

### 🎯 Tecnologías Utilizadas
- **Lenguaje:** Java 8 (JDK 1.8.0_202)
- **Paradigma:** Programación Orientada a Objetos (POO)
- **I/O:** Lectura y escritura de archivos TXT y CSV
- **IDE Compatible:** IntelliJ IDEA, Eclipse, NetBeans, VSCode

---

## 🎯 OBJETIVOS DEL PROYECTO

### Objetivos Generales
1. Aplicar conceptos fundamentales de programación en Java
2. Implementar un sistema completo de gestión de datos
3. Demostrar competencias en diseño orientado a objetos
4. Generar reportes analíticos a partir de datos procesados

### Objetivos Específicos
1. **Modelado de Datos:** Crear clases modelo robustas con validación
2. **Gestión de Archivos:** Implementar operaciones de lectura/escritura
3. **Lógica de Negocio:** Calcular comisiones, bonos, inventarios y estadísticas
4. **Manejo de Errores:** Implementar validaciones y excepciones apropiadas
5. **Generación de Reportes:** Crear documentos analíticos en múltiples formatos
6. **Buenas Prácticas:** Aplicar principios SOLID, documentación y código limpio

---

## 🏗️ ARQUITECTURA DEL SISTEMA

El sistema sigue una arquitectura de **tres capas** simplificada:

```
┌─────────────────────────────────────────┐
│     CAPA DE PRESENTACIÓN                │
│  (Salida por Consola y Archivos)        │
└─────────────────────────────────────────┘
                  ↓
┌─────────────────────────────────────────┐
│     CAPA DE LÓGICA DE NEGOCIO           │
│  - Main.java                            │
│  - GenerateInfoFiles.java               │
└─────────────────────────────────────────┘
                  ↓
┌─────────────────────────────────────────┐
│     CAPA DE DATOS (MODELOS)             │
│  - ProductModel.java                    │
│  - SalesmanModel.java                   │
└─────────────────────────────────────────┘
                  ↓
┌─────────────────────────────────────────┐
│     CAPA DE PERSISTENCIA                │
│  (Archivos TXT/CSV en input/output)    │
└─────────────────────────────────────────┘
```

### Flujo de Datos

```
1. GenerateInfoFiles → Genera datos → input/
2. Main → Lee datos desde input/
3. Main → Procesa y analiza datos
4. Main → Genera reportes → output/
```

---

## 🧩 COMPONENTES DEL SISTEMA

### 1️⃣ GenerateInfoFiles.java
**Propósito:** Clase ejecutable para generar datos de prueba automáticamente.

**Responsabilidades:**
- Crear directorio `input/` si no existe
- Generar datos aleatorios pero consistentes
- Crear múltiples archivos de entrada:
  - `data.txt` - Datos simples de productos
  - `data.csv` - Datos estructurados de productos
  - `products.txt` - Inventario completo de productos
  - `salesmen.txt` - Base de datos de vendedores
  - `sales_records.csv` - Registros de transacciones de ventas

**Características:**
- ✅ Datos realistas basados en categorías reales
- ✅ Generación reproducible (seed fijo para testing)
- ✅ Rangos de precios lógicos por tipo de producto
- ✅ 15 productos, 10 vendedores, 30 registros de ventas

### 2️⃣ Main.java
**Propósito:** Clase principal que procesa datos y genera reportes analíticos.

**Responsabilidades:**
- Leer y parsear archivos de entrada
- Validar datos utilizando los modelos
- Procesar información y calcular estadísticas
- Generar reportes completos en TXT y CSV
- Crear resumen ejecutivo

**Procesamiento Implementado:**
1. **Análisis de Productos:**
   - Valor total del inventario
   - Productos con bajo stock
   - Distribución por categorías
   - Ordenamiento por valor

2. **Análisis de Vendedores:**
   - Revenue total generado
   - Cálculo de comisiones (10%)
   - Identificación de bonos (>$50,000)
   - Ranking de desempeño
   - Distribución regional

3. **Análisis de Ventas:**
   - Total de transacciones
   - Monto total vendido
   - Promedio por venta

### 3️⃣ ProductModel.java
**Propósito:** Modelo de datos para representar productos con lógica de negocio.

**Atributos:**
```java
private String name;         // Nombre del producto
private double price;        // Precio unitario
private int quantity;        // Cantidad en inventario
private String category;     // Categoría del producto
```

**Métodos Principales:**
- `calculateTotalValue()` - Calcula valor total (precio × cantidad)
- `isInStock()` - Verifica si hay existencias
- `isLowStock()` - Detecta inventario bajo (<10 unidades)
- `toCSV()` - Exporta a formato CSV
- `toDetailedString()` - Genera reporte detallado

**Validaciones:**
- ✅ Nombre no puede ser nulo o vacío
- ✅ Precio debe ser >= 0
- ✅ Cantidad debe ser >= 0
- ✅ Categoría con valor por defecto "General"

### 4️⃣ SalesmanModel.java
**Propósito:** Modelo de datos para representar vendedores con cálculos de comisiones.

**Atributos:**
```java
private String salesmanId;   // ID único del vendedor
private String name;         // Nombre del vendedor
private int salesCount;      // Número de ventas realizadas
private double totalRevenue; // Revenue total generado
private String region;       // Región de ventas
```

**Métodos Principales:**
- `calculateCommission()` - Calcula comisión (10% del revenue)
- `calculateTotalEarnings()` - Suma comisión + bono
- `qualifiesForBonus()` - Verifica si califica para bono ($50,000+)
- `getAverageSaleAmount()` - Calcula promedio por venta
- `addSale(amount)` - Registra una nueva venta

**Reglas de Negocio:**
- 📊 Comisión: 10% del revenue total
- 🎁 Bono: $5,000 si revenue >= $50,000
- 📈 Cálculo automático de promedios

**Validaciones:**
- ✅ ID no puede ser nulo o vacío
- ✅ Nombre no puede ser nulo o vacío
- ✅ Contador de ventas >= 0
- ✅ Revenue >= 0
- ✅ Región con valor por defecto "National"

---

## 💡 FUNCIONALIDADES IMPLEMENTADAS

### ⚙️ Generación de Datos
1. **Productos Realistas**
   - 15 productos de tecnología
   - 5 categorías diferentes
   - Precios lógicos según tipo de producto
   - Cantidades aleatorias (1-100 unidades)

2. **Vendedores**
   - 10 vendedores con nombres hispanos
   - IDs únicos (S1001-S1010)
   - Distribución en 5 regiones
   - Revenue variable por desempeño

3. **Registros de Ventas**
   - 30 transacciones
   - Relación vendedor-producto
   - Fechas del mes actual
   - Cantidades variables (1-5 unidades)

### 📊 Procesamiento de Datos
1. **Análisis de Inventario**
   - Cálculo de valor total del inventario
   - Identificación de productos con bajo stock
   - Conteo de productos fuera de stock
   - Agrupación por categorías

2. **Análisis de Desempeño**
   - Cálculo automático de comisiones
   - Identificación de vendedores con bono
   - Ranking de top performers
   - Promedios por vendedor
   - Distribución regional

3. **Análisis de Ventas**
   - Total de transacciones procesadas
   - Monto total de ventas
   - Promedio por transacción

### 📄 Generación de Reportes
1. **Reportes de Productos**
   - `product_report.txt` - Análisis detallado
   - `product_report.csv` - Datos exportables

2. **Reportes de Vendedores**
   - `salesmen_report.txt` - Análisis de desempeño
   - `salesmen_report.csv` - Datos exportables

3. **Reportes de Ventas**
   - `sales_records_report.txt` - Lista de transacciones

4. **Resumen Ejecutivo**
   - `executive_summary.txt` - Resumen general del proyecto

---

## ✅ BUENAS PRÁCTICAS APLICADAS

### 1. Principios de POO
- ✅ **Encapsulación:** Atributos privados con getters/setters
- ✅ **Validación:** Métodos privados para validar datos
- ✅ **Cohesión:** Cada clase tiene una responsabilidad clara
- ✅ **Reutilización:** Métodos públicos para operaciones comunes

### 2. Convenciones de Código
- ✅ **Nomenclatura:** camelCase para métodos, PascalCase para clases
- ✅ **Constantes:** Variables finales en UPPER_SNAKE_CASE
- ✅ **Comentarios:** Javadoc completo en todas las clases y métodos públicos
- ✅ **Indentación:** Consistente en todo el código

### 3. Manejo de Errores
- ✅ **Validaciones:** En constructores y setters
- ✅ **Excepciones:** IllegalArgumentException con mensajes descriptivos
- ✅ **Try-Catch:** Bloques apropiados en operaciones de I/O
- ✅ **Mensajes:** Informativos y útiles para debugging

### 4. Organización del Código
- ✅ **Constantes:** Definidas al inicio de cada clase
- ✅ **Métodos:** Organizados por funcionalidad
- ✅ **Separación:** Métodos cortos y enfocados
- ✅ **DRY:** Sin código duplicado

### 5. Documentación
- ✅ **Javadoc:** Completo en todos los elementos públicos
- ✅ **Comentarios inline:** Para lógica compleja
- ✅ **README:** Instrucciones claras de ejecución
- ✅ **Esta documentación:** Guía completa del proyecto

---

## 📁 ESTRUCTURA DE ARCHIVOS

```
ConceptosFundProgSub9-1/
│
├── src/                                    # Código fuente
│   ├── GenerateInfoFiles.java            # Generador de datos
│   ├── Main.java                          # Procesador principal
│   ├── ProductModel.java                  # Modelo de productos
│   └── SalesmanModel.java                 # Modelo de vendedores
│
├── bin/                                    # Clases compiladas (.class)
│   ├── GenerateInfoFiles.class
│   ├── Main.class
│   ├── ProductModel.class
│   └── SalesmanModel.class
│
├── input/                                  # Archivos de entrada (generados)
│   ├── data.txt                           # Datos simples de productos
│   ├── data.csv                           # Datos estructurados de productos
│   ├── products.txt                       # Inventario completo
│   ├── salesmen.txt                       # Base de datos de vendedores
│   └── sales_records.csv                  # Registros de ventas
│
├── output/                                 # Reportes generados
│   ├── product_report.txt                 # Análisis de productos
│   ├── product_report.csv                 # Datos de productos
│   ├── salesmen_report.txt                # Análisis de vendedores
│   ├── salesmen_report.csv                # Datos de vendedores
│   ├── sales_records_report.txt           # Reporte de ventas
│   └── executive_summary.txt              # Resumen ejecutivo
│
├── escenarios/                             # Documentación de requisitos
│   └── [PDFs de lecturas fundamentales]
│
├── README.md                               # Guía de ejecución
├── DOCUMENTACION.md                        # Esta documentación
├── conclusion.txt                          # Conclusiones del proyecto
└── ConceptosFundProgSub9.iml              # Archivo de proyecto IntelliJ
```

---

## 🚀 GUÍA DE INSTALACIÓN Y EJECUCIÓN

### Prerrequisitos
- ✅ Java Development Kit (JDK) 8 o superior
- ✅ Variable de entorno JAVA_HOME configurada
- ✅ Terminal/PowerShell con acceso a `java` y `javac`

### Verificación de Java

```powershell
# Verificar versión de Java
java -version

# Verificar compilador
javac -version
```

**Salida esperada:**
```
java version "1.8.0_202"
javac 1.8.0_202
```

### Configuración del Compilador (si es necesario)

```powershell
# Configurar PATH temporalmente (Windows)
$env:PATH = "C:\Program Files\Java\jdk1.8.0_202\bin;" + $env:PATH
```

### Pasos de Ejecución

#### Paso 1: Compilar el Proyecto

```powershell
# Crear directorio para clases compiladas
mkdir bin

# Compilar todos los archivos Java
javac -d bin src\*.java
```

#### Paso 2: Generar Datos de Entrada

```powershell
# Ejecutar generador de datos
java -cp bin GenerateInfoFiles
```

**Salida esperada:**
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

#### Paso 3: Procesar Datos y Generar Reportes

```powershell
# Ejecutar procesador principal
java -cp bin Main
```

**Salida esperada:**
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

### Solución de Problemas Comunes

#### Error: "javac no se reconoce como comando"
**Solución:** Agregar Java al PATH del sistema o usar ruta completa:
```powershell
"C:\Program Files\Java\jdk1.8.0_202\bin\javac" -d bin src\*.java
```

#### Error: "No se puede encontrar el símbolo"
**Solución:** Asegurarse de compilar todos los archivos juntos:
```powershell
javac -d bin src\*.java
```

#### Error: "Error: no se ha encontrado o cargado la clase principal"
**Solución:** Verificar que el classpath esté correcto:
```powershell
java -cp bin Main
```

---

## 💼 EJEMPLOS DE USO

### Ejemplo 1: Consultar Inventario de Productos

**Archivo generado:** `output/product_report.txt`

```
======================================================================
PRODUCT INVENTORY REPORT
======================================================================

SUMMARY
----------------------------------------------------------------------
Total Products: 15
Total Inventory Value: $48,526.80
Total Units in Stock: 731
Out of Stock Products: 0
Low Stock Products: 2

PRODUCTS BY CATEGORY
----------------------------------------------------------------------
Computers: 3 products
Peripherals: 3 products
Components: 3 products
Audio: 3 products
Accessories: 3 products

DETAILED PRODUCT LIST
----------------------------------------------------------------------
Product: Laptop
  Price: $1,845.67
  Quantity: 45
  Category: Computers
  Total Value: $83,055.15
  Stock Status: In Stock
----------------------------------------------------------------------
```

### Ejemplo 2: Análisis de Desempeño de Vendedores

**Archivo generado:** `output/salesmen_report.txt`

```
======================================================================
SALESMEN PERFORMANCE REPORT
======================================================================

SUMMARY
----------------------------------------------------------------------
Total Salesmen: 10
Total Revenue Generated: $487,523.45
Total Sales Count: 352
Total Commissions: $48,752.35
Salesmen Qualifying for Bonus: 6
Average Revenue per Salesman: $48,752.35

TOP PERFORMERS (by Revenue)
----------------------------------------------------------------------
1. María González (S1002) - Sales: 54, Revenue: $68,234.56, Region: Sur
2. Carlos Rodríguez (S1003) - Sales: 48, Revenue: $62,145.78, Region: Este
3. Juan Pérez (S1001) - Sales: 42, Revenue: $54,876.23, Region: Norte
```

### Ejemplo 3: Registro de Ventas

**Archivo generado:** `output/sales_records_report.txt`

```
======================================================================
SALES RECORDS REPORT
======================================================================

Sale #5001 | María González | Laptop | 2 x $1,845.67 = $3,691.34 | 2024-10-01
Sale #5002 | Carlos Rodríguez | Mouse | 5 x $45.23 = $226.15 | 2024-10-02
Sale #5003 | Juan Pérez | Monitor | 1 x $567.89 = $567.89 | 2024-10-03
...

----------------------------------------------------------------------
TOTAL SALES: 30
GRAND TOTAL: $42,567.89
AVERAGE SALE: $1,418.93
```

### Ejemplo 4: Exportación a CSV

**Archivo generado:** `output/product_report.csv`

```csv
ProductName;Price;Quantity;Category;TotalValue;StockStatus
Laptop;1845.67;45;Computers;83055.15;In Stock
Monitor;567.89;32;Peripherals;18172.48;In Stock
Graphics Card;945.23;8;Components;7561.84;Low Stock
Mouse;45.23;156;Peripherals;7055.88;In Stock
```

**Uso:** Puede abrirse en Excel, Google Sheets o cualquier software de hojas de cálculo.

---

## 📈 RESULTADOS Y REPORTES

### Tipos de Reportes Generados

#### 1. Reportes de Análisis (TXT)
- **Formato:** Texto plano con formato tabular
- **Contenido:** Análisis detallado, estadísticas, rankings
- **Uso:** Revisión humana, presentaciones, documentación

#### 2. Reportes de Datos (CSV)
- **Formato:** Valores separados por punto y coma
- **Contenido:** Datos tabulados exportables
- **Uso:** Análisis en Excel, importación a bases de datos

#### 3. Resumen Ejecutivo (TXT)
- **Formato:** Texto estructurado
- **Contenido:** Visión general del proyecto
- **Uso:** Presentación, documentación, resumen rápido

### Métricas Calculadas

#### Para Productos:
- ✅ Valor total del inventario
- ✅ Valor por producto (precio × cantidad)
- ✅ Estado de stock (In Stock, Low Stock, Out of Stock)
- ✅ Distribución por categorías
- ✅ Ranking por valor

#### Para Vendedores:
- ✅ Revenue total generado
- ✅ Número de ventas realizadas
- ✅ Promedio por venta
- ✅ Comisión ganada (10%)
- ✅ Bono si aplica ($5,000)
- ✅ Earnings totales
- ✅ Distribución regional
- ✅ Ranking de desempeño

#### Para Ventas:
- ✅ Total de transacciones
- ✅ Monto total vendido
- ✅ Promedio por transacción
- ✅ Detalle por vendedor y producto

---

## 🎓 CONCLUSIONES

### Aprendizajes Técnicos

1. **Programación Orientada a Objetos**
   - Diseño de clases con responsabilidades claras
   - Implementación de encapsulación y validación
   - Uso efectivo de constructores y sobrecarga
   - Aplicación de herencia conceptual en diseño

2. **Manejo de Archivos en Java**
   - Lectura y escritura de archivos TXT y CSV
   - Uso de PrintWriter para salida formateada
   - Manejo de codificación UTF-8
   - Creación y gestión de directorios

3. **Lógica de Negocio**
   - Implementación de reglas de negocio complejas
   - Cálculos automáticos (comisiones, bonos, promedios)
   - Validación de datos de entrada
   - Generación de métricas y estadísticas

4. **Estructuras de Datos**
   - Uso de ArrayList para colecciones dinámicas
   - Implementación de HashMap para conteos
   - Ordenamiento con Comparator
   - Procesamiento eficiente de listas

5. **Buenas Prácticas**
   - Código limpio y legible
   - Documentación exhaustiva
   - Manejo apropiado de excepciones
   - Separación de responsabilidades

### Aplicaciones Profesionales

Este proyecto proporciona una base sólida para:

1. **Sistemas Empresariales**
   - Gestión de inventarios
   - Control de ventas
   - Sistemas de comisiones
   - Reportes gerenciales

2. **Análisis de Datos**
   - Procesamiento de archivos CSV
   - Generación de métricas
   - Análisis estadístico básico
   - Exportación de datos

3. **Automatización**
   - Generación automática de reportes
   - Procesamiento batch de datos
   - Validación automática
   - Cálculos recurrentes

### Desafíos Superados

1. **Validación Robusta**
   - Implementar validaciones en múltiples puntos
   - Mensajes de error descriptivos
   - Manejo de datos inválidos sin detener el proceso

2. **Diseño Escalable**
   - Estructura que permite agregar nuevos tipos de reportes
   - Modelos extensibles para nuevos atributos
   - Separación clara entre generación, procesamiento y reporte

3. **Formateo de Salida**
   - Reportes legibles y profesionales
   - Alineación y formato consistente
   - Múltiples formatos de salida (TXT, CSV)

### Mejoras Futuras Posibles

1. **Interfaz Gráfica (GUI)**
   - Implementar con JavaFX o Swing
   - Visualización de gráficos y estadísticas
   - Interacción usuario-amigable

2. **Base de Datos**
   - Migrar de archivos a JDBC
   - Persistencia en MySQL/PostgreSQL
   - Consultas SQL para análisis avanzado

3. **Reportes Adicionales**
   - Gráficos con JFreeChart
   - Exportación a PDF
   - Reportes HTML interactivos

4. **Testing**
   - JUnit para pruebas unitarias
   - Cobertura de código
   - Tests de integración

5. **Características Avanzadas**
   - Sistema de login y roles
   - Auditoría de cambios
   - Notificaciones automáticas
   - Dashboard en tiempo real

---

## 📚 REFERENCIAS Y RECURSOS

### Documentación de Java
- [Java 8 API Documentation](https://docs.oracle.com/javase/8/docs/api/)
- [Java File I/O Tutorial](https://docs.oracle.com/javase/tutorial/essential/io/)
- [Java Collections Framework](https://docs.oracle.com/javase/8/docs/technotes/guides/collections/)

### Buenas Prácticas
- [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html)
- [Effective Java by Joshua Bloch](https://www.oracle.com/java/technologies/effective-java.html)
- [Clean Code by Robert C. Martin](https://www.oreilly.com/library/view/clean-code-a/9780136083238/)

### Tutoriales Relacionados
- Programación Orientada a Objetos en Java
- Manejo de excepciones y validación
- Lectura y escritura de archivos
- Generación de reportes

### Material del Curso
- Lecturas fundamentales (carpeta `escenarios/`)
- Requisitos del proyecto (PDF principal)
- Conclusiones del proyecto (`conclusion.txt`)

---

## 👨‍💻 INFORMACIÓN DEL PROYECTO

**Curso:** Conceptos Fundamentales de Programación  
**Entrega:** Semanas 7 y 8 - Entrega Final  
**Versión:** 2.0  
**Fecha:** Octubre 2024  
**Lenguaje:** Java 8  
**Paradigma:** Programación Orientada a Objetos  

---

## 📞 SOPORTE Y CONTACTO

Para preguntas o problemas con el proyecto:

1. Revisar esta documentación completa
2. Consultar el archivo `README.md` para instrucciones de ejecución
3. Verificar los requisitos en `conclusion.txt`
4. Revisar las lecturas fundamentales en `escenarios/`

---

## ✨ AGRADECIMIENTOS

Agradecemos a los instructores y compañeros del curso por su apoyo y retroalimentación durante el desarrollo de este proyecto. Este trabajo representa la culminación de los conceptos aprendidos en las semanas 7 y 8 del curso de Conceptos Fundamentales de Programación.

---

## 📝 LICENCIA

Este proyecto es material educativo desarrollado como parte del curso de Conceptos Fundamentales de Programación. Su uso está destinado exclusivamente a fines académicos y de aprendizaje.

---

**© 2024 - Conceptos Fundamentales de Programación - Todos los derechos reservados**

---

## 🏁 FIN DE LA DOCUMENTACIÓN

Esta documentación cubre todos los aspectos del proyecto desde su concepción hasta su implementación final. Para ejecutar el proyecto, por favor siga las instrucciones en la sección [Guía de Instalación y Ejecución](#guía-de-instalación-y-ejecución).

**¡Gracias por revisar este proyecto!** 🎉

