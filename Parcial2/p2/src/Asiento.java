public class Asiento {
    private boolean reservado;
    
    public Asiento() {
        this.reservado = false; // Inicialmente el asiento está disponible
    }
    
    public boolean isReservado() {
        return reservado;
    }
    
    public boolean reservar() {
        if (!reservado) {
            reservado = true;
            return true;
        }
        return false;
    }
    
    public boolean cancelarReserva() {
        if (reservado) {
            reservado = false;
            return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        return reservado ? "[X]" : "[ ]"; // X para reservado, espacio para disponible
    }
}