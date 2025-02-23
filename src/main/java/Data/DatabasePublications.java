package Data;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author CARLOS_MIRANDA
 */



import Model.Publication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.io.BufferedWriter;
import java.time.LocalDateTime;




//code:
public class DatabasePublications {
    private static DatabasePublications instance;
    private static FileGestor filegestor;
    private static String path;
    
    private DatabasePublications(){
        filegestor = new FileGestor();
        
        path = "./PUBLICATIONS.txt";
    }
    public static DatabasePublications GetInstance(){
        if(instance == null){
            instance = new DatabasePublications();
        }
        return instance;
    }
    public boolean createNewPublication(Publication publication){
        List<Publication> publications =  getPublicationList();
        long id = 0;
        if(!publications.isEmpty()){
            id = publications.get(publications.size() - 1).getPUBLICATIONID();
        }
        
        id++;
        publication.setEventID(id);
        System.out.println(id);
        publications.add(publication);
        savePublications(publications);
        return true;           
    }
    public boolean deletePublication (Long PublicationID){
        List<Publication> publications = this.getPublicationList();
        boolean found = false;
        for(Publication publication : publications){
            if(PublicationID == publication.getPUBLICATIONID()){
                publications.remove(publication);
                found = true;
                break;
            }
        }
        savePublications(publications);
        return found;
        
    }
    public boolean ModifyPublication(Long PublicationID, Publication newData){
        List<Publication> publications = this.getPublicationList();
        boolean found = false;
        for(Publication publication : publications){
            if(PublicationID == publication.getPUBLICATIONID()){
                publication = newData;
                found = true;
                break;
            }
        }
        savePublications(publications);
        return found;
    }
    public List<Publication> getPublicationList(){
        List<Publication> ret = new ArrayList<>();
        
        try(Scanner br = filegestor.getScanner(path)){
            while (br.hasNextLine()) {
                ret.add(readEventWithStructure(br));
                System.out.println(ret.getFirst().getTitulo());
                
            }
            
        }catch (IOException e) {
            System.err.println("Esto no deberia fallar, y fallo");
        }
        System.out.println(ret.size());
        return ret;
    }
    public void savePublications(List<Publication> publications){
        try{
            filegestor.CleanFile(path);
        }catch(IOException e){
            e.printStackTrace();
        }
        
        try(BufferedWriter bw = filegestor.getBufferedWriter(path, true)){
            for(Publication event : publications){
                writeWithStructure(bw, event);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    private void writeWithStructure(BufferedWriter bw, Publication publication) throws IOException{
        /*
        bw.write("#I");bw.newLine();
        bw.write(Long.toString((long) publication.getEVENTID()));bw.newLine();
        bw.write("#T");bw.newLine();
        bw.write(publication.getTitulo());bw.newLine();
        bw.write("#F");bw.newLine();
        String fecha = Integer.toString(publication.getFecha().getYear()) + " " + Integer.toString(publication.getFecha().getMonthValue()) + " " + Integer.toString(publication.getFecha().getDayOfMonth());
        bw.write(fecha);bw.newLine();
        bw.write("#PL");bw.newLine();
        bw.write(publication.getPlace());bw.newLine();
        bw.write("#A");bw.newLine();
        bw.write(Long.toString((long)publication.getAutorID()));bw.newLine();
        bw.write("#D");bw.newLine();
        bw.write(publication.getDescripcion());bw.newLine();
        /*
        //falla
        bw.write("#M ");
        bw.write(Integer.toString((int)publications.getMaxCapacity()));
        bw.newLine();
        //por alguna razon imprime M (endl) M <valorReal>
        
        bw.write("#P");bw.newLine();
        List<Long> a = publication.getParticipants();
        for(long id : a){
            bw.write(Long.toString((long) id));bw.write(" ");
        }
        bw.newLine();
        */
    }
    private Publication readEventWithStructure(Scanner bw){
        /*
        Publication event = new Publication();
        
        //leer EventID
        String line = bw.nextLine(); 
        if(!line.equals("#I"))return null;
        line = bw.nextLine();
        event.setEventID(Long.parseLong(line));
        
        //leer TITLE
        line = bw.nextLine();
        if(!"#T".equals(line))return null;
        line = bw.nextLine();
        event.setTitulo(line);
        
        //leer FECHA
        line = bw.nextLine();
        if(!"#F".equals(line))return null;
        line = bw.nextLine();
        String separado[] = line.split(" ");
        LocalDateTime fecha = LocalDateTime.of(Integer.parseInt(separado[0]), Integer.parseInt(separado[1]), Integer.parseInt(separado[1]),0,0);
        event.setFecha(fecha);
        
        //leer Place
        line = bw.nextLine();
        if(!"#PL".equals(line))return null;
        line = bw.nextLine();
        event.setPlace(line);
        
        //leer AutorID
        line = bw.nextLine();
        if(!"#A".equals(line))return null;
        line = bw.nextLine();
        event.setAutorID(Long.valueOf(line));
        
        //leer Description
        line = bw.nextLine();
        if(!"#D".equals(line))return null;
        String description = "";
        
        while(!line.contains("#P")){
            line = bw.nextLine();
            description += line;
            description += "\n";
            
        }
        event.setDescription(description);
        /*
        //leer MaxCapacity
        separado = line.split(" ");
        event.setMaxCapacity(Integer.parseInt(separado[1]));
        */
        //leer inscritos
        /*line = bw.nextLine();
        if(!"#P".equals(line))return null;
        
        line = bw.nextLine();
        List<Long> participants = new ArrayList<>();
        if(line.equals("")){
        }
        else{
            separado = line.split(" ");
            for(String s : separado){
                participants.add(Long.valueOf(s));
            }
        }
        
        event.setParticipants(participants);
        
        
        return event;
        */
        return null;
    }

    

//file structure:
    /*
    #I
    EVENTID
    #T
    TITLE
    #F
    AAAA MM DD
    #PL
    PLACE
    #A
    AUTORID
    #D
    "DESCRIPTION"
    #M
    MAXPARTICIPANTS
    #P
    PARTICIPANTS
    */
    
    
    
    
}
