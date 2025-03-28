public class Autor {
    private String nombre;
    private String nacionalidad;
    
    public Autor(String Nombre, String Nacionalidad) {
        this.nombre = Nombre;
        this.nacionalidad = Nacionalidad;
    }   
    public String getNombre() {
        return nombre;
    }
    public String getNacionalidad() {
        return nacionalidad;
    }
}
