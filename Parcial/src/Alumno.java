public class Alumno extends Usuario {
    private double matricula;
    private double promedio;

    public Alumno(String nombre, String apellido, String carrera, double matricula, double promedio) {
        super(nombre, apellido, carrera);
        this.matricula = matricula;
        this.promedio = promedio;
    }

    public double GetMatricula() {
        return matricula;
    }
    public void SetMatricula(double matricula) {
        this.matricula = matricula;
    }
    public double GetPromedio() {
        return promedio;
    }
    public void SetPromedio(double promedio) {
        this.promedio = promedio;
    }
    
    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("Matricula: " + matricula);
        System.out.println("Promedio: " + promedio);
    }
    @Override
    public void modificar(String tipoDato, String valor) {
        switch (tipoDato) {
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
                try {
                    double mat = Double.parseDouble(valor);
                    SetMatricula(mat);
                } catch (NumberFormatException e) {
                    System.out.println("Valor no permitido");
                }
                break;
            case "promedio":
                try {
                    double prom = Double.parseDouble(valor);
                    SetPromedio(prom);
                } catch (NumberFormatException e) {
                    System.out.println("Valor no permitido");
                }
                break;
            default:
                System.out.println("No se ha modificado la información del alumno.");
        }
}
}

