
import java.util.Scanner;

public class App {

    private static MetodosOrdenamiento MO = new MetodosOrdenamiento();

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int opcion;
        boolean continuar = false;

        while (!continuar) {
            System.out.println("1: Ingresar datos manualmente");
            System.out.println("2: Generar datos aleatorios");
            System.out.println("3: Ordenar con Bubble Sort");
            System.out.println("4: Ordenar con Selection Sort");
            System.out.println("5: Ordenar con Isertation Sort");
            System.out.println("6: Ordenar con Quick Sort");
            System.out.println("7: Ordenar con Heap Sort");
            System.out.println("8: Salir");

            try {
                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1:
                        IngresarDatosManualmente(sc);
                        break;
                    case 2:
                        generarDatosAleatorios(sc);
                        break;
                    case 3:
                        BubbleSort(sc);
                        break;
                    case 4:
                        SelectionSort(sc);
                        break;
                    case 5:
                        InsertionSort(sc);
                        break;
                    case 6:
                        QuickSort(sc);
                        break;
                    case 7:
                        HeapSort(sc);
                        break;
                    case 8:
                        System.out.println("Saliendo del programa..");
                        continuar = true;
                        break;
                    default:
                        System.out.println("Opcion no valida. Intente nuevamente.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error: + " + e.getMessage());
                sc.nextLine();
            }
            if (!continuar) {
                System.out.println("\nPresione Enter para continuar...");
                sc.nextLine();
            }
        }
        sc.close();
    }
}
