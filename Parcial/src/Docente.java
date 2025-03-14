public class Docente extends Usuario {
    private String Asignatura;
    private double Salario;

    public Docente(String nombre, String apellido, String carrera, String asignatura, double salario) {
        super(nombre, apellido, carrera);
        this.Asignatura = asignatura;
        this.Salario = salario;
    }
    public String GetAsignatura() {
        return Asignatura;
    }
    public void SetAsignatura(String asignatura) {
        this.Asignatura = asignatura;
    }
    public double GetSalario() {
        return Salario;
    }
    public void SetSalario(double salario) {
        this.Salario = salario;
    }
    public void imprimir(){
        super.imprimir();
        System.out.println("Asignatura: " + Asignatura);
        System.out.println("Salario: " + Salario);
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
            case "asignatura":
                SetAsignatura(valor);
                break;
            case "salario":
                try {
                    double salario = Double.parseDouble(valor);
                    SetSalario(salario);
                } catch (NumberFormatException e) {
                    System.out.println("Valor no permitido");
                }
                break;
            default:
                System.out.println("No se ha modificado la información del docente.");
        }
}
}
