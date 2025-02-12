public class Coche {
    private String color;
    private String marca;

    public void acelerar() {
        System.out.println("El coche marca " +
        this.marca + " está acelerando. "); //ths es una variable que apunta a la clase
    }

    public void frenar() {
        System.out.println("El coche está frenando.");
    }
    
    // Devuelve el valor ed la proedad color al valor proporcionado.
    public String getColor () {
        return color;
    }

    //Establece el valor de la propiedad color al valor proporcionado.
    public void setColor(String color) {
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}