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
import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment>{
    @JsonAutowired(value= Payment.class,filepath="C:/Users/rizky/Documents/2022_Praktikum OOP/JSleep/src/json/payment.json")
    public static JsonTable<Payment> paymentTable;

    /**
     * Gets the payment table in JSON format.
     * @return JsonTable<Payment>
     */
    @Override
    public JsonTable<Payment> getJsonTable() {
        return paymentTable;
    }

    /**
     * Confirms a payment.
     * @param id
     * @return boolean
     */
    @PostMapping("/{id}/accept")
    public boolean accept (@PathVariable int id) {
        Payment payment = Algorithm.<Payment>find(getJsonTable(),pred -> pred.id == id);
        if(payment.status ==  Invoice.PaymentStatus.WAITING){
            payment.status =  Invoice.PaymentStatus.SUCCESS;
            return true;
        }
        return false;
    }

    /**
     * Cancels a payment.
     * @param id
     * @return boolean
     */
    @PostMapping("/{id}/cancel")
    public boolean cancel (@PathVariable int id) {
        Payment payment = Algorithm.<Payment>find(getJsonTable(),pred -> pred.id == id);
        if(payment.status ==  Invoice.PaymentStatus.WAITING){
            payment.status = Invoice.PaymentStatus.FAILED;
            return true;
        }
        return false;
    }

    /**
     * Creates a payment from a room.
     * @param buyerId
     * @param renterId
     * @param roomId
     * @param from
     * @param to
     * @return Payment
     * @throws ParseException
     */
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
            if (findAccount.balance >= totalPrice && Payment.availability(fromDate, toDate, findRoom)) {
                findAccount.balance -= findRoom.price.price;
                Payment currentPayment = new Payment(buyerId, renterId, roomId, fromDate, toDate);
                currentPayment.status = Invoice.PaymentStatus.WAITING;
                paymentTable.add(currentPayment);
                System.out.println(paymentTable);
                return currentPayment;
            } else {
                System.out.println(findAccount.balance); System.out.println(totalPrice); System.out.println(fromDate); System.out.println(toDate); System.out.println(findRoom);

                System.out.print("Failed in 2nd");
            }
        } else {
            System.out.print("Failed in 1nd");
        }
        return null;
    }

    /**
     * Gets all payments from an account ID.
     * @param accountId
     * @return List<Payment>
     */
    @PostMapping("/getPayments")
    public List<Payment> getAllPayments(
            @RequestParam int accountId
    ){
        return Algorithm.<Payment>collect(getJsonTable(), pred -> pred.buyerId == accountId);
    }
}
