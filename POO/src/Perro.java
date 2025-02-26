public class Perro extends Animal {
    private String nombre;
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vació");
        }
        this.nombre = nombre;
    }
    @Override
    public void hacerSonido() {
        System.out.println("El perro ladra");
    }
}
