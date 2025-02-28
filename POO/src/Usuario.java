public class Usuario {
    //Atributos
    private String correo;
    private String contraseña;
    //constructor 
    public Usuario(String correo, String contraseña) {
        this.correo = correo;
        this.contraseña = contraseña;
    }
    //Metodo para mostrar detalles
    public void mostrarDetalles() {
        System.out.println("correo: "+ correo + ", contraseña: "+ contraseña);
    }
}