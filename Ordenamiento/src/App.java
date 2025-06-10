import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        MetodosOrdenamiento MO = new MetodosOrdenamiento();
        try (Scanner sc = new Scanner(System.in)) {
            int opcion;
            boolean continuar = false;
            
            while (!continuar) {
                System.out.println("\n==== ALGORITMOS DE ORDENAMIENTO ====");
                System.out.println("1: Ingresar datos manualmente");
                System.out.println("2: Generar datos aleatorios");
                System.out.println("3: Ordenar con Bubble Sort");
                System.out.println("4: Ordenar con Selection Sort");
                System.out.println("5: Ordenar con Insertion Sort");
                System.out.println("6: Ordenar con Quick Sort");
                System.out.println("7: Ordenar con Heap Sort");
                System.out.println("8: Salir");
                System.out.print("Seleccione una opcion: ");
                
                try {
                    opcion = sc.nextInt();
                    sc.nextLine();
                    
                    switch (opcion) {
                        case 1 ->
                            MO.IngresarDatosManualmente(sc);
                        case 2 ->
                            MO.generarDatosAleatorios(sc);
                        case 3 ->
                            MO.BubbleSort(sc);
                        case 4 ->
                            MO.SelectionSort(sc);
                        case 5 ->
                            MO.InsertionSort(sc);
                        case 6 ->
                            MO.QuickSort(sc);
                        case 7 ->
                            MO.HeapSort(sc);
                        case 8 -> {
                            System.out.println("Saliendo del programa..");
                            continuar = true;
                        }
                        default ->
                            System.out.println("Error: Opcion no valida. Intente de nuevo");
                    }
                } catch (Exception e) {
                    System.out.println("Error: Opcion no valida. Intente de nuevo");
                    sc.nextLine();
                }
                if (!continuar) {
                    System.out.println("\nPresione Enter para continuar...");
                    sc.nextLine();
                }
            }
        }
    }
}
