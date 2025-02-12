public class App {
    public static void main(String[] args) throws Exception {
        Coche primercoche = new Coche();
        primercoche.setMarca("Ferrari");
        primercoche.setColor("rojo");
        primercoche.acelerar();
        primercoche.frenar();
        Coche segundocoche = new Coche();
        segundocoche.setColor("azul");
        segundocoche.setMarca("Toyota");
        segundocoche.acelerar();
        System.out.println("El coche de marca " + primercoche.getMarca()
        + " es de color " + primercoche.getColor());
        System.out.println("El coche de marca " + segundocoche.getMarca()
        + " es de color " + segundocoche.getColor());
    }
}