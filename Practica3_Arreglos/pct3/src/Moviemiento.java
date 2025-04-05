class Movimiento {
    private Operacion operacion;
    private double saldoAnteriorOrigen;
    private double saldoNuevoOrigen;
    private double saldoAnteriorDestino;
    private double saldoNuevoDestino;
    
    // Constructor para depósitos y retiros
    public Movimiento(Operacion operacion, double saldoAnteriorOrigen, double saldoNuevoOrigen) {
        this.operacion = operacion;
        this.saldoAnteriorOrigen = saldoAnteriorOrigen;
        this.saldoNuevoOrigen = saldoNuevoOrigen;
        this.saldoAnteriorDestino = 0;
        this.saldoNuevoDestino = 0;
    }
    
    // Constructor para transferencias
    public Movimiento(Operacion operacion, double saldoAnteriorOrigen, double saldoNuevoOrigen,
                      double saldoAnteriorDestino, double saldoNuevoDestino) {
        this.operacion = operacion;
        this.saldoAnteriorOrigen = saldoAnteriorOrigen;
        this.saldoNuevoOrigen = saldoNuevoOrigen;
        this.saldoAnteriorDestino = saldoAnteriorDestino;
        this.saldoNuevoDestino = saldoNuevoDestino;
    }
    
    public Operacion getOperacion() {
        return operacion;
    }
    
    public double getSaldoAnteriorOrigen() {
        return saldoAnteriorOrigen;
    }
    
    public double getSaldoNuevoOrigen() {
        return saldoNuevoOrigen;
    }
    
    public double getSaldoAnteriorDestino() {
        return saldoAnteriorDestino;
    }
    
    public double getSaldoNuevoDestino() {
        return saldoNuevoDestino;
    }
}