package com.MuhammadRizkyUtomoJSleepRJ.controller;

import com.MuhammadRizkyUtomoJSleepRJ.Algorithm;
import com.MuhammadRizkyUtomoJSleepRJ.Predicate;
import com.MuhammadRizkyUtomoJSleepRJ.dbjson.JsonTable;
import com.MuhammadRizkyUtomoJSleepRJ.dbjson.Serializable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public interface BasicGetController<T extends Serializable> {
    @GetMapping("/page")
    public default List<T> getPage(
            @RequestParam int page,
            @RequestParam int pageSize
    ) {
        return Algorithm.<T>paginate(getJsonTable(), page, pageSize, predicate -> true);
    }

    @GetMapping("/{id}")
    public default T getById(@PathVariable int id) {
        return Algorithm.<T>find(getJsonTable(), acc -> acc.id == id);
    }

    public abstract JsonTable<T> getJsonTable();
}
