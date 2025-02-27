package Model;



/**
 *
 * @author CARLOS_MIRANDA
 */



public class UserFactory {
    public UserFactory(){
        
    }
    public static User createUser(String type, long id, String usernm,String email, String password, String caree){
        User ret;
        if(type.equals("TEACHER")){
            ret = new Teacher(id,usernm,email,password,caree);
        }
        else{
            ret = new Student(id,usernm,email,password,caree);
        }
        return ret;
    }
}
