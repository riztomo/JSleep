package com.MuhammadRizkyUtomoJSleepRJ.controller;

import com.MuhammadRizkyUtomoJSleepRJ.*;
import com.MuhammadRizkyUtomoJSleepRJ.dbjson.JsonAutowired;
import com.MuhammadRizkyUtomoJSleepRJ.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController implements BasicGetController<Room>{
    @JsonAutowired(value = Room.class, filepath = "C:/Users/rizky/Documents/2022_Praktikum OOP/JSleep/src/json/account.json")
    public static JsonTable<Room> roomTable;
    @Override
    public JsonTable<Room> getJsonTable() {return roomTable;}

    @GetMapping("/{id}/renter")
    List<Room> getRoomByRenter(
            @PathVariable int id,
            @RequestParam int page,
            @RequestParam int pageSize
    ){
        return Algorithm.<Room>paginate(getJsonTable(), page, pageSize, pred -> pred.accountId == id);
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
    ){
        Price currentPrice = new Price(price);
        Account findAccount = Algorithm.<Account>find(AccountController.accountTable, pred -> pred.id == accountId);
        if(findAccount.renter != null){
            Room currentRoom = new Room(accountId, name, size, currentPrice, facility, city, address);
            roomTable.add(currentRoom);
            return currentRoom;
        }
        return null;
    }

    @GetMapping("/getAllRoom")
    public List<Room> getAllRoom(
            @RequestParam int page,
            @RequestParam int pageSize
    ){
        return Algorithm.<Room>paginate(roomTable, page, pageSize, pred -> true);
    }
}
