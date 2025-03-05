public abstract class Vehiculos implements Inscribible {
    private String marca;
    private String modelo;
    private int año;

    public Vehiculos(String marca, String modelo, int año) {
        this.marca = marca; 
        this.modelo = modelo;
        this.año = año;
    }
    public void Detalles() {
        System.out.println("Este vehículo es de marca la " + marca + ", modelo " + modelo + " y año " + año);
        if (2025 - año > 20) {
            System.out.println("Es considerado como antiguo");
        } else {
            System.out.println("Es considerado como moderno.");
        }
    }
    public void DetallesGenerales() {
        Detalles();
    }
}