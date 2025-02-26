import java.util.Scanner;
public class Main {
    Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
     Perro perro = new Perro();
     
     //Establece el atributo 'nombre' al perro
    perro.setNombre(null);    

     //Imprime el nombre del perro
    System.out.println(perro.getNombre());
    }
}
