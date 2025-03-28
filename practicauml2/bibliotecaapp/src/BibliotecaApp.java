public class BibliotecaApp {
    public static void main(String[] args) throws Exception {
        Autor autor1 = new Autor("Cesar", "Mexicano");
        Libro libro1 = new Libro("El diario de greg", autor1, "978-1-2345-6789-0");

        System.out.println("Libro: " + libro1.getTitulo());
        System.out.println("Autor: " + libro1.getAutor().getNombre());
        System.out.println("Nacionalidad" + libro1.getAutor().getNacionalidad());
        System.out.println("ISBN: " + libro1.getIsbn());
    }
}
