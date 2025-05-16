public class Asiento {
    private boolean reservado; // atributo

    public Asiento() { // constructor
        this.reservado = false;
    }

    // Saber si está reservado
    public boolean reservado() {
        return reservado;
    }

    // Reservar asiento
    public boolean reservar() {
        if (!reservado) {
            reservado = true;
            return true;
        } else {
            return false;
        }
    }

    // Cancelar reserva
    public boolean cancelar() {
        if (reservado) {
            reservado = false;
            return true;
        } else {
            return false;
        }
    }
}