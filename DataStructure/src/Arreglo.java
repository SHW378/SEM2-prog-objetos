import java.util.ArrayList;

public class Arreglo {
    public static void main(String[] args) throws Exception {
        // inicializar un arreglo de cadenas de texto
        ArrayList<String> lista = new ArrayList<>(5);
        // Insertar tres cadenas de texto 
        lista.add(0, "Este es el primer texto.");
        lista.add(1, "Este es el segundo texto.");
        lista.add(2, "Este es el tercer texto.");
        // obtener el elemento del indice 1 
        String texto = lista.get(1);
        System.out.println("El testo es: " + texto);
        // ver tamaño del arreglo
        System.out.println("El tamaño del arreglo es: " + lista.size());
        // Eliminar el elemento del indice 2 
        String textoEliminado = lista.remove(2);
        System.out.println("El texto eliminado es: " + textoEliminado);
        // ver tamaño del arreglo
        System.out.println("El tamaño del arreglo es: " + lista.size());
        
    }
}