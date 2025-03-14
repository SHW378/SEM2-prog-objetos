public class Alumno extends Usuario {
    private String matricula;
    private double promedio;

    public Alumno(String nombre, String apellido, String carrera, String matricula, double promedio) {
        super(nombre, apellido, carrera);
        this.matricula = matricula;
        this.promedio = promedio;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("Matrícula: " + matricula);
        System.out.println("Promedio: " + promedio);
    }

    @Override
    public void modificar(String tipoDato, String valor) {
        switch (tipoDato.toLowerCase()) {
            case "nombre":
                setNombre(valor);
                break;
            case "apellido":
                setApellido(valor);
                break;
            case "carrera":
                setCarrera(valor);
                break;
            case "matricula":
                setMatricula(valor);
                break;
            case "promedio":
                try {
                    double prom = Double.parseDouble(valor);
                    setPromedio(prom);
                } catch (NumberFormatException e) {
                    System.out.println("Valor no numérico para promedio.");
                }
                break;
            default:
                System.out.println("No se ha modificado la información del alumno.");
        }
    }
}