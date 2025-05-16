import java.util.ArrayList;
import java.util.Scanner;

public class Cine {
    private ArrayList<ArrayList<Sala>> salas; 
    private int numFunciones;
    private int numSalas;

    public Cine(int numFunciones, int numSalas, int filas, int columnas) {
        this.numFunciones = numFunciones;
        this.numSalas = numSalas;
        salas = new ArrayList<>(numFunciones);
        
        for (int funcion = 0; funcion < numFunciones; funcion++) {
            ArrayList<Sala> salasEnFuncion = new ArrayList<>(numSalas);
            for (int sala = 0; sala < numSalas; sala++) {
                salasEnFuncion.add(new Sala(filas, columnas));
            }
            salas.add(salasEnFuncion);
        }
    }

    public boolean reservarAsiento(int funcion, int sala, int fila, int columna) {
        if (esFuncionYSalaValida(funcion, sala)) {
            return salas.get(funcion).get(sala).reservarAsiento(fila, columna);
        }
        return false;
    }

    public boolean cancelarReservaAsiento(int funcion, int sala, int fila, int columna) {
        if (esFuncionYSalaValida(funcion, sala)) {
            return salas.get(funcion).get(sala).cancelarReservaAsiento(fila, columna);
        }
        return false;
    }
    
    public boolean estaAsientoReservado(int funcion, int sala, int fila, int columna) {
        if (esFuncionYSalaValida(funcion, sala)) {
            return salas.get(funcion).get(sala).estaAsientoReservado(fila, columna);
        }
        return false;
    }

    public boolean esFuncionYSalaValida(int funcion, int sala) {
        return funcion >= 0 && funcion < numFunciones && sala >= 0 && sala < numSalas;
    }

    public void mostrarEstadoSala(int funcion, int sala) {
        if (esFuncionYSalaValida(funcion, sala)) {
            System.out.println("Estado de la sala " + sala + " en la función " + funcion + ":");
            salas.get(funcion).get(sala).mostrarEstadoAsientos();
        } else {
            System.out.println("Función o sala no válida");
        }
    }
    
    public int getNumFunciones() {
        return numFunciones;
    }
    
    public int getNumSalas() {
        return numSalas;
    }
    
    public int getFilas(int funcion, int sala) {
        if (esFuncionYSalaValida(funcion, sala)) {
            return salas.get(funcion).get(sala).getFilas();
        }
        return 0;
    }
    
    public int getColumnas(int funcion, int sala) {
        if (esFuncionYSalaValida(funcion, sala)) {
            return salas.get(funcion).get(sala).getColumnas();
        }
        return 0;
    }
    
    public void verSala(Scanner scanner) {
        System.out.println("\n--- Ver Estado de una Sala ---");
        System.out.print("Ingrese el número de función (0-" + (getNumFunciones() - 1) + "): ");
        int funcion = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Ingrese el número de sala (0-" + (getNumSalas() - 1) + "): ");
        int sala = Integer.parseInt(scanner.nextLine());
        
        mostrarEstadoSala(funcion, sala);
    }
    
    public void reservarAsiento(ReservasEspera reservasEspera, Scanner scanner) {
        System.out.println("\n--- Reservar un Asiento ---");
        System.out.print("Ingrese el número de función (0-" + (getNumFunciones() - 1) + "): ");
        int funcion = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Ingrese el número de sala (0-" + (getNumSalas() - 1) + "): ");
        int sala = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Ingrese el número de fila: ");
        int fila = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Ingrese el número de columna: ");
        int columna = Integer.parseInt(scanner.nextLine());
        
        if (esFuncionYSalaValida(funcion, sala)) {
            if (reservarAsiento(funcion, sala, fila, columna)) {
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
    
    public void cancelarReserva(Cancelaciones cancelaciones, Scanner scanner) {
        System.out.println("\n--- Cancelar una Reserva ---");
        System.out.print("Ingrese el número de función (0-" + (getNumFunciones() - 1) + "): ");
        int funcion = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Ingrese el número de sala (0-" + (getNumSalas() - 1) + "): ");
        int sala = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Ingrese el número de fila: ");
        int fila = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Ingrese el número de columna: ");
        int columna = Integer.parseInt(scanner.nextLine());
        
        if (esFuncionYSalaValida(funcion, sala)) {
            if (cancelarReservaAsiento(funcion, sala, fila, columna)) {
                System.out.println("Reserva cancelada con éxito.");
                cancelaciones.registrarCancelacion(funcion, sala, fila, columna);
            } else {
                System.out.println("No se pudo cancelar la reserva. El asiento no estaba reservado o no es válido.");
            }
        } else {
            System.out.println("Función o sala no válida.");
        }
    }
}