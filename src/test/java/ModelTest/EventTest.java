package ModelTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import Model.Event;

public class EventTest{
    
    String title = "Quantum Machine Learning";
    LocalDateTime date = LocalDateTime.of(2025,2,28,9,30);
    String location="Auditorio 3";
    String summary="Introduccion a Machine Learning para computación cuántica";
    int maxCapacity=80;
    List<Integer> participants = new ArrayList();
    
    @Test
    public void EventConstructorTest(){
        Event newEvent = new Event(title, date, location, summary, maxCapacity);
        
        assertEquals(title, newEvent.getTitle());
        assertEquals(date, newEvent.getDate());
        assertEquals(location, newEvent.getLocation());
        assertEquals(summary, newEvent.getSummary());
        assertEquals(maxCapacity, newEvent.getMaxCapacity());
        
    }
}