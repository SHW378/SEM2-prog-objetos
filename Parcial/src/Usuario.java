public abstract class Usuario implements Administrable {
    private String nombre;
    private String apellido;
    private String carrera;
    private String estado;

    public Usuario(String nombre, String apellido, String carrera) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.carrera = carrera;
        this.estado = "activo";
    }

    public String GetNombre() {
        return nombre;
    }
    public void SetNombre(String nombre) {
        this.nombre = nombre;
    }
    public String GetApellido() {
        return apellido;
    }
    public void SetApellido(String apellido) {
        this.apellido = apellido;
    }
    public String GetCarrera() {
        return carrera;
    }
    public void SetCarrera(String carrera) {
        this.carrera = carrera;
    }
    public String GetEstado() {
        return estado;
    }
    public void SetEstado(String estado) {
        this.estado = estado;
    }
    public void imprimir() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Carrera: " + carrera);
        System.out.println("Estado: " + estado);
    }
    @Override
    public void desactivar() {
        if (estado == "activo") {
            estado = "inactivo";
            System.out.println("Se ha desactivado al usuario.");
        } else {
            System.out.println("El usuario ya había sido desactivado.");
        }
    }
}

