public class Ingeniero extends Empleado {
   // Redefinicion del método trabajar
    @Override
    public void trabajar() {
        System.out.println("El ingeniero está desarrollando software");
    }
    // Refefinición del método descansar
    @Override
    public void descansar() {
        System.out.println("El iongeniero está tomando un café");
    }
}
