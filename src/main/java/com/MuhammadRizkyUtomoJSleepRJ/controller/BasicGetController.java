package com.MuhammadRizkyUtomoJSleepRJ.controller;

import com.MuhammadRizkyUtomoJSleepRJ.Algorithm;
import com.MuhammadRizkyUtomoJSleepRJ.Predicate;
import com.MuhammadRizkyUtomoJSleepRJ.dbjson.JsonTable;
import com.MuhammadRizkyUtomoJSleepRJ.dbjson.Serializable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public interface BasicGetController<T extends Serializable> {
    /**
     * Gets a list of Objects.
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/page")
    public default List<T> getPage(
            @RequestParam int page,
            @RequestParam int pageSize
    ) {
        return Algorithm.<T>paginate(getJsonTable(), page, pageSize, predicate -> true);
    }

    /**
     * Finds an instance of an Object from its ID.
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public default T getById(@PathVariable int id) {
        return Algorithm.<T>find(getJsonTable(), acc -> acc.id == id);
    }

    /**
     * Gets a table from a JSON file.
     * @return
     */
    public abstract JsonTable<T> getJsonTable();
}
