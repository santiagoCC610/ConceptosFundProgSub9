# 🚀 Sistema de Gestión de Productos y Vendedores
## Conceptos Fundamentales de Programación - Semanas 7 y 8

[![Java Version](https://img.shields.io/badge/Java-8-orange)](https://www.oracle.com/java/technologies/javase/javase8-archive-downloads.html)
[![Status](https://img.shields.io/badge/Status-Completed-success)](https://github.com)
[![License](https://img.shields.io/badge/License-Educational-blue)](LICENSE)

---

## 📋 DESCRIPCIÓN DEL PROYECTO

Sistema completo de gestión empresarial desarrollado en Java que permite:

- ✅ **Generar** datos de prueba automáticamente (productos, vendedores, ventas)
- ✅ **Procesar** y analizar información empresarial
- ✅ **Calcular** comisiones, bonos, inventarios y estadísticas
- ✅ **Generar** reportes detallados en múltiples formatos (TXT, CSV)
- ✅ **Validar** datos con manejo robusto de errores

### 🎯 Características Principales

- **Modelos de Datos:** ProductModel y SalesmanModel con validación completa
- **Generación Automática:** 15 productos, 10 vendedores, 30 ventas
- **Análisis Completo:** Inventarios, comisiones, bonos, rankings, estadísticas
- **6 Reportes:** Análisis de productos, vendedores, ventas y resumen ejecutivo
- **Buenas Prácticas:** POO, validaciones, documentación Javadoc, código limpio

---

## 📁 ESTRUCTURA DEL PROYECTO

```
ConceptosFundProgSub9-1/
├── src/                          # Código fuente
│   ├── GenerateInfoFiles.java   # Generador de datos de entrada
│   ├── Main.java                 # Procesador y generador de reportes
│   ├── ProductModel.java         # Modelo de productos con lógica de negocio
│   └── SalesmanModel.java        # Modelo de vendedores con cálculo de comisiones
│
├── bin/                          # Clases compiladas (.class)
│
├── input/                        # Archivos de entrada (generados automáticamente)
│   ├── data.txt                  # Datos simples de productos
│   ├── data.csv                  # Datos estructurados de productos
│   ├── products.txt              # Inventario completo con categorías
│   ├── salesmen.txt              # Base de datos de vendedores
│   └── sales_records.csv         # Registros de transacciones
│
├── output/                       # Reportes generados
│   ├── product_report.txt        # Análisis detallado de productos
│   ├── product_report.csv        # Datos de productos exportables
│   ├── salesmen_report.txt       # Análisis de desempeño de vendedores
│   ├── salesmen_report.csv       # Datos de vendedores exportables
│   ├── sales_records_report.txt  # Reporte de transacciones
│   └── executive_summary.txt     # Resumen ejecutivo del sistema
│
├── README.md                     # Esta guía de ejecución
├── DOCUMENTACION.md              # Documentación técnica completa (30+ páginas)
└── conclusion.txt                # Conclusiones detalladas del proyecto
```

---

## 🔧 REQUISITOS DEL SISTEMA

### Software Necesario

- **Java Development Kit (JDK) 8 o superior**
- **Terminal/PowerShell** con acceso a comandos `java` y `javac`
- **Editor de texto** o IDE (opcional: IntelliJ IDEA, Eclipse, VSCode)

### Sistemas Operativos Soportados

- ✅ Windows 10/11
- ✅ macOS
- ✅ Linux

---

## ⚡ GUÍA DE INSTALACIÓN Y EJECUCIÓN

### 📌 Paso 0: Verificar Instalación de Java

```powershell
# Verificar versión de Java Runtime
java -version

# Verificar versión del compilador Java
javac -version
```

**Salida esperada:**
```
java version "1.8.0_202"
Java(TM) SE Runtime Environment (build 1.8.0_202-b08)
javac 1.8.0_202
```

**⚠️ Si `javac` no está disponible:**

```powershell
# Windows: Configurar PATH temporalmente
$env:PATH = "C:\Program Files\Java\jdk1.8.0_202\bin;" + $env:PATH

# Verificar nuevamente
javac -version
```

---

### 📌 Paso 1: Compilar el Proyecto

```powershell
# Crear directorio para clases compiladas
mkdir bin

# Compilar todos los archivos Java
javac -d bin src\*.java
```

**Resultado esperado:**
```
✓ No hay errores de compilación
✓ Archivos .class creados en bin/
```

**⚠️ Solución de Problemas:**

Si aparece error "no se puede encontrar el símbolo", asegúrate de compilar todos los archivos juntos:
```powershell
javac -d bin src\GenerateInfoFiles.java src\Main.java src\ProductModel.java src\SalesmanModel.java
```

---

### 📌 Paso 2: Generar Datos de Entrada

```powershell
# Ejecutar el generador de datos
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

**✅ Verificación:**
```powershell
# Listar archivos creados
dir input\

# Debería mostrar:
# - data.txt
# - data.csv
# - products.txt
# - salesmen.txt
# - sales_records.csv
```

---

### 📌 Paso 3: Procesar Datos y Generar Reportes

```powershell
# Ejecutar el procesador principal
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

**✅ Verificación:**
```powershell
# Listar reportes generados
dir output\

# Debería mostrar:
# - product_report.txt
# - product_report.csv
# - salesmen_report.txt
# - salesmen_report.csv
# - sales_records_report.txt
# - executive_summary.txt
```

---

## 📊 REVISIÓN DE RESULTADOS

### Abrir Reportes Generados

```powershell
# Windows - Abrir con Notepad
notepad output\executive_summary.txt
notepad output\product_report.txt
notepad output\salesmen_report.txt

# Abrir CSV con Excel (si está instalado)
start output\product_report.csv
start output\salesmen_report.csv
```

### Contenido de los Reportes

1. **product_report.txt** - Análisis completo del inventario:
   - Valor total del inventario
   - Productos con bajo stock
   - Distribución por categorías
   - Lista detallada ordenada por valor

2. **salesmen_report.txt** - Análisis de desempeño:
   - Revenue total generado
   - Comisiones calculadas (10%)
   - Vendedores con bono ($50,000+)
   - Top 5 performers
   - Distribución regional

3. **sales_records_report.txt** - Transacciones individuales:
   - Lista de todas las ventas
   - Total y promedio de ventas

4. **executive_summary.txt** - Resumen del proyecto:
   - Funcionalidades demostradas
   - Estructura del proyecto
   - Reportes generados

5. **Archivos CSV** - Datos exportables para análisis en Excel

---

## 🎯 CASOS DE USO

### Caso 1: Análisis de Inventario

```powershell
# 1. Generar datos
java -cp bin GenerateInfoFiles

# 2. Procesar
java -cp bin Main

# 3. Revisar reporte de productos
notepad output\product_report.txt
```

**Información obtenida:**
- Valor total del inventario
- Productos que necesitan reabastecimiento
- Distribución de productos por categoría
- Los productos más valiosos

### Caso 2: Cálculo de Comisiones

```powershell
# Revisar reporte de vendedores
notepad output\salesmen_report.txt
```

**Información obtenida:**
- Comisión de cada vendedor (10% del revenue)
- Vendedores que califican para bono ($5,000)
- Ranking de mejores vendedores
- Promedio de venta por vendedor

### Caso 3: Exportar a Excel

```powershell
# Abrir archivos CSV con Excel
start output\product_report.csv
start output\salesmen_report.csv
```

**Uso:**
- Análisis adicional en Excel
- Creación de gráficos
- Filtrado y ordenamiento personalizado
- Compartir con otros sistemas

---

## 🔍 SOLUCIÓN DE PROBLEMAS

### Error: "javac no se reconoce como comando"

**Causa:** Java JDK no está en el PATH del sistema.

**Solución:**
```powershell
# Opción 1: Agregar al PATH temporalmente
$env:PATH = "C:\Program Files\Java\jdk1.8.0_202\bin;" + $env:PATH

# Opción 2: Usar ruta completa
"C:\Program Files\Java\jdk1.8.0_202\bin\javac" -d bin src\*.java
```

### Error: "no se ha encontrado o cargado la clase principal"

**Causa:** Classpath incorrecto o archivos no compilados.

**Solución:**
```powershell
# Recompilar
javac -d bin src\*.java

# Ejecutar con classpath correcto
java -cp bin GenerateInfoFiles
java -cp bin Main
```

### Error: "Error al escribir archivo"

**Causa:** Permisos insuficientes o disco lleno.

**Solución:**
```powershell
# Ejecutar como administrador o verificar permisos
# Asegurar espacio en disco (necesita ~5MB)
```

### Los reportes están vacíos

**Causa:** No se ejecutó GenerateInfoFiles primero.

**Solución:**
```powershell
# Paso 1: Generar datos
java -cp bin GenerateInfoFiles

# Paso 2: Procesar datos
java -cp bin Main
```

---

## 📚 DOCUMENTACIÓN ADICIONAL

### Documentación Completa

Para información técnica detallada, arquitectura del sistema, diagramas y explicaciones de cada componente, consulta:

**📘 [DOCUMENTACION.md](DOCUMENTACION.md)** - 30+ páginas que incluyen:
- Arquitectura del sistema
- Documentación de cada clase y método
- Diagramas de flujo
- Buenas prácticas aplicadas
- Ejemplos detallados
- Referencias y recursos

### Conclusiones del Proyecto

Para aprendizajes, dificultades enfrentadas y resultados obtenidos, consulta:

**📄 [conclusion.txt](conclusion.txt)** - Conclusiones detalladas que incluyen:
- Lo aprendido en el proyecto
- Aplicaciones profesionales
- Dificultades y soluciones
- Competencias desarrolladas
- Próximos pasos

---

## 🎓 CONCEPTOS DEMOSTRADOS

Este proyecto demuestra dominio en:

### Programación Orientada a Objetos
- ✅ Clases con encapsulación apropiada
- ✅ Constructores con validación
- ✅ Métodos con responsabilidades claras
- ✅ Sobrecarga de métodos y constructores

### Manejo de Archivos
- ✅ Lectura de archivos TXT y CSV
- ✅ Escritura formateada con PrintWriter
- ✅ Manejo de directorios
- ✅ Codificación UTF-8

### Estructuras de Datos
- ✅ ArrayList para colecciones dinámicas
- ✅ HashMap para agrupaciones
- ✅ Ordenamiento con Comparator
- ✅ Operaciones de filtrado y búsqueda

### Lógica de Negocio
- ✅ Validación de datos
- ✅ Cálculos de comisiones y bonos
- ✅ Generación de estadísticas
- ✅ Reglas de negocio complejas

### Buenas Prácticas
- ✅ Código limpio y legible
- ✅ Documentación Javadoc completa
- ✅ Manejo de excepciones
- ✅ Constantes en lugar de valores mágicos
- ✅ Separación de responsabilidades

---

## 📞 SOPORTE

Si encuentras problemas:

1. ✅ Verifica que Java 8 esté correctamente instalado
2. ✅ Asegúrate de compilar antes de ejecutar
3. ✅ Ejecuta GenerateInfoFiles antes que Main
4. ✅ Revisa la sección de Solución de Problemas
5. ✅ Consulta la documentación completa en DOCUMENTACION.md

---

## 🏆 CRÉDITOS

**Curso:** Conceptos Fundamentales de Programación  
**Entrega:** Semanas 7 y 8 - Entrega Final  
**Versión:** 2.0  
**Fecha:** Octubre 2024  
**Lenguaje:** Java 8 (JDK 1.8.0)  
**Paradigma:** Programación Orientada a Objetos  

---

## ⭐ CARACTERÍSTICAS DESTACADAS

### 🎨 Interfaz de Consola Clara
- Mensajes informativos con formato profesional
- Separadores visuales para mejor legibilidad
- Códigos de estado ([OK], [ERROR], [WARNING])
- Progreso detallado de cada operación

### 📈 Análisis Completo
- 15 productos en 5 categorías diferentes
- 10 vendedores distribuidos en 5 regiones
- 30 transacciones de venta
- 6 reportes completos generados

### 💼 Lógica de Negocio Realista
- Precios lógicos según tipo de producto
- Cálculo automático de comisiones (10%)
- Sistema de bonos por desempeño ($50,000+)
- Detección de bajo inventario (<10 unidades)
- Rankings y estadísticas empresariales

### 🔒 Validación Robusta
- Validación en constructores
- Validación en setters
- Mensajes de error descriptivos
- Manejo de datos inválidos sin detener el proceso

---

## 🚀 EJECUCIÓN RÁPIDA (Quick Start)

Para usuarios experimentados:

```powershell
# 1. Compilar
javac -d bin src\*.java

# 2. Generar datos
java -cp bin GenerateInfoFiles

# 3. Procesar y generar reportes
java -cp bin Main

# 4. Ver resumen
notepad output\executive_summary.txt
```

---

## 📝 NOTAS IMPORTANTES

- ⚠️ El proyecto requiere Java 8 o superior
- ⚠️ Los archivos se generan en directorios `input/` y `output/`
- ⚠️ Los archivos CSV usan punto y coma (;) como separador
- ⚠️ La codificación es UTF-8 para soportar caracteres especiales
- ⚠️ Los datos son generados aleatoriamente pero de forma reproducible
- ✅ El proyecto funciona sin dependencias externas
- ✅ Todo el procesamiento es automático (no requiere entrada del usuario)

---

## ✨ PRÓXIMOS PASOS DESPUÉS DE LA EJECUCIÓN

1. **Revisar los reportes generados** en la carpeta `output/`
2. **Consultar la documentación técnica** en `DOCUMENTACION.md`
3. **Leer las conclusiones** en `conclusion.txt`
4. **Explorar el código fuente** en `src/` para entender la implementación
5. **Experimentar con modificaciones** (agregar productos, cambiar reglas de negocio)

---

**🎉 ¡Gracias por usar el Sistema de Gestión de Productos y Vendedores!**

**© 2024 - Conceptos Fundamentales de Programación - Entrega Final Semanas 7 y 8**
