import java.util.Calendar;
import java.util.GregorianCalendar;

public class Documento {
    private String nomeU;
    private String nomeA;
    private Calendar horarioInicio;
    private Calendar horarioFim;

    public Documento(String nomeU, String nomeA) {
        this.nomeU = nomeU;
        this.nomeA = nomeA;
        this.horarioInicio = GregorianCalendar.getInstance();
    }

    public void marcarFim() {
        this.horarioFim = GregorianCalendar.getInstance();
    }

    public String getHorarioFormatado(Calendar cal) {
        if (cal == null) return "Não registrado";
        int hora = cal.get(Calendar.HOUR_OF_DAY);
        int minuto = cal.get(Calendar.MINUTE);
        int segundo = cal.get(Calendar.SECOND);
        return String.format("%02d:%02d:%02d", hora, minuto, segundo);
    }

    public String getHorarioInicio() {
        return getHorarioFormatado(horarioInicio);
    }

    public String getHorarioFim() {
        return getHorarioFormatado(horarioFim);
    }

    public long getSegundosDecorridos() {
        if (horarioInicio != null && horarioFim != null) {
            long millisInicio = horarioInicio.getTimeInMillis();
            long millisFim = horarioFim.getTimeInMillis();
            return (millisFim - millisInicio) / 1000;
        }
        return -1;
    }

    public String getNomeU() {
        return nomeU;
    }

    public String getNomeA() {
        return nomeA;
    }

    @Override
    public String toString() {
        String duracao = horarioFim != null ? getSegundosDecorridos() + "s" : "pendente";
        return "Documento [nome do Usuario=" + nomeU +
               ", nome de Arquivo=" + nomeA +
               ", inicio=" + getHorarioInicio() +
               ", fim=" + getHorarioFim() +
               ", duracao=" + duracao + "]";
    }
}
