package com.MuhammadRizkyUtomoJSleepRJ.controller;

import com.MuhammadRizkyUtomoJSleepRJ.*;
import com.MuhammadRizkyUtomoJSleepRJ.dbjson.JsonAutowired;
import com.MuhammadRizkyUtomoJSleepRJ.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Controls Room management.
 *
 * @author Muhammad Rizky Utomo
 * @version 11/12/2022
 */

@RestController
@RequestMapping("/room")
public class RoomController implements BasicGetController<Room>{
    @JsonAutowired(value = Room.class, filepath = "C:/Users/rizky/Documents/2022_Praktikum OOP/JSleep/src/json/room.json")
    public static JsonTable<Room> roomTable;

    /**
     * Gets the room table in JSON format.
     * @return JsonTable<Room>
     */
    @Override
    public JsonTable<Room> getJsonTable() {return roomTable;}

    /**
     * Gets a specified amount of room with a specific ID.
     * @param id
     * @param page
     * @param pageSize
     * @return List<Room>
     */
    @GetMapping("/{id}/renter")
    List<Room> getRoomByRenter(
            @PathVariable int id,
            @RequestParam int page,
            @RequestParam int pageSize
    ){
        return Algorithm.<Room>paginate(getJsonTable(), page, pageSize, pred -> pred.accountId == id);
    }

    /**
     * Creates a room.
     * @param accountId Buyer's account ID.
     * @param name Room's
     * @param size Room's
     * @param price Room's
     * @param facility Room's
     * @param city Room's
     * @param address Room's
     * @param bedType Room's
     * @return Room
     */
    @PostMapping("/create")
    public Room create(
            @RequestParam int accountId,
            @RequestParam String name,
            @RequestParam int size,
            @RequestParam int price,
            @RequestParam ArrayList<Facility> facility,
            @RequestParam City city,
            @RequestParam String address,
            @RequestParam BedType bedType
    ){
        Price currentPrice = new Price(price);
        Account findAccount = Algorithm.<Account>find(AccountController.accountTable, pred -> pred.id == accountId);
        if(findAccount.renter != null){
            Room currentRoom = new Room(accountId, name, size, currentPrice, facility, city, address, bedType);
            roomTable.add(currentRoom);
            return currentRoom;
        }
        return null;
    }

    /**
     * Gets a specified amount of available room.
     * @param page
     * @param pageSize
     * @return List<Room>
     */
    @PostMapping("/getAllRoom")
    public List<Room> getAllRoom(
            @RequestParam int page,
            @RequestParam int pageSize
    ){
        return Algorithm.<Room>paginate(roomTable, page, pageSize, pred -> true);
    }
}
