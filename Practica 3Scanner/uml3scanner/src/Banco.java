public class Banco {
    private String nombre;
    private Sucursal[] sucursales;
    private int contadorSucursales;

    public Banco(String nombre) {
        this.nombre = nombre;
        this.sucursales = new Sucursal[5];
        this.contadorSucursales = 0;
    }

    public boolean agregarSucursal(Sucursal sucursal) {
        if (contadorSucursales < sucursales.length) {
            sucursales[contadorSucursales] = sucursal;
            contadorSucursales++;
            return true;
        } else {
            System.out.println("No se puede agregar más sucursales. Límite alcanzado en el banco " + nombre);
            return false;
        }
    }

    public void mostrarSucursales() {
        System.out.println("Sucursales del banco " + nombre + ":");
        if (contadorSucursales == 0) {
            System.out.println("No hay sucursales en el banco.");
            return;
        } else {
            for (int i = 0; i < contadorSucursales; i++) {
                System.out.println("- " + sucursales[i].getNombre());
            }
        }
    }

    public Sucursal buscarSucursal(int id) {
        for (int i = 0; i < contadorSucursales; i++) {
            if (sucursales[i].getId() == id) {
                return sucursales[i];
            }
        }
        return null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}