public class App {
    public static void main(String[] args) throws Exception {
        Empleados primerempleado = new Empleados();
        primerempleado.setNombre("Juan");
        primerempleado.SetApellido("Pérez");
        primerempleado.setCargo("Gerente");
        primerempleado.setSalario(50000);
        Empleados segundoempleado = new Empleados();
        segundoempleado.setNombre("Ana");
        segundoempleado.SetApellido("Gómez");
        segundoempleado.setCargo("Contadora");
        segundoempleado.setSalario(45000);
        System.out.println("Empleado: " + primerempleado.getNombre() + " " + primerempleado.getApellido() + ", " + primerempleado.getCargo() + ", " + primerempleado.getSalario());
        System.out.println("Empleado: " + segundoempleado.getNombre() + " " + segundoempleado.getApellido() + ", " + segundoempleado.getCargo() + ", " + segundoempleado.getSalario());
    }
}
