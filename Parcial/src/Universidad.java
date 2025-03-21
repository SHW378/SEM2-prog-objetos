import java.util.Scanner;

public class Universidad {
    private static Scanner sc = new Scanner(System.in);
    private static Usuario[] usuarios = new Usuario[10];
    private static int usuarioCount = 0;

    public static void main(String[] args) {
        for (;;) {
            System.out.println(
                "Menu:\n" +
                "1. Agregar Alumno\n" +
                "2. Agregar Docente\n" +
                "3. Mostrar Usuarios\n" +
                "4. Modificar Usuario\n" +
                "5. Desactivar Usuario\n" +
                "6. Salir");
            int opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    AgregarAlumno();
                    break;
                case 2:
                    AgregarDocente();
                    break;
                case 3:
                    MostrarUsuarios();
                    break;
                case 4:
                    ModificarUsuario();
                    break;
                case 5:
                    DesactivarUsuario();
                    break;
                case 6:
                    System.out.println("Saliendo del sistema.");
                    return; // Salir del método main
                default:
                    System.out.println("Opción no permitida.");
                    break;
            }
        }
    }

    private static void AgregarAlumno() {
        System.out.println("Ingrese el nombre del alumno:");
        String nombre = sc.nextLine();
        System.out.println("Ingrese el apellido del alumno:");
        String apellido = sc.nextLine();
        System.out.println("Ingrese la carrera del alumno:");
        String carrera = sc.nextLine();
        System.out.println("Ingrese la matrícula del alumno:");
        double matricula = sc.nextDouble();
        System.out.println("Ingrese el promedio del alumno:");
        double promedio = sc.nextDouble();
        sc.nextLine();

        Alumno alumno = new Alumno(nombre, apellido, carrera, matricula, promedio);
        agregarUsuario(alumno);
        System.out.println("Alumno agregado exitosamente.");
    }

    private static void AgregarDocente() {
        System.out.println("Ingrese el nombre del docente:");
        String nombre = sc.nextLine();
        System.out.println("Ingrese el apellido del docente:");
        String apellido = sc.nextLine();
        System.out.println("Ingrese la carrera del docente:");
        String carrera = sc.nextLine();
        System.out.println("Ingrese la asignatura del docente:");
        String asignatura = sc.nextLine();
        System.out.println("Ingrese el salario del docente:");
        double salario = sc.nextDouble();
        sc.nextLine();

        Docente docente = new Docente(nombre, apellido, carrera, asignatura, salario);
        agregarUsuario(docente);
        System.out.println("Docente agregado exitosamente.");
    }

    private static void agregarUsuario(Usuario usuario) {
        if (usuarioCount == usuarios.length) {
            Usuario[] nuevoArreglo = new Usuario[usuarios.length * 2];
            System.arraycopy(usuarios, 0, nuevoArreglo, 0, usuarios.length);
            usuarios = nuevoArreglo;
        }
        usuarios[usuarioCount++] = usuario;
    }

    private static void MostrarUsuarios() {
        if (usuarioCount == 0) {
            System.out.println("No se han encontrado usuarios.");
        } else {
            for (int i = 0; i < usuarioCount; i++) {
                usuarios[i].imprimir();
                System.out.println();
            }
        }
    }

    private static void ModificarUsuario() {
        System.out.print("Ingrese el nombre del usuario a modificar: ");
        String nombreUsuario = sc.nextLine();
        boolean encontrado = false;
        for (int i = 0; i < usuarioCount; i++) {
            if (usuarios[i].GetNombre() == (nombreUsuario)) {
                System.out.print("Ingrese el dato a modificar (nombre, apellido, carrera, matricula/promedio para alumno, asignatura/salario para docente): ");
                String campo = sc.nextLine();
                System.out.print("Ingrese el nuevo valor: ");
                String valor = sc.nextLine();
                usuarios[i].modificar(campo, valor);
                System.out.println("Usuario modificado.");
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Usuario no encontrado.");
        }
    }

    private static void DesactivarUsuario() {
        System.out.print("Ingrese el nombre del usuario a desactivar: ");
        String nombreUsuario = sc.nextLine();
        boolean encontrado = false;
        for (int i = 0; i < usuarioCount; i++) {
            if (usuarios[i].GetNombre() == (nombreUsuario)) {
                usuarios[i].desactivar();
                System.out.println("Usuario desactivado.");
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Usuario no encontrado.");
        }
    }
}