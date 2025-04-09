import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        brad primerbrad = new brad();
        System.out.println("Nombre: ");
        primerbrad.setNombre(sc.nextLine());
        System.out.println("Gusto:");
        primerbrad.setGusto(sc.nextLine());
        System.out.println("Medida:");
        primerbrad.setMedida(sc.nextInt());
        System.out.println("A " + primerbrad.getNombre() + " le gusta " + primerbrad.getGusto() + " y que midan " + primerbrad.getMedida() + " cm");
        sc.close();
    }
}

