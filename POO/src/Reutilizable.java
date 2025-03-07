public class Reutilizable {
    public static void main(String[] args) {
        Animal miPerro = new Perro();
        Animal miGato = new Gato();

        emitirSonido(miPerro);
        emitirSonido(miGato);
    }
    public static void emitirSonido(Animal animal) {
        animal.hacerSonido();
    }
}