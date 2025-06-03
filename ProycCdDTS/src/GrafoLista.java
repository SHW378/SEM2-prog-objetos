class NodoGrafo {
    int destino;
    NodoGrafo siguiente;

    public NodoGrafo(int destino, NodoGrafo siguiente) {
        this.destino = destino;
        this.siguiente = siguiente;
    }
}

class ListaAdyacencia {
    NodoGrafo cabeza;
}

class GrafoLista {
    private ListaAdyacencia[] listaAdyacencia;
    private int numVertices;

    public GrafoLista(int numVertices) {
        this.numVertices = numVertices;
        listaAdyacencia = new ListaAdyacencia[numVertices];
        for (int i = 0; i < numVertices; i++)
            listaAdyacencia[i] = new ListaAdyacencia();
    }

    public void agregarArista(int origen, int destino) {
        NodoGrafo nuevoNodo = new NodoGrafo(destino, listaAdyacencia[origen].cabeza);
        listaAdyacencia[origen].cabeza = nuevoNodo;
        NodoGrafo nuevoNodoInverso = new NodoGrafo(origen, listaAdyacencia[destino].cabeza);
        listaAdyacencia[destino].cabeza = nuevoNodoInverso;
    }

    public void mostrarLista() {
        for (int i = 0; i < numVertices; i++) {
            System.out.print(i + " -> ");
            NodoGrafo actual = listaAdyacencia[i].cabeza;
            while (actual != null) {
                System.out.print(actual.destino + " ");
                actual = actual.siguiente;
            }
            System.out.println();
        }
    }
}