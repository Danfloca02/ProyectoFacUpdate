package Data;



/**
 *
 * @author CARLOS_MIRANDA
 */

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class FileGestor {
    public FileGestor(){
        
    }
    public File openFile(String path){
        //opens the file, and create it if doesn't exist 
        File file = new File(path);
        try{
            if(file.createNewFile()){
                
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return file;
    }
    public BufferedReader getBufferedReader(String path, boolean mode) throws IOException{
        //return a bufferedReader with the path specified
        File rd = openFile(path);
        BufferedReader rt = new BufferedReader(new FileReader(rd));
        return rt;
    }
    public BufferedWriter getBufferedWriter(String path, boolean mode) throws IOException{
        //return a bufferedReader with the path specified
        File rd = openFile(path);
        BufferedWriter rt = new BufferedWriter(new FileWriter(path, mode));
        return rt;
    }
    public Scanner getScanner(String path) throws IOException{
        File rd = openFile(path);
        return (new Scanner(rd));
    }
    public void CleanFile(String path) throws IOException{
        FileWriter fw = new FileWriter(path, false);
        fw.write("");       
    }
    
}


/*
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CopiarImagen {
    public static void copiarImagenConNuevoNombre(String rutaLocal, String idPublicacion) {
        Path origenPath = Paths.get(rutaLocal);
        Path destinoPath = Paths.get("./IMAGENES/" + idPublicacion + ".jpg");

        try {
            // Crear el directorio si no existe
            File directorioDestino = new File("./IMAGENES/");
            if (!directorioDestino.exists()) {
                directorioDestino.mkdirs();
            }

            // Copiar el archivo de origen al destino
            Files.copy(origenPath, destinoPath);
            System.out.println("Imagen copiada con éxito a " + destinoPath.toString());
        } catch (IOException e) {
            System.err.println("Error al copiar la imagen: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        String rutaLocal = "C:/ruta/a/tu/imagen.jpg";
        String idPublicacion = "12345";
        copiarImagenConNuevoNombre(rutaLocal, idPublicacion);
    }
}

*/
