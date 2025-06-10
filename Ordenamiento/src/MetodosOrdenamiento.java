import java.util.*;

// Clase que contiene los métodos de ordenamiento y manejo de datos
public class MetodosOrdenamiento {

    // Contadores para estadísticas
    private int comparaciones = 0;
    private int intercambios = 0;

    // Arreglo actual sobre el que se trabaja
    private int[] arregloActual;

    // Permite ingresar los datos manualmente por teclado
    public void IngresarDatosManualmente(Scanner sc) {
        System.out.println("Ingrese el tamaño del arreglo");
        int n = sc.nextInt();
        arregloActual = new int[n];

        System.out.println("Ingrese los elementos del arreglo:");
        for (int i = 0; i < n; i++) {
            System.out.println("Elemento " + (i + 1) + ": ");
            arregloActual[i] = sc.nextInt();
        }

        System.out.println("Arreglo Ingresado: " + Arrays.toString(arregloActual));
    }

    // Genera un arreglo de datos aleatorios
    public void generarDatosAleatorios(Scanner sc) {
        System.out.println("Ingrese el tamaño del arreglo: ");
        int n = sc.nextInt();
        System.out.println("Ingrese el valor máximo de los elementos: ");
        int max = sc.nextInt();

        Random random = new Random();
        arregloActual = new int[n];

        for (int i = 0; i < n; i++) {
            arregloActual[i] = random.nextInt(max + 1);
        }

        System.out.println("Arreglo generado aleatoriamente: " + Arrays.toString(arregloActual));
    }

    // Verifica si el arreglo está listo para ser ordenado
    private boolean validarArreglo() {
        if (arregloActual == null || arregloActual.length == 0) {
            System.out.println("Error: No hay datos para ordenar. Primero ingrese o genere datos (opciones 1 o 2).");
            return false;
        }
        return true;
    }

    // Ordena usando Bubble Sort y muestra resultados
    public void BubbleSort(Scanner sc) {
        if (!validarArreglo()) {
            return;
        }

        int[] arreglo = arregloActual.clone();
        System.out.println("Arreglo antes de Bubble Sort: " + Arrays.toString(arreglo));

        resetContadores();
        long tiempoInicio = System.nanoTime();

        bubbleSort(arreglo);

        long tiempoFin = System.nanoTime();
        double tiempoEjecucion = (tiempoFin - tiempoInicio) / 1_000_000.0;

        mostrarResultados("Bubble Sort", arreglo, tiempoEjecucion);
    }

    // Ordena usando Selection Sort y muestra resultados
    public void SelectionSort(Scanner sc) {
        if (!validarArreglo()) {
            return;
        }

        int[] arreglo = arregloActual.clone();
        System.out.println("Arreglo antes de Selection Sort: " + Arrays.toString(arreglo));

        resetContadores();
        long tiempoInicio = System.nanoTime();

        selectionSort(arreglo);

        long tiempoFin = System.nanoTime();
        double tiempoEjecucion = (tiempoFin - tiempoInicio) / 1_000_000.0;

        mostrarResultados("Selection Sort", arreglo, tiempoEjecucion);
    }

    // Ordena usando Insertion Sort y muestra resultados
    public void InsertionSort(Scanner sc) {
        if (!validarArreglo()) {
            return;
        }

        int[] arreglo = arregloActual.clone();
        System.out.println("Arreglo antes de Insertion Sort: " + Arrays.toString(arreglo));

        resetContadores();
        long tiempoInicio = System.nanoTime();

        insertionSort(arreglo);

        long tiempoFin = System.nanoTime();
        double tiempoEjecucion = (tiempoFin - tiempoInicio) / 1_000_000.0;

        mostrarResultados("Insertion Sort", arreglo, tiempoEjecucion);
    }

    // Ordena usando Quick Sort y muestra resultados
    public void QuickSort(Scanner sc) {
        if (!validarArreglo()) {
            return;
        }

        int[] arreglo = arregloActual.clone();
        System.out.println("Arreglo antes de Quick Sort: " + Arrays.toString(arreglo));

        resetContadores();
        long tiempoInicio = System.nanoTime();

        quickSort(arreglo, 0, arreglo.length - 1);

        long tiempoFin = System.nanoTime();
        double tiempoEjecucion = (tiempoFin - tiempoInicio) / 1_000_000.0;

        mostrarResultados("Quick Sort", arreglo, tiempoEjecucion);
    }

    // Ordena usando Heap Sort y muestra resultados
    public void HeapSort(Scanner sc) {
        if (!validarArreglo()) {
            return;
        }

        int[] arreglo = arregloActual.clone();
        System.out.println("Arreglo antes de Heap Sort: " + Arrays.toString(arreglo));

        resetContadores();
        long tiempoInicio = System.nanoTime();

        heapSort(arreglo);

        long tiempoFin = System.nanoTime();
        double tiempoEjecucion = (tiempoFin - tiempoInicio) / 1_000_000.0;

        mostrarResultados("Heap Sort", arreglo, tiempoEjecucion);
    }

    // Reinicia los contadores de comparaciones e intercambios
    private void resetContadores() {
        comparaciones = 0;
        intercambios = 0;
    }

    // Muestra los resultados del algoritmo de ordenamiento
    private void mostrarResultados(String algoritmo, int[] arreglo, double tiempoEjecucion) {
        System.out.println();
        System.out.println("Arreglo después de " + algoritmo + ": " + Arrays.toString(arreglo));
        System.out.printf("Tiempo de ejecución: %.4f ms%n", tiempoEjecucion);
        System.out.println("Comparaciones: " + comparaciones);
        System.out.println("Intercambios: " + intercambios);
    }

    // Intercambia dos elementos en un arreglo
    private void intercambiar(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Implementación de Bubble Sort
    private void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                comparaciones++;
                if (arr[j] > arr[j + 1]) {
                    intercambiar(arr, j, j + 1);
                    intercambios++;
                }
            }
        }
    }

    // Implementación de Selection Sort
    private void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                comparaciones++;
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            if (minIdx != i) {
                intercambiar(arr, i, minIdx);
                intercambios++;
            }
        }
    }

    // Implementación de Insertion Sort
    private void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0) {
                comparaciones++;
                if (arr[j] > key) {
                    arr[j + 1] = arr[j];
                    intercambios++;
                    j--;
                } else {
                    break;
                }
            }
            arr[j + 1] = key;
        }
    }

    // Implementación de Quick Sort
    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Partición para Quick Sort
    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            comparaciones++;
            if (arr[j] <= pivot) {
                i++;
                intercambiar(arr, i, j);
                intercambios++;
            }
        }
        intercambiar(arr, i + 1, high);
        intercambios++;
        return i + 1;
    }

    // Implementación de Heap Sort
    private void heapSort(int[] arr) {
        int n = arr.length;

        // Construir el heap (reorganizar el arreglo)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extraer elementos del heap uno por uno
        for (int i = n - 1; i > 0; i--) {
            intercambiar(arr, 0, i);
            intercambios++;
            heapify(arr, i, 0);
        }
    }

    // Mantiene la propiedad de heap
    private void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n) {
            comparaciones++;
            if (arr[left] > arr[largest]) {
                largest = left;
            }
        }

        if (right < n) {
            comparaciones++;
            if (arr[right] > arr[largest]) {
                largest = right;
            }
        }

        if (largest != i) {
            intercambiar(arr, i, largest);
            intercambios++;
            heapify(arr, n, largest);
        }
    }
}