package ModelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import Model.Career;
import Model.Student;
import Model.Teacher;
import Model.User;


public class UserTest {
    
    long id = 12345L;
    String userName = "Danfloca";
    String email = "danfloca02@gmail.com";
    String password = "Daniel123";
    String career = "COMPUTACION";

    @Test
    public void testTeacherConstructor() {

        User teacher = new Teacher(id, userName, email, password, career);

        assertEquals(id, teacher.ID);
        assertEquals(userName, teacher.userName);
        assertEquals(email, teacher.Email);
        assertEquals(password, teacher.Password);
        assertEquals(Career.COMPUTACION, teacher.Kareer);
    }

    @Test
    public void testStudentConstructor() {

        User student = new Student(id, userName, email, password, career);

        assertEquals(id, student.ID);
        assertEquals(userName, student.userName);
        assertEquals(email, student.Email);
        assertEquals(password, student.Password);
        assertEquals(Career.COMPUTACION, student.Kareer);
    }
    
}
