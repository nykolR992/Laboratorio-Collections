package Plataforma_Solicitud_Taxis;

public class PruebaPlataformaTaxis {

    public static void main(String[] args) {

        int[] tamaños = {100, 1000, 10000, 100000};

        for (int n : tamaños) {

            PlataformaTaxis sistema = new PlataformaTaxis();

            long memoriaAntes = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

            long inicio = System.nanoTime();

            for (int i = 0; i < n; i++) {

                SolicitudTaxi s = new SolicitudTaxi(
                        "Usuario" + i,
                        "Origen" + i,
                        "Destino" + i
                );

                sistema.registrarSolicitud(s);
            }

            sistema.atenderSolicitud();

            long fin = System.nanoTime();

            long memoriaDespues = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

            long tiempoMs = (fin - inicio) / 1_000_000;
            long memoriaKB = (memoriaDespues - memoriaAntes) / 1024;

            System.out.println("Solicitudes: " + n);
            System.out.println("Tiempo: " + tiempoMs + " ms");
            System.out.println("Memoria: " + memoriaKB + " KB");
            System.out.println("----------------------");
        }
    }
}