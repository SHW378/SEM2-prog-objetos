public class Pato implements Volador, Nadador {
    @Override
    public void volar() {
        System.out.println("El pato vuela");
    }
    @Override
    public void nadar() {
        System.out.println("El pato nada");
    }
}
