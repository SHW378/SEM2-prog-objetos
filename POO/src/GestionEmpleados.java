public class GestionEmpleados {
    public static void main(String[] args) {
        Empleado empleado = new Empleado();
        Gerente gerente = new Gerente();
        Ingeniero ingeniero = new Ingeniero();
        // Llama al método trabajar() de empleado
        empleado.trabajar();
        // Llama al método trabajar() de gerente
        gerente.trabajar();
        // Llama al método trabajar() de ingeniero
        ingeniero.trabajar();
        // Llama al método descansar() de empleado
        empleado.descansar();
        // Llama al método descansar() de gerente
        gerente.descansar();
        // Llama al método descansar() de Ingeniero
        ingeniero.descansar();
    }
}
