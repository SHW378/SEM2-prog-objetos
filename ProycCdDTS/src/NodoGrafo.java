public class NodoGrafo {
    String destino;
    NodoGrafo siguiente;

    public NodoGrafo(String destino, NodoGrafo siguiente) {
        this.destino = destino;
        this.siguiente = siguiente;
    }
}