public class Vertice {
    int valor;
    Vertice izquierdo, derecho;

    public Vertice(int valor) {
        this.valor = valor;
        izquierdo = derecho = null;
    }
}