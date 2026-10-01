package plataforma_solicitud_taxis;

public class SolicitudTaxi {
    private String id;
    private String usuario;
    private String origen;
    private String destino;

    public SolicitudTaxi(String usuario, String origen, String destino) {
        this.usuario = usuario;
        this.origen = origen;
        this.destino = destino;
        this.id = java.util.UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    @Override
    public String toString() {
        return "SolicitudTaxi{" +
                "id='" + id + '\'' +
                ", usuario='" + usuario + '\'' +
                ", origen='" + origen + '\'' +
                ", destino='" + destino + '\'' +
                '}';
    }
}