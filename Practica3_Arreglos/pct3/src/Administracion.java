import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;


public class Administracion{
    
    private ArrayList<Cuenta> cuentas;
    private ArrayList<Operacion> historialOperaciones;
    private Stack<Movimiento> pilaMovimientos;
    
    public Administracion() {
        cuentas = new ArrayList<>();
        historialOperaciones = new ArrayList<>();
        pilaMovimientos = new Stack<>();
    }

    public void mostrarMenu() {
        System.out.println("\n===== SISTEMA BANCARIO =====");
        System.out.println("1. Abrir nueva cuenta");
        System.out.println("2. Depositar dinero");
        System.out.println("3. Retirar dinero");
        System.out.println("4. Transferir dinero");
        System.out.println("5. Deshacer última operación");
        System.out.println("6. Mostrar estado");
        System.out.println("7. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public void abrirCuenta(Scanner scanner) {
        System.out.println("\n=== ABRIR NUEVA CUENTA ===");
        System.out.print("Ingrese el número de cuenta: ");
        String numeroCuenta = scanner.nextLine();

        if (buscarCuenta(numeroCuenta) != null) {
            System.out.println("Error: Ya existe una cuenta con ese número.");
            return;
        }

        System.out.print("Ingrese el nombre del titular: ");
        String titular = scanner.nextLine();

        System.out.print("Ingrese el saldo inicial: ");
        double saldoInicial = scanner.nextDouble();
        
        System.out.println("Seleccione el tipo de cuenta: ");
        System.out.println("1. Ahorros");
        System.out.println("2. Corriente");
        int tipoCuenta = scanner.nextInt();
        scanner.nextLine();


        String tipoCuentaStr;
        if (tipoCuenta == 2) {
            tipoCuentaStr = "Corriente";
        } else if (tipoCuenta == 1) {
            tipoCuentaStr = "Ahorros";
        } else {
            System.out.println("Error: Tipo de cuenta no válido. Se asignará 'Ahorros' por defecto.");
            tipoCuentaStr = "Ahorros";
        }

        Cuenta nuevaCuenta = new Cuenta(numeroCuenta, titular, saldoInicial, tipoCuentaStr);
        cuentas.add(nuevaCuenta);

        System.out.println("Cuenta creada exitosamente.");
        System.out.println("Número de cuenta: " + nuevaCuenta.getNumeroCuenta() + ", Titular: " + nuevaCuenta.getTitular() + ", Saldo inicial: " + nuevaCuenta.getSaldo() + ", Tipo de cuenta: " + nuevaCuenta.getTipoCuenta());
    }

    public void depositarDinero(Scanner scanner) {
        System.out.println("\n=== DEPOSITAR DINERO ===");
        System.out.print("Ingrese el número de cuenta: ");
        String numeroCuenta = scanner.nextLine();
        System.out.println("Numero de cuenta: " + numeroCuenta + ", Titular: " + buscarCuenta(numeroCuenta).getTitular() + ", Saldo: " + buscarCuenta(numeroCuenta).getSaldo() + ", Tipo de cuenta: " + buscarCuenta(numeroCuenta).getTipoCuenta());  

        Cuenta cuenta = buscarCuenta(numeroCuenta);
        if (cuenta == null) {
            System.out.println("Error: La cuenta no existe.");
            return;
        }

        System.out.print("Ingrese el monto a depositar: ");
        double monto = scanner.nextDouble();
        scanner.nextLine();

        if (monto <= 0) {
            System.out.println("Error: El monto debe ser positivo.");
            return;
        }

        double saldoAnterior = cuenta.getSaldo();
        cuenta.setSaldo(saldoAnterior + monto);

        Operacion operacion = new Operacion("Depósito", monto, numeroCuenta, null);
        historialOperaciones.add(operacion);

        Movimiento movimiento = new Movimiento(operacion, saldoAnterior, cuenta.getSaldo());
        pilaMovimientos.push(movimiento);

        System.out.println("Depósito realizado exitosamente. ");
        System.out.println("Nuevo saldo: " + "Número de cuenta: " + numeroCuenta + ", Titular: " + cuenta.getTitular() + ", Saldo: " + cuenta.getSaldo() + ", Tipo de cuenta: " + cuenta.getTipoCuenta());
    }

    public void retirarDinero(Scanner scanner) {
        System.out.println("\n=== RETIRAR DINERO ===");
        System.out.print("Ingrese el número de cuenta: ");
        String numeroCuenta = scanner.nextLine();
        System.out.println("Numero de cuenta: " + numeroCuenta + ", Titular: " + buscarCuenta(numeroCuenta).getTitular() + ", Saldo: " + buscarCuenta(numeroCuenta).getSaldo() + ", Tipo de cuenta: " + buscarCuenta(numeroCuenta).getTipoCuenta());

        Cuenta cuenta = buscarCuenta(numeroCuenta);
        if (cuenta == null) {
            System.out.println("Error: La cuenta no existe.");
            return;
        }

        System.out.print("Monto a retirar: ");
        double monto = scanner.nextDouble();
        scanner.nextLine();

        if (monto <= 0) {
            System.out.println("Error: El monto debe ser positivo.");
            return;
        }

        if (monto > cuenta.getSaldo()) {
            System.out.println("Error: Saldo insuficiente.");
            return;
        }

        double saldoAnterior = cuenta.getSaldo();
        cuenta.setSaldo(saldoAnterior - monto);

        Operacion operacion = new Operacion("Retiro", monto, numeroCuenta, null);
        historialOperaciones.add(operacion);

        Movimiento movimiento = new Movimiento(operacion, saldoAnterior, cuenta.getSaldo());
        pilaMovimientos.push(movimiento);

        System.out.println("Retiro realizado exitosamente. ");
        System.out.println("Número de cuenta: " + numeroCuenta + ", Titular: " + cuenta.getTitular() + ", Saldo: " + cuenta.getSaldo() + ", Tipo de cuenta: " + cuenta.getTipoCuenta());
    }

    public void transferirDinero(Scanner scanner) {
        System.out.println("\n=== TRANSFERIR DINERO ===");
        System.out.print("Ingrese el número de cuenta origen: ");
        String cuentaOrigen = scanner.nextLine();
        System.out.println("Numero de cuenta origen: " + cuentaOrigen + ", Titular: " + buscarCuenta(cuentaOrigen).getTitular() + ", Saldo: " + buscarCuenta(cuentaOrigen).getSaldo() + ", Tipo de cuenta: " + buscarCuenta(cuentaOrigen).getTipoCuenta());

        Cuenta origen = buscarCuenta(cuentaOrigen);
        if (origen == null) {
            System.out.println("Error: La cuenta de origen no existe.");
            return;
        }

        System.out.print("Número de cuenta destino: ");
        String cuentaDestino = scanner.nextLine();
        System.out.println("Numero de cuenta destino: " + cuentaDestino + ", Titular: " + buscarCuenta(cuentaDestino).getTitular() + ", Saldo: " + buscarCuenta(cuentaDestino).getSaldo() + ", Tipo de cuenta: " + buscarCuenta(cuentaDestino).getTipoCuenta());

        Cuenta destino = buscarCuenta(cuentaDestino);
        if (destino == null) {
            System.out.println("Error: La cuenta de destino no existe.");
            return;
        }

        if (cuentaOrigen.equals(cuentaDestino)) {
            System.out.println("Error: No se puede transferir a la misma cuenta.");
            return;
        }

        System.out.print("Monto a transferir: ");
        double monto = scanner.nextDouble();
        scanner.nextLine();

        if (monto <= 0) {
            System.out.println("Error: El monto debe ser positivo.");
            return;
        }

        if (monto > origen.getSaldo()) {
            System.out.println("Error: Saldo insuficiente en la cuenta de origen.");
            return;
        }

        double saldoAnteriorOrigen = origen.getSaldo();
        double saldoAnteriorDestino = destino.getSaldo();

        origen.setSaldo(saldoAnteriorOrigen - monto);
        destino.setSaldo(saldoAnteriorDestino + monto);

        Operacion operacion = new Operacion("Transferencia", monto, cuentaOrigen, cuentaDestino);
        historialOperaciones.add(operacion);

        Movimiento movimiento = new Movimiento(operacion, saldoAnteriorOrigen, origen.getSaldo(), saldoAnteriorDestino, destino.getSaldo());
        pilaMovimientos.push(movimiento);

        System.out.println("Transferencia realizada exitosamente.");
        System.out.println("Cuenta Origen: " + "Número:" + cuentaOrigen + ", Titular: " + origen.getTitular() + ", Saldo: " + origen.getSaldo() + ", Tipo de cuenta: " + origen.getTipoCuenta());
        System.out.println("Cuenta Destino: " + "Número:" + cuentaDestino + ", Titular: " + destino.getTitular() + ", Saldo: " + destino.getSaldo() + ", Tipo de cuenta: " + destino.getTipoCuenta());
    }

    public void deshacerMovimiento(Scanner scanner) {
        System.out.println("\n=== DESHACER ÚLTIMO MOVIMIENTO ===");
        if (pilaMovimientos.isEmpty()) {
            System.out.println("No hay movimientos para deshacer.");
            return;
        }
    
        System.out.println("\n--- MOVIMIENTOS DISPONIBLES PARA DESHACER ---");
        Stack<Movimiento> pilaTemporal = new Stack<>();
        int index = 1;
    
        while (!pilaMovimientos.isEmpty()) {
            Movimiento movimiento = pilaMovimientos.pop();
            pilaTemporal.push(movimiento);
            System.out.println(index + ". " + movimiento.getOperacion().getTipo() + " - Cuenta origen: " + movimiento.getOperacion().getCuentaOrigen() +
                    (movimiento.getOperacion().getCuentaDestino() != null ? ", Cuenta destino: " + movimiento.getOperacion().getCuentaDestino() : ""));
            index++;
        }
    
        while (!pilaTemporal.isEmpty()) {
            pilaMovimientos.push(pilaTemporal.pop());
        }
    
        System.out.print("Seleccione el número del movimiento que desea deshacer: ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); 
    
        if (opcion < 1 || opcion >= index) {
            System.out.println("Opción no válida.");
            return;
        }
    
        Movimiento movimientoSeleccionado = null;
        for (int i = 1; i <= opcion; i++) {
            movimientoSeleccionado = pilaMovimientos.pop();
            if (i < opcion) {
                pilaTemporal.push(movimientoSeleccionado);
            }
        }
    
        while (!pilaTemporal.isEmpty()) {
            pilaMovimientos.push(pilaTemporal.pop());
        }
    
        System.out.print("¿Está seguro de que desea deshacer este movimiento? (S/N): ");
        String confirmacion = scanner.nextLine();
    
        if (!confirmacion.equalsIgnoreCase("S")) {
            System.out.println("Operación cancelada.");
            pilaMovimientos.push(movimientoSeleccionado); 
            return;
        }
    
        Operacion operacion = movimientoSeleccionado.getOperacion();
        Cuenta cuentaOrigen = buscarCuenta(operacion.getCuentaOrigen());
    
        if (operacion.getTipo().equals("Transferencia")) {
            Cuenta cuentaDestino = buscarCuenta(operacion.getCuentaDestino());
            cuentaOrigen.setSaldo(movimientoSeleccionado.getSaldoAnteriorOrigen());
            cuentaDestino.setSaldo(movimientoSeleccionado.getSaldoAnteriorDestino());
        } else {
            cuentaOrigen.setSaldo(movimientoSeleccionado.getSaldoAnteriorOrigen());
        }
    
        historialOperaciones.remove(historialOperaciones.size() - 1);
        System.out.println("Operación deshecha exitosamente.");
        
    }

    
    public void mostrarEstado() {
        System.out.println("\n--- Listado de cuentas ---");
        if (cuentas.isEmpty()) {
            System.out.println("No hay cuentas registradas.");
        } else {
            for (Cuenta cuenta : cuentas) {
                System.out.println("Cuenta [" + "Número de cuenta: " + cuenta.getNumeroCuenta() + ", Titular: " + cuenta.getTitular() + ", Saldo: " + cuenta.getSaldo() + ", Tipo de cuenta: " + cuenta.getTipoCuenta()+  "]");
            }
        }

        System.out.println("\n--- HISTORIAL DE OPERACIONES ---");
        if (historialOperaciones.isEmpty()) {
            System.out.println("No hay operaciones registradas.");
        } else {
            for (int i = 0; i < historialOperaciones.size(); i++) {
                System.out.println((i + 1) + ". " + historialOperaciones.get(i));
            }
        }

        System.out.println("\nOperaciones recientes disponibles para deshacer:");
        if (pilaMovimientos.isEmpty()) {
            System.out.println("No hay movimientos recientes.");
        } else {
            Stack<Movimiento> pilaTemporal = new Stack<>();
            boolean hayRetirosODepositos = false;
    
            while (!pilaMovimientos.isEmpty()) {
                Movimiento movimiento = pilaMovimientos.pop();
                pilaTemporal.push(movimiento);
    
                String tipoOperacion = movimiento.getOperacion().getTipo();
                if (tipoOperacion.equals("Retiro") || tipoOperacion.equals("Depósito") || tipoOperacion.equals("Transferencia")) {
                    System.out.println("- " + tipoOperacion + " en la cuenta " + movimiento.getOperacion().getCuentaOrigen() +
                            ", Monto: " + movimiento.getOperacion().getMonto());
                    hayRetirosODepositos = true;
                }
            }
    
            while (!pilaTemporal.isEmpty()) {
                pilaMovimientos.push(pilaTemporal.pop());
            }
    
            if (!hayRetirosODepositos) {
                System.out.println("No hay retiros ni depósitos recientes para deshacer.");
            }
        }
    }
    public Cuenta buscarCuenta(String numeroCuenta) {
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getNumeroCuenta().equals(numeroCuenta)) {
                return cuenta;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        SistemaBancario sistema = new SistemaBancario();
        sistema.ejecutar();
    }
}