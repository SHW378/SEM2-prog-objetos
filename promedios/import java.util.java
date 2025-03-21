import java.util.Scanner;
public class PromedioNumeros {
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int suma = 0;
    int contador = 0;
    String continuar;

    for (;;) {
        System.out.print("Ingrese un número: ");
        double numero = sc.nextDouble();
        suma += numero;
        contador++;
        System.out.print("¿Desea ingresar otro número? (s/n): ");
        continuar = sc.next();
        if (continuar.equalsIgnoreCase("s")) {
            System.out.println("El promedio de los números ingresados es: " + suma / contador);
        } else {
            System.out.println("No se ingresaron números.");
            break;
        }
    }

    sc.close();
}
}