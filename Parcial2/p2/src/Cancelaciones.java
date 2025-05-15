import java.util.Stack;

public class Cancelaciones {
    private Stack<InfoReserva> reservasCanceladas;
    
    public Cancelaciones() {
        this.reservasCanceladas = new Stack<>();
    }
    
    public void agregarCancelacion(int funcion, int sala, int fila, int columna) {
        InfoReserva info = new InfoReserva(funcion, sala, fila, columna);
        reservasCanceladas.push(info);
    }
    
    public InfoReserva deshacerCancelacion() {
        if (!reservasCanceladas.empty()) {
            return reservasCanceladas.pop();
        }
        return null;
    }
    
    public boolean hayCancelaciones() {
        return !reservasCanceladas.empty();
    }
    
    public void mostrarCancelaciones() {
        if (reservasCanceladas.empty()) {
            System.out.println("No hay cancelaciones pendientes.");
            return;
        }
        
        System.out.println("Cancelaciones pendientes:");
        int i = 1;
        for (InfoReserva info : reservasCanceladas) {
            System.out.println(i + ": " + info);
            i++;
        }
    }
}