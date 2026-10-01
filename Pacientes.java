import java.util.LinkedList;
import java.util.HashMap;
import java.util.HashSet;

public class Pacientes {

    static class Paciente {
        String documento;
        String nombre;

        public Paciente(String documento, String nombre) {
            this.documento = documento;
            this.nombre = nombre;
        }
    }

    public static void main(String[] args) {

        LinkedList<Paciente> pacientes = new LinkedList<>();
        HashMap<String, Paciente> buscarPacientes = new HashMap<>();
        HashSet<String> documentos = new HashSet<>();

        Runtime runtime = Runtime.getRuntime();
        int[] cantidades = {100, 1000, 10000, 100000};

        for (int cantidad : cantidades) {

            pacientes.clear();
            buscarPacientes.clear();
            documentos.clear();
            // Limpiar memoria antes de comenzar
            runtime.gc();
            long memoriaInicial =
                    runtime.totalMemory() - runtime.freeMemory();

            long inicio = System.nanoTime();

            // Registrar pacientes
            for (int i = 1; i <= cantidad; i++) {

                String documento = "DOC" + i;

                if (!documentos.contains(documento)) {

                    Paciente paciente =
                            new Paciente(documento, "Paciente " + i);

                    pacientes.add(paciente);
                    buscarPacientes.put(documento, paciente);
                    documentos.add(documento);
                }
            }

            long fin = System.nanoTime();

            // Medir memoria después de registrar
            long memoriaFinal =
                    runtime.totalMemory() - runtime.freeMemory();

            long memoriaUsada =
                    memoriaFinal - memoriaInicial;

            // Buscar un paciente
            long inicioBusqueda = System.nanoTime();

            Paciente paciente = buscarPacientes.get("DOC" + (cantidad / 2));

            long finBusqueda = System.nanoTime();

            double tiempoRegistro =
                    (fin - inicio) / 1000000.0;

            double tiempoBusqueda =
                    (finBusqueda - inicioBusqueda) / 1000000.0;

            System.out.println("   ---   ");
            System.out.println("Cantidad: " + cantidad);
            System.out.println("Pacientes registrados: "
                    + pacientes.size());
            System.out.println("Tiempo de registro: "
                    + tiempoRegistro + " ms");
            System.out.println("Tiempo de búsqueda: "
                    + tiempoBusqueda + " ms");
            System.out.println("Memoria utilizada: "
                    + memoriaUsada / 1024 + " KB");

            if (paciente != null) {
                System.out.println("Paciente encontrado: "
                        + paciente.nombre);
            }
        }
    }
}