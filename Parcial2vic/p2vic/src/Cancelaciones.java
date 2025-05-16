import java.util.Stack;

public class Cancelaciones {
    private Stack<Reserva> cancelaciones; //atributo de pila

    // Constructor
    public Cancelaciones() {
        cancelaciones = new Stack<>();
    }

    // Métodos
    public void agregarCancelacion(Reserva cancelacion) {
        cancelaciones.push(cancelacion);
    }

    public Reserva deshacerCancelacion() {
        if (!cancelaciones.isEmpty()) {
            return cancelaciones.pop();
        }
        return null;
    }

    public boolean hayCancelaciones() {
        return !cancelaciones.isEmpty();
    }
}