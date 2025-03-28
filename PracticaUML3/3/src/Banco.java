public class Banco {
    private String nombre;
    private Sucursal[] sucursales;
    private int contadorSucursales;

    public Banco(String nombre) {
        this.nombre = nombre;
        this.sucursales = new Sucursal[5];
        this.contadorSucursales = 0;
    }

    public void agregarSucursal(Sucursal sucursal) {
        if (contadorSucursales < sucursales.length) {
            sucursales[contadorSucursales] = sucursal;
            contadorSucursales++;
        } else {
            System.out.println("No se pueden agregar más sucursales.");
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}