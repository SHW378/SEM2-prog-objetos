public abstract class Figura {
    private String color; 

    public Figura(String color) {
        this.color = color;
    }

    public abstract double area();
    public abstract double perimetro();

    public void mostrarColor() {
        System.out.println("Color: " + color);
    }
}
