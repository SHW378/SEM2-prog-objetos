public class Estudiante {
    private String nombre;
    private String apellido;
    private int edad;
    private String carrera;

    public Estudiante (String nombre, String apellido, int edad, String carrera){
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.carrera = carrera;
     }
    public Estudiante (String nombre, String apellido, int edad){
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getCarrera() {
        return carrera;
    }
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    public void imprimirInscripcion() {
        System.out.println("Se ha inscrito: " + this.nombre + " " + this.apellido + ", " + this.edad + " años, para la carrera de " + this.carrera);
    }
    public void imprimirInscripcionSinCarrera(boolean esDecidido) {
        System.out.println("Se ha inscrito: " + this.nombre + " " + this.apellido + ", " + this.edad + " años, aún no ha decidido su carrera");
    }
}
