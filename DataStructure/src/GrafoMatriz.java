public class GrafoMatriz {
    private int[][] matrizAdyacencia;
    private int numVertices;

    public GrafoMatriz(int numVertices) {
        this.numVertices = numVertices;
        matrizAdyacencia = new int[numVertices][numVertices];
    }

    public void agregarArista(int i, int j) {
        matrizAdyacencia[i][j] = 1;
        matrizAdyacencia[j][i] = 1; // Solo cuando son grafos no dirigidos
    }

    public void mostrarMatriz() {
        System.out.print("  ");
        for (int j = 0; j < numVertices; j++) {
            System.out.print(j + " ");
        }
        System.out.println();
        // Imprimir la matriz de adyacencia
        for (int i = 0; i < numVertices; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < numVertices; j++) {
                System.out.print(matrizAdyacencia[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void dfs(int vertice) {
        boolean[] visitado = new boolean[numVertices];
        dfsRecursivo(vertice, visitado);
    }

    public void dfsRecursivo(int vertice, boolean[] visitados) {
        if(!visitados[vertice]){
            visitados[vertice] = true;
            System.out.println(vertice + " "); 
            for(int vecino = 0; vecino < numVertices; vecino++) {
                if(matrizAdyacencia[vertice][vecino] == 1) {
                    dfsRecursivo(vecino, visitados);
                }
            }
        }
    }
}