import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cantidad = 0;
        double suma = 0;
        String decision;

        do {
            System.out.print("Ingrese un número: ");
            double numero  = sc.nextDouble();
            suma += numero;
            cantidad++;
            System.out.println("desea ingresar otro numero? (s/n)");
            decision = sc.next();
        } while (decision.equals("s"));
        
        if (decision.equals("n")) {
            System.out.println("Promedio: " + suma / cantidad);
        }
        sc.close();
    }
}