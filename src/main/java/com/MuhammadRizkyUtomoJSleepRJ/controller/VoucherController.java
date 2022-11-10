package com.MuhammadRizkyUtomoJSleepRJ.controller;

import com.MuhammadRizkyUtomoJSleepRJ.Algorithm;
import com.MuhammadRizkyUtomoJSleepRJ.Price;
import com.MuhammadRizkyUtomoJSleepRJ.Voucher;
import com.MuhammadRizkyUtomoJSleepRJ.dbjson.JsonAutowired;
import com.MuhammadRizkyUtomoJSleepRJ.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/voucher")
public class VoucherController implements BasicGetController<Voucher> {

    @JsonAutowired(value = Voucher.class, filepath = "C:\\Users\\rizky\\Documents\\2022_Praktikum OOP\\JSleep\\src\\json\\voucher.json")
    public static JsonTable<Voucher> voucherTable;

    @Override
    public JsonTable<Voucher> getJsonTable() {
        return voucherTable;
    }

    @GetMapping("{id}/isUsed")
    boolean isUsed(@PathVariable int id) {
        Voucher voucher = getById(id);
        return voucher.isUsed();
    }

    @GetMapping("{id}/canApply")
    boolean canApply (
            @PathVariable int id,
            @RequestParam double price
    ) {
        Voucher voucher = getById(id);
        return voucher.canApply(new Price(price));
    }

    @GetMapping("{id}/getAvailable")
    List<Voucher> getAvailable(int page, int pageSize) {
        return Algorithm.<Voucher>paginate(getJsonTable(), page, pageSize, vou -> vou.isUsed() == false);
    }
}
