public class BibliotecaApp {
    public static void main(String[] args) throws Exception {
        Autor autor1 = new Autor("Cesar", "Mexicano");
        Libro libro1 = new Libro("El libro sobre mi", autor1, "978-1-2345-6789-0");

        Libro libro2 = new Libro("El libro sobre mi 2", autor1, "978-1-2345-6789-0");

        System.out.println("Libro: " + libro1.getTitulo());
        System.out.println("Autor: " + libro1.getAutor().getNombre());
        System.out.println("Nacionalidad: " + libro1.getAutor().getNacionalidad());
        System.out.println("ISBN: " + libro1.getIsbn());

        System.out.println();
        System.out.println("Libro: " + libro2.getTitulo());
        System.out.println("Autor: " + libro2.getAutor().getNombre());
        System.out.println("Nacionalidad: " + libro2.getAutor().getNacionalidad());
        System.out.println("ISBN: " + libro2.getIsbn());
    }
}
