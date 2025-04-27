import java.util.LinkedList;
import java.util.Queue;

public class ListaQueue {

    public static void main(String[] args) {
        // Creación de una cola utilizando LinkedList
        Queue<Integer> cola = new LinkedList<>();

        // Agregando elementos a la cola (encolar)
        cola.offer(1);
        cola.offer(2);
        cola.offer(3);

        // Observando el frente de la cola sin removerlo
        System.out.println("Elemento al frente de la cola: " + cola.peek());

        System.out.println(cola);

        // Removiendo el elemento al frente de la cola (desencolar)
        System.out.println("Elemento desencolado de la cola: " + cola.poll()); 

        // Verificar si la cola está vacía
        System.out.println("¿La cola está vacía?: " + cola.isEmpty());

        System.out.println(cola);
    }
}