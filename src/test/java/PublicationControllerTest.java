
import Controller.Publications.PublicationController;
import Data.FileGestor;
import Model.Comment;
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
    private static PublicationController PC = PublicationController.GetInstance();
    //long EVENTID, String titulo, int autor, String place,LocalDateTime fecha, String descripcion, int maxCapacity
    
    
    public static void main(String[] args) {
        
        Comment C1 = new Comment();
        C1.setAutorID(31080013);C1.setText("BRUTAL");
        
        //TestAddPublication();
        
        
        
        
        
        List<Publication> lista = PC.getPublications();
        for(Publication p : lista){
            System.out.println(p.toString());
        }
    }
    
    public static void TestAddPublication(){
        PC.addPublication(31080238, "Test1 Test1 Espacios", "C:/AppData/Terraria");
        PC.addPublication(31080238, "Test2", "C:/AppData/Minecraft");
        PC.addPublication(31080238, "Test3", "C:/AppData/Sky");
    }
    public static void TestAddLike(long PublicationID, long UserID){
        PC.AddLike(PublicationID, UserID);
    }
    public static void TestAddComment(long PublicationID, Comment comm){
        PC.AddComment(PublicationID, comm);
    }
}
