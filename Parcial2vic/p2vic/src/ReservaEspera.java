import java.util.Queue;
import java.util.LinkedList;

public class ReservaEspera {
    private Queue<Reserva> reservasEnEspera;

    public ReservaEspera() {
        reservasEnEspera = new LinkedList<>();
    }

    public void agregarReserva(Reserva reserva) {
        reservasEnEspera.offer(reserva);
    }

    public Reserva procesarReserva() {
        return reservasEnEspera.poll();
    }

    public boolean hayReservas() {
        return !reservasEnEspera.isEmpty();
    }
}