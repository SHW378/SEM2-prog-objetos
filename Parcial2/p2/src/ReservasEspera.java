import java.util.LinkedList;
import java.util.Queue;

public class ReservasEspera {
    private Queue<InfoReserva> reservasEnEspera;
    
    public ReservasEspera() {
        this.reservasEnEspera = new LinkedList<>();
    }
    
    public void agregarReservaEspera(int funcion, int sala, int fila, int columna) {
        InfoReserva info = new InfoReserva(funcion, sala, fila, columna);
        reservasEnEspera.add(info);
    }
    
    public InfoReserva procesarReservaEspera() {
        if (!reservasEnEspera.isEmpty()) {
            return reservasEnEspera.poll();
        }
        return null;
    }
    
    public void regresarAEspera(InfoReserva info) {
        if (info != null) {
            reservasEnEspera.add(info);
        }
    }
    
    public boolean hayReservasEspera() {
        return !reservasEnEspera.isEmpty();
    }
    
    public void mostrarReservasEspera() {
        if (reservasEnEspera.isEmpty()) {
            System.out.println("No hay reservas en espera.");
            return;
        }
        
        System.out.println("Reservas en espera:");
        int i = 1;
        for (InfoReserva info : reservasEnEspera) {
            System.out.println(i + ": " + info);
            i++;
        }
    }
}