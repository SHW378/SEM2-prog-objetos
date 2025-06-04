public class Grafos {
    public static void main(String[] args) {
        GrafoMatriz grafoMatriz = new GrafoMatriz(4);
        grafoMatriz.agregarArista(0, 1);
        grafoMatriz.agregarArista(0, 2);
        grafoMatriz.agregarArista(1, 3);
        grafoMatriz.agregarArista(2, 3);
        System.out.println("Grafo representado por una matriz de adyacencia:");
        grafoMatriz.mostrarMatriz();
        System.out.println();
        System.out.println("Recorrido DFS para grafo representado como matriz:");
        grafoMatriz.dfs(0);
        System.out.println();
        System.out.println("Recorrido BFS para grafo representado como matriz:");
        grafoMatriz.bfs(0);
        System.out.println();

        GrafoLista grafoLista = new GrafoLista(4);
        grafoLista.agregarArista(0, 1);
        grafoLista.agregarArista(0, 2);
        grafoLista.agregarArista(1, 3);
        grafoLista.agregarArista(2, 3);
        System.out.println("Grafo representado por una lista de adyacencia:");
        grafoLista.mostrarListas();
    }
}