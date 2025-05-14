public class Asiento {
    private boolean reservado;

    public Asiento() {
        this.reservado = false;
    }

    public void reservar() {
        if (!reservado) {
            reservado = true;
            System.out.println("El asiento ha sido reservado.");
        } else {
            System.out.println("El asiento ya está reservado.");
        }
    }

    public void cancelarReserva() {
        if (reservado) {
            reservado = false;
            System.out.println("La reserva del asiento ha sido cancelada.");
        } else {
            System.out.println("El asiento no está reservado.");
        }
    }

    public boolean estaReservado() {
        return reservado;
    }
}
