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
                        verSala(cine, scanner);
                        break;
                    case 2:
                        reservarAsiento(cine, reservasEspera, scanner);
                        break;
                    case 3:
                        cancelarReserva(cine, cancelaciones, scanner);
                        break;
                    case 4:
                        verReservasCanceladas(cancelaciones);
                        break;
                    case 5:
                        verReservasEnEspera(reservasEspera);
                        break;
                    case 6:
                        deshacerCancelacion(cine, cancelaciones, reservasEspera);
                        break;
                    case 7:
                        procesarReservaEnEspera(cine, reservasEspera);
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
    
    private static void verSala(Cine cine, Scanner scanner) {
        System.out.println("\n--- Ver Estado de una Sala ---");
        System.out.print("Ingrese el número de función (0-" + (cine.getNumFunciones() - 1) + "): ");
        int funcion = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Ingrese el número de sala (0-" + (cine.getNumSalas() - 1) + "): ");
        int sala = Integer.parseInt(scanner.nextLine());
        
        cine.mostrarEstadoSala(funcion, sala);
    }
    
    private static void reservarAsiento(Cine cine, ReservasEspera reservasEspera, Scanner scanner) {
        System.out.println("\n--- Reservar un Asiento ---");
        System.out.print("Ingrese el número de función (0-" + (cine.getNumFunciones() - 1) + "): ");
        int funcion = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Ingrese el número de sala (0-" + (cine.getNumSalas() - 1) + "): ");
        int sala = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Ingrese el número de fila: ");
        int fila = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Ingrese el número de columna: ");
        int columna = Integer.parseInt(scanner.nextLine());
        
        if (cine.esFuncionYSalaValida(funcion, sala)) {
            if (cine.reservarAsiento(funcion, sala, fila, columna)) {
                System.out.println("¡Asiento reservado con éxito!");
            } else {
                System.out.println("No se pudo reservar el asiento. Está ocupado o no es válido.");
                System.out.println("El asiento se ha añadido a la lista de espera.");
                reservasEspera.agregarReservaEspera(funcion, sala, fila, columna);
            }
        } else {
            System.out.println("Función o sala no válida.");
        }
    }
    
    private static void cancelarReserva(Cine cine, Cancelaciones cancelaciones, Scanner scanner) {
        System.out.println("\n--- Cancelar una Reserva ---");
        System.out.print("Ingrese el número de función (0-" + (cine.getNumFunciones() - 1) + "): ");
        int funcion = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Ingrese el número de sala (0-" + (cine.getNumSalas() - 1) + "): ");
        int sala = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Ingrese el número de fila: ");
        int fila = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Ingrese el número de columna: ");
        int columna = Integer.parseInt(scanner.nextLine());
        
        if (cine.esFuncionYSalaValida(funcion, sala)) {
            if (cine.cancelarReservaAsiento(funcion, sala, fila, columna)) {
                System.out.println("Reserva cancelada con éxito.");
                cancelaciones.registrarCancelacion(funcion, sala, fila, columna);
            } else {
                System.out.println("No se pudo cancelar la reserva. El asiento no estaba reservado o no es válido.");
            }
        } else {
            System.out.println("Función o sala no válida.");
        }
    }
    
    private static void verReservasCanceladas(Cancelaciones cancelaciones) {
        System.out.println("\n--- Reservas Canceladas ---");
        cancelaciones.mostrarCancelaciones();
    }
    
    private static void verReservasEnEspera(ReservasEspera reservasEspera) {
        System.out.println("\n--- Reservas en Espera ---");
        reservasEspera.mostrarReservasEnEspera();
    }
    
    private static void deshacerCancelacion(Cine cine, Cancelaciones cancelaciones, ReservasEspera reservasEspera) {
        System.out.println("\n--- Deshacer Cancelación ---");
        if (!cancelaciones.hayReservasCanceladas()) {
            System.out.println("No hay reservas canceladas para deshacer.");
            return;
        }
        
        String[] datos = cancelaciones.deshacerCancelacion();
        int funcion = Integer.parseInt(datos[0]);
        int sala = Integer.parseInt(datos[1]);
        int fila = Integer.parseInt(datos[2]);
        int columna = Integer.parseInt(datos[3]);
        
        if (cine.estaAsientoReservado(funcion, sala, fila, columna)) {
            System.out.println("El asiento ya ha sido reservado por otra persona. La cancelación no se puede deshacer.");
            return;
        }
        
        if (cine.reservarAsiento(funcion, sala, fila, columna)) {
            System.out.println("Cancelación deshecha con éxito. El asiento ha sido reservado nuevamente.");
        } else {
            System.out.println("No se pudo deshacer la cancelación. Error al reservar el asiento.");
        }
    }
    
    private static void procesarReservaEnEspera(Cine cine, ReservasEspera reservasEspera) {
        System.out.println("\n--- Procesar Reserva en Espera ---");
        if (!reservasEspera.hayReservasEnEspera()) {
            System.out.println("No hay reservas en espera para procesar.");
            return;
        }
        
        String[] datos = reservasEspera.procesarReservaEnEspera();
        int funcion = Integer.parseInt(datos[0]);
        int sala = Integer.parseInt(datos[1]);
        int fila = Integer.parseInt(datos[2]);
        int columna = Integer.parseInt(datos[3]);
        
        if (cine.reservarAsiento(funcion, sala, fila, columna)) {
            System.out.println("¡Reserva en espera procesada con éxito! Asiento reservado.");
        } else {
            System.out.println("No se pudo procesar la reserva en espera. El asiento sigue ocupado.");
            System.out.println("La reserva volverá al final de la cola de espera.");
            reservasEspera.devolverReservaAEspera(funcion, sala, fila, columna);
        }
    }
}