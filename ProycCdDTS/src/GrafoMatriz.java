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

    // Cambia la firma para recibir ArbolBinarioBusqueda y obtener nombres de ciudades
    public void dfs(int vertice, ArbolBinarioBusqueda abb) {
        boolean[] visitado = new boolean[numVertices];
        dfsRecursivo(vertice, visitado, abb);
        System.out.println();
    }

    private void dfsRecursivo(int vertice, boolean[] visitados, ArbolBinarioBusqueda abb) {
        if (!visitados[vertice]) {
            visitados[vertice] = true;
            System.out.print(abb.getNombreCiudad(vertice) + " ");
            for (int vecino = 0; vecino < numVertices; vecino++) {
                if (matrizAdyacencia[vertice][vecino] == 1) {
                    dfsRecursivo(vecino, visitados, abb);
                }
            }
        }
    }

    public void bfs(int vertice, ArbolBinarioBusqueda abb) {
        boolean[] visitados = new boolean[numVertices];
        int[] cola = new int[numVertices];
        int frente = 0;
        int fin = 0;

        visitados[vertice] = true;
        cola[fin++] = vertice;

        while (frente < fin) {
            int actual = cola[frente++];
            System.out.print(abb.getNombreCiudad(actual) + " ");
            for (int vecino = 0; vecino < numVertices; vecino++) {
                if (matrizAdyacencia[actual][vecino] == 1 && !visitados[vecino]) {
                    visitados[vecino] = true;
                    cola[fin++] = vecino;
                }
            }
        }
        System.out.println();
    }
}