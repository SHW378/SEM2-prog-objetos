public class InfoReserva {
    private int funcion;
    private int sala;
    private int fila;
    private int columna;
    
    public InfoReserva(int funcion, int sala, int fila, int columna) {
        this.funcion = funcion;
        this.sala = sala;
        this.fila = fila;
        this.columna = columna;
    }
    
    public int getFuncion() {
        return funcion;
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
    
    @Override
    public String toString() {
        return "Función: " + funcion + ", Sala: " + sala + 
               ", Fila: " + fila + ", Columna: " + columna;
    }
}