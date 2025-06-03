import java.util.Scanner;

public class ArbolBinario {
    public static void main(String[] args) {
        ArbolBinarioBusqueda abb = new ArbolBinarioBusqueda(10);
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n--- Gestion de Ciudades ---");
            System.out.println("1. Agregar ciudad");
            System.out.println("2. Buscar ciudad");
            System.out.println("3. Eliminar ciudad");
            System.out.println("4. Recorridos del árbol");
            System.out.println("5. Conectar ciudades");
            System.out.println("6. Mostrar rutas");
            System.out.println("7. Mostrar conexiones de una ciudad");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1 -> abb.insertar(capturarCiudad(scanner, "Ingrese el nombre de la ciudad: "));
                    case 2 -> System.out.println("¿La ciudad existe? " + abb.buscar(capturarCiudad(scanner, "Ingrese el nombre de la ciudad a buscar: ")));
                    case 3 -> abb.eliminar(capturarCiudad(scanner, "Ingrese el nombre de la ciudad a eliminar: "));
                    case 4 -> mostrarRecorridos(abb, scanner);
                    case 5 -> {
                        String origen = capturarCiudad(scanner, "Ingrese el nombre de la ciudad origen: ");
                        String destino = capturarCiudad(scanner, "Ingrese el nombre de la ciudad destino: ");
                        abb.conectarCiudades(origen, destino);
                    }
                    case 6 -> abb.mostrarRutas();
                    case 7 -> abb.mostrarConexionesDeCiudad(capturarCiudad(scanner, "Ingrese el nombre de la ciudad: "));
                    case 8 -> System.out.println("Saliste del programa....");
                    default -> System.out.println("Opción inválida.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine(); 
            }
        } while (opcion != 8);

        scanner.close();
    }

    private static String capturarCiudad(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    private static void mostrarRecorridos(ArbolBinarioBusqueda abb, Scanner scanner) {
        System.out.println("Seleccione el tipo de recorrido:");
        System.out.println("1. Inorden");
        System.out.println("2. Preorden");
        System.out.println("3. Postorden");
        int tipo = scanner.nextInt();
        scanner.nextLine(); 

        switch (tipo) {
            case 1 -> abb.recorrerInOrden();
            case 2 -> abb.recorrerPreorden();
            case 3 -> abb.recorrerPostorden();
            default -> System.out.println("Opción inválida.");
        }
    }
}