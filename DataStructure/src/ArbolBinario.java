public class ArbolBinario {
    public static void main(String[] args) {
        ArbolBinarioBusqueda abb = new ArbolBinarioBusqueda();
        abb.insertar(8);
        abb.insertar(3);
        abb.insertar(1);
        abb.insertar(6);
        abb.insertar(4);
        abb.insertar(7);
        abb.insertar(10);
        abb.insertar(14);
        abb.insertar(13);
        System.out.println("Recorrido en inorden:");
        abb.recorrerInorden();
        System.out.println("\nRecorrido en preorden:");
        abb.recorrerPreorden();
        System.out.println("\nRecorrido en postorden:");
        abb.recorrerPostorden();
        System.out.println("\n¿Existe el valor 50?: " + abb.buscar(50));
        System.out.println("¿Existe el valor 10?: " + abb.buscar(10));

        abb.eliminar(1);
        abb.eliminar(10);
        System.out.println("Recorrido inorden");
        abb.recorrerInorden();

    }
}