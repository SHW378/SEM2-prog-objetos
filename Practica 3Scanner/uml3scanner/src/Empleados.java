public class Empleados {
    private int id;
    private String nombre;
    private String puesto;

    public Empleados(int id, String nombre, String puesto) {
        this.id = id;
        this.nombre = nombre;
        this.puesto = puesto;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRol() {
        return puesto;
    }

    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", nombre=" + nombre + ", rol=" + puesto + '}';
    }
}