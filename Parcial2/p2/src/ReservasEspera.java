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
    
    public String[] obtenerReservaEnEspera() {
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
    
    public void procesarReservaEnEspera(Cine cine) {
        System.out.println("\n--- Procesar Reserva en Espera ---");
        if (!hayReservasEnEspera()) {
            System.out.println("No hay reservas en espera para procesar.");
            return;
        }
        
        String[] datos = obtenerReservaEnEspera();
        int funcion = Integer.parseInt(datos[0]);
        int sala = Integer.parseInt(datos[1]);
        int fila = Integer.parseInt(datos[2]);
        int columna = Integer.parseInt(datos[3]);
        
        if (cine.reservarAsiento(funcion, sala, fila, columna)) {
            System.out.println("¡Reserva en espera procesada con éxito! Asiento reservado.");
        } else {
            System.out.println("No se pudo procesar la reserva en espera. El asiento sigue ocupado.");
            System.out.println("La reserva volverá al final de la cola de espera.");
            devolverReservaAEspera(funcion, sala, fila, columna);
        }
    }
}