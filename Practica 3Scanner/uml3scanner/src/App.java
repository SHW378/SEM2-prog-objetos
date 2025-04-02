import java.util.Scanner;

public class App {
    private Banco banco;
    private Scanner scanner;

    public App(Banco banco) {
        this.banco = banco;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    agregarSucursal();
                    break;
                case 2:
                    agregarEmpleadoASucursal();
                    break;
                case 3:
                    mostrarSucursales();
                    break;
                case 4:
                    mostrarEmpleadosDeSucursal();
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 5);

        scanner.close();
    }

    private void mostrarMenu() {
        System.out.println("\n*SISTEMA BANCARIO*");
        System.out.println("1.) Agregar una sucursal");
        System.out.println("2.) Agregar un empleado a una sucursal");
        System.out.println("3.) Mostrar sucursales");
        System.out.println("4.) Mostrar empleados de una sucursal");
        System.out.println("5.) Salir");
        System.out.print("Seleccione una opción: ");
    }

    private void agregarSucursal() {
        System.out.print("Ingrese el ID de la sucursal: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        System.out.print("Ingrese el nombre de la sucursal: ");
        String nombre = scanner.nextLine();

        Sucursal sucursal = new Sucursal(id, nombre);
        if (banco.agregarSucursal(sucursal)) {
            System.out.println("Sucursal agregada exitosamente.");
        }
    }

    private void agregarEmpleadoASucursal() {
        System.out.print("Ingrese el ID de la sucursal: ");
        int idSucursal = scanner.nextInt();
        scanner.nextLine();

        Sucursal sucursal = banco.buscarSucursal(idSucursal);
        if (sucursal == null) {
            System.out.println("Sucursal con ID " + idSucursal + " no encontrada.");
            return;
        }

        System.out.print("Ingrese el ID del empleado: ");
        int idEmpleado = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        System.out.print("Ingrese el nombre del empleado: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el puesto del empleado: ");
        String puesto = scanner.nextLine();

        Empleados empleado = new Empleados(idEmpleado, nombre, puesto);
        if (sucursal.agregarEmpleado(empleado)) {
            System.out.println("Empleado agregado exitosamente a la sucursal " + sucursal.getNombre());
        }
    }

    private void mostrarSucursales() {
        banco.mostrarSucursales();
    }

    private void mostrarEmpleadosDeSucursal() {
        System.out.print("Ingrese el ID de la sucursal: ");
        int idSucursal = scanner.nextInt();
        scanner.nextLine();

        Sucursal sucursal = banco.buscarSucursal(idSucursal);
        if (sucursal != null) {
            sucursal.mostrarEmpleados();
        } else {
            System.out.println("Sucursal con ID " + idSucursal + " no encontrada.");
        }
    }

    public static void main(String[] args) {
        System.out.print("Ingrese el nombre del banco: ");
        Scanner scanner = new Scanner(System.in);
        String nombreBanco = scanner.nextLine();

        Banco banco = new Banco(nombreBanco);
        App app = new App(banco);
        app.iniciar();
        scanner.close();
    }    
}
