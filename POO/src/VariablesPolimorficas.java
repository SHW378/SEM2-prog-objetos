public class VariablesPolimorficas {
    public static void main(String[] args) {
        Animal mianimal = new Perro(); //Variable polimórfica
        mianimal.hacerSonido(); // Salida: El perro ladra
        //La misma variable, pero haciendo referencia a otro objeto
        mianimal = new Gato();
        mianimal.hacerSonido(); // Salida: El gato maulla
    }
}