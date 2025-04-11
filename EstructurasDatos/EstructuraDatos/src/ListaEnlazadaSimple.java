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
}
