class Operacion {
    private String tipo; // "Depósito", "Retiro", "Transferencia"
    private double monto;
    private String cuentaOrigen;
    private String cuentaDestino; // Solo para transferencias
    private String fecha;
    
    public Operacion(String tipo, double monto, String cuentaOrigen, String cuentaDestino) {
        this.tipo = tipo;
        this.monto = monto;
        this.cuentaOrigen = cuentaOrigen;
        this.cuentaDestino = cuentaDestino;
        this.fecha = obtenerFechaActual();
    }
    
    private String obtenerFechaActual() {
        // Método simple para obtener fecha actual sin usar la clase Date
        return "Fecha actual"; // En una implementación real, se usaría alguna lógica para la fecha
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public double getMonto() {
        return monto;
    }
    
    public String getCuentaOrigen() {
        return cuentaOrigen;
    }
    
    public String getCuentaDestino() {
        return cuentaDestino;
    }
    
    public String getFecha() {
        return fecha;
    }
    
    @Override
    public String toString() {
        if (tipo.equals("Transferencia")) {
            return tipo + " - Monto: $" + monto + " - De: " + cuentaOrigen + 
                   " - A: " + cuentaDestino + " - " + fecha;
        } else {
            return tipo + " - Monto: $" + monto + " - Cuenta: " + cuentaOrigen + 
                   " - " + fecha;
        }
    }
}