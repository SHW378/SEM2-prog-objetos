import java.util.ArrayList;
import java.util.Scanner;

public class Universidad {
    private static ArrayList<Usuario> usuarios = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion = 0;
        do {
            System.out.println("\nMenú:");
            System.out.println("1. Agregar Alumno");
            System.out.println("2. Agregar Docente");
            System.out.println("3. Mostrar Usuarios");
            System.out.println("4. Modificar Usuario");
            System.out.println("5. Desactivar Usuario");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    agregarAlumno();
                    break;
                case 2:
                    agregarDocente();
                    break;
                case 3:
                    mostrarUsuarios();
                    break;
                case 4:
                    modificarUsuario();
                    break;
                case 5:
                    desactivarUsuario();
                    break;
                case 6:
                    System.out.println("Saliendo del sistema.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 6);
    }

    private static void agregarAlumno() {
        System.out.print("Ingrese nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Ingrese carrera: ");
        String carrera = scanner.nextLine();
        System.out.print("Ingrese matrícula: ");
        String matricula = scanner.nextLine();
        System.out.print("Ingrese promedio: ");
        double promedio = scanner.nextDouble();
        scanner.nextLine();

        Alumno alumno = new Alumno(nombre, apellido, carrera, matricula, promedio);
        usuarios.add(alumno);
        System.out.println("Alumno agregado exitosamente.");
    }

    private static void agregarDocente() {
        System.out.print("Ingrese nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Ingrese carrera: ");
        String carrera = scanner.nextLine();
        System.out.print("Ingrese asignatura: ");
        String asignatura = scanner.nextLine();
        System.out.print("Ingrese salario: ");
        double salario = scanner.nextDouble();
        scanner.nextLine();

        Docente docente = new Docente(nombre, apellido, carrera, asignatura, salario);
        usuarios.add(docente);
        System.out.println("Docente agregado exitosamente.");
    }

    private static void mostrarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
        } else {
            for (Usuario u : usuarios) {
                u.imprimir();
                System.out.println("----------------------");
            }
        }
    }

    private static void modificarUsuario() {
        System.out.print("Ingrese el nombre del usuario a modificar: ");
        String nombre = scanner.nextLine();
        boolean encontrado = false;
        for (Usuario u : usuarios) {
            if (u.getNombre().equalsIgnoreCase(nombre)) {
                System.out.print(
                        "Ingrese el dato a modificar (nombre, apellido, carrera, matricula/promedio para alumno, asignatura/salario para docente): ");
                String campo = scanner.nextLine();
                System.out.print("Ingrese el nuevo valor: ");
                String valor = scanner.nextLine();
                u.modificar(campo, valor);
                System.out.println("Información modificada.");
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Usuario no encontrado.");
        }
    }

    private static void desactivarUsuario() {
        System.out.print("Ingrese el nombre del usuario a desactivar: ");
        String nombre = scanner.nextLine();
        boolean encontrado = false;
        for (Usuario u : usuarios) {
            if (u.getNombre().equalsIgnoreCase(nombre)) {
                u.desactivar();
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Usuario no encontrado.");
        }
    }
}