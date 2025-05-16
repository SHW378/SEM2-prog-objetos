import java.util.Stack;

public class Cancelaciones {
    private Stack<String> reservasCanceladas;
    
    public Cancelaciones() {
        reservasCanceladas = new Stack<>();
    }
    
    public void registrarCancelacion(int funcion, int sala, int fila, int columna) {
        String infoCancelacion = String.format("Función: %d, Sala: %d, Fila: %d, Columna: %d", 
                                              funcion, sala, fila, columna);
        reservasCanceladas.push(infoCancelacion);
    }
    
    public boolean hayReservasCanceladas() {
        return !reservasCanceladas.isEmpty();
    }
    
    public String[] deshacerCancelacion() {
        if (!hayReservasCanceladas()) {
            return null;
        }
        
        String infoCancelacion = reservasCanceladas.pop();
        String[] partes = infoCancelacion.split(", ");
        
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
    
    public void mostrarCancelaciones() {
        if (reservasCanceladas.isEmpty()) {
            System.out.println("No hay reservas canceladas en el sistema.");
            return;
        }
        
        System.out.println("Lista de reservas canceladas (de la más reciente a la más antigua):");
        
        Stack<String> temp = new Stack<>();
        temp.addAll(reservasCanceladas);
        
        int contador = 1;
        while (!temp.isEmpty()) {
            System.out.println(contador + ". " + temp.pop());
            contador++;
        }
    }
    
    public void deshacerCancelacion(Cine cine, ReservasEspera reservasEspera) {
        System.out.println("\n--- Deshacer Cancelación ---");
        if (!hayReservasCanceladas()) {
            System.out.println("No hay reservas canceladas para deshacer.");
            return;
        }
        
        String[] datos = deshacerCancelacion();
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
}