# Entrega 1 - Conceptos Fundamentales de Programación

Proyecto en **Java 8** que genera archivos de entrada para un sistema de ventas.  
Corresponde a la **primera entrega** del módulo *Conceptos Fundamentales de Programación*.

---

## Estructura del proyecto
- `src/` → Código fuente en Java
    - `GenerateInfoFiles.java` → Clase principal que genera los archivos planos de prueba
- `input/` → Archivos generados automáticamente:
    - `products.txt` → Lista de productos con ID, nombre y precio
    - `salesmen_info.txt` → Información de los vendedores
    - `sales_<TipoDoc>_<Numero>.txt` → Ventas asociadas a cada vendedor

---

## Ejecución en IntelliJ
1. Abrir el proyecto en **IntelliJ IDEA** (`File → Open → Seleccionar carpeta del proyecto`).
2. Verificar que la carpeta `src/` esté marcada como **Sources Root**.
3. Abrir el archivo `GenerateInfoFiles.java`.
4. Ejecutar con botón derecho sobre la clase → **Run 'GenerateInfoFiles.main()'**.
5. Los archivos de salida se crean en la carpeta `input/`.

---

## Requisitos
- **Java 8 (JDK 1.8)**
- **IntelliJ IDEA for Java Developers**

---

## Ejemplo de archivos generados
**products.txt**
