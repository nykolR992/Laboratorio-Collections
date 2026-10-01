package Plataforma_Solicitud_Taxis;

public class MainPlataformaTaxis {
    public static void main(String[] args) {
        PlataformaTaxis plataforma = new PlataformaTaxis();

        // Agregar solicitudes
        plataforma.registrarSolicitud(new SolicitudTaxi("Alice", "Calle 1", "Calle 2"));
        plataforma.registrarSolicitud(new SolicitudTaxi("Bob", "Calle 3", "Calle 4"));
        plataforma.registrarSolicitud(new SolicitudTaxi("Charlie", "Calle 5", "Calle 6"));

        // Mostrar solicitudes
        System.out.println("\nSolicitudes actuales:");
        plataforma.mostrarSolicitudes();

        // Atender una solicitud
        plataforma.atenderSolicitud();
        
        // Mostrar solicitudes
        System.out.println("\nSolicitudes actuales:");
        plataforma.mostrarSolicitudes();

        // Cancelar una solicitud (usando el ID de la segunda solicitud)
        String idParaCancelar = plataforma.colaSolicitudes.peek().getId();
        plataforma.cancelarSolicitud(idParaCancelar);

        // Mostrar solicitudes después de atender y cancelar
        System.out.println("\nSolicitudes después de atender y cancelar:");
        plataforma.mostrarSolicitudes();
    }
}
