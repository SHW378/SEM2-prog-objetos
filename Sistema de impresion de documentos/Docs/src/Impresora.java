import java.util.InputMismatchException;
import java.util.Scanner;

public class Impresora{

    
    Scanner scanner = new Scanner(System.in);
    Pendiente pendientes = new Pendiente();
    Cancelado cancelados = new Cancelado(); 
    Historial historial = new Historial(pendientes, cancelados);   
    


    // 1. agregar documento a la cola de impresión
public void AgregarCola() {
    System.out.println("--- Agregar Nuevo Documento ---");
    System.out.println("Título: ");
    String titulo = scanner.nextLine();

    int numerodepaginas = 0;
    boolean validInput = false;

    // Validar entrada para número de páginas
    while (!validInput) {
        System.out.println("Número de páginas: ");
        try {
            numerodepaginas = scanner.nextInt();
            scanner.nextLine(); 
            if (numerodepaginas <= 0) {
                throw new Exception("Número de páginas no válido. Debe ser mayor a 0.");
            }
            validInput = true; 
        } catch (InputMismatchException e) {
            System.out.println("Opción invalida. Ingrese un valor entero.");
            scanner.nextLine(); 
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    System.out.println("Tipo de documento:  \n  1. Escala de grises \n  2. Color");
    System.out.print("Opción: ");
    int Opcion = scanner.nextInt();
    String tipo = null;
    scanner.nextLine();
    try {
        if (Opcion != 1 && Opcion != 2) {
            throw new Exception("Opción no válida");
        }
        if (Opcion == 1) {
            tipo = "Escala de grises";
        } else if (Opcion == 2) {
            tipo = "Color";
        }
    } catch (Exception e) {
        System.out.println(e.getMessage());
        return;
    }

    Documento doc = new Documento(titulo, numerodepaginas, tipo);
    pendientes.AgregarPendientes(doc);

    System.out.println("Documento agregado a la cola: " + titulo);
}  
    
    // 2. Imprimir documento
    public void ImprimirDoc(){
        if (pendientes.pendientes.isEmpty()) {
            System.out.println("No hay documentos en la cola de impresión.");
            return;
        }
        Documento doc = pendientes.pendientes.poll();
        System.out.println("Imprimiendo: " + doc.getTitulo());
        historial.AgregarHistorial(doc);
    }

    // 3. Cancelar impresión
    public void CancelarImpresion() {
        if (historial.Historial.isEmpty()) {
            System.out.println("No hay documentos impresos para cancelar.");
            return;
        }
        
        Documento doc = historial.Historial.remove(historial.Historial.size() - 1);
        System.out.println("Impresión cancelada: " + doc.getTitulo());
        cancelados.AgregarCancelados(doc);
    }

    // 4. Deshacer cancelación
    public void DeshacerCancelacion() {
        Documento doc = cancelados.RestaurarUltimo();
        if (doc == null) {
            System.out.println("No hay documentos cancelados para restaurar.");
            return;
        }
        System.out.println("Cancelación deshecha: " + doc.getTitulo());
        pendientes.AgregarPendientes(doc);    
    }
    // 5. Mostrar estado de la impresora
    public void MostrarEstado() {
        historial.MostrarHistorial();
    }
}
