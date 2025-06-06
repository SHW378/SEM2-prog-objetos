import java.util.Scanner;

public class ArbolBinario {
    public static void main(String[] args) {
        // Crea el árbol binario de búsqueda y el grafo con capacidad para 10 ciudades
        ArbolBinarioBusqueda abb = new ArbolBinarioBusqueda(10);
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        boolean continuar = false;

        // Ciclo principal del menú interactivo
        while (!continuar) {
            // Muestra el menú de opciones al usuario
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
                // Lee la opción del usuario
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpia el buffer

                // Ejecuta la acción correspondiente según la opción elegida
                switch (opcion) {
                    case 1 -> abb.insertar(capturarCiudad(scanner, "Ingrese el nombre de la ciudad: "));
                    case 2 -> abb.eliminar(capturarCiudad(scanner, "Ingrese el nombre de la ciudad a eliminar: "));
                    case 3 -> {
                        // Añadir ruta entre dos ciudades
                        String origen = capturarCiudad(scanner, "Ingrese el nombre de la ciudad origen: ");
                        String destino = capturarCiudad(scanner, "Ingrese el nombre de la ciudad destino: ");
                        abb.conectarCiudades(origen, destino);
                    }
                    case 4 -> {
                        // Eliminar ruta entre dos ciudades
                        String origen = capturarCiudad(scanner, "Ingrese el nombre de la ciudad origen: ");
                        String destino = capturarCiudad(scanner, "Ingrese el nombre de la ciudad destino: ");
                        abb.eliminarRuta(origen, destino);
                    }
                    case 5 -> mostrarRecorridos(abb, scanner); // Recorridos del árbol binario
                    case 6 -> mostrarRecorridosGrafo(abb, scanner); // Recorridos del grafo (DFS/BFS)
                    case 7 -> {
                        // Salir del programa
                        System.out.println("Saliendo del programa...");
                        continuar = true;
                    }
                    default -> System.out.println("Opción inválida.");
                }
            } catch (Exception e) {
                // Manejo de errores de entrada
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine(); // Limpia el buffer en caso de error
            }
            // Pausa para que el usuario vea el resultado antes de mostrar el menú de nuevo
            if (!continuar) {
                System.out.println("\nPresione Enter para continuar...");
                scanner.nextLine();
            }
        } 

        scanner.close(); 
    }

    /**
     * Método auxiliar para capturar el nombre de una ciudad desde la terminal.
     */
    private static String capturarCiudad(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    /**
     * Muestra los recorridos del árbol binario de búsqueda:
     * Preorden, Inorden y Postorden.
     */
    private static void mostrarRecorridos(ArbolBinarioBusqueda abb, Scanner scanner) {
        System.out.println("Reccorridos en el Árbol:");
        System.out.println("1. Preorden");
        abb.recorrerPreorden();
        System.out.println("2. Inorden");
        abb.recorrerInOrden();
        System.out.println("3. Postorden");
        abb.recorrerPostorden();
    }

    /**
     * Muestra los recorridos del grafo (DFS y BFS) desde una ciudad de inicio.
     */
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