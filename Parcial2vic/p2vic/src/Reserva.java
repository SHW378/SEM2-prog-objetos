import java.util.Scanner;

public class Reserva {
    private int sala;
    private int fila;
    private int columna;
    private int horario;

    public Reserva(int sala, int fila, int columna, int horario) {
        this.sala = sala;
        this.fila = fila;
        this.columna = columna;
        this.horario = horario;
    }

    public int getSala() {
        return sala;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public int getHorario() {
        return horario;
    }

    @Override
    public String toString() {
        return "Sala: " + sala + ", Fila: " + fila + ", Columna: " + columna + ", Horario: " + horario;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cine cine = new Cine(2, 3, 3, 24);
        ReservaEspera reservaEspera = new ReservaEspera(); 
        Cancelaciones cancelaciones = new Cancelaciones(); 

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Reservar asiento");
            System.out.println("2. Cancelar reserva");
            System.out.println("3. Ver sala");
            System.out.println("4. Ver reservas en espera");
            System.out.println("5. Procesar reservas en espera");
            System.out.println("6. Deshacer última cancelación");
            System.out.println("7. Salir");
            System.out.print("Elige una opción: ");
            int opcion = sc.nextInt();

            if (opcion == 1) {
                System.out.print("Sala: ");
                int sala = sc.nextInt();
                System.out.print("Fila: ");
                int fila = sc.nextInt();
                System.out.print("Columna: ");
                int columna = sc.nextInt();
                System.out.println("Horario: ");
                int horario = sc.nextInt();
                if (cine.reservarAsiento(sala, fila, columna)) {
                    System.out.println("Reservaste correctamente el asiento.");
                } else {
                    System.out.println("El asiento esta ocupado. Se agrego a la lista de espera.");
                    reservaEspera.agregarReserva(new Reserva(sala, fila, columna, horario));
                }
            } else if (opcion == 2) {
                System.out.print("Sala: ");
                int sala = sc.nextInt();
                System.out.print("Fila: ");
                int fila = sc.nextInt();
                System.out.print("Columna: ");
                int columna = sc.nextInt();
                System.out.println("Horario: ");
                int horario = sc.nextInt();
                
                if (cine.cancelarAsiento(sala, fila, columna)) {
                    cancelaciones.agregarCancelacion(new Reserva(sala, fila, columna, horario));
                    System.out.println("Cancelaste correctamente el asiento.");
                } else {
                    System.out.println("No se pudo cancelar, el asiento no estaba reservdo).");
                }
            } else if (opcion == 3) {
                System.out.print("Sala: ");
                int sala = sc.nextInt();
                cine.mostrarSala(sala);
            } else if (opcion == 4) {
                if (reservaEspera.hayReservas()) {
                    System.out.println("Reservas en espera:");
                    while (reservaEspera.hayReservas()) {
                        System.out.println(reservaEspera.procesarReserva());
                    }
                } else {
                    System.out.println("No hay reservas en espera.");
                }
            } else if (opcion == 5) {
                if (reservaEspera.hayReservas()) {
                    Reserva reserva = reservaEspera.procesarReserva();
                    System.out.println("Procesando reserva: " + reserva);
                    if (cine.reservarAsiento(reserva.getSala(), reserva.getFila(), reserva.getColumna())) {
                        System.out.println("Reserva procesada correctamente.");
                    } else {
                        System.out.println("El asiento sigue ocupado volviendo a la lista de espera.");
                        reservaEspera.agregarReserva(reserva);
                    }
                } else {
                    System.out.println("No hay reservas en espera.");
                }
            } else if (opcion == 6) {
                if (cancelaciones.hayCancelaciones()) {
                    Reserva ultima = cancelaciones.deshacerCancelacion();
                    cine.reservarAsiento(ultima.getSala(), ultima.getFila(), ultima.getColumna());
                    System.out.println("Se deshizo la última cancelación");
                } else {
                    System.out.println("No hay cancelaciones para deshacer.");
                }
            } else if (opcion == 7) {
                System.out.println("Saliste");
                break;
            } else {
                System.out.println("Opción no valida.");
            }
        }
        sc.close();
    }
}