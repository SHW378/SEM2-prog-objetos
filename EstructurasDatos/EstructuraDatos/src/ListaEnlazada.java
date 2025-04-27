import java.util.LinkedList;

public class ListaEnlazada {
    public static void main(String[] args) {
        LinkedList<Integer> miLista = new LinkedList<>();

        // Agregar elementos al inicio de la lista
        miLista.addFirst(1);
        miLista.addFirst(2);
        miLista.addFirst(3); // Ahora la lista es [3, 2, 1]

        // Agregar elementos al final de la lista
        miLista.addLast(4);
        miLista.addLast(5); // La lista es [3, 2, 1, 4, 5]

        // Imprimir todos los elementos de la lista
        System.out.println("Elementos de la lista: " + miLista);

        // Remover el primer elemento de la lista
        int primero = miLista.removeFirst();
        System.out.println("Elemento removido del inicio: " + primero);

        // Remover el último elemento de la lista
        int ultimo = miLista.removeLast();
        System.out.println("Elemento removido del final: " + ultimo);

        // Acceder a un elemento específico sin removerlo
        int elemento = miLista.get(0); // Obtiene el primer elemento actual de la lista
        System.out.println("Primer elemento actual de la lista: " + elemento);

        // Verificar si la lista está vacía
        boolean estaVacia = miLista.isEmpty();
        System.out.println("¿La lista está vacía?: " + estaVacia);

        // Imprimir la lista actualizada
        System.out.println("Lista actualizada: " + miLista);
    }
}