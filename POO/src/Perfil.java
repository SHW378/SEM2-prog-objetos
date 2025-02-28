public class Perfil extends Usuario {
    //Atributos
    private String nombre;
    private String apellido;
    //constructor
    public Perfil(
        String correo, String contraseña,
        String nombre, String apellido
    ) {
        //Llamando al constructor de la superclase
        super(correo, contraseña);
        this.nombre = nombre;
        this.apellido = apellido;
    }
    @Override
    public void mostrarDetalles() {
        super.mostrarDetalles();
        System.out.println("Nombre: "+ nombre + ", Apellido: "+ apellido);
    }
}