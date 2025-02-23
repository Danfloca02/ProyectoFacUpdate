package Controller.Publications;

import Data.DatabasePublications;
import java.time.LocalDateTime;

import java.util.List;
import Model.Publication;
import Model.User;

public class PublicationController {
    private static PublicationController instance;
    private DatabasePublications DB;
    public List<Publication> eventos;

    private PublicationController() {
        DB = DatabasePublications.GetInstance();
        loadPublications();
    }
    private void loadPublications(){
        eventos = DB.getPublicationList();
    }
    public static PublicationController GetInstance(){
        if(instance == null)instance = new PublicationController();
        return instance;
    }
    
    public void addPublication(long EVENTID, String titulo, int autor, String place,LocalDateTime fecha, String descripcion, int maxCapacity) {
        Publication publication = new Publication(EVENTID, titulo, autor, place, fecha, descripcion, maxCapacity);
        DB.createNewPublication(publication);
        loadPublications();
    }
    public void deletePublication(Publication event){
        DB.deletePublication(event.getPUBLICATIONID());
        loadPublications();
    }

    public List<Publication> getPublications() {
        return eventos;
    }
    public void subscribeUser(Publication event, User user){
        event.addParticipant(user.ID);
        DB.ModifyPublication(event.getPUBLICATIONID(), event);
        loadPublications();
    }

    public void printPublications() {
        //solo para probar las cosas mas rapido
        for (Publication evento : eventos) {
            System.out.println("Nombre E: " + evento.getTitulo());
            System.out.println("Fecha: " + evento.getFecha());
            System.out.println("Descripcion: " + evento.getDescripcion());
            System.out.println("Capacidad Max: " + evento.getMaxCapacity());
            System.out.println("Participantes: " + evento.getParticipants());
            System.out.println("---------------------------");
        }
    }

}


