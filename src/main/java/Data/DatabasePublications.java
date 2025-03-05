package Data;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author CARLOS_MIRANDA
 */



import Model.Comment;
import Model.Publication;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.io.BufferedWriter;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.LocalTime;
import javax.imageio.ImageIO;




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
    public Publication createNewPublication(Publication publication){
        List<Publication> publications =  getPublicationList();
        
        long id = 0;
        if(!publications.isEmpty()){
            id = publications.get(publications.size() - 1).getPUBLICATION_ID();
        }
        
        id++;
        publication.setPUBLICATION_ID(id);
        
        String newPath = SaveImage(publication.getImage_path(), publication.getPUBLICATION_ID());
        publication.setImage_path(newPath);
        /*
        CODIGO QUE COPIE LA IMAGEN A LA DIRECCION ./IMAGENES/
        Y QUE LE DE UN NUEVO NOMBRE QUE SEA EL ID DE LA PUBLICACION
        */
        
        
        publications.add(publication);
        savePublications(publications);
        return publication;           
    }
    private String SaveImage(String OriginPath, long publicationID) {
        File sourceFile = new File(OriginPath);
        String destinationDirectory = "Images/";
        String newFileName = publicationID + ".png";
        String pathDestiny = destinationDirectory + newFileName;

        // Verificar si el archivo de origen existe
        if (!sourceFile.exists()) {
            System.out.println("La imagen de origen no existe.");
            return null;
        }

        try {
            // Leer la imagen de origen
            BufferedImage image = ImageIO.read(sourceFile);
            if (image == null) {
                System.out.println("El archivo de origen no es una imagen válida.");
                return null;
            }

            // Crear el directorio de destino si no existe
            Files.createDirectories(Paths.get(destinationDirectory));

            // Escribir la imagen en el destino como PNG
            File destinationFile = new File(pathDestiny);
            ImageIO.write(image, "png", destinationFile);

            System.out.println("Imagen guardada en: " + pathDestiny);
            return pathDestiny;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        
    }
    private void deleteImage(Long ID){
        String path = "Images/" + Long.toString(ID) + ".png";
        File sourceFile = new File(path);
        if(sourceFile.exists()){
            sourceFile.delete();
        }
    }
    public boolean deletePublication (Long PublicationID){
        List<Publication> publications = this.getPublicationList();
        boolean found = false;
        for(Publication publication : publications){
            if(PublicationID == publication.getPUBLICATION_ID()){
                publications.remove(publication);
                found = true;
                break;
            }
        }
        deleteImage(PublicationID);
        savePublications(publications);
        return found;
        
    }
    public boolean ModifyPublication(Long PublicationID, Publication newData){
        List<Publication> publications = this.getPublicationList();
        boolean found = false;
        for(int i = 0; i < publications.size(); i++){
            if(PublicationID.equals(publications.get(i).getPUBLICATION_ID())){
                publications.set(i, newData);
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
                
                ret.add(readWithStructure(br));
                
                
            }
            
        }catch (IOException e) {
            System.err.println("Esto no deberia fallar, y fallo");
        }
        
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
                writeWithStructure(event);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    private void writeWithStructure(Publication publication) throws IOException{
        //escribir los datos iniciales
        try(BufferedWriter bw = filegestor.getBufferedWriter(path, true)){
            bw.write(Long.toString(publication.getPUBLICATION_ID()));
            bw.newLine();
            bw.write(Long.toString(publication.getAUTOR_ID()));
            bw.newLine();
            bw.write("<\n");
            bw.write(publication.getText());
            bw.write("\n>\n");
            LocalDateTime fech = publication.getDate();
            String fecha = Integer.toString(fech.getYear()) + " " + Integer.toString(fech.getMonthValue()) + " " + Integer.toString(fech.getDayOfMonth());
            bw.write(fecha);
            bw.newLine();
            bw.write(publication.getImage_path());
            bw.newLine();
        }catch(IOException e){
            e.printStackTrace();
        }
        //escribir likes y comentarios
        try(BufferedWriter bw = filegestor.getBufferedWriter(path, true)){
            //escribir los likes
            
            bw.write(Integer.toString(publication.getLikes()));
            bw.newLine();
            if(publication.getLikes() > 0){
                List<Long> a = publication.getUsersWhoReacted();
                for(long id : a){
                    bw.write(Long.toString(id));
                    bw.write(" ");
                }
                bw.newLine();
            }
            
            
            //escribir los comentarios
            List<Comment> comments = publication.getComments();
            int commentsSize = comments.size();
            bw.write(Integer.toString(commentsSize));
            bw.newLine();
            for(Comment com : comments){
                String line = Long.toString(com.getAutorID());
                bw.write(line);
                bw.newLine();
                bw.write("<\n");
                line = com.getText();
                bw.write(line);
                bw.write("\n>\n");                
            }
        }catch(IOException e){
            e.printStackTrace();
        }       
    }
    private Publication readWithStructure(Scanner scan){
        if(!scan.hasNext())return null;
        Publication ret = new Publication();
        
        long aux = scan.nextLong();
        ret.setPUBLICATION_ID(aux);
        aux = scan.nextLong();
        ret.setAUTOR_ID(aux);
        scan.nextLine(); // consume la linea
        
        StringBuilder descripcion = new StringBuilder();
        if (scan.next().equals("<")) {
            while (scan.hasNext()) {
                String linea = scan.nextLine();
                if (linea.contains(">")) {
                    break;
                }
                descripcion.append(linea);
            }
        }
        ret.setText(descripcion.toString());
        
        int aux2 = scan.nextInt();
        int aux3 = scan.nextInt();
        int aux4 = scan.nextInt();
        ret.setDate(LocalDateTime.of(aux2,aux3,aux4, 0,0));
        
        scan.nextLine();
        
        ret.setImage_path(scan.nextLine());
        
        //leer los likes
        aux2 = scan.nextInt();
        List<Long> uwl = new ArrayList<>();
        if(aux2>0){
            for(int i = 0; i < aux2; i++){
                aux = scan.nextLong();
                uwl.add(aux);
            }  
        }
        
        ret.setLikes(aux2);
        ret.setUsersWhoReacted(uwl);
        
        
        //leer los comentarios
        aux2 = scan.nextInt();
        List<Comment> comentarios = new ArrayList<>();
        if(aux2 > 0){
            for(int i = 0; i < aux2; i++){
                Comment Caux = new Comment();
                Caux.setAutorID(scan.nextLong());
                //se lee el contenido del comentario
                StringBuilder Cdescripcion = new StringBuilder();
                if (scan.next().equals("<")) {
                    while (scan.hasNext()) {
                        String linea = scan.nextLine();
                        if (linea.contains(">")) {
                            Cdescripcion.append(linea, 0, linea.indexOf(">"));
                            break;
                        }
                        Cdescripcion.append(linea);
                    }
                }
                Caux.setText(Cdescripcion.toString());
            
                //se aniade el comentario
                comentarios.add(Caux);
            }
        }
        else{
            scan.nextLine();
        }
        
        ret.setComments(comentarios);
        
        return ret;
    }

    

//file structure:
    /*
    Publication ID <long>
    Autor ID <long>
    <
    descripcion <string> (esta entre < > y puede tener varias lineas
    >
    AAAA MM DD <string>
    imagepath <strign>
    NumberOfLikes
    list of UsersIDWhoLiked
    NumberOfComments
    list of Comments
    (each comment is Comment Autor ID
                    <
                    text
                    >
    )
    */
    
    
    
    
}
