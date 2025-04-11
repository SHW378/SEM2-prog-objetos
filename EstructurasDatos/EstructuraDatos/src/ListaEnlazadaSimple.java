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
            System.out.print(nodoActual.dato + " -> ");
            nodoActual = nodoActual.puntero;
        }
        System.out.print("null");
    }

    // Método para eliminar un elemento del inicio de la lista 
    public int eliminarDelInicio(){
        if (cabecera != null){
            Nodo nodoTemporal = cabecera;
            cabecera = cabecera.puntero;
            return nodoTemporal.dato;
        } else {
            System.out.println("Lista está vacia.");
            // Vañor númerico para indicar que está vacio
            return Integer.MIN_VALUE;
        }
    }    

    // Método para eliminar el último elemento de la lista
    public int eliminarDelFinal() {
        if (cabecera == null) {
            System.out.println("Lista está vacia");
            // Valor numerico para indicar que est´´a vacio
            return Integer.MIN_VALUE;
        } else if (cabecera.puntero == null) {
            //Solo hay un nodo
            int dato = cabecera.dato;
            cabecera = null;
            return dato;
        } else {
            //Har más de un nodo
            Nodo nodoTemporal = cabecera;
            Nodo nodoPenultimo = null;
            while (nodoTemporal.puntero != null){
                nodoPenultimo = nodoTemporal;
                nodoTemporal = nodoTemporal.puntero;   
            }
            nodoPenultimo.puntero = null;
            return nodoTemporal.dato;
        }
    }

    public static void main(String[] args) {
        ListaEnlazadaSimple lista= new ListaEnlazadaSimple();
        lista.agregarAlfinal(2);
        lista.agregarAlfinal(3);
        lista.agregarAlInicio(1);
        System.out.println("Elementos de la lista");
        lista.imprimirLista();
        System.out.println();
        lista.eliminarDelInicio();
        lista.eliminarDelFinal();
        System.out.println("Elementos de la lista");
        lista.imprimirLista();
        System.out.println();
        System.out.println("¿Está vacia?: " + lista.estaVacia());
    }
}