public class Gerente extends Empleado {
    // REdefinicion del metodo trabajar
    @Override
    public void trabajar() {
        System.out.println("El gerente está supervisando el trabajo");
    }

    //Redefinición del método descansar
    @Override
    public void descansar() {
        System.out.println("El gerente está en la salla de descanso");
    }
}
