package com.MuhammadRizkyUtomoJSleepRJ.controller;

import com.MuhammadRizkyUtomoJSleepRJ.*;
import com.MuhammadRizkyUtomoJSleepRJ.dbjson.JsonAutowired;
import com.MuhammadRizkyUtomoJSleepRJ.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;
import com.MuhammadRizkyUtomoJSleepRJ.controller.AccountController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment>{
    @JsonAutowired(value= Payment.class,filepath="C:/Users/rizky/Documents/2022_Praktikum OOP/JSleep/src/json/account.json")
    public static JsonTable<Payment> paymentTable;
    @Override
    public JsonTable<Payment> getJsonTable() {
        return paymentTable;
    }

    @PostMapping("/{id}/accept")
    public boolean accept (@PathVariable int id) {
        Payment payment = Algorithm.<Payment>find(getJsonTable(),pred -> pred.id == id);
        if(payment.status ==  Invoice.PaymentStatus.WAITING){
            payment.status =  Invoice.PaymentStatus.SUCCESS;
            return true;
        }
        return false;
    }

    @PostMapping("/{id}/cancel")
    public boolean cancel (@PathVariable int id) {
        Payment payment = Algorithm.<Payment>find(getJsonTable(),pred -> pred.id == id);
        if(payment.status ==  Invoice.PaymentStatus.WAITING){
            Account findAccount = Algorithm.<Account>find(AccountController.accountTable, pred -> pred.id == payment.buyerId);
            Room findRoom = Algorithm.<Room>find(RoomController.roomTable, pred -> pred.id == payment.getRoomId());
            payment.status =  Invoice.PaymentStatus.FAILED;
            findAccount.balance += findRoom.price.price;
            return true;
        }
        return false;
    }

    @PostMapping("/create")
    public Payment create (@RequestParam int buyerId,
                           @RequestParam int renterId,
                           @RequestParam int roomId,
                           @RequestParam String from,
                           @RequestParam String to) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fromDate = sdf.parse(from);
        Date toDate = sdf.parse(to);
        Account findAccount = Algorithm.<Account>find(AccountController.accountTable, pred -> pred.id == buyerId);
        Room findRoom = Algorithm.<Room>find(RoomController.roomTable, pred -> pred.id == roomId);
        if (findAccount != null && findRoom != null){
            double totalPrice = findRoom.price.price;
            if (findAccount.balance >= totalPrice && Payment.availability(fromDate, toDate, findRoom)){
                Payment currentPayment = new Payment(buyerId, renterId, roomId, fromDate, toDate);
                findAccount.balance -= findRoom.price.price;
                currentPayment.status = Invoice.PaymentStatus.WAITING;
                paymentTable.add(currentPayment);
                return currentPayment;
            }
        }
        return null;
    }
}
