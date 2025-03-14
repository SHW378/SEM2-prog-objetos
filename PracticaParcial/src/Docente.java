public class Docente extends Usuario {
    private String asignatura;
    private double salario;

    public Docente(String nombre, String apellido, String carrera, String asignatura, double salario) {
        super(nombre, apellido, carrera);
        this.asignatura = asignatura;
        this.salario = salario;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("Asignatura: " + asignatura);
        System.out.println("Salario: " + salario);
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
            case "asignatura":
                setAsignatura(valor);
                break;
            case "salario":
                try {
                    double sal = Double.parseDouble(valor);
                    setSalario(sal);
                } catch (NumberFormatException e) {
                    System.out.println("Valor no numérico para salario.");
                }
                break;
            default:
                System.out.println("No se ha modificado la información del docente.");
        }
    }
}