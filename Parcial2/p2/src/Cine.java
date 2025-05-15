import java.util.ArrayList;

public class Cine {
    private ArrayList<ArrayList<Sala>> funcionesSalas;
    private int numFunciones;
    private int numSalasPorFuncion;

    public Cine(int numFunciones, int numSalasFuncion, int filas, int columnas) {
        this.numFunciones = numFunciones;
        this.numSalasPorFuncion = numSalasFuncion;
        this.funcionesSalas = new ArrayList<>();

        for (int i = 0; i < numFunciones; i++) {
            ArrayList<Sala> salas = new ArrayList<>();
            for (int j = 0; j < numSalasFuncion; j++) {
                salas.add(new Sala(filas, columnas)); 
            }
            funcionesSalas.add(salas);
        }
    }

    public boolean reservarAsiento(int funcion, int sala, int fila, int columna) {
        if (validarIndices(funcion, sala)) {
            return funcionesSalas.get(funcion).get(sala).cancelarReserva(fila, columna);
        }
        return false;
    }

    public boolean estaReservado(int funcion, int sala, int fila, int columna) {
        if (validarIndices(funcion, sala)) {
            return funcionesSalas.get(funcion).get(sala).estaReservado(fila, columna);
        }
        return false;
    }

    public boolean validarIndices(int funcion, int sala) {
        return funcion >= 0 && funcion < numFunciones && sala >= 0 && sala < numSalasPorFuncion;
    }

    public void mostrarEstadosala(int funcion, int sala) {
        if (validarIndices(funcion, sala)) {
            System.out.println("Estado de la función" + funcion + ", Sala" + sala + ":");
            funcionesSalas.get(funcion).get(sala).mostrarEstado();
        } else {
            System.out.println("Función o sala no valida");
        }
    }

    public int getNumFunciones() {
        return numFunciones;
    }

    public int getNumSalasPorFuncion() {
        return numSalasPorFuncion;
    }

    public int getFilasSala(int funcion, int sala) {
        if (validarIndices(funcion, sala)) {
            return funcionesSalas.get(funcion).get(sala).getColumnas();
        }
        return 0;
    }
} 