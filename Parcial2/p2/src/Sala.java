import java.util.ArrayList;

public class Sala {
    private ArrayList<ArrayList<Asiento>> asientos;

    public Sala(int filas, int columnas) {
        asientos = new ArrayList<>(filas);
        for (int i = 0; i < filas; i++) {
            ArrayList<Asiento> fila = new ArrayList<>(columnas);
            for (int j = 0; j < columnas; j++) {
                fila.add(new Asiento());
            }
            asientos.add(fila);
        }
    }

    public void reservarAsientoSala(int fila, int columna) {
        if (fila < 0 || fila >= asientos.size() || columna < 0 || columna >= asientos.get(fila).size()) {
            System.out.println("Asiento no válido.");
            return;
        }
        Asiento asiento = asientos.get(fila).get(columna);
        asiento.reservar();
    }

    public void cancelarReservaSala(int fila, int columna) {
        if (fila < 0 || fila >= asientos.size() || columna < 0 || columna >= asientos.get(fila).size()) {
            System.out.println("Asiento no válido.");
            return;
        }
        Asiento asiento = asientos.get(fila).get(columna);
        asiento.cancelarReserva();
    }

    public void mostrarAsientosSala() {
        for (int i = 0; i < asientos.size(); i++) {
            for (int j = 0; j < asientos.get(i).size(); j++) {
                Asiento asiento = asientos.get(i).get(j);
                System.out.print(asiento.estaReservado() ? "[X] " : "[ ] ");
            }
            System.out.println();
        }
    }
}
