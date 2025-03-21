import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de números: ");
        int cantidad = sc.nextInt();
        double suma = 0;
        String decision;

        do {
            System.out.print("Ingrese un número: ");
            double numero = sc.nextDouble();
            suma += numero;
            System.out.println("desea ingresar otro numero? (s/n)");
            decision = sc.next();
        } while (decision.equals("s"));
        
        if (decision.equals("n")) {
            System.out.println("Promedio: " + suma / cantidad);
        }
        sc.close();
    }
}