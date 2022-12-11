package com.MuhammadRizkyUtomoJSleepRJ;
import com.MuhammadRizkyUtomoJSleepRJ.dbjson.Serializable;

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
    public Renter renter;
    public double balance;

    public static final String REGEX_EMAIL = "^[a-zA-Z0-9 ][a-zA-Z0-9]+@[a-zA-Z.]+?\\.[a-zA-Z]+?$";
    public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";

    /**
     * Constructor of Account.
     * @param name User's name
     * @param email User's email
     * @param password User's password
     */
    public Account(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    /**
     * Validates that the email and password strings are compliant to the required character combinations.
     * @return boolean
     */
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

    /**
     * Returns the name, email, and account information in a string format.
     * @return name, email, password
     */
    public String toString() {
        return (
            "Name: " + name + "\n" +
            "Email: " + email + "\n" +
            "Password: " + password + "\n"
        );
    }
}
