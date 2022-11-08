package com.MuhammadRizkyUtomoJSleepRJ;
import com.MuhammadRizkyUtomoJSleepRJ.dbjson.Serializable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Stores the personal data of a renter.
 *
 * @author Muhammad Rizky Utomo
 * @version 01/11/2022
 */
public class Renter extends Serializable
{
    public String phoneNumber;
    public String address;
    public String username;
    public static final String REGEX_NAME = "^[A-Z][a-z_-]{5,22}$";
    public static final String REGEX_PHONE = "[0-9]{9,12}$";

    public Renter (String username, String phoneNumber, String address)
    {
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.username = username;
    }

    public boolean validate()
    {
        Pattern usernamePattern = Pattern.compile(REGEX_NAME);
        Pattern phoneNumPattern = Pattern.compile(REGEX_PHONE);
        Matcher usernameMatch = usernamePattern.matcher(username);
        Matcher phoneNumMatch = phoneNumPattern.matcher(phoneNumber);

        if (usernameMatch.find() == false || phoneNumMatch.find() == false) {
            return false;
        } else {
            return true;
        }
    }
}
