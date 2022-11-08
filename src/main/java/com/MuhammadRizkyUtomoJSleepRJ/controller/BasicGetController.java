package com.MuhammadRizkyUtomoJSleepRJ.controller;

import com.MuhammadRizkyUtomoJSleepRJ.Algorithm;
import com.MuhammadRizkyUtomoJSleepRJ.Predicate;
import com.MuhammadRizkyUtomoJSleepRJ.dbjson.JsonTable;
import com.MuhammadRizkyUtomoJSleepRJ.dbjson.Serializable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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

    public JsonTable<T> getJsonTable();
}
