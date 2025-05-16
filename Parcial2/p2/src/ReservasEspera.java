import java.util.LinkedList;
import java.util.Queue;

public class ReservasEspera {
    private Queue<String> reservasEnEspera;
    
    public ReservasEspera() {
        reservasEnEspera = new LinkedList<>();
    }
    
    public void agregarReservaEspera(int funcion, int sala, int fila, int columna) {
        String infoReserva = String.format("Función: %d, Sala: %d, Fila: %d, Columna: %d", 
                                          funcion, sala, fila, columna);
        reservasEnEspera.add(infoReserva);
    }
    
    public boolean hayReservasEnEspera() {
        return !reservasEnEspera.isEmpty();
    }
    
    public String[] procesarReservaEnEspera() {
        if (!hayReservasEnEspera()) {
            return null;
        }
        
        String infoReserva = reservasEnEspera.poll();
        String[] partes = infoReserva.split(", ");
        
        int funcion = Integer.parseInt(partes[0].split(": ")[1]);
        int sala = Integer.parseInt(partes[1].split(": ")[1]);
        int fila = Integer.parseInt(partes[2].split(": ")[1]);
        int columna = Integer.parseInt(partes[3].split(": ")[1]);
        
        return new String[] {
            String.valueOf(funcion),
            String.valueOf(sala),
            String.valueOf(fila),
            String.valueOf(columna)
        };
    }
    
    public void devolverReservaAEspera(int funcion, int sala, int fila, int columna) {
        String infoReserva = String.format("Función: %d, Sala: %d, Fila: %d, Columna: %d", 
                                          funcion, sala, fila, columna);
        reservasEnEspera.add(infoReserva);
    }
    
    public void mostrarReservasEnEspera() {
        if (reservasEnEspera.isEmpty()) {
            System.out.println("No hay reservas en espera en el sistema.");
            return;
        }
        
        System.out.println("Lista de reservas en espera (de la más antigua a la más reciente):");
        
        Queue<String> temp = new LinkedList<>(reservasEnEspera);
        
        int contador = 1;
        while (!temp.isEmpty()) {
            System.out.println(contador + ". " + temp.poll());
            contador++;
        }
    }
}