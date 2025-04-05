import java.util.Scanner;

public class SistemaBancario {
    private Administracion admin;
    private Scanner scanner;
    
    public SistemaBancario() {
        admin = new Administracion();
        scanner = new Scanner(System.in);   
    }

    public void ejecutar() {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            admin.mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    admin.abrirCuenta(scanner);
                    break;
                case 2:
                    admin.depositarDinero(scanner);
                    break;
                case 3:
                    admin.retirarDinero(scanner);
                    break;
                case 4:
                    admin.transferirDinero(scanner);
                    break;
                case 5:
                    admin.deshacerMovimiento(scanner);
                    break;
                case 6:
                    admin.mostrarEstado();
                    break;
                case 7:
                    continuar = false;
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
        scanner.close();
    }

}