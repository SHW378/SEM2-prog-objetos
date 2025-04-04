import java.util.Stack;

public class Pila {
    public static void main(String[] args) {
        //Creación de la pila
        Stack<Integer> pila = new Stack<>();
        //La pila actualmente está vacia
        boolean estaVacia = pila.isEmpty();
        System.out.println("¿La pila está vacia?: " + estaVacia);
        //Ingresar datos
        pila.push(1);
        pila.push(2);
        pila.push(3);
        // ver el elemento de la cima
        int cima = pila.peek();
        System.out.println("El elemento de la cima es: "+ cima);
        // volver a verificar si está vacia
        System.out.println("¿La pila está vacia?: " + pila.isEmpty());
        // Estraer elemento y revisar la cima
        int elemento = pila.pop();
        System.out.println("El elemento extraido es: " + elemento);
        System.out.println("El elemento de la cima es: "+ pila.peek());

    }
}