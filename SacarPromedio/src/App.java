import java.util.Scanner;
import java.util.InputMismatchException;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cantidad = 0;
        double suma = 0;
        String decision;

        do {
            double numero = 0;
            boolean caracterValido = false;
            while(!caracterValido) {
                try {
                    System.out.println("Ingrese un número: ");
                    numero = sc.nextDouble();
                    if (numero <= -1) {
                        System.out.println("Error: ingrese un número positivo");
                    } else {
                        caracterValido = true;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Error: debe ingresar un número");
                    sc.next();
                }
            }
            suma += numero;
            cantidad++;
            System.out.println("¿Desea ingresar otro numero? (s/n)");
            decision = sc.next();
            while(!decision.equals("s") && !decision.equals("n")) {
                System.out.println("Error: ingrese s o n");
                System.out.println("¿Desea ingresar otro número? (s/n)");
                decision = sc.next();
            }
        } while (decision.equals("s"));
        
        if (decision.equals("n")) {
            System.out.println("Promedio: " + suma / cantidad);
        }
        sc.close();
    }
}