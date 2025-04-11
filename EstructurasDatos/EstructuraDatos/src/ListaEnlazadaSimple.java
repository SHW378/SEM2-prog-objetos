public class ListaEnlazadaSimple {
    Nodo cabecera;
    
    // Constructor para inicializar la lista enlazada
    public ListaEnlazadaSimple() {
        cabecera = null;
    }

    //Método para agregar un elemento al inicio de la lista 
    public void agregarAlInicio(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        nuevoNodo.puntero = cabecera;
        cabecera = nuevoNodo;
    }

    //Método para agregar un elemento al final de la lista 
    public void agregarAlfinal(int dato){
        Nodo nuevoNodo = new Nodo(dato);
        if (cabecera == null) {
            // La lista está vacia
            cabecera = nuevoNodo;
        } else {
            Nodo nodoTemporal = cabecera;
            // Recorrer la lista hasta el último nodo 
            while (nodoTemporal.puntero != null){
                nodoTemporal = nodoTemporal.puntero;
            }
            // Asinar el nuevo nodo al final de la lista 
            nodoTemporal.puntero = nuevoNodo;
        }
    }

    // Método para verificar si la lista está vacia
    public boolean estaVacia() {
        return cabecera == null;
    }

    // Método para imprimir los elementos de la lista 
    public void imprimirLista() {
        Nodo nodoActual = cabecera;
        while (nodoActual != null){
            System.out.println(nodoActual.dato + " -> ");
            nodoActual = nodoActual.puntero;
        }
        System.out.print("null");
    }
}