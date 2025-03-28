public class Sucursal {
    private int id;
    private String nombre;
    private Empleados[] empleados;
    private int contadorEmpleados;

    public Sucursal(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.empleados = new Empleados[5];
        this.contadorEmpleados = 0;
    }

    public void agregarEmpleado(Empleados empleado) {
        if (contadorEmpleados < empleados.length) {
            empleados[contadorEmpleados] = empleado;
            contadorEmpleados++;
        } else {
            System.out.println("No se pueden agregar más empleados.");
        }
    }

    public void mostrarEmpleados() {
        System.out.println("- " + nombre + " (ID: " + this.getId() + ")");
        if (contadorEmpleados == 0) {
            System.out.println("   No hay empleados en la sucursal.");
        } else {
            System.out.println("   Empleados de la sucursal " + nombre + ":");
            for (int i = 0; i < contadorEmpleados; i++) {
                System.out.println("   - " +  "ID: " + empleados[i].getId() + ", Nombre: " + empleados[i].getNombre() + ", Rol: " + empleados[i].getRol());
            }
        }
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
