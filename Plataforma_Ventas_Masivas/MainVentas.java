package Plataforma_Ventas_Masivas;

public class MainVentas {
    public static void main(String[] args) {
        Ventas ventas = new Ventas();

        Producto p1 = new Producto("Laptop", "P001", 1500.00, "Electrónica");
        Producto p2 = new Producto("Smartphone", "P002", 800.00, "Electrónica");
        Producto p3 = new Producto("Camiseta", "P003", 20.00, "Ropa");
        Producto p4 = new Producto("Pantalones", "P004", 40.00, "Ropa");

        ventas.agregarProducto(p1);
        ventas.agregarProducto(p2);
        ventas.agregarProducto(p3);
        ventas.agregarProducto(p4);

        System.out.println("Productos ordenados por precio:");
        ventas.mostrarProductosOrdenados();

        System.out.println("\nBuscar producto por código P002:");
        System.out.println(ventas.buscarPorCodigo("P002"));

        System.out.println("\nFiltrar productos por categoría 'Ropa':");
        ventas.filtrarPorCategoria("Ropa");
    }
}
