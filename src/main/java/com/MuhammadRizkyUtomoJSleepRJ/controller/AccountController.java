package com.MuhammadRizkyUtomoJSleepRJ.controller;

import com.MuhammadRizkyUtomoJSleepRJ.Account;
import com.MuhammadRizkyUtomoJSleepRJ.Algorithm;
import com.MuhammadRizkyUtomoJSleepRJ.Renter;
import com.MuhammadRizkyUtomoJSleepRJ.dbjson.JsonAutowired;
import com.MuhammadRizkyUtomoJSleepRJ.dbjson.JsonTable;

import org.springframework.web.bind.annotation.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account>
{
    public static @JsonAutowired(value=Account.class,filepath="C:/Users/rizky/Documents/2022_Praktikum OOP/JSleep/src/json/account.json") JsonTable<Account> accountTable;
    public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
    public static final Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);
    public static final String REGEX_EMAIL = "^[a-zA-Z0-9 ][a-zA-Z0-9]+@[a-zA-Z.]+?\\.[a-zA-Z]+?$";
    public static final Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);

    /**
     * Gets the account table in JSON format.
     * @return JsonTable<Account>
     */
    @Override
    public JsonTable<Account> getJsonTable() {
        return accountTable;
    }

    /**
     * Registers an account.
     * @param name
     * @param email
     * @param password
     * @return Account
     */
    @PostMapping("/register")
    Account register(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String password
    ) {
        final String generatedPass;
        Matcher matcher_email = REGEX_PATTERN_EMAIL.matcher(email);
        Matcher matcher_password = REGEX_PATTERN_PASSWORD.matcher(password);
        Account findEmail = Algorithm.<Account>find(accountTable, pred -> pred.email.equals(email));

        if(matcher_email.find() && matcher_password.find() && !name.isBlank() && findEmail == null){
            generatedPass = hashPassword(password);
            Account account = new Account(name, email, generatedPass);
            accountTable.add(account);
            return account;
        }
        return null;
    }

    /**
     * Logs into an account.
     * @param email
     * @param password
     * @return Account
     */
    @PostMapping("/login")
    Account login(
            @RequestParam String email,
            @RequestParam String password
    ) {
        final String generatedPass = hashPassword(password);
        return Algorithm.<Account>find(accountTable, pred -> Objects.equals(pred.email, email) && Objects.equals(pred.password, generatedPass));
    }

    /**
     * Registers renter's details from an account.
     * @param id
     * @param name
     * @param address
     * @param phoneNumber
     * @return Renter
     */
    @PostMapping("/{id}/registerRenter")
    Renter registerRenter(
            @PathVariable int id,
            @RequestParam String name,
            @RequestParam String address,
            @RequestParam String phoneNumber
    ) { Account test = Algorithm.<Account>find(getJsonTable(), pred -> pred.id == id);
        if(test.renter == null){
            test.renter = new Renter(name, address, phoneNumber);
            return test.renter;
        }
        return null;
    }

    /**
     * Top-ups an account's balance
     * @param id
     * @param balance
     * @return boolean
     */
    @PostMapping("/{id}/topUp")
    boolean topUp
            (
                    @PathVariable int id,
                    @RequestParam double balance
            )
    {
        Account account = Algorithm.<Account>find(getJsonTable(), pred -> pred.id == id);
        if(account != null && balance > 0){
            account.balance += balance;
            return true;
        }
        return false;
    }

    /**
     * Converts a password to its hashed variant.
     * @param password
     * @return String
     */
    private static String hashPassword(String password){
        String hashedPass = null;
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte aByte : bytes) {
                sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }
            hashedPass = sb.toString();
        }catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return hashedPass;
    }
}

