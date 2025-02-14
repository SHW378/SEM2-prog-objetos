public class App {
    public static void main(String[] args) throws Exception {
        brad primerbrad = new brad();
        primerbrad.setNombre("");
        primerbrad.setGusto("");
        primerbrad.setMedida(15);
        System.out.println("A " + primerbrad.getNombre() + " le gusta " + primerbrad.getGusto() + " y que midan " + primerbrad.getMedida() + " cm");
    }
}
