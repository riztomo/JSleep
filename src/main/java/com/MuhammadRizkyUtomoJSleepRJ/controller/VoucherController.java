package com.MuhammadRizkyUtomoJSleepRJ.controller;

import com.MuhammadRizkyUtomoJSleepRJ.Algorithm;
import com.MuhammadRizkyUtomoJSleepRJ.Price;
import com.MuhammadRizkyUtomoJSleepRJ.Voucher;
import com.MuhammadRizkyUtomoJSleepRJ.dbjson.JsonAutowired;
import com.MuhammadRizkyUtomoJSleepRJ.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/voucher")
public class VoucherController implements BasicGetController<Voucher>{
    @JsonAutowired(value = Voucher.class, filepath = "C:/Users/rizky/Documents/2022_Praktikum OOP/JSleep/src/json/voucher.json")
    public static JsonTable<Voucher> voucherTable;
    @Override
    public JsonTable<Voucher> getJsonTable() {return voucherTable;}

    @GetMapping("/{id}/isUsed")
    boolean isUsed(@PathVariable int id){
        Voucher findVoucher = Algorithm.<Voucher>find(getJsonTable(), pred -> pred.id == id);
        return findVoucher.isUsed();
    }

    @GetMapping("/{id}/canApply")
    boolean canApply(
            @PathVariable int id,
            @RequestParam double price
    ){
        Voucher findVoucher = Algorithm.<Voucher>find(getJsonTable(), pred -> pred.id == id);
        return findVoucher.canApply(new Price(price));
    }

    @GetMapping("/getAvailable")
    List<Voucher> getAvailable(
            @RequestParam int page,
            @RequestParam int pageSize
    ){
        ArrayList<Voucher> voucherList = new ArrayList<>();
        for (Voucher voucher : getJsonTable()){
            if (!voucher.isUsed()){
                voucherList.add(voucher);
            }
        }
        return Algorithm.<Voucher>paginate(voucherList, page, pageSize, pred -> true);
    }
}
