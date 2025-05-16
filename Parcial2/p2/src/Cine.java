import java.util.ArrayList;

public class Cine {
    private ArrayList<ArrayList<Sala>> salas; 
    private int numFunciones;
    private int numSalas;

    public Cine(int numFunciones, int numSalas, int filas, int columnas) {
        this.numFunciones = numFunciones;
        this.numSalas = numSalas;
        salas = new ArrayList<>(numFunciones);
        
        for (int funcion = 0; funcion < numFunciones; funcion++) {
            ArrayList<Sala> salasEnFuncion = new ArrayList<>(numSalas);
            for (int sala = 0; sala < numSalas; sala++) {
                salasEnFuncion.add(new Sala(filas, columnas));
            }
            salas.add(salasEnFuncion);
        }
    }

    public boolean reservarAsiento(int funcion, int sala, int fila, int columna) {
        if (esFuncionYSalaValida(funcion, sala)) {
            return salas.get(funcion).get(sala).reservarAsiento(fila, columna);
        }
        return false;
    }

    public boolean cancelarReservaAsiento(int funcion, int sala, int fila, int columna) {
        if (esFuncionYSalaValida(funcion, sala)) {
            return salas.get(funcion).get(sala).cancelarReservaAsiento(fila, columna);
        }
        return false;
    }
    
    public boolean estaAsientoReservado(int funcion, int sala, int fila, int columna) {
        if (esFuncionYSalaValida(funcion, sala)) {
            return salas.get(funcion).get(sala).estaAsientoReservado(fila, columna);
        }
        return false;
    }

    public boolean esFuncionYSalaValida(int funcion, int sala) {
        return funcion >= 0 && funcion < numFunciones && sala >= 0 && sala < numSalas;
    }

    public void mostrarEstadoSala(int funcion, int sala) {
        if (esFuncionYSalaValida(funcion, sala)) {
            System.out.println("Estado de la sala " + sala + " en la función " + funcion + ":");
            salas.get(funcion).get(sala).mostrarEstadoAsientos();
        } else {
            System.out.println("Función o sala no válida");
        }
    }
    
    public int getNumFunciones() {
        return numFunciones;
    }
    
    public int getNumSalas() {
        return numSalas;
    }
    
    public int getFilas(int funcion, int sala) {
        if (esFuncionYSalaValida(funcion, sala)) {
            return salas.get(funcion).get(sala).getFilas();
        }
        return 0;
    }
    
    public int getColumnas(int funcion, int sala) {
        if (esFuncionYSalaValida(funcion, sala)) {
            return salas.get(funcion).get(sala).getColumnas();
        }
        return 0;
    }
}