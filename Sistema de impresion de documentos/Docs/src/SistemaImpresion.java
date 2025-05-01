import java.util.Scanner;

public class SistemaImpresion {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Impresora impresora = new Impresora();
        boolean salir = false;

        while (!salir) {
            System.out.println("===== Sistema de Impresión =====");
            System.out.println("1. Agregar Documento a la cola");
            System.out.println("2. Imprimir Documento");
            System.out.println("3. Cancelar Impresión");
            System.out.println("4. Deshacer Cancelación");
            System.out.println("5. Mostrar estado");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion: ");
            
            int Opcion;
            Opcion = scanner.nextInt();
            scanner.nextLine();
            switch (Opcion) {
                case 1:
                    impresora.AgregarCola();
                    break;

                case 2:
                    impresora.ImprimirDoc();
                    break;
                case 3:
                    impresora.CancelarImpresion();
                    break;
                case 4:
                    impresora.DeshacerCancelacion();
                    break;
                case 5:
                    impresora.MostrarEstado();
                    break;
                case 6:
                    System.out.println("Saliendo del sistema...");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no valida, intente nuevamente.");
            }
        }    
        scanner.close();
    }
}