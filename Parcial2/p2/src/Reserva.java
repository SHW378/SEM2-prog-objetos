import java.util.Scanner;

public class Reserva {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("===== CONFIGURACIÓN INICIAL DEL CINE =====");
        
        int numFunciones = solicitarEnteroPositivo(scanner, "Ingrese la cantidad de funciones : ", 1);
        int numSalas = solicitarEnteroPositivo(scanner, "Ingrese la cantidad de salas por función: ", 1);
        int numFilas = solicitarEnteroPositivo(scanner, "Ingrese la cantidad de filas por sala: ", 1);
        int numColumnas = solicitarEnteroPositivo(scanner, "Ingrese la cantidad de asientos por fila: ", 1);
        
        
        Cine cine = new Cine(numFunciones, numSalas, numFilas, numColumnas);
        Cancelaciones cancelaciones = new Cancelaciones();
        ReservasEspera reservasEspera = new ReservasEspera();
        
        
        boolean salir = false;
        while (!salir) {
            mostrarMenu();
            
            try {
                int opcion = Integer.parseInt(scanner.nextLine());
                
                switch (opcion) {
                    case 1:
                        cine.verSala(scanner);
                        break;
                    case 2:
                        cine.reservarAsiento(reservasEspera, scanner);
                        break;
                    case 3:
                        cine.cancelarReserva(cancelaciones, scanner);
                        break;
                    case 4:
                        cancelaciones.mostrarCancelaciones();
                        break;
                    case 5:
                        reservasEspera.mostrarReservasEnEspera();
                        break;
                    case 6:
                        cancelaciones.deshacerCancelacion(cine, reservasEspera);
                        break;
                    case 7:
                        reservasEspera.procesarReservaEnEspera(cine);
                        break;
                    case 8:
                        System.out.println("Saliendo del programa.");
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, intente de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
            }
            
            if (!salir) {
                System.out.println("\nPresione Enter para continuar...");
                scanner.nextLine();
            }
        }
        
        scanner.close();
    }
    
    private static int solicitarEnteroPositivo(Scanner scanner, String mensaje, int minimo) {
        int valor = 0;
        boolean entradaValida = false;
        
        while (!entradaValida) {
            System.out.print(mensaje);
            try {
                valor = Integer.parseInt(scanner.nextLine());
                if (valor >= minimo) {
                    entradaValida = true;
                } else {
                    System.out.println("Por favor, ingrese un número mayor o igual a " + minimo + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
            }
        }
        
        return valor;
    }
    
    private static void mostrarMenu() {
        System.out.println("\n===== SISTEMA DE RESERVAS DE CINE =====");
        System.out.println("1. Ver estado de una sala");
        System.out.println("2. Reservar un asiento");
        System.out.println("3. Cancelar una reserva");
        System.out.println("4. Ver reservas canceladas");
        System.out.println("5. Ver reservas en espera");
        System.out.println("6. Deshacer una cancelación");
        System.out.println("7. Procesar reserva en espera");
        System.out.println("8. Salir");
        System.out.print("Seleccione una opción: ");
    }
}