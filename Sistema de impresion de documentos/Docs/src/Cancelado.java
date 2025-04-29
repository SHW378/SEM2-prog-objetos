import java.util.ArrayList;
public class Cancelado {
        ArrayList<Documento> cancelados = new ArrayList<>();

        public void AgregarCancelados(Documento documento) {
        cancelados.add(documento);
    }

    public void MostrarCancelados() {
        System.out.println("Documentos Cancelados: (" + cancelados.size() + "):");
        if (cancelados.isEmpty()) {
            System.out.println("No hay documentos cancelados.\n");
        } else {
            for (Documento documento : cancelados) {
                System.out.println("Documento: " + documento+"\n");
            }
        }
    }

        public Documento RestaurarUltimo() {
        if (cancelados.isEmpty()) return null;
        return cancelados.remove(cancelados.size() - 1);
    }

}
