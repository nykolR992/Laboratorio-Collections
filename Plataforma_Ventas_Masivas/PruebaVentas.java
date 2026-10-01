package Plataforma_Ventas_Masivas;

import java.util.Random;

public class PruebaVentas {

    public static void main(String[] args) {

        int[] tamaños = {100, 1000, 10000, 100000};

        for (int n : tamaños) {

            Ventas ventas = new Ventas();
            Random random = new Random();

            long memoriaAntes = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

            long inicio = System.nanoTime();

            // Insertar productos
            for (int i = 0; i < n; i++) {

                String codigo = "P" + i;
                String nombre = "Producto" + i;
                double precio = random.nextDouble() * 1000;

                String categoria;
                if (i % 3 == 0)
                    categoria = "Tecnologia";
                else if (i % 3 == 1)
                    categoria = "Hogar";
                else
                    categoria = "Deportes";

                Producto p = new Producto(codigo, nombre, precio, categoria);

                ventas.agregarProducto(p);
            }

            // Buscar un producto
            ventas.buscarPorCodigo("P" + (n / 2));

            long fin = System.nanoTime();

            long memoriaDespues = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

            long tiempo = fin - inicio;

            long memoriaUsada = memoriaDespues - memoriaAntes;

            System.out.println("Cantidad de productos: " + n);
            System.out.println("Tiempo de ejecución (ms): " + tiempo / 1_000_000);
            System.out.println("Memoria usada aprox (KB): " + memoriaUsada / 1024);
            System.out.println("-----------------------------------");
        }
    }
}