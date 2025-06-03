public class ArbolBinarioBusqueda {
    private Vertice raiz;

    public ArbolBinarioBusqueda() {
        raiz = null;
    }

    public void insertar(int valor) throws CiudadDuplicadaException {
        raiz = insertarRecursivamente(raiz, valor);
    }

    public Vertice insertarRecursivamente(Vertice raiz, int valor) throws CiudadDuplicadaException {
        if (raiz == null) {
            return new Vertice(valor);
        }
        if (valor < raiz.valor) {
            raiz.izquierdo = insertarRecursivamente(raiz.izquierdo, valor);
        } else if (valor > raiz.valor) {
            raiz.derecho = insertarRecursivamente(raiz.derecho, valor);
        } else {
            throw new CiudadDuplicadaException("La ciudad con valor " + valor + " ya existe.");
        }
        return raiz;
    }

    public boolean buscar(int valor) {
        return buscarRecursivamente(raiz, valor) != null;
    }

    public Vertice buscarRecursivamente(Vertice raiz, int valor) {
        if (raiz == null || raiz.valor == valor) {
            return raiz;
        }
        if (valor < raiz.valor) {
            return buscarRecursivamente(raiz.izquierdo, valor);
        }
        return buscarRecursivamente(raiz.derecho, valor);
    }

    // Método para buscar y lanzar excepción si no existe
    public int buscarCiudad(int valor) throws CiudadNoEncontradaException {
        Vertice resultado = buscarRecursivamente(raiz, valor);
        if (resultado == null) {
            throw new CiudadNoEncontradaException("Ciudad con valor " + valor + " no encontrada.");
        }
        return resultado.valor;
    }

    public void recorrerInorden() {
        recorrerInordenRecursivamente(raiz);
    }

    public void recorrerInordenRecursivamente(Vertice raiz) {
        if (raiz != null) {
            recorrerInordenRecursivamente(raiz.izquierdo);
            System.out.print(raiz.valor + " ");
            recorrerInordenRecursivamente(raiz.derecho);
        }
    }

    public void recorrerPreorden() {
        recorrerPreordenRecursivamente(raiz);
    }

    public void recorrerPreordenRecursivamente(Vertice raiz) {
        if (raiz != null) {
            System.out.print(raiz.valor + " ");
            recorrerPreordenRecursivamente(raiz.izquierdo);
            recorrerPreordenRecursivamente(raiz.derecho);
        }
    }

    public void recorrerPostorden() {
        recorrerPostordenRecursivamente(raiz);
    }

    public void recorrerPostordenRecursivamente(Vertice raiz) {
        if (raiz != null) {
            recorrerPostordenRecursivamente(raiz.izquierdo);
            recorrerPostordenRecursivamente(raiz.derecho);
            System.out.print(raiz.valor + " ");
        }
    }

    public void eliminar(int valor) throws CiudadNoEncontradaException {
        if (!buscar(valor)) {
            throw new CiudadNoEncontradaException("Ciudad con valor " + valor + " no encontrada.");
        }
        raiz = eliminarRecursivamente(raiz, valor);
    }

    public Vertice eliminarRecursivamente(Vertice raiz, int valor) {
        if (raiz == null) {
            return raiz;
        }
        if (valor < raiz.valor) {
            raiz.izquierdo = eliminarRecursivamente(raiz.izquierdo, valor);
        } else if (valor > raiz.valor) {
            raiz.derecho = eliminarRecursivamente(raiz.derecho, valor);
        } else {
            if (raiz.izquierdo == null) {
                return raiz.derecho;
            } else if (raiz.derecho == null) {
                return raiz.izquierdo;
            }
            raiz.valor = valorMinimo(raiz.derecho);
            raiz.derecho = eliminarRecursivamente(raiz.derecho, raiz.valor);
        }
        return raiz;
    }

    public int valorMinimo(Vertice raiz) {
        int valorMin = raiz.valor;
        while (raiz.izquierdo != null) {
            valorMin = raiz.izquierdo.valor;
            raiz = raiz.izquierdo;
        }
        return valorMin;
    }
}