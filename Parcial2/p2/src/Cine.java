import java.util.ArrayList;

public class Cine {
    private ArrayList<ArrayList<Sala>> funciones;
    
    public Cine(int numFunciones, int numSalas, int filas, int columnas) {
        funciones = new ArrayList<>(numFunciones);
        for (int i = 0; i < numFunciones; i++) {
            ArrayList<Sala> salas = new ArrayList<>(numSalas);
            for (int j = 0; j < numSalas; j++) {
                salas.add(new Sala(filas, columnas));
            }
            funciones.add(salas);
        }
    }

    public void reservarAsientoCine(int funcion, int sala, int fila, int columna) {
        if (funcion < 0 || funcion >= funciones.size() || sala < 0 || sala >= funciones.get(funcion).size()) {
            System.out.println("Función o sala no válida.");
            return;
        }
        Sala salaSeleccionada = funciones.get(funcion).get(sala);
        salaSeleccionada.reservarAsientoSala(fila, columna);
    }

    public void cancelarReservaCine(int funcion, int sala, int fila, int columna) {
        if (funcion < 0 || funcion >= funciones.size() || sala < 0 || sala >= funciones.get(funcion).size()) {
            System.out.println("Función o sala no válida.");
            return;
        }
        Sala salaSeleccionada = funciones.get(funcion).get(sala);
        salaSeleccionada.cancelarReservaSala(fila, columna);
    }

    public void mostrarAsientosCine(int funcion, int sala) {
        if (funcion < 0 || funcion >= funciones.size() || sala < 0 || sala >= funciones.get(funcion).size()) {
            System.out.println("Función o sala no válida.");
            return;
        }
        System.out.println("Estado de los asientos:");
        System.out.println("Función " + funcion + ", Sala " + sala);
        Sala salaSeleccionada = funciones.get(funcion).get(sala);
        salaSeleccionada.mostrarAsientosSala();

    }
}
