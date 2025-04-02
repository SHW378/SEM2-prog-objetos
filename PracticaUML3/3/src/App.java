public class App {
    public static void main(String[] args) throws Exception {
        Banco banco = new Banco("BBVA");

        Sucursal sucursal1 = new Sucursal(1, "Centro");
        Sucursal sucursal2 = new Sucursal(2, "Norte");
        Sucursal sucursal3 = new Sucursal(3, "Oeste");
        Sucursal sucursal4 = new Sucursal(4, "Sur");
        Sucursal sucursal5 = new Sucursal(5, "Este");

        banco.agregarSucursal(sucursal1);
        banco.agregarSucursal(sucursal2);
        banco.agregarSucursal(sucursal3);
        banco.agregarSucursal(sucursal4);
        banco.agregarSucursal(sucursal5);

        Empleados empleado1 = new Empleados(1, "Pedro", "Seguridad");
        Empleados empleado2 = new Empleados(2, "Maria", "Cajera");
        Empleados empleado3 = new Empleados(3, "Gerardo", "Gerente");
        Empleados empleado4 = new Empleados(4, "Daniela", "Contadora");
        Empleados empleado5 = new Empleados(5, "Javier", "Ejecutivo");

        sucursal1.agregarEmpleado(empleado1);
        sucursal1.agregarEmpleado(empleado2);
        sucursal1.agregarEmpleado(empleado3);
        sucursal1.agregarEmpleado(empleado4);
        sucursal1.agregarEmpleado(empleado5);

        System.out.println("Nombre del Banco: " + banco.getNombre());
        sucursal1.mostrarEmpleados();
        sucursal2.mostrarEmpleados();
        sucursal3.mostrarEmpleados();
        sucursal4.mostrarEmpleados();
        sucursal5.mostrarEmpleados();

    }
}
