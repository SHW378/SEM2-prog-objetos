public class ArbolBinarioBusqueda {
    private Vertice raiz;

    public ArbolBinarioBusqueda() {
        raiz = null;
    }

    public void insertar(int valor) {
        raiz = insertarRecursivamente(raiz, valor);
    }

    public Vertice insertarRecursivamente(Vertice raiz, int valor) {
        if (raiz == null) {
            raiz = new Vertice(valor);
            return raiz;
        }
        if (valor < raiz.valor) {
            raiz.izquierdo = insertarRecursivamente(raiz.izquierdo, valor);
        } else if (valor > raiz.valor) {
            raiz.derecho = insertarRecursivamente(raiz.derecho, valor);
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

    public void eliminar(int valor) {
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

            raiz.derecho = eliminarRecursivamente(raiz.derecho, valor);
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
    } //
}