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
}