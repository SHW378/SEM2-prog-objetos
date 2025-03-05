public class Transporte {
    public static void main(String[] args) {
        Automoviles auto1 = new Automoviles("Toyota", "Corolla", 200, 2);
        Automoviles auto2 = new Automoviles("Seat", "Toledo", 2016, 4);
        Motocicletas moto1 = new Motocicletas("Honda", "CBR", 2004, 650 ); 
        Motocicletas moto2 = new Motocicletas("Yamaha", "MT-15", 2024, 100);

        System.out.println("Detalles del automóvil: ");
        auto1.Detalles();
        auto1.matricular("AUT-ABC-123");

        System.out.println("\nDetalles del vehículo: ");
        auto2.DetallesGenerales();
        auto2.matricular("AUT-DEF-456");

        System.out.println("\nDetalles de la motocicleta: ");
        moto1.Detalles();
        moto1.matricular("MOT-ZY-09");

        System.out.println("\nDetalles del vehiculo: ");
        moto2.DetallesGenerales();
        moto2.matricular("MOT-XW-87");
    }
}
