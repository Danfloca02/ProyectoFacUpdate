package Controller.Publications;

import Data.DatabasePublications;
import Model.Comment;
import java.time.LocalDateTime;

import java.util.List;
import Model.Publication;
import Model.User;
import java.util.Collections;

public class PublicationController {
    private static PublicationController instance;
    private DatabasePublications DB;
    public List<Publication> publications;

    private PublicationController() {
        DB = DatabasePublications.GetInstance();
        loadPublications();
    }
    private void loadPublications(){
        publications = DB.getPublicationList();
        Collections.reverse(publications);
    }
    public static PublicationController GetInstance(){
        if(instance == null)instance = new PublicationController();
        return instance;
    }
    
    public Publication addPublication(long AutorID, String descripcion, String image_path) {
        //long PUBLICATION_ID, long AUTOR_ID, String autorName, String text
        Publication publication = new Publication(0, AutorID, descripcion, image_path);
        publication = DB.createNewPublication(publication);
        loadPublications();
        return publication;
        
    }
    public void deletePublication(Long publicationID){
        DB.deletePublication(publicationID);
        loadPublications();
    }

    public List<Publication> getPublications() {
        return publications;
    }
    
    public void AddComment(long PublicationID, Comment comment){
        Publication p = searchPublication(PublicationID);
        List<Comment> publicationComments = p.getComments();
        publicationComments.add(comment);
        p.setComments(publicationComments);
        DB.ModifyPublication(PublicationID, p);
        loadPublications();
    }
    public void AddLike(long PublicationID, long UserID){
        Publication p = searchPublication(PublicationID);
        List<Long> publicationReacts = p.getUsersWhoReacted();
        publicationReacts.add(UserID);
        p.setUsersWhoReacted(publicationReacts);
        
        DB.ModifyPublication(PublicationID, p);
        loadPublications();
    }
    public void DeleteLike(long PublicationID, long UserID){
        Publication p = searchPublication(PublicationID);
        List<Long> publicationReacts = p.getUsersWhoReacted();
        publicationReacts.remove(UserID);
        p.setUsersWhoReacted(publicationReacts);
        
        DB.ModifyPublication(PublicationID, p);
        loadPublications();
    }
    
    public Publication searchPublication(long ID){
        for(Publication p : publications){
            if(p.getPUBLICATION_ID() == ID){
                return p;
            }
        }
        return null;
    }
    
    

}


