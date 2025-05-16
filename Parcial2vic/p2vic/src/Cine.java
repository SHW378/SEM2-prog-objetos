import java.util.ArrayList;

public class Cine {
    private ArrayList<Sala> funciones;
    private int horario;
   
    public Cine(int salas, int filas, int columnas, int horario) {
        this.horario = horario;
        funciones = new ArrayList<Sala>();
        for (int i = 0; i < salas; i++) {
            funciones.add(new Sala(filas, columnas));
        }
    }
    public int getHorario() {
    return horario;
    }
    public boolean reservarAsiento(int sala, int fila, int columna) {
        if (sala >= 0 && sala < funciones.size()) {
            return funciones.get(sala).reservarAsiento(fila, columna);
        }
        return false;
    }

    public boolean cancelarAsiento(int sala, int fila, int columna) {
        if (sala >= 0 && sala < funciones.size()) {
            return funciones.get(sala).cancelarAsiento(fila, columna);
        }
        return false;
    }

    public void mostrarSala(int sala) {
        if (sala >= 0 && sala < funciones.size()) {
            funciones.get(sala).mostrarAsientos();
        }
    }
}