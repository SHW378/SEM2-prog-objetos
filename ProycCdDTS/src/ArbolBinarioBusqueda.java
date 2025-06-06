/**
 * Clase que implementa un Árbol Binario de Búsqueda para gestionar ciudades
 * y un grafo de adyacencia para gestionar las rutas entre ellas.
 */
public class ArbolBinarioBusqueda {
    private Vertice raiz; // Raíz del árbol binario de búsqueda
    private GrafoMatriz grafo; // Grafo de adyacencia para las rutas
    private String[] ciudades; // Arreglo de nombres de ciudades
    private int numCiudades;   // Número actual de ciudades

    /**
     * Constructor que inicializa el árbol y el grafo.
     * 
     * @param numVertices Número máximo de ciudades (vértices) permitidas.
     */
    public ArbolBinarioBusqueda(int numVertices) {
        raiz = null;
        grafo = new GrafoMatriz(numVertices);
        ciudades = new String[numVertices];
        numCiudades = 0;
    }

    /**
     * Inserta una nueva ciudad en el árbol y la agrega al grafo.
     * Lanza excepción si la ciudad ya existe o si se supera el límite.
     */
    public void insertar(String valor) {
        if (buscar(valor)) {
            throw new IllegalArgumentException("La ciudad ya existe en el árbol.");
        }
        if (numCiudades >= grafo.getNumVertices()) {
            throw new IllegalArgumentException("No se pueden agregar más ciudades al grafo.");
        }
        ciudades[numCiudades++] = valor;
        raiz = insertarRecursivamente(raiz, valor);
        System.out.println("Ciudad agregada: " + valor);
    }

    // Inserta recursivamente un nodo en el árbol binario de búsqueda
    private Vertice insertarRecursivamente(Vertice raiz, String valor) {
        if (raiz == null) {
            return new Vertice(valor);
        }
        if (valor.compareTo(raiz.valor) < 0) {
            raiz.izquierdo = insertarRecursivamente(raiz.izquierdo, valor);
        } else if (valor.compareTo(raiz.valor) > 0) {
            raiz.derecho = insertarRecursivamente(raiz.derecho, valor);
        }
        return raiz;
    }

    /**
     * Busca si una ciudad existe en el árbol.
     * 
     * @param valor Nombre de la ciudad.
     * @return true si existe, false si no.
     */
    public boolean buscar(String valor) {
        return buscarRecursivamente(raiz, valor) != null;
    }

    // Busca recursivamente un nodo en el árbol
    private Vertice buscarRecursivamente(Vertice raiz, String valor) {
        if (raiz == null) {
            return null;
        }
        if (raiz.valor.equals(valor)) {
            return raiz;
        }
        if (valor.compareTo(raiz.valor) < 0) {
            return buscarRecursivamente(raiz.izquierdo, valor);
        }
        return buscarRecursivamente(raiz.derecho, valor);
    }

    /**
     * Elimina una ciudad del árbol y elimina todas sus conexiones en el grafo.
     * Lanza excepción si la ciudad no existe.
     */
    public void eliminar(String valor) {
        int indice = obtenerIndiceCiudad(valor);
        if (indice == -1) {
            throw new IllegalArgumentException("La ciudad no existe.");
        }
        // Elimina la ciudad del arreglo y recorre los elementos
        for (int i = indice; i < numCiudades - 1; i++) {
            ciudades[i] = ciudades[i + 1];
        }
        ciudades[numCiudades - 1] = null;
        numCiudades--;

        raiz = eliminarRecursivamente(raiz, valor);

        // Elimina todas las conexiones de la ciudad en la matriz de adyacencia
        for (int i = 0; i < grafo.getNumVertices(); i++) {
            grafo.eliminarArista(indice, i);
            grafo.eliminarArista(i, indice);
        }

        System.out.println("Ciudad eliminada: " + valor);
    }

    // Elimina recursivamente un nodo del árbol binario de búsqueda
    private Vertice eliminarRecursivamente(Vertice raiz, String valor) {
        if (raiz == null) {
            return null;
        }
        if (valor.compareTo(raiz.valor) < 0) {
            raiz.izquierdo = eliminarRecursivamente(raiz.izquierdo, valor);
        } else if (valor.compareTo(raiz.valor) > 0) {
            raiz.derecho = eliminarRecursivamente(raiz.derecho, valor);
        } else {
            // Nodo con un solo hijo o sin hijos
            if (raiz.izquierdo == null) {
                return raiz.derecho;
            } else if (raiz.derecho == null) {
                return raiz.izquierdo;
            }
            // Nodo con dos hijos: obtener el sucesor inorden
            raiz.valor = valorMinimo(raiz.derecho);
            raiz.derecho = eliminarRecursivamente(raiz.derecho, raiz.valor);
        }
        return raiz;
    }

    private String valorMinimo(Vertice raiz) {
        String valorMin = raiz.valor;
        while (raiz.izquierdo != null) {
            valorMin = raiz.izquierdo.valor;
            raiz = raiz.izquierdo;
        }
        return valorMin;
    }

    /**
     * Realiza un recorrido inorden del árbol y muestra las ciudades.
     */
    public void recorrerInOrden() {
        recorrerInOrdenRecursivamente(raiz);
        System.out.println();
    }

    private void recorrerInOrdenRecursivamente(Vertice raiz) {
        if (raiz != null) {
            recorrerInOrdenRecursivamente(raiz.izquierdo);
            System.out.print(raiz.valor + " ");
            recorrerInOrdenRecursivamente(raiz.derecho);
        }
    }

    /**
     * Realiza un recorrido preorden del árbol y muestra las ciudades.
     */
    public void recorrerPreorden() {
        recorrerPreOrdenRecursivamente(raiz);
        System.out.println();
    }

    private void recorrerPreOrdenRecursivamente(Vertice raiz) {
        if (raiz != null) {
            System.out.print(raiz.valor + " ");
            recorrerPreOrdenRecursivamente(raiz.izquierdo);
            recorrerPreOrdenRecursivamente(raiz.derecho);
        }
    }

    /**
     * Realiza un recorrido postorden del árbol y muestra las ciudades.
     */
    public void recorrerPostorden() {
        recorrerPostOrdenRecursivamente(raiz);
        System.out.println();
    }

    private void recorrerPostOrdenRecursivamente(Vertice raiz) {
        if (raiz != null) {
            recorrerPostOrdenRecursivamente(raiz.izquierdo);
            recorrerPostOrdenRecursivamente(raiz.derecho);
            System.out.print(raiz.valor + " ");
        }
    }

    /**
     * Conecta dos ciudades en el grafo (agrega una arista entre ellas).
     * Lanza excepción si alguna ciudad no existe o ya están conectadas.
     */
    public void conectarCiudades(String ciudadOrigen, String ciudadDestino) {
        int indiceOrigen = obtenerIndiceCiudad(ciudadOrigen);
        int indiceDestino = obtenerIndiceCiudad(ciudadDestino);
        if (indiceOrigen == -1 || indiceDestino == -1) {
            throw new IllegalArgumentException("Una o ambas ciudades no existen en el árbol.");
        }
        if (ciudadOrigen.equals(ciudadDestino)) {
            throw new IllegalArgumentException("No se puede conectar una ciudad consigo misma.");
        }
        if (grafo.getMatrizAdyacencia()[indiceOrigen][indiceDestino] == 1) {
            throw new IllegalArgumentException("Las ciudades ya están conectadas.");
        }
        grafo.agregarArista(indiceOrigen, indiceDestino);
        System.out.println("Ruta creada correctamente entre " + ciudadOrigen + " y " + ciudadDestino + ".");
    }

    /**
     * Muestra la matriz de adyacencia del grafo (todas las rutas).
     */
    public void mostrarRutas() {
        grafo.mostrarMatriz();
    }

    /**
     * Muestra todas las ciudades conectadas a una ciudad dada.
     * Lanza excepción si la ciudad no existe.
     */
    public void mostrarConexionesDeCiudad(String ciudad) {
        int indice = obtenerIndiceCiudad(ciudad);
        if (indice == -1) {
            throw new IllegalArgumentException("La ciudad no existe.");
        }
        System.out.println("Conexiones de " + ciudad + ":");
        for (int i = 0; i < numCiudades; i++) {
            if (grafo.getMatrizAdyacencia()[indice][i] == 1) {
                System.out.println("Conectada con: " + ciudades[i]);
            }
        }
    }

    /**
     * Elimina una ruta (arista) entre dos ciudades en el grafo.
     * Lanza excepción si alguna ciudad no existe o no están conectadas.
     */
    public void eliminarRuta(String ciudadOrigen, String ciudadDestino) {
        int indiceOrigen = obtenerIndiceCiudad(ciudadOrigen);
        int indiceDestino = obtenerIndiceCiudad(ciudadDestino);
        if (indiceOrigen == -1 || indiceDestino == -1) {
            System.out.println("Una o ambas ciudades no existen.");
            return;
        }
        if (grafo.getMatrizAdyacencia()[indiceOrigen][indiceDestino] == 0) {
            System.out.println("Las ciudades no están conectadas.");
            return;
        }
        grafo.eliminarArista(indiceOrigen, indiceDestino);
        System.out.println("Ruta eliminada correctamente entre " + ciudadOrigen + " y " + ciudadDestino + ".");
    }

    
    private int obtenerIndiceCiudad(String nombre) {
        for (int i = 0; i < numCiudades; i++) {
            if (ciudades[i].equals(nombre)) return i;
        }
        return -1;
    }

    public String getNombreCiudad(int indice) {
        if (indice >= 0 && indice < numCiudades) return ciudades[indice];
        return null;
    }

    public void dfs(String ciudadInicio) {
        int indice = obtenerIndiceCiudad(ciudadInicio);
        if (indice == -1) {
            System.out.println("La ciudad no existe.");
            return;
        }
        System.out.print("Recorrido DFS: ");
        grafo.dfs(indice, this);
    }

    public void bfs(String ciudadInicio) {
        int indice = obtenerIndiceCiudad(ciudadInicio);
        if (indice == -1) {
            System.out.println("La ciudad no existe.");
            return;
        }
        System.out.print("Recorrido BFS: ");
        grafo.bfs(indice, this);
    }
}