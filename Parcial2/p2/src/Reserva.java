import java.util.Scanner;

public class Reserva {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== SISTEMA DE RESERVAS PARA CINE ===");
        System.out.println("Configuración del cine:");
        
        System.out.print("Número de funciones: ");
        int numFunciones = obtenerEnteroPositivo(scanner);
        
        System.out.print("Número de salas por función: ");
        int numSalas = obtenerEnteroPositivo(scanner);
        
        System.out.print("Número de filas por sala: ");
        int numFilas = obtenerEnteroPositivo(scanner);
        
        System.out.print("Número de columnas por sala: ");
        int numColumnas = obtenerEnteroPositivo(scanner);
        
        Cine cine = new Cine(numFunciones, numSalas, numFilas, numColumnas);
        Cancelaciones cancelaciones = new Cancelaciones();
        ReservasEspera reservasEspera = new ReservasEspera();
        
        int opcion;
        do {
            mostrarMenu();
            System.out.print("Seleccione una opción: ");
            opcion = obtenerEnteroEnRango(scanner, 0, 7);
            
            switch (opcion) {
                case 1:
                    verSalas(scanner, cine);
                    break;
                case 2:
                    reservarAsiento(scanner, cine, reservasEspera);
                    break;
                case 3:
                    cancelarReserva(scanner, cine, cancelaciones);
                    break;
                case 4:
                    verCancelaciones(cancelaciones);
                    break;
                case 5:
                    verReservasEspera(reservasEspera);
                    break;
                case 6:
                    deshacerCancelacion(cine, cancelaciones);
                    break;
                case 7:
                    procesarReservaEspera(cine, reservasEspera);
                    break;
                case 0:
                    System.out.println("Cerrando el sistema...");
                    break;
            }
        } while (opcion != 0);
        
        scanner.close();
    }
    
    private static void mostrarMenu() {
        System.out.println("\n=== MENÚ PRINCIPAL ===");
        System.out.println("1. Ver estado de las salas");
        System.out.println("2. Reservar asiento");
        System.out.println("3. Cancelar reserva");
        System.out.println("4. Ver reservas canceladas");
        System.out.println("5. Ver reservas en espera");
        System.out.println("6. Deshacer cancelación");
        System.out.println("7. Procesar reserva en espera");
        System.out.println("0. Salir");
    }
    
    private static void verSalas(Scanner scanner, Cine cine) {
        System.out.print("Ingrese el número de función (0-" + (cine.getNumFunciones() - 1) + "): ");
        int funcion = obtenerEnteroEnRango(scanner, 0, cine.getNumFunciones() - 1);
        
        System.out.print("Ingrese el número de sala (0-" + (cine.getNumSalasPorFuncion() - 1) + "): ");
        int sala = obtenerEnteroEnRango(scanner, 0, cine.getNumSalasPorFuncion() - 1);
        
        cine.mostrarEstadoSala(funcion, sala);
    }
    
    private static void reservarAsiento(Scanner scanner, Cine cine, ReservasEspera reservasEspera) {
        System.out.print("Ingrese el número de función (0-" + (cine.getNumFunciones() - 1) + "): ");
        int funcion = obtenerEnteroEnRango(scanner, 0, cine.getNumFunciones() - 1);
        
        System.out.print("Ingrese el número de sala (0-" + (cine.getNumSalasPorFuncion() - 1) + "): ");
        int sala = obtenerEnteroEnRango(scanner, 0, cine.getNumSalasPorFuncion() - 1);
        
        System.out.print("Ingrese la fila del asiento (0-" + (cine.getFilasSala(funcion, sala) - 1) + "): ");
        int fila = obtenerEnteroEnRango(scanner, 0, cine.getFilasSala(funcion, sala) - 1);
        
        System.out.print("Ingrese la columna del asiento (0-" + (cine.getColumnasSala(funcion, sala) - 1) + "): ");
        int columna = obtenerEnteroEnRango(scanner, 0, cine.getColumnasSala(funcion, sala) - 1);
        
        if (cine.reservarAsiento(funcion, sala, fila, columna)) {
            System.out.println("¡Asiento reservado con éxito!");
        } else {
            System.out.println("No se pudo reservar el asiento. El asiento ya está reservado.");
            System.out.println("La reserva se agregará a la lista de espera.");
            reservasEspera.agregarReservaEspera(funcion, sala, fila, columna);
            reservasEspera.mostrarReservasEspera();
        }
    }
    
    private static void cancelarReserva(Scanner scanner, Cine cine, Cancelaciones cancelaciones) {
        System.out.print("Ingrese el número de función (0-" + (cine.getNumFunciones() - 1) + "): ");
        int funcion = obtenerEnteroEnRango(scanner, 0, cine.getNumFunciones() - 1);
        
        System.out.print("Ingrese el número de sala (0-" + (cine.getNumSalasPorFuncion() - 1) + "): ");
        int sala = obtenerEnteroEnRango(scanner, 0, cine.getNumSalasPorFuncion() - 1);
        
        System.out.print("Ingrese la fila del asiento (0-" + (cine.getFilasSala(funcion, sala) - 1) + "): ");
        int fila = obtenerEnteroEnRango(scanner, 0, cine.getFilasSala(funcion, sala) - 1);
        
        System.out.print("Ingrese la columna del asiento (0-" + (cine.getColumnasSala(funcion, sala) - 1) + "): ");
        int columna = obtenerEnteroEnRango(scanner, 0, cine.getColumnasSala(funcion, sala) - 1);
        
        if (cine.cancelarReserva(funcion, sala, fila, columna)) {
            System.out.println("Reserva cancelada con éxito.");
            cancelaciones.agregarCancelacion(funcion, sala, fila, columna);
            cancelaciones.mostrarCancelaciones();
        } else {
            System.out.println("No se pudo cancelar la reserva. El asiento no estaba reservado.");
        }
    }
    
    private static void verCancelaciones(Cancelaciones cancelaciones) {
        cancelaciones.mostrarCancelaciones();
    }
    
    private static void verReservasEspera(ReservasEspera reservasEspera) {
        reservasEspera.mostrarReservasEspera();
    }
    
    private static void deshacerCancelacion(Cine cine, Cancelaciones cancelaciones) {
        if (!cancelaciones.hayCancelaciones()) {
            System.out.println("No hay cancelaciones para deshacer.");
            return;
        }
        
        InfoReserva info = cancelaciones.deshacerCancelacion();
        if (info != null) {
            int funcion = info.getFuncion();
            int sala = info.getSala();
            int fila = info.getFila();
            int columna = info.getColumna();
            
            if (cine.estaReservado(funcion, sala, fila, columna)) {
                System.out.println("No se puede deshacer la cancelación. El asiento ya está reservado.");
            } else {
                if (cine.reservarAsiento(funcion, sala, fila, columna)) {
                    System.out.println("Se deshizo la cancelación. Asiento reservado nuevamente.");
                } else {
                    System.out.println("Error al deshacer la cancelación.");
                }
            }
        }
        
        cancelaciones.mostrarCancelaciones();
    }
    
    private static void procesarReservaEspera(Cine cine, ReservasEspera reservasEspera) {
        if (!reservasEspera.hayReservasEspera()) {
            System.out.println("No hay reservas en espera para procesar.");
            return;
        }
        
        InfoReserva info = reservasEspera.procesarReservaEspera();
        if (info != null) {
            int funcion = info.getFuncion();
            int sala = info.getSala();
            int fila = info.getFila();
            int columna = info.getColumna();
            
            if (cine.reservarAsiento(funcion, sala, fila, columna)) {
                System.out.println("Reserva en espera procesada con éxito. Asiento reservado.");
            } else {
                System.out.println("No se pudo procesar la reserva en espera. El asiento sigue ocupado.");
                System.out.println("La reserva vuelve a la cola de espera.");
                reservasEspera.regresarAEspera(info);
            }
        }
        
        reservasEspera.mostrarReservasEspera();
    }
    
    private static int obtenerEnteroPositivo(Scanner scanner) {
        int valor;
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, ingrese un número entero.");
                scanner.next(); 
            }
            valor = scanner.nextInt();
            scanner.nextLine(); 
            
            if (valor <= 0) {
                System.out.println("Por favor, ingrese un número mayor que cero.");
            }
        } while (valor <= 0);
        
        return valor;
    }
    
    private static int obtenerEnteroEnRango(Scanner scanner, int min, int max) {
        int valor;
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, ingrese un número entero.");
                scanner.next(); 
            }
            valor = scanner.nextInt();
            scanner.nextLine(); 
            
            if (valor < min || valor > max) {
                System.out.println("Por favor, ingrese un número entre " + min + " y " + max + ".");
            }
        } while (valor < min || valor > max);
        
        return valor;
    }
}