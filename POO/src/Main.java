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

    //Usar los métodos heredados
    perro.hacerSonido();
    gato.hacerSonido();

    // Crear el objetos de AccionesAnimal
    AccionesAnimal accion = new AccionesAnimal();

    //Iteración entre clases
    accion.dormir(perro.getNombre());
    accion.dormir(gato.getNombre());

    Pajaro pajaro = new Pajaro();
    Avion avion = new Avion();

    //Polimorfismo del método volar
    pajaro.volar();
    avion.volar();
    
    }
}