public class BibliotecaApp{
    public static void main(String[] args) {

        Autor autor1 = new Autor("Cesar", "Mexicano");
        Libro libro1 = new Libro("El libro de la vida", autor, "978-1-2345-6789-0");

        System.out.println("Libro: "+ libro.getTitulo());
        System.out.println("Autor: " + libro.getAutor().getNombre());
        System.out.println("Nacionalidad: " + libro.getAutor().getNacionalidad());
        System.out.println("ISBN: " + libro.getIsbn());
    }
}
 

/*
@startuml
class BibliotecaApp {
    + main(args: String[]): void
}

class Libro {
    - titulo: String
    - autor: Autor
    - isbn: String
    + Libro(titulo: String, autor: Autor, isbn: String)
    + getTitulo(): String
    + getAutor(): Autor
    + getIsbn(): String
}

class Autor {
    - nombre: String
    - nacionalidad: String
    + Autor(nombre: String, nacionalidad: String)
    + getNombre(): String
    + getNacionalidad(): String
}

BibliotecaApp ..> Libro : usa
BibliotecaApp ..> Autor : usa
Libro --> Autor : 1
@enduml
*/
