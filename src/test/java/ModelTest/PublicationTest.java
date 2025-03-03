package ModelTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import org.junit.jupiter.api.Test;

import Model.Comment;
import Model.Publication;

public class PublicationTest {

    long PUBLICATION_ID = 1;
    long AUTOR_ID = 28314837;
    String text = "This is a publication";
    String image_path = "C://Users//danfl//OneDrive//Pictures//Imagen1.png";
    int likes = 5;
    List<Comment> comentarios;
    List<Long> uwr;
    LocalDateTime date;

    @Test
    public void PublicationConstructorNoPublicatedTest() {
        Publication p1= new Publication(PUBLICATION_ID, AUTOR_ID, text, image_path);
        assertEquals(PUBLICATION_ID, p1.getPUBLICATION_ID());
        assertEquals(AUTOR_ID, p1.getAUTOR_ID());
        assertEquals(text, p1.getText());
        assertEquals(image_path, p1.getImage_path());     
        assertEquals(0, p1.getLikes());
        assertIterableEquals(new ArrayList<>(), p1.getComments());
        assertIterableEquals(new ArrayList<>(), p1.getUsersWhoReacted());
        assertEquals(LocalDateTime.now(), p1.getDate());   
    }

    @Test
    public void PublicationConstructorWithLikesTest() {
        Publication p2= new Publication(PUBLICATION_ID, AUTOR_ID, text, image_path, likes, comentarios, uwr, date);
        assertEquals(PUBLICATION_ID, p2.getPUBLICATION_ID());
        assertEquals(AUTOR_ID, p2.getAUTOR_ID());
        assertEquals(text, p2.getText());
        assertEquals(image_path, p2.getImage_path());
        assertEquals(likes, p2.getLikes());
        assertIterableEquals(comentarios, p2.getComments());
        assertIterableEquals(uwr, p2.getUsersWhoReacted());
        assertEquals(date, p2.getDate());
    }

    @Test
    public void PublicationWitoutParametersTest(){
        Publication p3= new Publication();
        assertEquals(0, p3.getPUBLICATION_ID());
        assertEquals(0, p3.getAUTOR_ID());
        assertEquals("", p3.getText());
        assertEquals("", p3.getImage_path());
        assertEquals(0, p3.getLikes());
        assertIterableEquals(new ArrayList<>(), p3.getComments());
        assertIterableEquals(new ArrayList<>(), p3.getUsersWhoReacted());
        assertEquals(LocalDateTime.now(), p3.getDate());
    }

    @Test
    public void convertPublicationToString(){
        Publication p4= new Publication(1, 28314837, "This is my first Publication", "Images/2.png");
                assertEquals("Publication{PUBLICATION_ID=1, AUTOR_ID=28314837, text=This is my first Publication, likes=0, date="+LocalDateTime.now()+", image_path=Images/2.png}"
, p4.toString());
    }
}

