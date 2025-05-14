public class Asiento {
    private boolean reservado;

    public Asiento() {
        this.reservado = false;
    }

    public boolean reservar() {
        if (!reservado) {
            reservado = true;
            return true;
        } else {
            return false;
        }
    }

    public boolean cancelarReserva() {
        if (reservado) {
            reservado = false;
            return true;
        } else {
            return false;
        }
    }

    public boolean estaReservado() {
        return reservado;
    }

    @Override
    public String toString() {
        return reservado ? "[X]" : "[ ]";
    }
}
