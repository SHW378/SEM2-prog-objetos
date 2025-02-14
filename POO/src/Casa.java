public class Casa { //Definimos la clase 
    private String color; // definimos el aributo o la propiedad color

    public Casa(String valor) { //definimos el constructor de Casa
        this.color = valor;
    }

    public void mostrarColor() {  //Definimos el método mostrarColor
        System.out.println("El valor del color de la casa es: " + this.color);
    }
    public static void main(String[] args) { //Definimos el método para ejecutar el programa
        // Sección de creación de objetos 
        Casa miCasa = new Casa("Blanco"); //Definimos la instancia miCasa 
        // Llamar al método
        miCasa.mostrarColor(); //Definimos el mensaje mostrarColor
        Casa otraCasa = new Casa("Verde"); //Definimos la instancia otraCasa
        otraCasa.mostrarColor(); //Definimos el mensaje mostrarColor de la instancia otraCasa

    }   
}