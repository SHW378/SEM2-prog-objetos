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
        
        System.out.print("Tipo de cuenta (1. Ahorros / 2. Corriente): ");
        int tipoCuenta = scanner.nextInt();
        scanner.nextLine();

        String tipo = (tipoCuenta == 1) ? "Ahorros" : "Corriente";

        scanner.nextLine();

        Cuenta nuevaCuenta = new Cuenta(numeroCuenta, titular, saldoInicial, tipo);
        cuentas.add(nuevaCuenta);

        System.out.println("Cuenta creada exitosamente.");
    }

    public void depositarDinero(Scanner scanner) {
        System.out.println("\n=== DEPOSITAR DINERO ===");
        System.out.print("Número de cuenta: ");
        String numeroCuenta = scanner.nextLine();

        Cuenta cuenta = buscarCuenta(numeroCuenta);
        if (cuenta == null) {
            System.out.println("Error: La cuenta no existe.");
            return;
        }

        System.out.print("Monto a depositar: ");
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

        System.out.println("Depósito realizado con éxito. Nuevo saldo: " + cuenta.getSaldo());
    }

    public void retirarDinero(Scanner scanner) {
        System.out.println("\n=== RETIRAR DINERO ===");
        System.out.print("Número de cuenta: ");
        String numeroCuenta = scanner.nextLine();

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

        System.out.println("Retiro realizado con éxito. Nuevo saldo: " + cuenta.getSaldo());
    }

    public void transferirDinero(Scanner scanner) {
        System.out.println("\n=== TRANSFERIR DINERO ===");
        System.out.print("Número de cuenta origen: ");
        String cuentaOrigen = scanner.nextLine();

        Cuenta origen = buscarCuenta(cuentaOrigen);
        if (origen == null) {
            System.out.println("Error: La cuenta de origen no existe.");
            return;
        }

        System.out.print("Número de cuenta destino: ");
        String cuentaDestino = scanner.nextLine();

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

        System.out.println("Transferencia realizada con éxito.");
        System.out.println("Nuevo saldo cuenta origen: " + origen.getSaldo());
        System.out.println("Nuevo saldo cuenta destino: " + destino.getSaldo());
    }

    public void deshacerMovimiento() {
        if (pilaMovimientos.isEmpty()) {
            System.out.println("No hay movimientos para deshacer.");
            return;
        }

        Movimiento ultimoMovimiento = pilaMovimientos.pop();
        Operacion operacion = ultimoMovimiento.getOperacion();

        Cuenta cuentaOrigen = buscarCuenta(operacion.getCuentaOrigen());

        if (operacion.getTipo().equals("Transferencia")) {
            Cuenta cuentaDestino = buscarCuenta(operacion.getCuentaDestino());

            cuentaOrigen.setSaldo(ultimoMovimiento.getSaldoAnteriorOrigen());
            cuentaDestino.setSaldo(ultimoMovimiento.getSaldoAnteriorDestino());

            System.out.println("Transferencia deshecha. Se revirtieron los saldos de las cuentas.");
        } else {
            cuentaOrigen.setSaldo(ultimoMovimiento.getSaldoAnteriorOrigen());
            System.out.println(operacion.getTipo() + " deshecho. Se revirtió el saldo de la cuenta.");
        }

        historialOperaciones.remove(historialOperaciones.size() - 1);
    }

    public void mostrarEstado() {
        System.out.println("\n===== ESTADO DEL SISTEMA =====");
        System.out.println("\n--- CUENTAS ---");
        if (cuentas.isEmpty()) {
            System.out.println("No hay cuentas registradas.");
        } else {
            for (Cuenta cuenta : cuentas) {
                System.out.println(cuenta);
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

        System.out.println("\n--- PILA DE MOVIMIENTOS PARA DESHACER ---");
        if (pilaMovimientos.isEmpty()) {
            System.out.println("No hay movimientos en la pila.");
        } else {
            System.out.println("Número de movimientos en pila: " + pilaMovimientos.size());
            System.out.println("Último movimiento: " + pilaMovimientos.peek().getOperacion());
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