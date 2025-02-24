package Model;


/**
 *
 * @author CARLOS_MIRANDA
 */



public abstract class User {
    
    public String userName;
    public long ID;
    public String Password;
    public String Email;
    public Career Kareer;

    public User() {
    }
    
    public User(long id,String usernm, String email, String password, String caree){
        ID = id;
        userName = usernm;
        Password = password;
        Email = email;
        for(Career career : Career.values()){
            if(career.name().equals(caree)){
                Kareer = career;
                break;
            }
        }
    }
}

