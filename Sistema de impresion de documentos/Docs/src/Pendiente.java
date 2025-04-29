import java.util.Queue;
import java.util.LinkedList;

public class Pendiente {
    
    Queue<Documento> pendientes = new LinkedList<>();
    public void AgregarPendientes(Documento documento) {
        pendientes.add(documento);
    }
    public void MostrarPendientes() {
        System.out.println("Documentos Pendientes: (" + pendientes.size() + "):");
        if (pendientes.isEmpty()) {
            System.out.println("No hay documentos pendientes.\n");
        } else {
            for (Documento documento : pendientes) {
                System.out.println("Documento:" + documento+"\n");
            }
        }
    }

}
