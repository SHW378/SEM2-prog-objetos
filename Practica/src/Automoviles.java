public class Automoviles extends Vehiculos {
    private int numeroPuertas;
    public Automoviles(String marca, String modelo, int año, int numeroPuertas) {
        super(marca, modelo, año);
        this.numeroPuertas = numeroPuertas;
    }

    @Override
    public void Detalles() {
        super.Detalles();
        System.out.println("Cuenta con  " + numeroPuertas + " puertas");
    }
    @Override
    public void matricular(String matricula) {
        System.out.println("La matricula del automovil es: "+ matricula);
    }
    public void DetallesGenerales() {
        super.Detalles();
    }
}
