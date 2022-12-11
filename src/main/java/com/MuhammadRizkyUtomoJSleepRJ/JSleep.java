package com.MuhammadRizkyUtomoJSleepRJ;
import java.io.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.io.File;
import java.io.FileWriter;

import com.MuhammadRizkyUtomoJSleepRJ.dbjson.JsonDBEngine;
import com.google.gson.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Location of the 'main' method.
 *
 * @author Muhammad Rizky Utomo
 * @version 01/11/2022
 */

/** Place of running (and testing) */
@SpringBootApplication
public class JSleep
{
    /* class Country {
        public String name;
        public int population;
        public List<String> listOfStates;
    }*/
    public static void main(String[] args) {

        /*SpringApplication.run(JSleep.class, args);*/

        JsonDBEngine.Run(JSleep.class);
        SpringApplication.run(JSleep.class, args);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> JsonDBEngine.join()));

        /*Room roomEx = createRoom();
        System.out.println(roomEx.name);
        System.out.println(roomEx.size);
        System.out.println(roomEx.price.price);
        System.out.println(roomEx.facility);*/
        
        /*Payment testRoom = new Payment(1, 1, 1, "", 1, "", "");
        Invoice testInvoice = new Invoice(2, 2, 2, "");
        System.out.println(testRoom.print());
        System.out.println(testInvoice.print());*/
        
        /* Complaint testComplain = new Complaint(1, "23 August 2022", "Bad Quality");
        Price testPrice = new Price(100000, 20000);
        Room testRoom = new Room(1, "Presidential Suite", 5, testPrice,
        Facility.FitnessCenter, City.DEPOK, "JL. Margonda Raya");
        Account testAccount = new Account(1, "Bob", "bob@gmail.com", "bob");
        Rating testRating = new Rating();
        System.out.println(testComplain.toString());
        System.out.println(testRoom.toString());
        System.out.println(testAccount.toString());
        System.out.println(testPrice.toString());
        System.out.println(testRating.toString()); */
        
        /*Payment testPayment = new Payment(2, 2, 2,2);
        System.out.println(testPayment.getTime());
        System.out.println(testPayment.getDuration());
        Price[] unfilteredArray = new Price[5];
        for(int i=0;i < unfilteredArray.length;i++){
            int j = 5000;
            unfilteredArray[i] = new Price((i+1)*j);
        }
        System.out.println("Price List");
        for(int i=0;i < unfilteredArray.length;i++){
            System.out.println(unfilteredArray[i].price);
        }
        System.out.println("Below 12000.0");
        System.out.println(Validate.filter(unfilteredArray, 12000,true));
        System.out.println("Above 10000.0");
        System.out.println(Validate.filter(unfilteredArray, 10000,false));*/
        
        /*Room RoomA = createRoom();
        Room RoomB = createRoom();
        System.out.println("Membuat booking dari tanggal 15 hingga 18");
        Date start = Date.valueOf("2022-8-15");
        Date end = Date.valueOf("2022-8-20");
        System.out.println(Payment.makeBooking(start, end,RoomA));
        System.out.println("Membuat booking dari tanggal 15 hingga 18");
        Date start2 = Date.valueOf("2022-8-18");
        Date end2 = Date.valueOf("2022-8-20");
        System.out.println(Payment.makeBooking(start2, end2,RoomA));
        System.out.println("Membuat booking dari tanggal 15 hingga 18 untuk kamar berbeda");
        Date start3 = Date.valueOf("2022-8-18");
        Date end3 = Date.valueOf("2022-8-20");
        System.out.println(Payment.makeBooking(start3, end3,RoomB));*/

        /*ArrayList<Room> RoomSer = new ArrayList<>();*/


        /* for (int i = 0; i < 5; i++) {
            RoomSer.add(i, JSleep.createRoom());
            System.out.println(RoomSer.get(i).toString());
        }

        String filepath = "C:\\Users\\rizky\\Documents\\2022_Praktikum OOP\\JSleep\\city.json";
        Gson gson = new Gson();

        try {
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            Country input = gson.fromJson(br, Country.class);
            System.out.println("name: " + input.name);
            System.out.println("population: " + input.population);
            System.out.println("states: ");
            input.listOfStates.forEach(state -> System.out.println(state));
        } catch (IOException e) {
            e.printStackTrace();
        } */

        /*Renter testRegex = new Renter("Netlab_", "081212345678", "Jl");
        System.out.println(testRegex.validate());*/

        /*try {
            JsonTable<Account> tableAccount = new JsonTable<>(Account.class, "src/json/account.json");
            Account acc = new Account("name", "email", "password");
            tableAccount.add(acc);
            tableAccount.writeJson();
        } catch (Throwable t) {
            t.printStackTrace();
        }

        for(int i = 0; i < 10; i++) {
            ThreadingObject thread = new ThreadingObject("Thread " + i);
            thread.run();
        }*/
    }
    
    /*
    public static Room createRoom() {
        Price price = new Price(5000000, 18);
        Room room = new Room(1,"Hotel", 30, price, Facility.AC, City.SURABAYA, "somewhere");
        return room;
    }

    public static List<Room> filterByCity(List<Room> roomList, String city, int page, int pageSize) {
        List<Room> sent = Algorithm.paginate(roomList, page, pageSize, city::equals);
        return sent;
    }
    public static List<Room> filterByPrice(List<Room> roomList, double priceStart, double priceFinish) {
        List<Room> obtained = new ArrayList<>();
        int i = 0;

        Iterable<Room> roomIterable = roomList;
        Iterator<Room> roomFinalIter = roomIterable.iterator();

        while (roomFinalIter.hasNext()) {
            Room room = roomFinalIter.next();
            if (room.price.price >= priceStart && room.price.price <= priceFinish) {
                obtained.add(room);
            }
        }

        return obtained;
    }

    public static List<Room> filterByAccountId(List<Room> roomList, int accountId, int idStart, int idRange) {

        List<Room> obtained = new ArrayList<>();
        int i = 0;

        Iterable<Room> roomIterable = roomList;
        Iterator<Room> roomFinalIter = roomIterable.iterator();

        while (roomFinalIter.hasNext()) {
            Room current = roomFinalIter.next();
            if (current.accountId == accountId) {
                if (i >= idStart && i < idStart+idRange) {
                    obtained.add(current);
                }
                i += 1;
            }
        }

        return obtained;
    }
     */
    
    /*
    public static int getHotelId() {
        return 0;
    }
    
    public static String getHotelName() {
        return "hotel";
    }
    
    public static boolean isDiscount() {
        return true;
    }
    
    public static float getDiscountPercentage(int beforeDiscount, int afterDiscount) {
        if (afterDiscount < beforeDiscount) {
            return (((beforeDiscount - afterDiscount) / beforeDiscount) * 100);
        } else {
            return 0;
        }
    }
    
    public static int getDiscountedPrice(int price, float discountPercentage) {
        if (discountPercentage > 100) {
            discountPercentage = 100;
        }
        
        return (int) (((100 - discountPercentage) / 100) * price);
    }
    
    public static int getOriginalPrice(int discountedPrice, float discountPercentage) {
        return (int) (discountedPrice * (100 / (100 - discountPercentage)));
    }
    
    public static float getAdminFeePercentage() {
        return 0.05f;
    }
    
    public static int getAdminFee(int price) {
        return (int) (price * getAdminFeePercentage());
    }
    
    public static int getTotalPrice(int price, int numberOfNight) {
        int total = numberOfNight * price;
        return (int) (total + (total * getAdminFeePercentage()));
    }*/
}
