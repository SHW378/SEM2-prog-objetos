import java.util.Scanner;
import java.util.ArrayList;
public class Universidad {
    private static Scanner sc = new Scanner(System.in);
    public static ArrayList<Usuario> usuarios = new ArrayList<>();

        public static void main(String[] args) {
            int opcion = 0;
            for (int i = 0; i <= 20; i++) {
                System.out.println(
                "Menu:\n" +
                "1. Agregar Alumno\n" +
                "2. Agregar Docente\n" +
                "3. Mostrar Usuarios\n" +
                "4. Modificar Usuario\n" +
                "5. Desactivar Usuario\n" +
                "6. Salir");
                opcion = sc.nextInt();
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
                        break;
                    default:
                        System.out.println("Opción no permitida.");
                        break;
                }
                if (opcion == 6) {
                    break;
                }
            }
        }

    private static void AgregarAlumno() {
        System.out.println("Ingrese el nombre del alumno: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese el apellido del alumno: ");
        String apellido = sc.nextLine();
        System.out.println("Ingrese la carrera del alumno: ");
        String carrerra = sc.nextLine();
        System.out.println("Ingrese la matricula del alumno: ");
        double matricula = sc.nextDouble();
        System.out.println("Ingrese el promedio del alumno: ");
        double promedio = sc.nextDouble();
        Alumno alumno = new Alumno(nombre, apellido, carrerra, matricula, promedio);
        usuarios.add(alumno);
        System.out.println("Alumno agregado.");
    }

    private static void AgregarDocente() {
        System.out.println("Ingrese el nombre del docente: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese el apellido del docente: ");
        String apellido = sc.nextLine();
        System.out.println("Ingrese la carrera del docente: ");
        String carrerra = sc.nextLine();
        System.out.println("Ingrese la asignatura del docente: ");
        String asignatura = sc.nextLine();
        System.out.println("Ingrese el salario del docente: ");
        double salario = sc.nextDouble();
        Docente docente = new Docente(nombre, apellido, carrerra, asignatura, salario);
        usuarios.add(docente);
        System.out.println("Docente agregado.");
    }
    private static void MostrarUsuarios() {
        if (usuarios == null || usuarios.isEmpty()) {
            System.out.println("No se han encontrado usuarios");
        } else {
            for (Usuario u : usuarios) {
                u.imprimir();
                System.out.println();
            }
        }
    }

    private static void ModificarUsuario() {
        System.out.print("Ingrese el usuario a modificar: ");
        String usuario = sc.nextLine();
        for (Usuario u : usuarios) {
            if (u.GetNombre() == (usuario)) {
                System.out.print( "Ingrese el dato a modificar (nombre, apellido, carrera, matricula/promedio para alumno, asignatura/salario para docente): ");
                String campo = sc.nextLine();
                System.out.print("Ingrese el nuevo valor: ");
                String valor = sc.nextLine();
                u.modificar(campo, valor);
                System.out.println("Usuario modificado.");
                break;
            }
        }
        System.out.println("Usuario no encontrado");
    }
    
    private static void DesactivarUsuario() {
        System.out.println("ingrese el usuario a desactivar: ");
        String usuario = sc.nextLine();
        for (Usuario u : usuarios) {
            if (u.GetNombre() == (usuario)) {
                u.desactivar();
                System.out.println("Usuario desactivado.");
                break;
            }
        }
        System.out.println("Usuario no encontrado");
    }
}
