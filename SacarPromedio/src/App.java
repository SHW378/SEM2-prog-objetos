import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de números: ");
        int cantidad = sc.nextInt();
        double suma = 0;

        for (int i = 0; i < cantidad; i++) {
            System.out.print("Ingrese un número: ");
            double numero = sc.nextDouble();
            suma += numero;
        }

        if (cantidad > 0) {
            double promedio = suma / cantidad;
            System.out.println("El promedio de los números ingresados es: " + promedio);
        } else {
            System.out.println("No se ingresaron números.");
        }

        sc.close();
    }
}