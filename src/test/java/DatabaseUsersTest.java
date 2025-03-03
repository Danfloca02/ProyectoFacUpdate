
import Data.DatabaseUsers;
import Model.*;


public class DatabaseUsersTest {
    // Creación de una instancia de DatabaseUsers
    static DatabaseUsers db = DatabaseUsers.GetInstance();
    public static void main(String[] args) {
        
        User user = UserFactory.createUser("STUDENT", 14861479, "Yarlin_brito", "yarlinbrito@gmail.com", "Yarlin.123", "COMPUTACION");  
        WriteTest(user);
        //SearchTest(user);
        
        
        // Llamada a métodos de DatabaseUsers o ejecución de pruebas
        
    }
    private static void WriteTest(User user){
        System.out.println(db.createNewUser(user));
    }
    private static void SearchTest(User user){
        boolean b = !(db.userSearchByEMAIL(user.Email) == null);
        System.out.println(b);
        b = !(db.userSearchByUSERNAME(user.userName) == null);
        System.out.println(b);
        b = !(db.userSearchByID(user.ID) == null);
        System.out.println(b);
    }
}
