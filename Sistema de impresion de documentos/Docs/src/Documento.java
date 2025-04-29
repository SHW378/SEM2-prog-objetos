public class Documento {
    private String titulo;
    private int numerodepaginas;
    private String tipo;

    public Documento(String titulo, int numerodepaginas, String tipo) {
        this.titulo = titulo;
        this.numerodepaginas = numerodepaginas;
        this.tipo = tipo;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }   
    public int getnumerodepaginas() {
        return numerodepaginas;
    }
    public void setnumerodepaginas(int numerodepaginas) {
        this.numerodepaginas = numerodepaginas;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Título: " + titulo + ", Páginas: " + numerodepaginas + ", Tipo: " + tipo;
    }
}
