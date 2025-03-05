public class Motocicletas extends Vehiculos {
    private int cilindrada;

    public Motocicletas(String marca, String modelo, int año, int cilindrada) {
        super(marca, modelo, año);
        this.cilindrada = cilindrada;
    }
    @Override
    public void matricular(String matricula) {
        System.out.println("La matricula de la motocicleta es: "+ matricula); 
    }
    @Override
    public void Detalles() {
        super.Detalles();
        System.out.println("Cilindrada: " + cilindrada + "cc");
    }
    @Override
    public void DetallesGenerales() {
        super.Detalles();
    }
}
