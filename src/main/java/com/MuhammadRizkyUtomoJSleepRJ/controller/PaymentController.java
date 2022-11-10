package com.MuhammadRizkyUtomoJSleepRJ.controller;

import com.MuhammadRizkyUtomoJSleepRJ.*;
import com.MuhammadRizkyUtomoJSleepRJ.dbjson.JsonAutowired;
import com.MuhammadRizkyUtomoJSleepRJ.dbjson.JsonTable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

public class PaymentController implements BasicGetController<Payment>{
    @JsonAutowired(value = Payment.class, filepath = "C:\\Users\\rizky\\Documents\\2022_Praktikum OOP\\JSleep\\src\\json\\payment.json")
    public static JsonTable<Payment> paymentTable;

    public JsonTable<Payment> getJsonTable() {
        return paymentTable;
    }

    @GetMapping("/create")
    public Payment create(
            @RequestParam int buyerId,
            @RequestParam int renterId,
            @RequestParam int roomId,
            @RequestParam String from,
            @RequestParam String to
    ) throws ParseException {
        Iterable<Account> iterableAcc = AccountController.accountTable;
        Iterable<Room> iterableRoom = RoomController.roomTable;

        while (iterableAcc.iterator().hasNext()) {
            Account checkedAcc = iterableAcc.iterator().next();
            if (checkedAcc.id == buyerId) {
                while (iterableAcc.iterator().hasNext()) {
                    Room checkedRoom = iterableRoom.iterator().next();
                    if (checkedRoom.id == roomId) {
                        if (checkedAcc.balance >= checkedRoom.price.price) {
                            SimpleDateFormat sdf = new SimpleDateFormat();
                            Date fromDate = sdf.parse(from);
                            Date toDate = sdf.parse(to);

                            Payment payment = new Payment(buyerId, renterId, roomId, fromDate, toDate);
                            if (Payment.availability(fromDate, toDate, checkedRoom) == true) {
                                checkedAcc.balance = checkedRoom.price.price;
                                payment.status = Invoice.PaymentStatus.WAITING;
                                Payment.makeBooking(fromDate, toDate, checkedRoom);
                                paymentTable.add(payment);
                            }


                        }
                    }
                }
            }
        }
        return null;
    }

    @PostMapping("/id/accept")
    public boolean accept(int id){
        Payment payment = Algorithm.<Payment>find(getJsonTable(), acc -> acc.id == id);
        if (payment == null) {
            if (payment.status == Invoice.PaymentStatus.WAITING) {
                payment.status = Invoice.PaymentStatus.SUCCESS;
                return true;
            }
        }
        return false;
    }

    @PostMapping("/id/cancel")
    public boolean cancel(int id){
        Payment payment = Algorithm.<Payment>find(getJsonTable(), acc -> acc.id == id);
        if (payment == null) {
            if (payment.status == Invoice.PaymentStatus.WAITING) {
                Account account = Algorithm.<Account>find(AccountController.accountTable, acc -> acc.id == payment.buyerId);
                Room room = Algorithm.<Room>find(RoomController.roomTable, acc -> acc.id == payment.getRoomId());
                payment.status = Invoice.PaymentStatus.FAILED;
                account.balance += room.price.price;
                return true;
            }
        }
        return false;
    }
}
