public class ListaDobleEnlazada {
    Nodo cabecera;

    // Constructor para inicializar la lista enlazada
    public ListaDobleEnlazada() {
        cabecera = null;
    }

    // Método para agregar un elemento al inicio de la lista
    public void agregarAlInicio(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (cabecera != null) {
            cabecera.anterior = nuevoNodo;
        }
        nuevoNodo.siguiente = cabecera;
        cabecera = nuevoNodo;
    }

    // Método para agregar un elemento al final de la lista
    public void agregarAlfinal(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (cabecera == null) {
            // La lista está vacia
            cabecera = nuevoNodo;
        } else {
            Nodo nodoTemporal = cabecera;
            // Recorrer la lista hasta el último nodo
            while (nodoTemporal.siguiente != null) {
                nodoTemporal = nodoTemporal.siguiente;
            }
            // Asinar el nuevo nodo al final de la lista
            nodoTemporal.siguiente = nuevoNodo;
            nuevoNodo.anterior = nodoTemporal;
        }
    }

    // Método para verificar si la lista está vacia
    public boolean estaVacia() {
        return cabecera == null;
    }

    // Método para imprimir los elementos de la lista
    public void imprimirLista() {
        Nodo nodoActual = cabecera;
        while (nodoActual != null) {
            System.out.print(nodoActual.dato + " -> ");
            nodoActual = nodoActual.siguiente;
        }
        System.out.print("null");
    }

    // Método para eliminar un elemento del inicio de la lista
    public int eliminarDelInicio() {
        if (cabecera != null) {
            int dato = cabecera.dato;
            cabecera = cabecera.siguiente;
            if (cabecera != null) {
                cabecera.anterior = null;
            }
            return dato;
        } else {
            System.out.println("Lista está vacia");
            // Valor numerico para indicar que est´´a vacio
            return Integer.MIN_VALUE;
        }
    }

    // Método para eliminar el último elemento de la lista
    public int eliminarDelFinal() {
        if (cabecera == null) {
            System.out.println("Lista está vacia");
            // Valor numerico para indicar que est´´a vacio
            return Integer.MIN_VALUE;
        } else if (cabecera.siguiente == null) {
            // Solo hay un nodo
            int dato = cabecera.dato;
            cabecera = null;
            return dato;
        } else {
            // Har más de un nodo
            Nodo nodoTemporal = cabecera;
            Nodo nodoPenultimo = null;
            while (nodoTemporal.siguiente != null) {
                nodoPenultimo = nodoTemporal;
                nodoTemporal = nodoTemporal.siguiente;
            }
            nodoPenultimo.anterior = null;
            return nodoTemporal.dato;
        }
    }

    public static void main(String[] args) {
        ListaDobleEnlazada lista = new ListaDobleEnlazada();
        System.out.println();
        System.out.println("Elementos de la lista");
        lista.imprimirLista();
        lista.agregarAlInicio(19);
        lista.agregarAlfinal(28);
        lista.agregarAlInicio(11);
        lista.agregarAlfinal(51);
        lista.eliminarDelInicio();
        System.out.println("\nElementos de la lista");
        lista.imprimirLista();
        lista.agregarAlInicio(9);
        lista.eliminarDelFinal();
        System.out.println("\nElementos de la lista");
        lista.imprimirLista();
        System.out.println();
    }
}   
