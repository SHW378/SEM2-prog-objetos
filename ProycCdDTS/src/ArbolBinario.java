import java.util.Scanner;

public class ArbolBinario {
    public static void main(String[] args) {
        ArbolBinarioBusqueda abb = new ArbolBinarioBusqueda(10);
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\nMenú de Gestión de Rutas de Transporte:");
            System.out.println("1. Agregar Ciudad");
            System.out.println("2. Eliminar Ciudad");
            System.out.println("3. Añadir Ruta");
            System.out.println("4. Eliminar Ruta");
            System.out.println("5. Mostrar Recorridos del Árbol");
            System.out.println("6. Mostrar Recorridos del Grafo");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1 -> abb.insertar(capturarCiudad(scanner, "Ingrese el nombre de la ciudad: "));
                    case 2 -> abb.eliminar(capturarCiudad(scanner, "Ingrese el nombre de la ciudad a eliminar: "));
                    case 3 -> {
                        String origen = capturarCiudad(scanner, "Ingrese el nombre de la ciudad origen: ");
                        String destino = capturarCiudad(scanner, "Ingrese el nombre de la ciudad destino: ");
                        abb.conectarCiudades(origen, destino);
                    }
                    case 4 -> {
                        String origen = capturarCiudad(scanner, "Ingrese el nombre de la ciudad origen: ");
                        String destino = capturarCiudad(scanner, "Ingrese el nombre de la ciudad destino: ");
                        abb.eliminarRuta(origen, destino);
                    }
                    case 5 -> mostrarRecorridos(abb, scanner);
                    case 6 -> mostrarRecorridosGrafo(abb, scanner);
                    case 7 -> System.out.println("Saliste del programa....");
                    default -> System.out.println("Opción inválida.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine();
            }
        } while (opcion != 7);

        scanner.close();
    }

    private static String capturarCiudad(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    private static void mostrarRecorridos(ArbolBinarioBusqueda abb, Scanner scanner) {
        System.out.println("Reccorridos en el Árbol:");
        System.out.println("1. Preorden");
        abb.recorrerPreorden();
        System.out.println("2. Inorden");
        abb.recorrerInOrden();
        System.out.println("3. Postorden");
        abb.recorrerPostorden();
    }

    private static void mostrarRecorridosGrafo(ArbolBinarioBusqueda abb, Scanner scanner) {
        System.out.print("Ingrese la ciudad de inicio: ");
        String ciudadInicio = scanner.nextLine();

        System.out.println("Recorridos en el Grafo:");
        System.out.println("1. DFS (Profundidad)");
        abb.dfs(ciudadInicio);
        System.out.println("2. BFS (Anchura)");
        abb.bfs(ciudadInicio);
    }
}