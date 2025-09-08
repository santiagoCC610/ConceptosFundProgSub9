# Entrega 1 - Conceptos Fundamentales de Programación

Proyecto en **Java 8** que genera archivos de entrada para un sistema de ventas.
Corresponde a la **primera entrega** del módulo *Conceptos Fundamentales de Programación*.

---

## Estructura del proyecto
- `src/` → Código fuente en Java
    - `GenerateInfoFiles.java` → Clase principal que genera los archivos planos de prueba
- `input/` → Archivos generados automáticamente:
    - `products.txt` → Lista de productos con formato `ID;Nombre;Precio` (precio con 2 decimales)
    - `salesmen_info.txt` → Información de vendedores `Tipo;Numero;Nombres;Apellidos`
    - `sales_<Tipo>_<Numero>.txt` → Ventas de cada vendedor. Primera línea `Tipo;Numero` y luego `IDProducto;Cantidad;` por línea

---

## Formatos de archivo
- Productos (`products.txt`):
  - `IDProducto;NombreProducto;PrecioPorUnidad` (p. ej., `1;Nova Product 1;15.99`)
- Información vendedores (`salesmen_info.txt`):
  - `TipoDocumento;NumeroDocumento;Nombres;Apellidos` (p. ej., `CC;12345678;Santiago;González`)
- Ventas por vendedor (`sales_<Tipo>_<Numero>.txt`):
  - Línea 1: `TipoDocumento;NumeroDocumento`
  - Siguientes líneas: `IDProducto;Cantidad;` (incluye punto y coma final como en el enunciado)

---

## Requisitos
- **Java 8 (JDK 1.8)**
- IDE recomendado: **Eclipse for Java Developers** o **IntelliJ IDEA**

---

## Ejecución
### En Eclipse
1. `File → Import… → Existing Projects into Workspace` y seleccione la carpeta del proyecto.
2. Asegúrese de que `src/` esté marcado como **Source** y que el proyecto use **JDK 1.8**.
3. Abra `GenerateInfoFiles.java` y ejecute `Run → Run As → Java Application`.
4. Verifique la carpeta `input/` para los archivos generados.

### En IntelliJ IDEA
1. `File → Open` y seleccione la carpeta del proyecto.
2. Verifique que `src/` sea **Sources Root**.
3. Abra `GenerateInfoFiles.java` y ejecute **Run 'GenerateInfoFiles.main()'**.
4. Los archivos de salida se crean en `input/`.

---

## Descripción de la generación
Al ejecutar `GenerateInfoFiles` se generan:
- `products.txt` con 20 productos de ejemplo (nombres y precios pseudoaleatorios, precio con 2 decimales y `Locale.US`).
- `salesmen_info.txt` con 10 vendedores (tipos de documento: `CC`, `CE`, `TI`, `NIT`).
- Un archivo `sales_<Tipo>_<Numero>.txt` por cada vendedor con un número aleatorio de líneas de ventas.

No se solicita información al usuario y el programa informa éxito o error por consola.

---

## Notas de implementación (Entrega 1)
- Escritura y lectura en **UTF-8**.
- Buenas prácticas: nombres descriptivos, Javadoc, manejo de errores y directorio de salida asegurado.
- Los formatos siguen exactamente el enunciado (incluye `;` final en líneas de ventas).
