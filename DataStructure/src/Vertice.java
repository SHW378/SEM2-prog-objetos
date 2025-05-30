public class Vertice {
    int valor;
    Vertice izquierdo, derecho;
    // Constructor para inicializar el vértice
    public Vertice(int valor) {
        this.valor = valor;
        izquierdo = derecho = null;
        //igual a 
        //this.izquierdo = null;
        //this.derecho = null;
    }
}