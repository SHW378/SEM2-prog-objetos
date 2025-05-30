import java.util.ArrayList;

public class ArregloBiDimensional {
    public static void main(String[] args) {
        // inicializar un Arraylist que contenga Arraylist de enteros
        ArrayList<ArrayList<Integer>> matriz = new ArrayList<>();

        // declarar las filas de la matriz
        int filas = 3;
        // inicializar las filas
        for (int indice = 0; indice < filas; indice++) {
            matriz.add(new ArrayList<>());
        }

        // Declarar las columnas de la matriz
        int columnas = 3;
        // Agregar los datos a la matriz
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz.get(i).add(i * columnas + j);
            }
        }
        // imprimir la matriz
        for (ArrayList<Integer> fila : matriz) {
            System.out.println(fila);
        }
    }
}