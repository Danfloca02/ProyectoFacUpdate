
import Controller.Publications.PublicationController;
import Data.FileGestor;
import Model.Publication;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author USER
 */
public class PublicationControllerTest {
    private static PublicationController CC = PublicationController.GetInstance();
    //long EVENTID, String titulo, int autor, String place,LocalDateTime fecha, String descripcion, int maxCapacity
    
    
    public static void main(String[] args) {
        
        
        CC.addPublication(0, "PRUEBA1", 31080238, "Plaza Langosta", LocalDateTime.of(2025, 2, 22,0,0),"prueba1", 18);
        CC.addPublication(0, "PRUEBA2", 31080238, "Parrilleras", LocalDateTime.of(2025, 2, 22,0,0),"prueba2", 2);
        CC.addPublication(0, "PRUEBA3", 31080238, "Parrilleras", LocalDateTime.of(2025, 2, 22,0,0),"prueba3", 2);
        System.out.print("ESCRIBIO");
        
        List<Publication> a = CC.getPublications();
        for(Publication e : a){
            System.out.print(e.getPUBLICATIONID());
            System.out.print(" ");
            System.out.println(e.getTitulo());
        }
        
    }
}
