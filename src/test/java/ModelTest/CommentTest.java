package ModelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import Model.Comment;

public class CommentTest {
    
    @Test
    public void CommentConstructorWithParametersTest(){
        Comment comment = new Comment(28314837, "This is a comment");
        assertEquals(28314837, comment.getAutorID());
        assertEquals("This is a comment", comment.getText());
    }

    @Test
    public void CommentConstructorNoParameters(){
        Comment c2 = new Comment();
        assertEquals(0, c2.getAutorID());
        assertEquals("", c2.getText());
    }
    
}
