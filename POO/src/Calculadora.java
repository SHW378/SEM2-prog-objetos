public class Calculadora {
    public void suma (String a, String b) {
        System.out.println("No se puede sumar valores no númericos");
    }
    public void suma (int a, int b) {
        System.out.println("La suma es: " + (a + b));
    }
    public void suma (float a, float b) {
        System.out.println("La suma es: " + (a + b));
    }
public static void main(String[] args) {
    Calculadora calculadora = new Calculadora();
    calculadora.suma("abc", "xyz");
    calculadora.suma(1, 2);
    calculadora.suma(2.2f, 3.3f);
}
}
