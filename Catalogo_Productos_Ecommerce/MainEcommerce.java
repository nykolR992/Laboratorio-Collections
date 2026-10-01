package Catalogo_Productos_Ecommerce;

public class MainEcommerce {
    public static void main(String[] args) {
        Ecommerce ecommerce = new Ecommerce();

        // Agregar productos
        ecommerce.agregarProducto(new Producto("Laptop", "P001", 1200.00));
        ecommerce.agregarProducto(new Producto("Smartphone", "P002", 800.00));
        ecommerce.agregarProducto(new Producto("Tablet", "P003", 500.00));
        ecommerce.agregarProducto(new Producto("Monitor", "P004", 300.00));

        // Mostrar productos ordenados por precio
        System.out.println("Productos ordenados por precio:");
        ecommerce.mostrarProductosOrdenados();

        // Buscar un producto por código
        System.out.println("\nBuscando producto con código P002:");
        System.out.println(ecommerce.buscarProducto("P002"));
    }
}
