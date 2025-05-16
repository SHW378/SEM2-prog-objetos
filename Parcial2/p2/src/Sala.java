import java.util.ArrayList;

public class Sala {
    private ArrayList<ArrayList<Asiento>> asientos;
    private int filas;
    private int columnas;

    public Sala(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.asientos = new ArrayList<>(filas);
        
        for (int i = 0; i < filas; i++) {
            ArrayList<Asiento> fila = new ArrayList<>(columnas);
            for (int j = 0; j < columnas; j++) {
                fila.add(new Asiento());
            }
            asientos.add(fila);
        }
    }

    public boolean reservarAsiento(int fila, int columna) {
        if (esAsientoValido(fila, columna)) {
            return asientos.get(fila).get(columna).reservar();
        }
        return false;
    }

    public boolean cancelarReservaAsiento(int fila, int columna) {
        if (esAsientoValido(fila, columna)) {
            return asientos.get(fila).get(columna).cancelarReserva();
        }
        return false;
    }

    public boolean estaAsientoReservado(int fila, int columna) {
        if (esAsientoValido(fila, columna)) {
            return asientos.get(fila).get(columna).estaReservado();
        }
        return false;
    }

    private boolean esAsientoValido(int fila, int columna) {
        return fila >= 0 && fila < filas && columna >= 0 && columna < columnas;
    }

    public void mostrarEstadoAsientos() {
        System.out.println("Estado de los asientos en la sala:");
        
        System.out.print("   ");
        for (int j = 0; j < columnas; j++) {
            System.out.printf("%2d  ", j);
        }
        System.out.println();
        
        for (int i = 0; i < filas; i++) {
            System.out.printf("%2d ", i);
            for (int j = 0; j < columnas; j++) {
                System.out.print(asientos.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
    
    public int getFilas() {
        return filas;
    }
    
    public int getColumnas() {
        return columnas;
    }
}