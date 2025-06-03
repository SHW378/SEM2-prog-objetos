public class GrafoMatriz {
    private int[][] matrizAdyacencia;
    private int numVertices;

    public GrafoMatriz(int numVertices) {
        this.numVertices = numVertices;
        matrizAdyacencia = new int[numVertices][numVertices];
    }

    public int getNumVertices() {
        return numVertices;
    }

    public int[][] getMatrizAdyacencia() {
        return matrizAdyacencia; // Devuelve la matriz de adyacencia
    }

   public void agregarArista(int i, int j) {
    matrizAdyacencia[i][j] = 1;
    matrizAdyacencia[j][i] = 1; // Grafo no dirigido
}

    public void eliminarArista(int i, int j) {
        matrizAdyacencia[i][j] = 0;
        matrizAdyacencia[j][i] = 0; // Grafo no dirigido
    }

   public void mostrarMatriz() {
    System.out.println("Matriz de Adyacencia:");
    for (int i = 0; i < numVertices; i++) {
        for (int j = 0; j < numVertices; j++) {
            System.out.print(matrizAdyacencia[i][j] + " ");
        }
        System.out.println();
    }
}
    }
