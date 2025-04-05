class Cuenta {
    private String numeroCuenta;
    private String titular;
    private double saldo;
    private String tipoCuenta; // "Ahorros" o "Corriente"
    
    public Cuenta(String numeroCuenta, String titular, double saldo, String tipoCuenta) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldo;
        this.tipoCuenta = tipoCuenta;
    }
    
    public String getNumeroCuenta() {
        return numeroCuenta;
    }
    
    public String getTitular() {
        return titular;
    }
    
    public double getSaldo() {
        return saldo;
    }
    
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public String getTipoCuenta() {
        return tipoCuenta;
    }
    
    @Override
    public String toString() {
        return "Cuenta #" + numeroCuenta + " - Titular: " + titular + 
               " - Tipo: " + tipoCuenta + " - Saldo: $" + saldo;
    }
}
