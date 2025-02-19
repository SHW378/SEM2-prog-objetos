import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("¿Cuantos estudiantes desea registrar?");
        int numeroEstudiantes = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < numeroEstudiantes; i++) {
            if (i >= numeroEstudiantes) {
                break;
            }
            System.out.println("ingrese los datos del estudiante " + (i + 1));
            Estudiante primerEstudiante = new Estudiante();
            System.out.println("Nombre: ");
            primerEstudiante.setNombre(sc.nextLine());
            System.out.println("Apellido: ");
            primerEstudiante.setApellido(sc.nextLine());
            System.out.println("Edad: ");
            primerEstudiante.setEdad(Integer.parseInt(sc.nextLine()));
            System.out.println("¿El estudiante ha decidido su carrera? (s/n) ");
            String respuesta = sc.nextLine();
            if (respuesta.equals("s")) {
                System.out.println("Carrera: ");
                primerEstudiante.setCarrera(sc.nextLine());
                System.out.println("Se ha inscrito: " + primerEstudiante.getNombre() + " " + primerEstudiante.getApellido() + ", " + primerEstudiante.getEdad() + " años, para la carrera de " + primerEstudiante.getCarrera());
            } else if (respuesta.equals("n")) {
                System.out.println("Se ha inscrito: " + primerEstudiante.getNombre() + " " + primerEstudiante.getApellido() + ", " + primerEstudiante.getEdad() + " años, aún no ha decidido su carrera");
            } else {
                System.out.println("Caracter no válido");
            }
        }
        sc.close();
    }
}
