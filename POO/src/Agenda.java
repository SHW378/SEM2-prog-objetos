public class Agenda extends Calendario {
    private final int DIAS_LABORALES= 5;
    @Override
    public void mostrarsemana() {
        super.mostrarsemana(); //usar super apra refenciar al métpdp de la super clase
        System.out.println("Eñ número de días laborales de la semana son " + DIAS_LABORALES);
    }
}
