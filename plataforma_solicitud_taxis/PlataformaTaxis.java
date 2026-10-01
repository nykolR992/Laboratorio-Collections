package plataforma_solicitud_taxis;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class PlataformaTaxis {
    public Queue<SolicitudTaxi> colaSolicitudes = new LinkedList<>();
    private HashMap<String, SolicitudTaxi> solicitudesMap = new HashMap<>();

    public void registrarSolicitud(SolicitudTaxi solicitud) {
        colaSolicitudes.add(solicitud);
        solicitudesMap.put(solicitud.getId(), solicitud);
    }

    public SolicitudTaxi atenderSolicitud() {
        SolicitudTaxi solicitudAtendida = colaSolicitudes.poll();
        if(solicitudAtendida != null) {
            solicitudesMap.remove(solicitudAtendida.getId());
            System.out.println("\nAtendiendo solicitud: " + solicitudAtendida);
        }
        return solicitudAtendida;
    }

    public void cancelarSolicitud(String id) {
        SolicitudTaxi solicitud = solicitudesMap.remove(id);
        if (solicitud != null) {
            colaSolicitudes.remove(solicitud);
            System.out.println("\nSolicitud cancelada: " + solicitud);
        } else {
            System.out.println("\nNo se encontró la solicitud con ID: " + id);
        }
    }

    public void mostrarSolicitudes() {
        for (SolicitudTaxi solicitud : colaSolicitudes) {
            System.out.println(solicitud);
        }
    }
}