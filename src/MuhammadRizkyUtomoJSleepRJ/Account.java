package MuhammadRizkyUtomoJSleepRJ;


/**
 * Write a description of class Account here.
 *
 * @author Muhammad Rizky Utomo
 * @version 04/10/2022
 */
public class Account extends Serializable
{
    public String name;
    public String email;
    public String password;
    
    public Account(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
    
    public String toString() {
        return (
            "Name: " + name + "\n" +
            "Email: " + email + "\n" +
            "Password: " + password + "\n"
        );
    }
    
    public Object write() {
        return null;
    }
    
    public boolean read(String a) {
        return false;
    }
}
