import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int numeroEstudiantes = 0;
        while (true) {
        System.out.println("¿Cuantos estudiantes desea registrar?");
        try {
            numeroEstudiantes = Integer.parseInt(sc.nextLine());
            break;
            } catch (NumberFormatException e) {
                System.out.println("Carácter inválido. Por favor ingrese un carácter válido.");
            }
        }
        for (int i = 0; i < numeroEstudiantes; i++) {
            if (i >= numeroEstudiantes) {
                break;
            }
            System.out.println("ingrese los datos del estudiante " + (i + 1));
            Estudiante primerEstudiante = new Estudiante(null, null, i);
            System.out.println("Nombre: ");
            primerEstudiante.setNombre(sc.nextLine());
            System.out.println("Apellido: ");
            primerEstudiante.setApellido(sc.nextLine());
            System.out.println("Edad: ");
            primerEstudiante.setEdad(Integer.parseInt(sc.nextLine()));
            String respuesta;
            while (true) {
            System.out.println("¿El estudiante ha decidido su carrera? (s/n) ");
            respuesta = sc.nextLine();
                try {
                    if (respuesta.equals("s") || respuesta.equals("n")) {
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Carácter inválido. Por favor ingrese s o n.");
                }
        }
            if (respuesta.equals("s")){
                System.out.println("Carrera: ");
                primerEstudiante.setCarrera(sc.nextLine());
                primerEstudiante.imprimirInscripcion();
            } else if (respuesta.equals("n")) {
                primerEstudiante.imprimirInscripcionSinCarrera(true);
            } 
        }
        sc.close();
    }
}