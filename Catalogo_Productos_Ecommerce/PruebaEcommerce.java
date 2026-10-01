package Catalogo_Productos_Ecommerce;

import java.util.Random;

public class PruebaEcommerce {

    public static void main(String[] args) {

        int[] tamaños = {100, 1000, 10000, 100000};

        for (int n : tamaños) {

            Ecommerce ecommerce = new Ecommerce();
            Random random = new Random();

            long memoriaAntes = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

            long inicio = System.nanoTime();

            for (int i = 0; i < n; i++) {

                Producto p = new Producto(
                        "P" + i,
                        "Producto" + i,
                        random.nextDouble() * 1000
                );

                ecommerce.agregarProducto(p);
            }

            ecommerce.buscarProducto("P" + (n / 2));

            long fin = System.nanoTime();

            long memoriaDespues = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

            long tiempoMs = (fin - inicio) / 1_000_000;
            long memoriaKB = (memoriaDespues - memoriaAntes) / 1024;

            System.out.println("Productos: " + n);
            System.out.println("Tiempo: " + tiempoMs + " ms");
            System.out.println("Memoria: " + memoriaKB + " KB");
            System.out.println("---------------------------");
        }
    }
}