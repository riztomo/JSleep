package com.MuhammadRizkyUtomoJSleepRJ.controller;

import com.MuhammadRizkyUtomoJSleepRJ.*;
import com.MuhammadRizkyUtomoJSleepRJ.dbjson.JsonAutowired;
import com.MuhammadRizkyUtomoJSleepRJ.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController implements BasicGetController<Room> {

    @JsonAutowired(value = Room.class, filepath = "C:\\Users\\rizky\\Documents\\2022_Praktikum OOP\\JSleep\\src\\json\\room.json")
    public static JsonTable<Room> roomTable;

    public RoomController() {

    }

    @Override
    public JsonTable<Room> getJsonTable() {
        return roomTable;
    }

    @GetMapping("/{id}/renter")
    List<Room> getRoomByRenter
            (
                @PathVariable int id, @PathVariable int page, @PathVariable int pageSize
            ) {
        return Algorithm.<Room>paginate(getJsonTable(), page, pageSize, room -> room.accountId == id);
    }

    @PostMapping("/create")
    public Room create(
            @RequestParam int accountId,
            @RequestParam String name,
            @RequestParam int size,
            @RequestParam int price,
            @RequestParam Facility facility,
            @RequestParam City city,
            @RequestParam String address
            ) {



        Iterable<Account> iterableRoom = AccountController.accountTable;
        Iterator<Account> iteratorRoom = iterableRoom.iterator();

        while (iteratorRoom.hasNext()) {
            Account checked = iteratorRoom.next();

            if (checked.id == accountId && checked.renter != null) {
                return null;
            }
        }

        return new Room(accountId, name, size, new Price(price), facility, city, address);
    }
}
