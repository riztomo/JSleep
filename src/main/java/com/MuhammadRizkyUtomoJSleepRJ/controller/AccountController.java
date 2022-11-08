package com.MuhammadRizkyUtomoJSleepRJ.controller;

import com.MuhammadRizkyUtomoJSleepRJ.Account;
import com.MuhammadRizkyUtomoJSleepRJ.Renter;
import com.MuhammadRizkyUtomoJSleepRJ.dbjson.JsonAutowired;
import com.MuhammadRizkyUtomoJSleepRJ.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account>
{
    @JsonAutowired(value = Account.class, filepath ="C:\\Users\\rizky\\Documents\\2022_Praktikum OOP\\JSleep\\src\\json\\account.json")
    public static JsonTable<Account> accountTable;
    public static final String REGEX_PASSWORD = "[(A-Z){1,}(a-z){1,}(0-9){1,}]{8,}";
    public static final Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);
    public static final String REGEX_EMAIL = "^[A-Za-z0-9]{1,}@{1}[A-Za-z]{1,}[.]{1}.([A-Za-z])$";
    public static final Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);

    /*@GetMapping
    String index() { return "account page"; }
    */
    @PostMapping("/register")
    Account register
            (
                    @RequestParam String name,
                    @RequestParam String email,
                    @RequestParam String password
            ) {
        Matcher emailMatch = REGEX_PATTERN_EMAIL.matcher(email);
        Matcher passwordMatch = REGEX_PATTERN_PASSWORD.matcher(password);

        if (name.isBlank() || emailMatch.find() == false || passwordMatch.find() == false) {
            return null;
        } else {
            Iterable<Account> iterableAccount = accountTable;
            Iterator<Account> iteratorAcc = iterableAccount.iterator();

            while (iteratorAcc.hasNext()) {
                Account check = iteratorAcc.next();
                if (check.email == email) {
                    return null;
                }
            }
            return new Account(name, email, password);
        }

    }

    public JsonTable<Account> getJsonTable() {
        return accountTable;
    }

    @PostMapping("/login")
    Account login
            (
            @RequestParam String email,
            @RequestParam String password
    ) {
        Iterable<Account> iterableAccount = accountTable;
        Iterator<Account> iteratorAcc = iterableAccount.iterator();

        while (iteratorAcc.hasNext()) {
            Account check = iteratorAcc.next();
            if (check.email == email && check.password == password) {
                return check;
            }
        }
        return null;
    }

    @PostMapping("/{id}/registerRenter")
    Renter registerRenter (
            @PathVariable int id,
            @RequestParam String username,
            @RequestParam String address,
            @RequestParam String phoneNumber
    ) {
        Iterable<Account> iterableAccount = accountTable;
        Iterator<Account> iteratorAcc = iterableAccount.iterator();

        while (iteratorAcc.hasNext()) {
            Account check = iteratorAcc.next();
            if (check.id == id) {
                if (check.renter == null) {
                    return new Renter(username, phoneNumber, address);
                } else { return null; }
            }
        }
        return null;
    }
    @PostMapping("/{id}//topUp")
    boolean topUp(@PathVariable int id, @RequestParam double balance) {
        Iterable<Account> iterableAccount = accountTable;
        Iterator<Account> iteratorAcc = iterableAccount.iterator();

        while (iteratorAcc.hasNext()) {
            Account check = iteratorAcc.next();
            if (check.id == id) {
                check.balance = balance;
                return true;
            }
        }
        return false;
    }
}
