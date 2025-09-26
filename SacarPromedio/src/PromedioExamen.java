import java.util.*;

public class PromedioExamen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Cálculo de promedio ponderado (Examen / Tareas) ===");
        
        //leer porcentajes
        float porcentaje_examen = (float) pedirNumero(sc, "Ingrese el porcentaje del examen (0-100): ", 0f, 100f);
        float porcentaje_tareas = (float) pedirNumero(sc, "Ingrese el porcentaje de las tareas (0-100): ", 0f, 100f);

        while (porcentaje_examen + porcentaje_tareas != 100f) {
            System.out.println("La suma de porcentajes debe ser exactamente 100. Intente nuevamente.");
            porcentaje_examen = (float) pedirNumero(sc, "Ingrese el porcentaje del examen (0-100): ", 0f, 100f);
            porcentaje_tareas = (float) pedirNumero(sc, "Ingrese el porcentaje de las tareas (0-100): ", 0f, 100f);
        }
        float cal_examen = (float) pedirNumero(sc, "Ingrese la calificación del examen (0-100): ", 0f, 100f);

        System.out.println("Ingrese calificaciones de Tareas (0-100). Escriba 'n' para terminar:");
        float suma_tareas = 0f;
        int cantidad_tareas = 0;

        while (true) {
            System.out.print("Calificación de tarea (o 'n' para terminar): ");
            String input = sc.nextLine().strip().toLowerCase();
            if (input.equals("n")) {
                if (cantidad_tareas == 0) {
                    System.out.println("Debe ingresar al menos una calificación de tarea");
                    continue;
                } else {
                    break;
                }
            }
            try {
                float cal_tarea = Float.parseFloat(input);
                if (cal_tarea < 0f || cal_tarea > 100f) {
                    System.out.println("La calificación debe estar entre 0 y 100.");
                    continue;
                }
                suma_tareas += cal_tarea;
                cantidad_tareas++;
            } catch (NumberFormatException e) {
                System.out.println("Por favor ingrese un número válido o 'n' para terminar.");
            }
        }
        float promedio_tareas = suma_tareas / cantidad_tareas;

        float promedio_final = (cal_examen * (porcentaje_examen / 100)) + (promedio_tareas * (porcentaje_tareas / 100));
        
        System.out.println("\n=== Resultado ===");
        System.out.println(String.format("%% Examen: %.2f%%, Tareas: %.2f%%", porcentaje_examen, porcentaje_tareas));
        System.out.println(String.format("Calif. Examen: %.2f%n", cal_examen));
        System.out.printf("Promedio Tareas: %.2f (con %d tareas)%n", promedio_tareas, cantidad_tareas);
        System.out.println(String.format("Promedio Final: %.2f", promedio_final));
    }

    public static double pedirNumero(Scanner sc, String mensaje, Float minimo, Float maximo) {
        while (true) {
            try {
                System.out.print(mensaje);
                float valor = Float.parseFloat(sc.nextLine());
                if  (minimo != null && valor < minimo) {
                    System.out.println("El valor debe ser >=" + minimo);
                    continue;
                } else if (maximo != null && valor > maximo) {
                    System.out.println("El valor debe ser <=" + maximo);
                    continue;
                }
                return valor;
            } catch (Exception e) {
                System.out.println("Por favor ingrese un número válido.");
            }
        }
    }
}
