package com.MuhammadRizkyUtomoJSleepRJ;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Details the customers' account.
 *
 * @author Muhammad Rizky Utomo
 * @version 01/11/2022
 */
public class Account extends Serializable
{
    public String name = "name";
    public String email = "email";
    public String password = "password";

    public static final String REGEX_EMAIL = "^[A-Za-z0-9]{1,}@{1}[A-Za-z]{1,}[.]{1}.([A-Za-z])$";
    public static final String REGEX_PASSWORD = "[(A-Z){1,}(a-z){1,}(0-9){1,}]{8,}";
    
    public Account(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public boolean validate()
    {
        Pattern emailPattern = Pattern.compile(this.REGEX_EMAIL);
        Pattern passwordPattern = Pattern.compile(this.REGEX_PASSWORD);
        Matcher emailMatch = emailPattern.matcher(this.email);
        Matcher passswordMatch = passwordPattern.matcher(this.password);

        if (!emailMatch.find() || !passswordMatch.find()) {
            return false;
        } else {
            return true;
        }
    }
    
    public String toString() {
        return (
            "Name: " + name + "\n" +
            "Email: " + email + "\n" +
            "Password: " + password + "\n"
        );
    }
}
