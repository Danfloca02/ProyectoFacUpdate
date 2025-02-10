
import Data.DatabaseUsers;
import Model.*;


public class DatabaseUsersTest {
    // Creación de una instancia de DatabaseUsers
    static DatabaseUsers db = DatabaseUsers.GetInstance();
    public static void main(String[] args) {
        
        User user = UserFactory.createUser("STUDENT", 31080238, "CARLOS_11", "Carlos@gmail.com", "O11.2", "COMPUTACION");  
        WriteTest(user);
        //SearchTest(user);
        
        
        // Llamada a métodos de DatabaseUsers o ejecución de pruebas
        
    }
    private static void WriteTest(User user){
        db.createNewUser(user);
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
