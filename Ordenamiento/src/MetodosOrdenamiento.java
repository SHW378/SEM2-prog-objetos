import java.util.*;

public class MetodosOrdenamiento {
    private int comparaciones = 0;
    private int intercambios = 0;

    private int[] arregloActual;

    public void IngresarDatosManualmente(Scanner sc) {
        System.out.println("Ingrese el tamaño del arreglo");
        int n  = sc.nextInt();
        arregloActual = new int[n];

        System.out.println("Ingrese los elementos del arreglo:");
        for(int i = 0; i < n; i++) {
            System.out.println("Elemento " + (i + 1) + ": ");
            arregloActual[i] = sc.nextInt();
        }

        System.out.println("Arreglo Ingresado: " + Arrays.toString(arregloActual));
    }

    public void generarDatosAleatorios(Scanner sc) {
        System.out.println("Ingrese el tamaño del arreglo: ");
        int n = sc.nextInt();
        System.out.println("Ingrese el valor máximo de los elementos: ");
        int max = sc.nextInt();

        Random random =  new Random();
        arregloActual = new int[n];

        for (int i = 0; i < n; i++) {
            arregloActual[i] = random.nextInt(max + 1);
        }

        System.out.println("Arreglo generado aleatoriamente: " + Arrays.toString(arregloActual));
    }

    public void BubbleSort(Scanner sc) {
        if (!validarArreglo()) return;

        int[] arreglo = arregloActual.clone();
        System.out.println("Arreglo antes de bubble Sort: " + Arrays.toString(arreglo));
 
        resetContadores();
        long tiempoInicio = System.nanoTime();

        bubbleSort(arreglo);

        long tiempoFin = System.nanoTime();
        double tiempoEjecucion = (tiempoFin - tiempoInicio) / 1_000_000.0;
        
        mostrarResultados("Bubble Sort", arreglo, tiempoEjecucion);
    }

    public void SelectionSort(Scanner sc) {
        if (!validarArreglo()) return;

        int[] arreglo = arregloActual.clone();
        System.out.println("Arreglo antes de Selection Sort: " + Arrays.toString(arreglo));

        resetContadores();
        long tiempoInicio = System.nanoTime();

        selectionSort(arreglo);

        long tiempoFin = System.nanoTime();
        double tiempoEjecucion = (tiempoFin - tiempoInicio) / 1_000_000.0;

        mostrarResultados("Selection Sort", arreglo, tiempoEjecucion);
    }

    public 
}