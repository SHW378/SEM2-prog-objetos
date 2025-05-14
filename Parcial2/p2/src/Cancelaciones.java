import java.util.Stack;

public class Cancelaciones {
    private Stack<Reserva> reservaCancelada;
    private Cine cine; 
    public Cancelaciones(Cine cine) { 
        this.reservaCancelada = new Stack<>();
        this.cine = cine; 
    }

    public void agregarReservaCancelada(int funcion, int sala, int fila, int columna) {
        Reserva reserva = new Reserva(funcion, sala, fila, columna);
        reservaCancelada.push(reserva);
        System.out.println("Reserva cancelada: " + reserva);
    }

    public void deshacerCancelacion() {
        if (reservaCancelada.isEmpty()) {
            System.out.println("No hay reservas canceladas para deshacer.");
            return;
        }
        Reserva ultimaReserva = reservaCancelada.pop();
        System.out.println("Reserva deshecha: " + ultimaReserva);

        if (cine.estaReservado(ultimaReserva.getFuncion(), ultimaReserva.getSala(), ultimaReserva.getFila(), ultimaReserva.getColumna())) {
            System.out.println("El asiento ya está reservado.");
        } else {
            cine.reservarAsiento(ultimaReserva.getFuncion(), ultimaReserva.getSala(), ultimaReserva.getFila(), ultimaReserva.getColumna());
            System.out.println("Reserva restaurada: " + ultimaReserva);
        }
    }
    public void mostrarCancelaciones() {
        if (reservaCancelada.isEmpty()) {
            System.out.println("No hay reservas canceladas.");
            return;
        }
        System.out.println("Cancelaciones Pendientes:");
        for (Reserva reserva : reservaCancelada) {
            System.out.println(reserva);
        }
    }
}