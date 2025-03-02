package ControllerTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import Controller.session.SesionController;

public class SessionControllerTest {
    SesionController sc = SesionController.GetInstance();
    String filePath = "C:\\ProyectoFacUpdate\\ProyectoFacUpdate\\USERS.txt";

    @Test
    public void registerExistentUserTest(){
        assertFalse(sc.register("STUDENT", "carlosmirandaucv@gmail.com", "Carlos.11", "31080238", "Carlos_11"));
    }

    @Test
    public void registeNewUserValidDataTest(){
        assertTrue(sc.register("STUDENT", "danfloca02@gmail.com", "Dan2307", "28314837", "danfloca02"));
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            if (!lines.isEmpty()) {
                lines.remove(lines.size() - 1); // Elimina la última línea
                Files.write(Paths.get(filePath), lines, StandardOpenOption.TRUNCATE_EXISTING); // Reescribe el archivo
            }
        } catch (IOException e) {
            e.printStackTrace(); // Maneja la excepción adecuadamente
        }
    }

    @Test
    public void registerNewUserInvalidPassword(){
        assertFalse(sc.register("STUDENT", "danfloca02@gmail.com", "2307", "28314837", "danfloca02"));
    }

}
