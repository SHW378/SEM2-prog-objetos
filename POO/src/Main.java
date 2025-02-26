public class Main {
    public static void main(String[] args) {
     Perro perro = new Perro();
     Gato gato = new Gato();
     //Establece el atributo 'nombre' al perro
    perro.setNombre("Firulais");    
    gato.setNombre("Garfield");

     //Imprime el nombre del perro
    System.out.println(perro.getNombre());
    System.out.println(gato.getNombre());

    perro.hacerSonido();
    gato.hacerSonido();
    }
}
