import java.util.ArrayList;
public class Historial {

    private Pendiente pendiente;
    private Cancelado cancelado;
    
    public Historial(Pendiente pendiente, Cancelado cancelado) {
        this.pendiente = pendiente;
        this.cancelado = cancelado;
    }


    ArrayList<Documento> Historial = new ArrayList<>();
    public void AgregarHistorial(Documento documento) {
        Historial.add(documento);
    }

    public void MostrarImpresos() {
        System.out.println("Documentos Impresos: (" + Historial.size() + "):");
        if (Historial.isEmpty()) {
            System.out.println("No hay documentos impresos.\n");
        } else {
            for (Documento documento : Historial) {
                System.out.println("Documento: " + documento+"\n");
            }
        }
    }

    public void MostrarHistorial() {
        System.out.println("==== ESTADO DE LA IMPRESORA Laserjet2000 ====\n");
        pendiente.MostrarPendientes();
        MostrarImpresos();
        cancelado.MostrarCancelados();

    }


}
