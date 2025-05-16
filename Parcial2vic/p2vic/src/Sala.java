import java.util.ArrayList;

public class Sala {
    // Atributos
    private ArrayList<ArrayList<Asiento>> asientos;
    private int filas;
    private int columnas;

    // Constructor
    public Sala(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        asientos = new ArrayList<>();
        for (int i = 0; i < filas; i++) {
            ArrayList<Asiento> fila = new ArrayList<>();
            for (int j = 0; j < columnas; j++) {
                fila.add(new Asiento());
            }
            asientos.add(fila);
        }
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public boolean reservarAsiento(int fila, int columna) {
        if (asientos.get(fila).get(columna).reservado()) {
            return false;
        } else {
            asientos.get(fila).get(columna).reservar();
            return true;
        }
    }

    public boolean cancelarAsiento(int fila, int columna) {
        if (asientos.get(fila).get(columna).reservado()) {
            asientos.get(fila).get(columna).cancelar();
            return true;
        } else {
            return false;
        }
    }

    public void mostrarAsientos() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(asientos.get(i).get(j).reservado() ? "[X]" : "[ ]");
            }
            System.out.println();
        }
    }

    public ArrayList<ArrayList<Asiento>> getAsientos() {
        return asientos;
    }
}