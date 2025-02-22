import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Calendario {
    private List<Evento> eventos;

    public Calendario() {
        this.eventos = new ArrayList<>();
    }

    public void agregarEvento(Evento evento) {
        eventos.add(evento);
    }

    public List<Evento> obtenerEventos() {
        return eventos;
    }

    public void mostrarEventos() {
        //solo para probar las cosas mas rapido
        for (Evento evento : eventos) {
            System.out.println("Nombre E: " + evento.getTitulo());
            System.out.println("Fecha: " + evento.getFecha());
            System.out.println("Descripcion: " + evento.getDescripcion());
            System.out.println("Capacidad Max: " + evento.getMaxCapacity());
            System.out.println("Participantes: " + evento.getParticipants());
            System.out.println("---------------------------");
        }
    }


    public static void main(String[] args) {
        Calendario calendario = new Calendario();

        Evento evento1 = new Evento("Evento 1", LocalDateTime.now(), "Prueba de evento", 100);
        calendario.agregarEvento(evento1);

        Evento evento2 = new Evento("Evento 2", LocalDateTime.of(2025, 2, 22, 14, 30), "Otro evento", 50);
        calendario.agregarEvento(evento2);

        evento1.setParticipants(1);
        evento1.setParticipants(2);
        evento2.setParticipants(3);

        calendario.mostrarEventos();
    }

}


class Evento {

    private String titulo;
    private LocalDateTime fecha;
    private String descripcion;
    private int maxCapacity;
    private List<Integer> participants;

    public Evento(String titulo, LocalDateTime fecha, String descripcion, int maxCapacity) {
        this.titulo = titulo;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.maxCapacity = maxCapacity;
        this.participants = new ArrayList<>();
    }

    public String getTitulo() {
        return titulo;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public Integer getMaxCapacity() {
        return maxCapacity;
    }

    public List<Integer> getParticipants() {
        return participants;
    }

    public void setParticipants(Integer participant) {
        if (this.participants.size() < this.maxCapacity) {
            this.participants.add(participant);
            maxCapacity--;

        } else {
            System.out.println("n");
        }
    }
}
